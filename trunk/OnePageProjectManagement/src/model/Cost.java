package model;

import java.awt.Color;

public class Cost {

	private long id;
	private Color color;
	private float budget;
	private float expense;

	public Cost() {
		super();
	}

	public Cost(long id, Color color, float budget, float expense) {
		super();
		this.id = id;
		this.color = color;
		this.budget = budget;
		this.expense = expense;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public float getBudget() {
		return budget;
	}

	public void setBudget(float budget) {
		this.budget = budget;
	}

	public float getExpense() {
		return expense;
	}

	public void setExpense(float expense) {
		this.expense = expense;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
