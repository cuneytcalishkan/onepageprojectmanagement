package controller.editAction;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.MajorTask;
import model.Objective;
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

import controller.HibernateUtil;
import controller.form.MajorTaskForm;

public class EditMajorTaskAction extends DispatchAction {

	@SuppressWarnings("unchecked")
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession(true);
		MajorTaskForm majorTaskForm = (MajorTaskForm) form;
		Puser user = (Puser) session.getAttribute("user");
		if (user == null || (!user.getRole().equals("project manager"))) {
			throw new RuntimeException(
					"You are not authorized to execute this action.");
		}

		Transaction ta = null;
		Session hibernateSession = HibernateUtil.getSession();
		try {
			ta = hibernateSession.beginTransaction();
			System.out.println("hmm");
			List<Objective> objectives = (List<Objective>) hibernateSession.createCriteria(Objective.class)
				.add(Restrictions.eq("project.id",majorTaskForm.getProjectId() )).list();
			request.setAttribute("objectives", objectives);
			MajorTask majorTask = null;
			majorTask = (MajorTask) hibernateSession.get(MajorTask.class,
					majorTaskForm.getId());
			majorTaskForm.setName(majorTask.getName());
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
					new ActionMessage("majorTask.notFound"));
			saveMessages(request, actionMessages);
			return mapping.findForward("failure");
		}

	}
}
