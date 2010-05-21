package model;

import java.rmi.RemoteException;
import java.util.ArrayList;

import exception.AddElementException;
import exception.RemoveElementException;

public abstract class Task {

	private String name;
	private ArrayList<Slice> slices;
	private ArrayList<Assignment> assignments;

	public Task(String name) {
		super();
		this.name = name;
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

	public void addSlice(Slice newSlice) throws AddElementException {
		if (this.slices == null)
			setSlices(new ArrayList<Slice>());
		if (!this.slices.add(newSlice))
			throw new AddElementException("Specified slice cannot be added!");
	}

	public void removeSlice(Slice sl) throws RemoveElementException {
		if (this.slices.size() > 0)
			if (!this.slices.remove(sl))
				throw new RemoveElementException(
						"Specified slice cannot be removed!");
	}

	public ArrayList<Slice> getSlices() {
		return slices;
	}

	public void setSlices(ArrayList<Slice> slices) {
		this.slices = slices;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
