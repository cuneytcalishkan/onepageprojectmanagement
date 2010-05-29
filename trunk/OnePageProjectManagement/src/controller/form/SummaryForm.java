package controller.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class SummaryForm extends ActionForm {

	private static final long serialVersionUID = 1L;
	private Long projectId;
	private String description;

	public ActionErrors validate(ActionMapping arg0, HttpServletRequest arg1) {
		ActionErrors errors = new ActionErrors();

		if (description != null && description.equals(""))
			errors.add("comment", new ActionMessage("empty"));
		if (projectId == 0)
			errors.add("project", new ActionMessage("project.empty"));

		return errors;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

}
