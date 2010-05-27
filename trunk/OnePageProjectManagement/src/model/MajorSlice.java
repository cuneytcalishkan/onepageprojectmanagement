package model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MAJORSLICE")
public class MajorSlice extends Slice {
	private boolean completed;
	private boolean verified;
	
	

	@Override
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		// TODO Auto-generated method stub
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

}
