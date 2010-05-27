package model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "SUMMARY")
public class Summary {

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "COMMENTED", joinColumns = @JoinColumn(name = "SUMMARY_ID"), inverseJoinColumns = @JoinColumn(name = "PROJECT_ID"))
	private long id;
	private Date summaryDate;
	private String description;

	public Summary() {
		super();
	}

	public Summary(Date summaryDate, String description) {
		super();
		this.summaryDate = summaryDate;
		this.description = description;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
