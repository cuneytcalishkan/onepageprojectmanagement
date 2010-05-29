package controller.form;

import javax.servlet.http.HttpServletRequest;

import model.Project;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class ObjectiveForm extends ActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long id;
	private String name;
	private Project project;

	public ActionErrors validate(ActionMapping arg0, HttpServletRequest arg1) {
		ActionErrors errors = new ActionErrors();

		if (name != null && name.equals(""))
			errors.add("name", new ActionMessage("empty"));
		if (project != null)
			errors.add("project", new ActionMessage("empty"));
		return errors;
	}

	public void reset(ActionMapping arg0, HttpServletRequest arg1) {
		name = null;
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

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

}
