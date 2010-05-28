package model;

import java.awt.Color;
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
@Table(name = "SUBJECTIVESLICE")
public class SubjectiveSlice extends Slice {

	private Color color;
	private SubjectiveTask task;

	@Override
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		// TODO Auto-generated method stub
		return super.getId();
	}

	public SubjectiveSlice(Date sliceDate) {
		super(sliceDate);
	}

	public SubjectiveSlice(long id, Date sliceDate) {
		super(id, sliceDate);
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "ST_HAS", joinColumns = @JoinColumn(name = "SUBJECTIVESLICE_ID"), inverseJoinColumns = @JoinColumn(name = "SUBJECTIVETASK_ID"))
	public SubjectiveTask getTask() {
		return task;
	}

	public void setTask(SubjectiveTask task) {
		this.task = task;
	}

}
