package com.vai.prac.jaxrs.resources;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.vai.prac.jaxrs.models.Student;
import com.vai.prac.jaxrs.resources.beans.StudentfFilterBean;
import com.vai.prac.jaxrs.services.StudentService;

@Path("/students")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class StudentRes {

	StudentService serv = new StudentService();

	@GET
	@Produces(MediaType.APPLICATION_XML)
	// public List<Student> getAllStudents(@QueryParam("year") int year,
	// @QueryParam("start") int start,
	// @QueryParam("size") int size) {
	public List<Student> getAllStudents(@BeanParam StudentfFilterBean bean) {

		if (bean.getYear() > 0) {
			return serv.getStudentsForYear(bean.getYear());
		}
		if (bean.getStart() >= 0 && bean.getSize() >= 0) {
			return serv.getStudentsPaginated(bean.getStart(), bean.getSize());
		}

		return serv.getAllStudents();
	}

	@GET
	@Path("/{studentId}")
	public Student getStudent(@PathParam("studentId") long id) {
		return serv.getStudent(id);
	}

	@POST
	public Student addStudent(Student student) {
		return serv.addStudent(student);
	}

	@PUT
	@Path("/{studentId}")
	// @Consumes(MediaType.APPLICATION_JSON)
	// @Produces(MediaType.APPLICATION_JSON)
	public Student updateStudent(Student student, @PathParam("studentId") long id) {
		student.setId(id);
		return serv.updateStudent(student);
	}

	@DELETE
	@Path("/{studentId}")
	public Student deleteStudent(@PathParam("studentId") long id) {
		return serv.removeStudent(id);
	}

	@GET
	@Path("/test")
	@Produces(MediaType.TEXT_PLAIN)
	public String getTest() {
		return "TEST app";
	}
}
