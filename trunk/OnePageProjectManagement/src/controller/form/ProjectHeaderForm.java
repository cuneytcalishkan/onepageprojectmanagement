package controller.form;

import java.util.Calendar;
import java.util.Date;
import java.util.Formatter;
import java.util.GregorianCalendar;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class ProjectHeaderForm extends ActionForm {

	private Long id;
	private String name;
	private int startDateDay;
	private int startDateMonth;
	private int startDateYear;
	private int finishDateDay;
	private int finishDateMonth;
	private int finishDateYear;
	private int sliceAmount;
	private String leader;
	private String objective;

	public ActionErrors validate(ActionMapping arg0, HttpServletRequest arg1) {
		ActionErrors errors = new ActionErrors();

		if (name.equals(""))
			errors.add("name", new ActionMessage("empty"));
		
		if(sliceAmount < 1)
			errors.add("sliceAmount", new ActionMessage("slice.invalid"));

		// set id to null if not specified
		if (id != null && id.intValue() == 0) {
			id = null;
		}

		return errors;
	}

	public Date getStartDate() {
		Calendar cal = new GregorianCalendar(startDateYear, startDateMonth-1, startDateDay);
		return cal.getTime();
	}

	public Date getFinishDate() {
		Calendar cal = new GregorianCalendar(finishDateYear, finishDateMonth-1, finishDateDay);
		return cal.getTime();
	}

	public void setStartDate(Date stDate) {
		Calendar cal = new GregorianCalendar();
		cal.setTime(stDate);
		startDateYear = cal.get(Calendar.YEAR);
		startDateMonth = cal.get(Calendar.MONTH) + 1;
		startDateDay = cal.get(Calendar.DAY_OF_MONTH);
	}

	public void setFinishDate(Date fnDate) {
		Calendar cal = new GregorianCalendar();
		cal.setTime(fnDate);
		finishDateYear = cal.get(Calendar.YEAR);
		finishDateMonth = cal.get(Calendar.MONTH) + 1;
		finishDateDay = cal.get(Calendar.DAY_OF_MONTH);
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

	public String getLeader() {
		return leader;
	}

	public int getStartDateDay() {
		return startDateDay;
	}

	public void setStartDateDay(int startDateDay) {
		this.startDateDay = startDateDay;
	}

	public int getStartDateMonth() {
		return startDateMonth;
	}

	public void setStartDateMonth(int startDateMonth) {
		this.startDateMonth = startDateMonth;
	}

	public int getStartDateYear() {
		return startDateYear;
	}

	public void setStartDateYear(int startDateYear) {
		this.startDateYear = startDateYear;
	}

	public int getFinishDateDay() {
		return finishDateDay;
	}

	public void setFinishDateDay(int finishDateDay) {
		this.finishDateDay = finishDateDay;
	}

	public int getFinishDateMonth() {
		return finishDateMonth;
	}

	public void setFinishDateMonth(int finishDateMonth) {
		this.finishDateMonth = finishDateMonth;
	}

	public int getFinishDateYear() {
		return finishDateYear;
	}

	public void setFinishDateYear(int finishDateYear) {
		this.finishDateYear = finishDateYear;
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

	public int getSliceAmount() {
		return sliceAmount;
	}

	public void setSliceAmount(int sliceAmount) {
		this.sliceAmount = sliceAmount;
	}
	

}
