package controller.deleteAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.SubjectiveTask;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.hibernate.Session;

import controller.HibernateUtil;
import controller.form.IdForm;

public class DeleteSubjectiveTaskAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		IdForm idForm = (IdForm) form;
		Long id = idForm.getId();

		ActionMessages actionMessages = new ActionMessages();
		Session session = HibernateUtil.getSession();
		session.beginTransaction();

		SubjectiveTask o = (SubjectiveTask) session.get(SubjectiveTask.class,
				id);
		session.delete(o);
		session.getTransaction().commit();
		session.close();

		actionMessages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
				"subjectiveTask.deleted",o.getName()));
		saveMessages(request, actionMessages);

		return new ActionForward("/OnePageProject.do?id="+o.getObjectives().get(0).getProject().getId());
	}

}
