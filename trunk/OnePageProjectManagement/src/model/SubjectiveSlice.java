package model;

import java.awt.Color;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "SUBJECTIVESLICE")
public class SubjectiveSlice extends Slice {

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "ST_HAS", joinColumns = @JoinColumn(name = "SUBJECTIVESLICE_ID"), inverseJoinColumns = @JoinColumn(name = "SUBJECTIVETASK_ID"))
	private Color color;

	public SubjectiveSlice(long id, Date sliceDate) {
		super(id, sliceDate);
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

}
