package model;

import java.util.ArrayList;

import exception.AddElementException;
import exception.RemoveElementException;

public class MajorTask extends Task {

	private ArrayList<MajorSlice> majorSlices;

	public MajorTask(long id, String name) {
		super(id, name);
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

	public ArrayList<MajorSlice> getMajorSlices() {
		return majorSlices;
	}

	public void setMajorSlices(ArrayList<MajorSlice> majorSlices) {
		this.majorSlices = majorSlices;
	}

}
