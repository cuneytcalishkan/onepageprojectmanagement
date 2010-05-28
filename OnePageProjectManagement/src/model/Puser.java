package model;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import exception.AddElementException;
import exception.RemoveElementException;

@Entity
@Table(name = "PUSER")
@Embeddable
public class Puser {

	private long id;
	private String userName;
	private String nameSurname;
	private String password;
	private String role;
	//private List<Assignment> assignments;
	private List<Project> projects;

	public Puser() {
		super();

	}

	public Puser(String userName, String nameSurname, String password,
			String role) {
		super();
		this.userName = userName;
		this.nameSurname = nameSurname;
		this.password = password;
		this.role = role;
	}

	public Puser(long id, String userName, String nameSurname, String password,
			String role) {
		super();
		this.id = id;
		this.userName = userName;
		this.nameSurname = nameSurname;
		this.password = password;
		this.role = role;
	}

	@Override
	public String toString() {
		return this.nameSurname;
	}

//	public void addAssignment(Assignment assgn) throws AddElementException {
//		if (this.assignments == null)
//			setAssignments(new ArrayList<Assignment>());
//		if (!this.assignments.add(assgn))
//			throw new AddElementException(
//					"Specified assignment cannot be added!");
//	}
//
//	public void removeAssignment(Assignment assgn) throws RemoteException {
//		if (this.assignments.size() > 0)
//			if (!this.assignments.remove(assgn))
//				throw new RemoteException(
//						"Specified assignment cannot be removed!");
//	}

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

//	@OneToMany(mappedBy = "user")
//	public List<Assignment> getAssignments() {
//		return assignments;
//	}
//
//	public void setAssignments(List<Assignment> assignments) {
//		this.assignments = assignments;
//	}

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
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@ManyToMany(targetEntity = Project.class, cascade = { CascadeType.PERSIST,
			CascadeType.MERGE })
	@JoinTable(name = "WORKSON", joinColumns = @JoinColumn(name = "USER_ID"), inverseJoinColumns = @JoinColumn(name = "PROJECT_ID"))
	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(ArrayList<Project> projects) {
		this.projects = projects;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
