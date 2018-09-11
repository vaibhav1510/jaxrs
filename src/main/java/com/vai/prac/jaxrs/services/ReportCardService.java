package com.vai.prac.jaxrs.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.vai.prac.jaxrs.database.DBClass;
import com.vai.prac.jaxrs.models.ReportCard;
import com.vai.prac.jaxrs.models.Student;

public class ReportCardService {
	
	private Map<String/* student name */, ReportCard> reports = DBClass.getReports();

	public ReportCardService() {

		Student s3 = new Student(3l, "Gemi");
		ReportCard rep3 = new ReportCard(3l, s3, 65.18d);

		Student s4 = new Student(4l, "Smith");
		ReportCard rep4 = new ReportCard(4l, s4, 89.2d);

		reports.put(rep3.getStudent().getName(), rep3);
		reports.put(rep4.getStudent().getName(), rep4);
	}

	public List<ReportCard> getAllReports() {
		return new ArrayList<ReportCard>(reports.values());
	}

	public ReportCard getReport(String studentName) {
		return reports.get(studentName);
	}

	public ReportCard addReport(ReportCard report) {
		report.setId(reports.size() + 1);
		reports.put(report.getStudent().getName(), report);
		return report;
	}

	public ReportCard updateReport(ReportCard report) {
		if (!reports.containsKey(report.getStudent().getName())) {
			return null;
		}
		reports.put(report.getStudent().getName(), report);
		return report;
	}

	public ReportCard removeReport(String studentName) {
		return reports.remove(studentName);
	}
}
