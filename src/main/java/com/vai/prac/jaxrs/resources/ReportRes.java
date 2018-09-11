package com.vai.prac.jaxrs.resources;

import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.vai.prac.jaxrs.models.ReportCard;
import com.vai.prac.jaxrs.models.Student;
import com.vai.prac.jaxrs.services.ReportCardService;

@Path("/reports")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

public class ReportRes {
	private ReportCardService serv = new ReportCardService();

	@GET
	public List<ReportCard> getAllReports() {
		return serv.getAllReports();
	}

	@POST
	public ReportCard addReport(ReportCard report) {
		return serv.addReport(report);
	}

	@PUT
	@Path("/{studentName}")
	public ReportCard updateReport(ReportCard report, @PathParam("{studentName}") String studentName) {
		ReportCard existingRep = serv.getReport(studentName);
		report.setId(existingRep.getId());		
		return serv.updateReport(report);
	}

	@DELETE
	@Path("/{studentName}")
	public ReportCard deleteReport(@PathParam("studentName") String studentName) {
		return serv.removeReport(studentName);
	}
}
