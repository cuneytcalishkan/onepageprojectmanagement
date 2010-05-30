package controller.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class ProjectMemberForm extends ActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long projectMember;
	private long projectId;

	public ActionErrors validate(ActionMapping arg0, HttpServletRequest arg1) {
		ActionErrors errors = new ActionErrors();

		if (projectMember == 0)
			errors.add("name", new ActionMessage("empty"));
		if (projectId == 0)
			errors.add("project", new ActionMessage("project.empty"));
		return errors;
	}

	public long getProjectMember() {
		return projectMember;
	}

	public void setProjectMember(long projectMember) {
		this.projectMember = projectMember;
	}

	public long getProjectId() {
		return projectId;
	}

	public void setProjectId(long projectId) {
		this.projectId = projectId;
	}

}
