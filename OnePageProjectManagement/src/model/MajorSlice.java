package model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "MAJORSLICE")
public class MajorSlice {
	private long id;
	private Date sliceDate;
	private boolean completed;
	private boolean verified;
	private MajorTask majorTask;

	public MajorSlice(long id, Date sliceDate) {
		this.id = id;
		this.sliceDate = sliceDate;
	}

	public Date getSliceDate() {
		return sliceDate;
	}

	public void setSliceDate(Date sliceDate) {
		this.sliceDate = sliceDate;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	@ManyToOne
    @JoinColumn(name="majorTaskId")
	public MajorTask getMajorTask() {
		return majorTask;
	}

	public void setMajorTask(MajorTask task) {
		this.majorTask = task;
	}

}
