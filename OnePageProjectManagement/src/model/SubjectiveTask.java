package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import exception.AddElementException;
import exception.RemoveElementException;

@Entity
@Table(name = "SUBJECTIVETASK")
public class SubjectiveTask {

	private long id;
	private String name;
	private List<SubjectiveSlice> subjectiveSlices;
	private List<Objective> objectives;

	public SubjectiveTask() {
		super();
		objectives = new ArrayList<Objective>();
	}

	public SubjectiveTask(String name) {
		this.name = name;
		objectives = new ArrayList<Objective>();
	}

	public SubjectiveTask(long id, String name) {
		this.id = id;
		this.name = name;
		objectives = new ArrayList<Objective>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void addSubjectiveSlice(SubjectiveSlice ss)
			throws AddElementException {
		if (this.subjectiveSlices == null)
			setSubjectiveSlices(new ArrayList<SubjectiveSlice>());
		if (!this.subjectiveSlices.add(ss))
			throw new AddElementException(
					"Specified subjective task cannot be added!");
	}

	public void removeSubjectiveSlice(SubjectiveSlice ss)
			throws RemoveElementException {
		if (this.subjectiveSlices.size() > 0)
			if (!this.subjectiveSlices.remove(ss))
				throw new RemoveElementException(
						"Specified subjective task cannot be removed!");
	}

	public void addObjective(Objective obj) {
		this.objectives.add(obj);
	}

	@OneToMany(mappedBy = "task")
	public List<SubjectiveSlice> getSubjectiveSlices() {
		return subjectiveSlices;
	}

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "subjectiveTasks", targetEntity = Objective.class)
	public List<Objective> getObjectives() {
		return objectives;
	}

	public void setObjectives(List<Objective> objectives) {
		this.objectives = objectives;
	}

	public void setSubjectiveSlices(List<SubjectiveSlice> subjectiveSlices) {
		this.subjectiveSlices = subjectiveSlices;
	}

}
