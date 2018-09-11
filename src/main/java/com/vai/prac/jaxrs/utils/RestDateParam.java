package com.vai.prac.jaxrs.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.ext.Provider;
import javax.xml.bind.annotation.adapters.XmlAdapter;

@Provider
public class RestDateParam extends XmlAdapter<String, Date>{

	// Declare the date format for the parsing to be correct
	private SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	private java.sql.Date date;
//
//	/**
//	 * This is the default constructor which must take in one string parameter. The
//	 * parameter is no other than the one passed in through the REST end-point.
//	 * We'll see it later...
//	 */
//	public RestDateParam(String dateStr) throws WebApplicationException {
//		try {
//			date = new java.sql.Date(df.parse(dateStr).getTime());
//		} catch (final ParseException ex) {
//			// Wrap up any expection as javax.ws.rs.WebApplicationException
//			throw new WebApplicationException(ex);
//		}
//	}

	
	@Override
	public String toString() {
		if (date != null) {
			return date.toString();
		} else {
			return "";
		}
	}

	@Override
	public String marshal(Date dateStr) throws Exception {
		synchronized (df) {
            return df.format(dateStr);
        }
	}
	
	@Override
	public Date unmarshal(String dateStr) throws Exception {
		try {
			date = new java.sql.Date(df.parse(dateStr).getTime());
			return date;
		} catch (final ParseException ex) {
			// Wrap up any expection as javax.ws.rs.WebApplicationException
			throw new WebApplicationException(ex);
		}
	}

	
}