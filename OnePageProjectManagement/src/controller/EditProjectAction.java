package controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import org.hibernate.criterion.Restrictions;

import controller.form.ProjectForm;

/**
 * @author tile
 */
public class EditProjectAction extends DispatchAction {
    
    @SuppressWarnings("unchecked")
	public ActionForward execute(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) {
        
        ProjectForm projectForm = (ProjectForm) form;
        Transaction ta = null;
        Session session = HibernateUtil.getSession();
        try {
            ta = session.beginTransaction();
            
            List<Puser> leaders = session.createCriteria(Puser.class)
            	.add(Restrictions.eq("role", "project manager")).list();
            request.setAttribute("leader", leaders);
            
            Project project = (Project) session.get(Project.class, projectForm.getId());
			projectForm.setName(project.getName());
			projectForm.setLeader(project.getLeaderId()); //TODO select iþleri
			projectForm.setObjective(project.getObjective());
			projectForm.setStartDate(project.getStartDate());
			projectForm.setFinishDate(project.getFinishDate());
			ta.commit();
			session.close();
			return mapping.getInputForward();
        } catch(Exception e) {
        	if (ta != null) {
				ta.rollback();
				session.close();
			}
        	projectForm.setStartDate(new Date());
	        ActionMessages actionMessages = new ActionMessages();
	        actionMessages.add(ActionMessages.GLOBAL_MESSAGE,
	        	new ActionMessage("project.notFound"));
	        saveMessages(request,actionMessages);
	        return mapping.findForward("failure");
        }
        
    }
    
}
