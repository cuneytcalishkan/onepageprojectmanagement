package controller.editAction;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.SubjectiveTask;
import model.Objective;
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

import controller.HibernateUtil;
import controller.form.SubjectiveTaskForm;

public class EditSubjectiveTaskAction extends DispatchAction {

	@SuppressWarnings("unchecked")
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession(true);
		SubjectiveTaskForm subjectiveTaskForm = (SubjectiveTaskForm) form;
		Puser user = (Puser) session.getAttribute("user");
		if (user == null || (!user.getRole().equals("project manager"))) {
			throw new RuntimeException(
					"You are not authorized to execute this action.");
		}

		Transaction ta = null;
		Session hibernateSession = HibernateUtil.getSession();
		try {
			ta = hibernateSession.beginTransaction();
			List<Objective> objectives = (List<Objective>) hibernateSession
					.createCriteria(Objective.class).add(
							Restrictions.eq("project.id", subjectiveTaskForm
									.getProjectId())).list();
			request.setAttribute("objectives", objectives);
			SubjectiveTask subjectiveTask = null;
			subjectiveTask = (SubjectiveTask) hibernateSession.get(
					SubjectiveTask.class, subjectiveTaskForm.getId());
			subjectiveTaskForm.setName(subjectiveTask.getName());
			ta.commit();
			hibernateSession.close();
			return mapping.getInputForward();
		} catch (Exception e) {
			if (ta != null) {
				ta.rollback();
				hibernateSession.close();
			}
			System.out.println(e.getMessage());
			ActionMessages actionMessages = new ActionMessages();
			actionMessages.add(ActionMessages.GLOBAL_MESSAGE,
					new ActionMessage("subjectiveTask.notFound"));
			saveMessages(request, actionMessages);
			return mapping.findForward("failure");
		}

	}

}
