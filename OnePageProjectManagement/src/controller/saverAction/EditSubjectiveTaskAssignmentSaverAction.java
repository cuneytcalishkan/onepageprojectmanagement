package controller.saverAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Puser;
import model.SubjectiveAssignment;
import model.SubjectiveTask;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.actions.DispatchAction;
import org.hibernate.Session;
import org.hibernate.Transaction;

import controller.HibernateUtil;
import controller.form.SubjectiveTaskAssignmentForm;
import exception.AddElementException;

public class EditSubjectiveTaskAssignmentSaverAction extends DispatchAction {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession(true);
		SubjectiveTaskAssignmentForm staf = (SubjectiveTaskAssignmentForm) form;
		Puser user = (Puser) session.getAttribute("user");
		if (user == null || !user.getRole().equals("project manager")) {
			throw new RuntimeException(
					"You are not authorized to execute this action.");
		}

		Session hibernateSession = HibernateUtil.getSession();
		Transaction ta = hibernateSession.beginTransaction();
		Long id = staf.getId();
		SubjectiveAssignment sa;
		if (id != null && id != 0)
			sa = (SubjectiveAssignment) hibernateSession.get(
					SubjectiveAssignment.class, id);
		else
			sa = new SubjectiveAssignment();

		Puser assignmentUser = (Puser) hibernateSession.get(Puser.class, staf
				.getPuserId());
		SubjectiveTask task = (SubjectiveTask) hibernateSession.get(
				SubjectiveTask.class, staf.getSubjectiveTaskId());

		sa.setPriority(staf.getPriority());
		sa.setPuser(assignmentUser);
		sa.setSubjectiveTask(task);

		hibernateSession.saveOrUpdate(sa);
		try {
			assignmentUser.addSubjectiveAssignment(sa);
			sa.setPuser(assignmentUser);
		} catch (AddElementException e) {
			e.printStackTrace();
		}
		hibernateSession.saveOrUpdate(assignmentUser);

		ta.commit();
		hibernateSession.close();
		ActionMessages actionMessages = new ActionMessages();
		actionMessages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
				"subjectiveTask.added", assignmentUser.getNameSurname()));
		saveMessages(request, actionMessages);
		return mapping.findForward("success");
	}

}
