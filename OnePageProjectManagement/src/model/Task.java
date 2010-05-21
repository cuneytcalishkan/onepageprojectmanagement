package model;

import java.util.ArrayList;

public abstract class Task {

	private String name;
	private ArrayList<Slice> slices;
	private Assignment assignments;

	public Task(String name) {
		super();
		this.name = name;
	}

	public Assignment getAssignments() {
		return assignments;
	}

	public void setAssignments(Assignment assignments) {
		this.assignments = assignments;
	}

	public void addSlice(Slice newSlice) {
		if (this.slices == null)
			setSlices(new ArrayList<Slice>());
		this.slices.add(newSlice);
	}

	public void removeSlice(Slice sl) {
		if (this.slices.size() > 0)
			this.slices.remove(sl);
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
