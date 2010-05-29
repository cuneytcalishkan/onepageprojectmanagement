package controller.editAction;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

import controller.HibernateUtil;
import controller.form.ObjectiveForm;

public class EditObjectiveAction extends DispatchAction {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession(true);
		ObjectiveForm objectiveForm = (ObjectiveForm) form;
		Puser user = (Puser) session.getAttribute("user");
		if (user == null || (!user.getRole().equals("project manager"))) {
			throw new RuntimeException(
					"You are not authorized to execute this action.");
		}

		Transaction ta = null;
		Session hibernateSession = HibernateUtil.getSession();
		try {
			ta = hibernateSession.beginTransaction();
			Project project = (Project) hibernateSession.get(Project.class, (Serializable) objectiveForm.getProject());
			Objective objective = null;
			objective = (Objective) hibernateSession.get(Objective.class,
					objectiveForm.getId());
			objectiveForm.setName(objective.getName());
			objectiveForm.setProject(project);
			ta.commit();
			hibernateSession.close();
			return mapping.getInputForward();
		} catch (Exception e) {
			if (ta != null) {
				ta.rollback();
				hibernateSession.close();
			}
			ActionMessages actionMessages = new ActionMessages();
			actionMessages.add(ActionMessages.GLOBAL_MESSAGE,
					new ActionMessage("objective.notFound"));
			saveMessages(request, actionMessages);
			return mapping.findForward("failure");
		}

	}

}