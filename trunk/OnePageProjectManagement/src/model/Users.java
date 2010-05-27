package model;

import java.rmi.RemoteException;
import java.util.ArrayList;

import exception.AddElementException;

public class Users {

	private long id;
	private String userName;
	private String nameSurname;
	private String password;
	private ArrayList<Assignment> assignments;

	public Users(long id,String userName, String nameSurname, String password) {
		super();
		this.id = id;
		this.userName = userName;
		this.nameSurname = nameSurname;
		this.password = password;
	}

	public void addAssignment(Assignment assgn) throws AddElementException {
		if (this.assignments == null)
			setAssignments(new ArrayList<Assignment>());
		if (!this.assignments.add(assgn))
			throw new AddElementException(
					"Specified assignment cannot be added!");
	}

	public void removeAssignment(Assignment assgn) throws RemoteException {
		if (this.assignments.size() > 0)
			if (!this.assignments.remove(assgn))
				throw new RemoteException(
						"Specified assignment cannot be removed!");
	}

	public ArrayList<Assignment> getAssignments() {
		return assignments;
	}

	public void setAssignments(ArrayList<Assignment> assignments) {
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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
