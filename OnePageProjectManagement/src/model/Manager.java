package model;

public class Manager extends Puser {

	public Manager(long id, String userName, String nameSurname, String password) {
		super(id, userName, nameSurname, password, "manager");
	}

	public Manager(String userName, String nameSurname, String password) {
		super(userName, nameSurname, password, "manager");
	}

}
