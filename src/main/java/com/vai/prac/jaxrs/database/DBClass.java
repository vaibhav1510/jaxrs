package com.vai.prac.jaxrs.database;

import java.util.HashMap;
import java.util.Map;

import com.vai.prac.jaxrs.models.ReportCard;
import com.vai.prac.jaxrs.models.Student;

public class DBClass {

	private static Map<Long, Student> students = new HashMap<>();
	private static Map<String, ReportCard> reports = new HashMap<>();

	public static Map<Long, Student> getStudents() {
		return students;
	}
	
	public static Map<String, ReportCard> getReports() {
		return reports;
	}

}
