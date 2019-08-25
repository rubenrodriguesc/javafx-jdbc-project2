package gui.tests;

import java.util.Date;

public class DateTest {

	public static void main(String[] args) {

		Date date = new Date();
		java.sql.Date dateSQL = new java.sql.Date(1);
		System.out.println(date);
		System.out.println(dateSQL);
	}

}
