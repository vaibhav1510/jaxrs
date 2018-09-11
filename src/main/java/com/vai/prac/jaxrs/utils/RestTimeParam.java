package com.vai.prac.jaxrs.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.ws.rs.WebApplicationException;

public class RestTimeParam {

	private SimpleDateFormat df = new SimpleDateFormat("h:mma");
	private java.sql.Time time;

	public RestTimeParam(String timeStr) throws WebApplicationException {
		try {
			time = new java.sql.Time(df.parse(timeStr).getTime());
		} catch (final ParseException ex) {
			throw new WebApplicationException(ex);
		}
	}

	public java.sql.Time getTime() {
		return time;
	}

	@Override
	public String toString() {
		if (time != null) {
			return time.toString();
		} else {
			return "";
		}
	}
}