package model;

import java.awt.Color;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SUBJECTIVESLICE")
public class SubjectiveSlice extends Slice {

	private Color color;
	
	

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

}
