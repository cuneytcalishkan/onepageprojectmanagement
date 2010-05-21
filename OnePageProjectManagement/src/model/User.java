package model;

public class User {

	private String userName;
	private String nameSurname;
	private String password;
	private Assignment assignments;

	public User(String userName, String nameSurname, String password) {
		super();
		this.userName = userName;
		this.nameSurname = nameSurname;
		this.password = password;
	}

	public Assignment getAssignments() {
		return assignments;
	}

	public void setAssignments(Assignment assignments) {
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

}
