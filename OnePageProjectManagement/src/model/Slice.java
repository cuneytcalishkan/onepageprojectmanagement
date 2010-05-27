package model;

import java.util.Date;

public abstract class Slice {

	private long id;
	private Date sliceDate;

	public Slice() {
		super();
	}

	public Slice(long id, Date sliceDate) {
		super();
		this.id = id;
		this.sliceDate = sliceDate;
	}

	public Date getSliceDate() {
		return sliceDate;
	}

	public void setSliceDate(Date sliceDate) {
		this.sliceDate = sliceDate;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
