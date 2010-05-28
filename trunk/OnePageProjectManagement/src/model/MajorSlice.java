package model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "MAJORSLICE")
public class MajorSlice extends Slice {
	private boolean completed;
	private boolean verified;
	private MajorTask majorTask;

	@Override
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return super.getId();
	}

	public MajorSlice(long id, Date sliceDate) {
		super(id, sliceDate);
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	public boolean isVerified() {
		return verified;
	}

	public void setVerified(boolean verified) {
		this.verified = verified;
	}

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "MT_HAS", joinColumns = @JoinColumn(name = "MAJORSLICE_ID"), inverseJoinColumns = @JoinColumn(name = "MAJORTASK_ID"))
	public MajorTask getMajorTask() {
		return majorTask;
	}

	public void setMajorTask(MajorTask task) {
		this.majorTask = task;
	}

}
