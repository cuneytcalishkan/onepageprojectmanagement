package controller.saverAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.SubjectiveTask;
import model.Objective;
import model.Puser;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.hibernate.Session;
import org.hibernate.Transaction;

import controller.HibernateUtil;
import controller.form.SubjectiveTaskForm;
import exception.AddElementException;

public class EditSubjectiveTaskSaverAction extends DispatchAction {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession(true);
		SubjectiveTaskForm subjectiveTaskForm = (SubjectiveTaskForm) form;
		Puser user = (Puser) session.getAttribute("user");
		if (user == null || (!user.getRole().equals("project manager"))) {
			throw new RuntimeException(
					"You are not authorized to execute this action.");
		}
		Session hibernateSession = HibernateUtil.getSession();
		Transaction ta = hibernateSession.beginTransaction();
		Long id = subjectiveTaskForm.getId();
		SubjectiveTask subjectiveTask;
		if (id != null && id != 0)
			subjectiveTask = (SubjectiveTask) hibernateSession.get(
					SubjectiveTask.class, id);
		else
			subjectiveTask = new SubjectiveTask();

		subjectiveTask.setName(subjectiveTaskForm.getName());
		String[] objectives = subjectiveTaskForm.getObjectivesList();
		for (int i = 0; i < objectives.length; i++) {
			Objective obj = (Objective) hibernateSession.get(Objective.class,
					Long.parseLong(objectives[i]));
			try {
				subjectiveTask.addObjective(obj);
				obj.addSubjectiveTask(subjectiveTask);
			} catch (AddElementException e) {
				e.printStackTrace();
			}
			hibernateSession.saveOrUpdate(obj);
		}

		hibernateSession.saveOrUpdate(subjectiveTask);
		ta.commit();
		hibernateSession.close();
		return mapping.findForward("success");
	}

}
