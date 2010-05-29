package controller;

import java.util.Date;
import java.util.Formatter;

public class Utilizer {

	public String getDateAsString(Date date) {
		Formatter formatter = new Formatter();
		return formatter.format("DD-MM-YYYY", date).toString();
	}
}
