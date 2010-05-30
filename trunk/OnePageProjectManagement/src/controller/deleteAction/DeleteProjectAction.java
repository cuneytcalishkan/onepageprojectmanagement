package controller.deleteAction;

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

import controller.HibernateUtil;
import controller.form.IdForm;

/**
 * @author tile
 */
public class DeleteProjectAction extends Action {
    
    public ActionForward execute(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) {

    	HttpSession session = request.getSession(true);
		Puser user = (Puser) session.getAttribute("user");
		if (user == null || (!user.getRole().equals("project manager"))) {
			throw new RuntimeException(
					"You are not authorized to execute this action.");
		}
    	
        IdForm idForm = (IdForm) form;
        Long id = idForm.getId();

        ActionMessages actionMessages = new ActionMessages();
        //<html:link action="/DeleteObservation" paramId="id" paramName="observationForm" paramProperty="id">
        Session hibernateSession = HibernateUtil.getSession();
        hibernateSession.beginTransaction();
        Project p = (Project) hibernateSession.get(Project.class, id);
        hibernateSession.delete(p);
        hibernateSession.getTransaction().commit();
        hibernateSession.close();

        actionMessages.add(ActionMessages.GLOBAL_MESSAGE,
                new ActionMessage("project.deleted",p.getName()));
        saveMessages(request,actionMessages);

        return mapping.findForward("success");
    }
}
