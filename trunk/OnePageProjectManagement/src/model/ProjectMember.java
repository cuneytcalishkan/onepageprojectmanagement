package model;

public class ProjectMember extends Puser {

	public ProjectMember(long id, String userName, String nameSurname,
			String password) {
		super(id, userName, nameSurname, password, "project member");

	}

	public ProjectMember(String userName, String nameSurname, String password) {
		super(userName, nameSurname, password, "project member");
	}
}
