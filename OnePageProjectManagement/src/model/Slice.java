package model;

import java.util.Date;

public abstract class Slice {

	private Date sliceDate;

	public Slice(Date sliceDate) {
		super();
		this.sliceDate = sliceDate;
	}

	public Date getSliceDate() {
		return sliceDate;
	}

	public void setSliceDate(Date sliceDate) {
		this.sliceDate = sliceDate;
	}

}
