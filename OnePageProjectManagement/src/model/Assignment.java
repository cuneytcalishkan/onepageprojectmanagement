package model;

import java.util.ArrayList;

public class Assignment {

	private char priority;
	private ArrayList<User> users;
	private ArrayList<Task> tasks;

	public Assignment(char priority, ArrayList<User> users,
			ArrayList<Task> tasks) {
		super();
		this.priority = priority;
		this.users = users;
		this.tasks = tasks;
	}

	public void addTask(Task tsk) {
		if (this.tasks == null)
			setTasks(new ArrayList<Task>());
		this.tasks.add(tsk);
	}

	public void removeTask(Task tsk) {
		if (this.tasks.size() > 0)
			this.tasks.remove(tsk);
	}

	public void addUser(User usr) {
		if (this.users == null)
			setUsers(new ArrayList<User>());
		this.users.add(usr);
	}

	public void removeUser(User usr) {
		if (this.users.size() > 0)
			this.users.remove(usr);
	}

	public char getPriority() {
		return priority;
	}

	public void setPriority(char priority) {
		this.priority = priority;
	}

	public ArrayList<User> getUsers() {
		return users;
	}

	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}

	public ArrayList<Task> getTasks() {
		return tasks;
	}

	public void setTasks(ArrayList<Task> tasks) {
		this.tasks = tasks;
	}

}
