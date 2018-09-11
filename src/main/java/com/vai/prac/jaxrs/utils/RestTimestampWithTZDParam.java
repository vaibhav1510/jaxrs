package com.vai.prac.jaxrs.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.ws.rs.WebApplicationException;

public class RestTimestampWithTZDParam {

	private SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
	private java.util.Date date;

	public RestTimestampWithTZDParam(String dateTimeStr) throws WebApplicationException {
		try {
			date = new java.util.Date(df.parse(dateTimeStr).getTime());
		} catch (final ParseException ex) {
			throw new WebApplicationException(ex);
		}
	}

	public java.util.Date getDate() {
		return date;
	}

	@Override
	public String toString() {
		if (date != null) {
			return date.toString();
		} else {
			return "";
		}
	}
}