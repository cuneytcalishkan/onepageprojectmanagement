package model;

import java.util.ArrayList;

import exception.AddElementException;
import exception.RemoveElementException;

public class SubjectiveTask extends Task {

	private ArrayList<SubjectiveSlice> subjectiveSlices;

	public SubjectiveTask() {
		super();
	}

	public SubjectiveTask(long id, String name) {
		super(id, name);
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

	public ArrayList<SubjectiveSlice> getSubjectiveSlices() {
		return subjectiveSlices;
	}

	public void setSubjectiveSlices(ArrayList<SubjectiveSlice> subjectiveSlices) {
		this.subjectiveSlices = subjectiveSlices;
	}

}
