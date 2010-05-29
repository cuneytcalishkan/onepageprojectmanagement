package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import exception.AddElementException;
import exception.RemoveElementException;

@Entity
@Table(name = "PUSER")
public class Puser {

	private long id;
	private String userName;
	private String nameSurname;
	private String password;
	private String role;
	private List<Assignment> assignments;
	private List<SubjectiveAssignment> subjectiveAssignments;
	private List<Project> projects;

	public Puser() {
		super();
		this.projects = new ArrayList<Project>();

	}

	public Puser(String userName, String nameSurname, String password,
			String role) {
		super();
		this.userName = userName;
		this.nameSurname = nameSurname;
		this.password = password;
		this.role = role;
		this.projects = new ArrayList<Project>();
	}

	public Puser(long id, String userName, String nameSurname, String password,
			String role) {
		super();
		this.id = id;
		this.userName = userName;
		this.nameSurname = nameSurname;
		this.password = password;
		this.role = role;
		this.projects = new ArrayList<Project>();
	}

	@Override
	public String toString() {
		return this.nameSurname;
	}

	public void addAssignment(Assignment assgn) throws AddElementException {
		if (this.assignments == null)
			setAssignments(new ArrayList<Assignment>());
		if (!this.assignments.add(assgn))
			throw new AddElementException(
					"Specified assignment cannot be added!");
	}

	public void removeAssignment(Assignment assgn)
			throws RemoveElementException {
		if (this.assignments.size() > 0)
			if (!this.assignments.remove(assgn))
				throw new RemoveElementException(
						"Specified assignment cannot be removed!");
	}

	public void addProject(Project prj) throws AddElementException {
		if (this.projects == null)
			setProjects(new ArrayList<Project>());
		if (!this.projects.add(prj)) {
			throw new AddElementException("Specified project cannot be added!");
		}
	}

	public void removeProject(Project prj) throws RemoveElementException {
		if (this.projects.size() > 0)
			if (!this.projects.remove(prj))
				throw new RemoveElementException(
						"Specified prject cannot be removed!");
	}

	@OneToMany(mappedBy = "puser")
	public List<Assignment> getAssignments() {
		return assignments;
	}

	public void setAssignments(List<Assignment> assignments) {
		this.assignments = assignments;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getNameSurname() {
		return nameSurname;
	}

	public void setNameSurname(String nameSurname) {
		this.nameSurname = nameSurname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "users", targetEntity = Project.class, fetch = FetchType.EAGER)
	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@OneToMany(mappedBy = "puser")
	public List<SubjectiveAssignment> getSubjectiveAssignments() {
		return subjectiveAssignments;
	}

	public void setSubjectiveAssignments(
			List<SubjectiveAssignment> subjectiveAssignments) {
		this.subjectiveAssignments = subjectiveAssignments;
	}

}
