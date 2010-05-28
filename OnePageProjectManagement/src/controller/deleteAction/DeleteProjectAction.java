package controller.deleteAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Project;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.actions.DispatchAction;
import org.hibernate.Session;

import controller.HibernateUtil;
import controller.form.IdForm;

/**
 * @author tile
 */
public class DeleteProjectAction extends DispatchAction {
    
    public ActionForward execute(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) {

        IdForm idForm = (IdForm) form;
        Long id = idForm.getId();

        ActionMessages actionMessages = new ActionMessages();
        //<html:link action="/DeleteObservation" paramId="id" paramName="observationForm" paramProperty="id">
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Project p = (Project) session.get(Project.class, id);
        session.delete(p);
        session.getTransaction().commit();
        session.close();

        actionMessages.add(ActionMessages.GLOBAL_MESSAGE,
                new ActionMessage("observation.deleted"));
        saveMessages(request,actionMessages);

        return mapping.findForward("success");
    }
}
