package model;

import java.awt.Color;

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
@Table(name = "COST")
public class Cost {

	private long id;
	private Color color;
	private float budget;
	private float expense;
	private Project project;

	public Cost() {
		super();
	}

	public Cost(Color color, float budget, float expense) {
		super();
		this.color = color;
		this.budget = budget;
		this.expense = expense;
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

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@ManyToOne(cascade = { CascadeType.PERSIST , CascadeType.MERGE})
	@JoinTable(name = "PROJECT_HAS", joinColumns = @JoinColumn(name = "COST_ID"), inverseJoinColumns = @JoinColumn(name = "PROJECT_ID"))
	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

}
