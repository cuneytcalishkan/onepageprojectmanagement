package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import exception.AddElementException;
import exception.RemoveElementException;

@Entity
@Table(name = "SUBJECTIVETASK")
public class SubjectiveTask extends Task {

	private List<SubjectiveSlice> subjectiveSlices;

	public SubjectiveTask() {
		super();
	}

	public SubjectiveTask(String name) {
		super(name);
	}

	public SubjectiveTask(long id, String name) {
		super(id, name);
	}

	@Override
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		// TODO Auto-generated method stub
		return super.getId();
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

	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "ST_HAS", joinColumns = @JoinColumn(name = "SUBJECTIVE_ID"), inverseJoinColumns = @JoinColumn(name = "SUBJECTIVESLICE_ID"))
	public List<SubjectiveSlice> getSubjectiveSlices() {
		return subjectiveSlices;
	}

	public void setSubjectiveSlices(ArrayList<SubjectiveSlice> subjectiveSlices) {
		this.subjectiveSlices = subjectiveSlices;
	}

}
