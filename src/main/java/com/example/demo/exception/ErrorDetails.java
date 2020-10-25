package com.example.demo.exception;

import java.util.Date;

public class ErrorDetails {
	private Date timeStamp;
	private String message;
	private String details;
	
	public ErrorDetails(Date timeStamp,String message,String details)
	{
		this.details=details;
		this.timeStamp=timeStamp;
		this.message=message;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	
	public String getMessage() {
		return message;
	}

	

	public String getDetails() {
		return details;
	}

	

}
