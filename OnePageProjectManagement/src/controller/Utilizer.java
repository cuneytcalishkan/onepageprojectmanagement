package controller;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utilizer {

	public static String getDateAsString(Date date) {
		Format formatter = new SimpleDateFormat("dd-MM-yyyy");
		return formatter.format(date);
	}
}
