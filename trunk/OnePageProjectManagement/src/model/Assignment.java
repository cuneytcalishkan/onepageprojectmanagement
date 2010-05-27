package model;


public class Assignment {

	private char priority;
	private User user;
	private Task task;

	public Assignment(char priority, User user, Task task) {
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

}
