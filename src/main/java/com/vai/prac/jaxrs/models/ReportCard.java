package com.vai.prac.jaxrs.models;

public class ReportCard {

	private long id;
	private Student student;
	private Double marks;

	public ReportCard(long id, Student student, double marks) {
		this.id = id;
		this.student = student;
		this.marks = marks;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Double getMarks() {
		return marks;
	}

	public void setMarks(Double marks) {
		this.marks = marks;
	}

}
