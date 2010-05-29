package controller.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class MajorTaskForm extends ActionForm {

	private static final long serialVersionUID = 1L;

	private long id;
	private String name;
	private long projectId;

	public ActionErrors validate(ActionMapping arg0, HttpServletRequest arg1) {
		ActionErrors errors = new ActionErrors();

		if (name != null && name.equals(""))
			errors.add("name", new ActionMessage("empty"));
		if (projectId == 0)
			errors.add("project", new ActionMessage("project.empty"));
		return errors;
	}

	public void reset(ActionMapping arg0, HttpServletRequest arg1) {
		name = null;
		projectId = 0;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getProjectId() {
		return projectId;
	}

	public void setProjectId(long projectId) {
		this.projectId = projectId;
	}

}
