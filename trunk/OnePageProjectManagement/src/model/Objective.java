package model;

import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import exception.AddElementException;
import exception.RemoveElementException;

@Entity
@Table(name = "OBJECTIVE")
public class Objective {

	private long id;

	@ManyToMany(targetEntity = MajorTask.class, cascade = { CascadeType.PERSIST,
			CascadeType.MERGE })
	@JoinTable(name = "HASTASK", joinColumns = @JoinColumn(name = "OBJECTIVE_ID"), inverseJoinColumns = @JoinColumn(name = "MAJORTASK_ID"))
	private String name;
	private ArrayList<Task> tasks;

	public Objective() {
		super();
	}

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

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
