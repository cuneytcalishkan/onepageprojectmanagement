package controller.form;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class ProjectForm extends ActionForm {
	
	private Long id;
	private String name;
	private Date startDate;
	private Date finishDate;
	private String leader;
	private String objective;
	
	public ActionErrors validate(ActionMapping arg0, HttpServletRequest arg1) {
        ActionErrors errors = new ActionErrors();

        if(name.equals(""))
	    	errors.add("name", new ActionMessage("empty"));

	    if(startDate == null || finishDate == null)
	    	errors.add("date", new ActionMessage("empty"));
	    
	    // set id to null if not specified
        if(id != null && id.intValue() == 0) {
            id = null;
        }
	    
        return errors;
    }
	
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStartDate() {
		return DateFormat.getDateInstance().format(startDate);
	}

	public void setStartDate(String startDate) {
		try {
			this.startDate = DateFormat.getDateInstance().parse(startDate);
		} catch (ParseException e) {
			this.startDate = null;
		}
	}

	public String getFinishDate() {
		return DateFormat.getDateInstance().format(finishDate);
	}

	public void setFinishDate(String finishDate) {
		try {
			this.finishDate = DateFormat.getDateInstance().parse(finishDate);
		} catch (ParseException e) {
			this.finishDate = null;
		}
	}
	

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public void setFinishDate(Date finishDate) {
		this.finishDate = finishDate;
	}

	public String getLeader() {
		return leader;
	}

	public void setLeader(String leader) {
		this.leader = leader;
	}

	public String getObjective() {
		return objective;
	}

	public void setObjective(String objective) {
		this.objective = objective;
	}
	
	

}
