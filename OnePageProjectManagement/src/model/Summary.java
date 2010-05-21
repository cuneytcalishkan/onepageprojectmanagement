package model;

import java.util.Date;

public class Summary {

	private Date summaryDate;
	private String description;

	public Summary(Date summaryDate, String description) {
		super();
		this.summaryDate = summaryDate;
		this.description = description;
	}

	public Date getSummaryDate() {
		return summaryDate;
	}

	public void setSummaryDate(Date summaryDate) {
		this.summaryDate = summaryDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
