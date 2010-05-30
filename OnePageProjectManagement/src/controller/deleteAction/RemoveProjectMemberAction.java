package controller.deleteAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

import controller.HibernateUtil;
import controller.form.ProjectMemberForm;
import exception.RemoveElementException;

public class RemoveProjectMemberAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		ProjectMemberForm projectMemberForm = (ProjectMemberForm) form;

		ActionMessages actionMessages = new ActionMessages();
		Session hibernateSession = HibernateUtil.getSession();
		hibernateSession.beginTransaction();
		Project project = (Project) hibernateSession.get(Project.class,
				projectMemberForm.getProjectId());
		Puser oldMember = (Puser) hibernateSession.get(Puser.class,
				projectMemberForm.getProjectMember());
		try {
			oldMember.removeProject(project);
			project.removeUser(oldMember);
			hibernateSession.saveOrUpdate(oldMember);
			hibernateSession.saveOrUpdate(project);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoveElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		hibernateSession.getTransaction().commit();
		hibernateSession.close();

		actionMessages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
				"member.removed",oldMember.getNameSurname()));
		saveMessages(request, actionMessages);

		return new ActionForward("/OnePageProject.do?id="+projectMemberForm.getProjectId());
	}

}
