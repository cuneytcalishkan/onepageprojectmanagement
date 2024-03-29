package controller.saverAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Objective;
import model.Project;
import model.Puser;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.hibernate.Session;
import org.hibernate.Transaction;

import controller.HibernateUtil;
import controller.form.ObjectiveForm;

public class EditObjectiveSaverAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession(true);
		ObjectiveForm objectiveForm = (ObjectiveForm) form;
		Puser user = (Puser) session.getAttribute("user");
		if (user == null || (!user.getRole().equals("project manager"))) {
			throw new RuntimeException(
					"You are not authorized to execute this action.");
		}
		Session hibernateSession = HibernateUtil.getSession();
		Transaction ta = hibernateSession.beginTransaction();
		Long id = objectiveForm.getId();
		Objective objective;
		if (id != null && id != 0)
			objective = (Objective) hibernateSession.get(Objective.class, id);
		else
			objective = new Objective();
		Project project = (Project) hibernateSession.get(Project.class, objectiveForm.getProjectId());
		objective.setName(objectiveForm.getName());
		objective.setProject(project);
		hibernateSession.saveOrUpdate(objective);
		ta.commit();
		hibernateSession.close();
		ActionMessages actionMessages = new ActionMessages();
        actionMessages.add(ActionMessages.GLOBAL_MESSAGE,
                new ActionMessage("objective.added",objective.getName()));
        saveMessages(request,actionMessages);
		return new ActionForward("/OnePageProject.do?id="+objectiveForm.getProjectId());
	}

}
