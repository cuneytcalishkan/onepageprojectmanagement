package model;

import java.util.ArrayList;

public class Objective {

	private String name;
	private ArrayList<Task> tasks;

	public Objective(String name) {
		super();
		this.name = name;
	}

	public void addTask(Task newTask) {
		if (this.tasks == null)
			setTasks(new ArrayList<Task>());
		this.tasks.add(newTask);
	}

	public void removeTask(Task tsk) {
		if (this.tasks.size() > 0)
			this.tasks.remove(tsk);
	}

	public ArrayList<Task> getTasks() {
		return tasks;
	}

	public void setTasks(ArrayList<Task> tasks) {
		this.tasks = tasks;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
