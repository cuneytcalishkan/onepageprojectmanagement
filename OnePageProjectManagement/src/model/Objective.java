package model;

import java.util.ArrayList;

import exception.AddElementException;
import exception.RemoveElementException;

public class Objective {

	private long id;
	private String name;
	private ArrayList<Task> tasks;

	public Objective(long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public void addTask(Task newTask) throws AddElementException {
		if (this.tasks == null)
			setTasks(new ArrayList<Task>());
		if (!this.tasks.add(newTask))
			throw new AddElementException("Specified task cannot be added!");
	}

	public void removeTask(Task tsk) throws RemoveElementException {
		if (this.tasks.size() > 0)
			if (!this.tasks.remove(tsk))
				throw new RemoveElementException(
						"Specified task cannot be removed!");
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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
