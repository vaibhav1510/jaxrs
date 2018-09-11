package com.vai.prac.jaxrs.services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.ws.rs.PathParam;

import com.vai.prac.jaxrs.database.DBClass;
import com.vai.prac.jaxrs.models.Student;

public class StudentService {

	private Map<Long, Student> students = DBClass.getStudents();

	public StudentService() {
		put(new Student(1l, "Gemi"));
		put(new Student(2l, "Smith"));
		put(new Student(3l, "Mini"));
		put(new Student(4l, "Idea"));
		put(new Student(5l, "John"));
		put(new Student(6l, "Duggu"));
	}

	private void put(Student s) {
		students.put(s.getId(), s);
	}

	public List<Student> getAllStudents() {
		return new ArrayList<Student>(students.values());
		// Student s1 = new Student(1l, "John");
		// Student s2 = new Student(2l, "Smith");
		// List<Student> l = new ArrayList<>();
		// l.add(s1);
		// l.add(s2);
		// return l;
	}

	public List<Student> getStudentsForYear(int year) {
		ArrayList<Student> toRet = new ArrayList<>();
		Calendar cal = Calendar.getInstance();
		for (Student s : students.values()) {
			cal.setTime(s.getCreatedAt());
			if (cal.get(Calendar.YEAR) == year) {
				toRet.add(s);
			}
		}
		return toRet;
	}

	public List<Student> getStudentsPaginated(int start, int size) {
		ArrayList<Student> toRet = new ArrayList<>(students.values());
		if (size + start > students.size()) {
			return new ArrayList<Student>();
		}
		return toRet.subList(start, start + size);
	}

	public Student getStudent(long id) {
		return students.get(id);
	}

	public Student addStudent(Student student) {
		student.setId(students.size() + 1);
		students.put(student.getId(), student);
		return student;
	}

	public Student updateStudent(Student student) {
		if (!students.containsKey(student.getId())) {
			return null;
		}
		students.put(student.getId(), student);
		return student;
	}

	public Student removeStudent(long studentId) {
		return students.remove(studentId);
	}
}
