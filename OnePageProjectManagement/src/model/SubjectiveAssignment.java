package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "SUBJECTIVEASSIGNMENT")
public class SubjectiveAssignment {

	private long id;
	private char priority;
	private Puser puser;
	private SubjectiveTask subjectiveTask;

	public SubjectiveAssignment() {
		super();
	}

	public SubjectiveAssignment(char priority, Puser user, SubjectiveTask task) {
		super();
		this.priority = priority;
		this.puser = user;
		this.subjectiveTask = task;
	}

	public char getPriority() {
		return priority;
	}

	public void setPriority(char priority) {
		this.priority = priority;
	}

	@ManyToOne
	@JoinColumn(name = "PUSER_ID")
	public Puser getPuser() {
		return puser;
	}

	public void setPuser(Puser user) {
		this.puser = user;
	}

	@ManyToOne
	@JoinColumn(name = "SubjectiveTask_ID")
	public SubjectiveTask getSubjectiveTask() {
		return subjectiveTask;
	}

	public void setSubjectiveTask(SubjectiveTask task) {
		this.subjectiveTask = task;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
