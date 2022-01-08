package com.RestWeb.Exception;

import java.util.Date;

//I wouldeven think a level above and make it a standard across almost all services in your organization
//so that everybody can use this structure and this structure should be language independent
//What we want  to do is whenever an exception happens we would return a response back in this format
public class ExceptionResponse {
	private Date timestamp;
	private  String message;
	private String details;
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public ExceptionResponse(Date timestamp, String message, String details) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}
	public ExceptionResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ExceptionResponse [timestamp=" + timestamp + ", message=" + message + ", details=" + details + "]";
	}

}
