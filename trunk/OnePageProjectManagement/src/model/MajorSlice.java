package model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "MAJORSLICE")
public class MajorSlice extends Slice {

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "MT_HAS", joinColumns = @JoinColumn(name = "MAJORSLICE_ID"), inverseJoinColumns = @JoinColumn(name = "MAJORTASK_ID"))
	
	private boolean completed;
	private boolean verified;

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

}
