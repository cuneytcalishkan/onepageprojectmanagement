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
	private Puser user;
	private MajorTask task;

	public Assignment() {
		super();
	}

	public Assignment(char priority, Puser user, MajorTask task) {
		super();
		this.priority = priority;
		this.user = user;
		this.task = task;
	}
	public char getPriority() {
		return priority;
	}

	public void setPriority(char priority) {
		this.priority = priority;
	}
	@Id
	@ManyToOne
    @JoinColumn(name="USER_ID")
	public Puser getUser() {
		return user;
	}

	public void setUser(Puser user) {
		this.user = user;
	}
	@Id
	@ManyToOne
    @JoinColumn(name="MAJORTASK_ID")
	public MajorTask getTask() {
		return task;
	}

	public void setTask(MajorTask task) {
		this.task = task;
	}

}
