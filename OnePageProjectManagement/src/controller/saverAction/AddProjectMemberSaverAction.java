package controller.saverAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Project;
import model.Puser;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import controller.HibernateUtil;
import controller.form.ProjectMemberForm;
import exception.AddElementException;

public class AddProjectMemberSaverAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		ProjectMemberForm projectMemberForm = (ProjectMemberForm) form;
		HttpSession session = request.getSession(true);
		Puser user = (Puser) session.getAttribute("user");
		if (user == null || (!user.getRole().equals("project manager"))) {
			throw new RuntimeException(
					"You are not authorized to execute this action.");
		}
		Session hibernateSession = HibernateUtil.getSession();
		Transaction ta = hibernateSession.beginTransaction();
		Project project = (Project) hibernateSession.get(Project.class,
				projectMemberForm.getProjectId());
		Puser newMember = (Puser) hibernateSession.get(Puser.class,
				projectMemberForm.getProjectMember());
		try {
			newMember.addProject(project);
			project.addUser(newMember);
			hibernateSession.saveOrUpdate(newMember);
			hibernateSession.saveOrUpdate(project);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AddElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ta.commit();
		hibernateSession.close();
		ActionMessages actionMessages = new ActionMessages();
        actionMessages.add(ActionMessages.GLOBAL_MESSAGE,
                new ActionMessage("member.added",newMember.getNameSurname()));
        saveMessages(request,actionMessages);
		
		return new ActionForward("/OnePageProject.do?id="+projectMemberForm.getProjectId());
	}

}
