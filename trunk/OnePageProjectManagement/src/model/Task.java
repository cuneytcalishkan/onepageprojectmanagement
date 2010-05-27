package model;

import java.util.ArrayList;

import exception.AddElementException;
import exception.RemoveElementException;

public abstract class Task {

	private long id;
	private String name;
	private ArrayList<Slice> slices;
	

	public Task() {
		super();
	}

	public Task(long id, String name) {
		super();
		this.id = id;
		this.name = name;
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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
