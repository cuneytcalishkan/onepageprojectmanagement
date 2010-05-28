package controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Project;
import model.Puser;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.actions.DispatchAction;
import org.hibernate.Session;
import org.hibernate.Transaction;

import controller.form.UserForm;

/**
 * @author tile
 */
public class EditUserAction extends DispatchAction {
    
	public ActionForward execute(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) {
    	HttpSession session = request.getSession(true);
    	UserForm userForm = (UserForm) form;
    	Puser user = (Puser) session.getAttribute("user");
        if( user == null ||  (!user.getRole().equals("manager") &&
        		!(user.getId() == userForm.getId())))  {
        	throw new RuntimeException("You are not unauthorized to execute this action.");
        }
        
        
        Transaction ta = null;
        Session hibernateSession = HibernateUtil.getSession();
        try {
            ta = hibernateSession.beginTransaction();
            
            Puser pUser = (Puser) hibernateSession.get(Puser.class, userForm.getId());
            userForm.setUserName(pUser.getUserName());
			userForm.setNameSurname(pUser.getNameSurname());
			userForm.setPassword(pUser.getPassword()); 
			userForm.setRole(pUser.getRole());
			ta.commit();
			hibernateSession.close();
			return mapping.getInputForward();
        } catch(Exception e) {
        	if (ta != null) {
				ta.rollback();
				hibernateSession.close();
			}
	        ActionMessages actionMessages = new ActionMessages();
	        actionMessages.add(ActionMessages.GLOBAL_MESSAGE,
	        	new ActionMessage("user.notFound"));
	        saveMessages(request,actionMessages);
	        return mapping.findForward("failure");
        }
        
    }
    
}
