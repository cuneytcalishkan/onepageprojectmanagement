package model;

import java.util.ArrayList;

public class MajorTask extends Task {

	private ArrayList<MajorSlice> majorSlices;

	public MajorTask(String name) {
		super(name);
	}

	public void addMajorSlice(MajorSlice ms) {
		if (this.majorSlices == null)
			setMajorSlices(new ArrayList<MajorSlice>());
		this.majorSlices.add(ms);
	}

	public void removeMajorSlice(MajorSlice ms) {
		if (this.majorSlices.size() > 0)
			this.majorSlices.remove(ms);
	}

	public ArrayList<MajorSlice> getMajorSlices() {
		return majorSlices;
	}

	public void setMajorSlices(ArrayList<MajorSlice> majorSlices) {
		this.majorSlices = majorSlices;
	}

}
