package model;

import java.awt.Color;
import java.util.Date;

public class SubjectiveSlice extends Slice {

	private Color color;

	public SubjectiveSlice(Date sliceDate) {
		super(sliceDate);
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

}
