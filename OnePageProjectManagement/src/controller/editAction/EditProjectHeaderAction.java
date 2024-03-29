package controller.editAction;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Project;
import model.Puser;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.hibernate.Session;
import org.hibernate.Transaction;

import controller.HibernateUtil;
import controller.form.ProjectHeaderForm;

/**
 * @author tile
 */
public class EditProjectHeaderAction extends Action {
    
	public ActionForward execute(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) {
    	HttpSession session = request.getSession(true);
    	Puser user = (Puser) session.getAttribute("user");
    	if(user == null){
			ActionMessages actionMessages = new ActionMessages();
	        actionMessages.add(ActionMessages.GLOBAL_MESSAGE,
	        	new ActionMessage("user.notFound"));
	        saveMessages(request,actionMessages);
			return mapping.findForward("login");
		}
        if( user == null || ! user.getRole().equals("project manager"))  {
        	throw new RuntimeException("You are not authorized to execute this action.");
        }
        
        ProjectHeaderForm projectForm = (ProjectHeaderForm) form;
        Transaction ta = null;
        Session hibernateSession = HibernateUtil.getSession();
        try {
            ta = hibernateSession.beginTransaction();
            
            Project project = (Project) hibernateSession.get(Project.class, projectForm.getId());
			projectForm.setName(project.getName());
			projectForm.setLeader(user.getNameSurname()); 
			projectForm.setObjective(project.getObjective());
			projectForm.setSliceAmount(project.getSliceAmount());
			projectForm.setStartDate(project.getStartDate());
			projectForm.setFinishDate(project.getFinishDate());
			ta.commit();
			hibernateSession.close();
			return mapping.getInputForward();
        } catch(Exception e) {
        	if (ta != null) {
				ta.rollback();
				hibernateSession.close();
			}
        	Date today = new Date();
        	projectForm.setStartDate(today);
        	projectForm.setFinishDate(today);
        	projectForm.setLeader(user.getNameSurname());
        	projectForm.setSliceAmount(1);
	        ActionMessages actionMessages = new ActionMessages();
	        actionMessages.add(ActionMessages.GLOBAL_MESSAGE,
	        	new ActionMessage("project.notFound"));
	        saveMessages(request,actionMessages);
	        return mapping.findForward("failure");
        }
        
    }
    
}
