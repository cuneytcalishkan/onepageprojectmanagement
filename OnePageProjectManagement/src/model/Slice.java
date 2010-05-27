package model;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public abstract class Slice {

	private long id;
	private Date sliceDate;

	public Slice() {
		super();
	}

	public Slice(Date sliceDate) {
		super();
		this.sliceDate = sliceDate;
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

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
