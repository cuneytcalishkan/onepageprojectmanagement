package model;

import java.awt.Color;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "SUBJECTIVESLICE")
public class SubjectiveSlice {

	private long id;
	private Date sliceDate;
	private Color color;
	private SubjectiveTask task;

	public SubjectiveSlice(Date sliceDate) {
		this.sliceDate = sliceDate;
	}

	public SubjectiveSlice(long id, Date sliceDate) {
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

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	@ManyToOne
    @JoinColumn(name="subjectiveSliceId")
	public SubjectiveTask getTask() {
		return task;
	}

	public void setTask(SubjectiveTask task) {
		this.task = task;
	}

}
