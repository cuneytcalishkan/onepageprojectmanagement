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
@Table(name = "MAJORTASK")
public class MajorTask {

	private List<Assignment> assignments;

	private List<MajorSlice> majorSlices;
	private List<Objective> objectives;
	private long id;
	private String name;

	public MajorTask() {
		super();
	}

	public MajorTask(long id, String name) {
		this.id = id;
		this.name = name;
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

	public void addMajorSlice(MajorSlice ms) throws AddElementException {
		if (this.majorSlices == null)
			setMajorSlices(new ArrayList<MajorSlice>());
		if (!this.majorSlices.add(ms))
			throw new AddElementException(
					"Specified major task cannot be added!");
	}

	public void removeMajorSlice(MajorSlice ms) throws RemoveElementException {
		if (this.majorSlices.size() > 0)
			if (!this.majorSlices.remove(ms))
				throw new RemoveElementException(
						"Specified major task cannot be removed!");
	}

	@OneToMany(mappedBy = "majorTask")
	public List<MajorSlice> getMajorSlices() {
		return majorSlices;
	}

	public void setMajorSlices(ArrayList<MajorSlice> majorSlices) {
		this.majorSlices = majorSlices;
	}

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "majorTasks", targetEntity = Objective.class)
	public List<Objective> getObjectives() {
		return objectives;
	}

	public void setObjectives(List<Objective> objectives) {
		this.objectives = objectives;
	}

	@OneToMany(mappedBy = "majorTask")
	public List<Assignment> getAssignments() {
		return assignments;
	}

	public void setAssignments(List<Assignment> assignments) {
		this.assignments = assignments;
	}

	public void setMajorSlices(List<MajorSlice> majorSlices) {
		this.majorSlices = majorSlices;
	}

}
