package controller.deleteAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Objective;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.actions.DispatchAction;
import org.hibernate.Session;

import controller.HibernateUtil;
import controller.form.IdForm;

public class DeleteObjectiveAction extends DispatchAction {
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		IdForm idForm = (IdForm) form;
		Long id = idForm.getId();

		ActionMessages actionMessages = new ActionMessages();
		Session session = HibernateUtil.getSession();
		session.beginTransaction();

		Objective o = (Objective) session.get(Objective.class, id);
		session.delete(o);
		session.getTransaction().commit();
		session.close();

		actionMessages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
				"objective.deleted"));
		saveMessages(request, actionMessages);

		return new ActionForward("/OnePageProject.do?id="+o.getProjectId());
	}
}
