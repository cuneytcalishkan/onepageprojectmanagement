package controller.deleteAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
public class DeleteUserAction extends Action {
    
    public ActionForward execute(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) {

        IdForm idForm = (IdForm) form;
        Long id = idForm.getId();
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Puser p = (Puser) session.get(Puser.class, id);
        session.delete(p);
        session.getTransaction().commit();
        session.close();
        
        ActionMessages actionMessages = new ActionMessages();
        actionMessages.add(ActionMessages.GLOBAL_MESSAGE,
                new ActionMessage("user.deleted",p.getNameSurname()));
        saveMessages(request,actionMessages);

        return mapping.findForward("success");
    }
}
