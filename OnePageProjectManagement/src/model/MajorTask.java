package model;

import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import exception.AddElementException;
import exception.RemoveElementException;

@Entity
@Table(name = "MAJORTASK")
public class MajorTask extends Task {

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "projects", targetEntity = Puser.class)

	private ArrayList<MajorSlice> majorSlices;

	public MajorTask(long id, String name) {
		super(id, name);
	}

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "tasks", targetEntity = Objective.class)
	
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
