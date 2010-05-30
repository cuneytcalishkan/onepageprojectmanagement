package controller.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class SubjectiveTaskAssignmentForm extends ActionForm {

	private static final long serialVersionUID = 1L;

	private long id;
	private long subjectiveTaskId;
	private long puserId;
	private char priority;

	public ActionErrors validate(ActionMapping arg0, HttpServletRequest arg1) {
		ActionErrors errors = new ActionErrors();

		if (id == 0)
			errors.add("id", new ActionMessage("id.empty"));
		if (puserId == 0)
			errors.add("user", new ActionMessage("user.empty"));
		if (subjectiveTaskId == 0)
			errors.add("subjectiveTask", new ActionMessage(
					"subjectiveTask.empty"));
		return errors;
	}

	public long getSubjectiveTaskId() {
		return subjectiveTaskId;
	}

	public void setSubjectiveTaskId(long subjectiveTaskId) {
		this.subjectiveTaskId = subjectiveTaskId;
	}

	public long getPuserId() {
		return puserId;
	}

	public void setPuserId(long puserId) {
		this.puserId = puserId;
	}

	public char getPriority() {
		return priority;
	}

	public void setPriority(char priority) {
		this.priority = priority;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
