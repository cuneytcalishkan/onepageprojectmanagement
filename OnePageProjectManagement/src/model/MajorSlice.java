package model;

import java.util.Date;

public class MajorSlice extends Slice {

	private boolean completed;
	private boolean verified;

	public MajorSlice(Date sliceDate) {
		super(sliceDate);
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
