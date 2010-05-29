package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "COST")
public class Cost {

	private long id;
	private String color;
	private float budget;
	private float expense;
	private Project project;

	public Cost() {
		super();
	}

	public Cost(String color, float budget, float expense) {
		super();
		this.color = color;
		this.budget = budget;
		this.expense = expense;
	}

	public Cost(long id, String color, float budget, float expense) {
		super();
		this.id = id;
		this.color = color;
		this.budget = budget;
		this.expense = expense;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
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
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name = "projectId")
	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

}
