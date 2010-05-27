package model;

public class ProjectManager extends Puser {

	public ProjectManager(long id, String userName, String nameSurname,
			String password) {
		super(id, userName, nameSurname, password, "project manager");
	}

	public ProjectManager(String userName, String nameSurname, String password) {
		super(userName, nameSurname, password, "project manager");
	}
}
