package model;

import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import exception.AddElementException;
import exception.RemoveElementException;

@Entity
@Table(name = "MAJORTASK")
public class MajorTask extends Task {

	private ArrayList<Assignment> assignments;
	private ArrayList<MajorSlice> majorSlices;

	public MajorTask(long id, String name) {
		super(id, name);
	}

	public void addAssignment(Assignment assgn) throws AddElementException {
		if (this.assignments == null)
			setAssignments(new ArrayList<Assignment>());
		if (!this.assignments.add(assgn))
			throw new AddElementException(
					"Specified assignment cannot be added!");
	}

	public void removeAssignment(Assignment assgn) throws RemoteException {
		if (this.assignments.size() > 0)
			if (!this.assignments.remove(assgn))
				throw new RemoteException(
						"Specified assignment cannot be removed!");
	}

	public ArrayList<Assignment> getAssignments() {
		return assignments;
	}

	public void setAssignments(ArrayList<Assignment> assignments) {
		this.assignments = assignments;
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

	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "MT_HAS", joinColumns = @JoinColumn(name = "MAJORTASK_ID"), inverseJoinColumns = @JoinColumn(name = "MAJORSLICE_ID"))
	public ArrayList<MajorSlice> getMajorSlices() {
		return majorSlices;
	}

	public void setMajorSlices(ArrayList<MajorSlice> majorSlices) {
		this.majorSlices = majorSlices;
	}

}
