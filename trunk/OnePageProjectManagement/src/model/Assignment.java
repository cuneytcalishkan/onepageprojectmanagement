package model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ASSIGNMENT")
public class Assignment {

	private char priority;
	private Puser user;
	private Task task;

	public Assignment() {
		super();
	}

	public Assignment(char priority, Puser user, Task task) {
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

	public Puser getUser() {
		return user;
	}

	public void setUser(Puser user) {
		this.user = user;
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

}
