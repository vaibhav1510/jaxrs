package com.vai.prac.jaxrs.resources;

import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("/injdemo")
@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.TEXT_PLAIN)
public class InjectDemo {

	@GET
	@Path("annots")
	public String getParamsUsingAnnotations(@MatrixParam("param") String matrixParam,
			@HeaderParam("ip_address") String ipAddr, @CookieParam("email") String email) {
		return "Matrix Param: " + matrixParam + "| HEADER: " + ipAddr + "| Coocke: " + email;
	}

	@GET
	@Path("context")
	public String getParamsUsingContext(@Context UriInfo uriInfo, @Context HttpHeaders headers) {

		StringBuffer buf = new StringBuffer();
		// uriInfo.getQueryParameters()
		String path = uriInfo.getAbsolutePath().toString();
		buf.append(path + " | ");

		String hdrs = headers.getRequestHeaders().toString();
		buf.append(hdrs + " | ");

		String coockies = headers.getCookies().toString();
		buf.append(coockies + " | ");
		return buf.toString();
	}
}
