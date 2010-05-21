package model;

import java.util.ArrayList;

public class SubjectiveTask extends Task {

	private ArrayList<SubjectiveSlice> subjectiveSlices;

	public SubjectiveTask(String name) {
		super(name);
	}

	public void addSubjectiveSlice(SubjectiveSlice ss) {
		if (this.subjectiveSlices == null)
			setSubjectiveSlices(new ArrayList<SubjectiveSlice>());
		this.subjectiveSlices.add(ss);
	}

	public void removeSubjectiveSlice(SubjectiveSlice ss) {
		if (this.subjectiveSlices.size() > 0)
			this.subjectiveSlices.remove(ss);
	}

	public ArrayList<SubjectiveSlice> getSubjectiveSlices() {
		return subjectiveSlices;
	}

	public void setSubjectiveSlices(ArrayList<SubjectiveSlice> subjectiveSlices) {
		this.subjectiveSlices = subjectiveSlices;
	}

}
