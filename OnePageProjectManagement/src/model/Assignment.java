package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ASSIGNMENT")
public class Assignment {

	private char priority;
	private Puser puser;
	private MajorTask majorTask;

	public Assignment() {
		super();
	}

	public Assignment(char priority, Puser user, MajorTask task) {
		super();
		this.priority = priority;
		this.puser = user;
		this.majorTask = task;
	}

	public char getPriority() {
		return priority;
	}

	public void setPriority(char priority) {
		this.priority = priority;
	}
	@Id
	@ManyToOne
	@JoinColumn(name = "PUSER_ID")
	public Puser getPuser() {
		return puser;
	}

	public void setPuser(Puser user) {
		this.puser = user;
	}
	@Id
	@ManyToOne
	@JoinColumn(name = "MAJORTASK_ID")
	public MajorTask getMajorTask() {
		return majorTask;
	}

	public void setMajorTask(MajorTask task) {
		this.majorTask = task;
	}

}
