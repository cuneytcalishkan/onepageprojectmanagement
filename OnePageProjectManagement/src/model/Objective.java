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
	private String name;
	private ArrayList<MajorTask> majorTasks;
	private ArrayList<SubjectiveTask> subjectiveTasks;

	public Objective() {
		super();
	}

	public Objective(long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public void addMajorTask(MajorTask newTask) throws AddElementException {
		if (this.majorTasks == null)
			setMajorTasks(new ArrayList<MajorTask>());
		if (!this.majorTasks.add(newTask))
			throw new AddElementException("Specified task cannot be added!");
	}

	public void removeMajorTask(MajorTask tsk) throws RemoveElementException {
		if (this.majorTasks.size() > 0)
			if (!this.majorTasks.remove(tsk))
				throw new RemoveElementException(
						"Specified task cannot be removed!");
	}

	public void addSubjectiveTask(SubjectiveTask newTask)
			throws AddElementException {
		if (this.subjectiveTasks == null)
			setSubjectiveTasks(new ArrayList<SubjectiveTask>());
		if (!this.subjectiveTasks.add(newTask))
			throw new AddElementException("Specified task cannot be added!");
	}

	public void removeSubjectiveTask(SubjectiveTask tsk)
			throws RemoveElementException {
		if (this.subjectiveTasks.size() > 0)
			if (!this.subjectiveTasks.remove(tsk))
				throw new RemoveElementException(
						"Specified task cannot be removed!");
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

	@ManyToMany(targetEntity = MajorTask.class, cascade = {
			CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "HASTASK", joinColumns = @JoinColumn(name = "OBJECTIVE_ID"), inverseJoinColumns = @JoinColumn(name = "MAJORTASK_ID"))
	public ArrayList<MajorTask> getMajorTasks() {
		return majorTasks;
	}

	public void setMajorTasks(ArrayList<MajorTask> majorTasks) {
		this.majorTasks = majorTasks;
	}

	@ManyToMany(targetEntity = SubjectiveTask.class, cascade = {
			CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "HASSUBJECTIVE", joinColumns = @JoinColumn(name = "OBJECTIVE_ID"), inverseJoinColumns = @JoinColumn(name = "SUBJECTIVETASK_ID"))
	public ArrayList<SubjectiveTask> getSubjectiveTasks() {
		return subjectiveTasks;
	}

	public void setSubjectiveTasks(ArrayList<SubjectiveTask> subjectiveTasks) {
		this.subjectiveTasks = subjectiveTasks;
	}

}
