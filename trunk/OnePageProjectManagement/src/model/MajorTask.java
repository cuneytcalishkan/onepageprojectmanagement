package model;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import exception.AddElementException;
import exception.RemoveElementException;

@Entity
@Table(name = "MAJORTASK")
@Embeddable
public class MajorTask extends Task {

	//private List<Assignment> assignments;
	private List<MajorSlice> majorSlices;
	private List<Objective> objectives;

	public MajorTask(long id, String name) {
		super(id, name);
	}

	@Override
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return super.getId();
	}

//	public void addAssignment(Assignment assgn) throws AddElementException {
//		if (this.assignments == null)
//			setAssignments(new ArrayList<Assignment>());
//		if (!this.assignments.add(assgn))
//			throw new AddElementException(
//					"Specified assignment cannot be added!");
//	}
//
//	public void removeAssignment(Assignment assgn) throws RemoteException {
//		if (this.assignments.size() > 0)
//			if (!this.assignments.remove(assgn))
//				throw new RemoteException(
//						"Specified assignment cannot be removed!");
//	}
//
//	@OneToMany(mappedBy = "majorTask")
//	public List<Assignment> getAssignments() {
//		return assignments;
//	}

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
	@JoinTable(name = "MT_HAS", joinColumns = @JoinColumn(name = "MAJORTASK_ID"), inverseJoinColumns = @JoinColumn(name = "MAJORSLICE_ID"))
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

//	public void setAssignments(List<Assignment> assignments) {
//		this.assignments = assignments;
//	}

	public void setMajorSlices(List<MajorSlice> majorSlices) {
		this.majorSlices = majorSlices;
	}

}
