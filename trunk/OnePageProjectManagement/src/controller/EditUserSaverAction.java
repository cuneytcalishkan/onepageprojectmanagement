package controller;

import java.text.DateFormat;
import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Project;
import model.Puser;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.hibernate.Session;
import org.hibernate.Transaction;

import controller.form.UserForm;

/**
 * @author tile
 */
public class EditUserSaverAction extends DispatchAction {
    
    public ActionForward execute(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) {

        HttpSession session = request.getSession(true);
        Puser user = (Puser) session.getAttribute("user");
        if( user == null || ! user.getRole().equals("manager"))  {
        	throw new RuntimeException("You are not unauthorized to execute this action.");
        }

        UserForm userForm = (UserForm) form;
        Session hibernateSession = HibernateUtil.getSession();
    	Transaction ta = hibernateSession.beginTransaction();
    	Long id = userForm.getId();
    	Puser pUser;
		if(id != null || id != 0)
			pUser = (Puser) hibernateSession.get(Puser.class, id);
		else
			pUser = new Puser();
		pUser.setUserName(userForm.getUserName());
		pUser.setNameSurname(userForm.getNameSurname());
		pUser.setPassword(userForm.getPassword());
		pUser.setRole(userForm.getRole());
        hibernateSession.saveOrUpdate(pUser);
        ta.commit();
        hibernateSession.close();
        return mapping.findForward("success");
    }
    
}
