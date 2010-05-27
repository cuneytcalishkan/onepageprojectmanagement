package model;

import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name="ASSIGNMENT")
public class Assignment {

	private char priority;
	private Users user;
	private Task task;

	public Assignment(char priority, Users user, Task task) {
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

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

}
