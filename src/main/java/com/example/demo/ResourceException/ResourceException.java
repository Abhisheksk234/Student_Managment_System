package com.example.demo.ResourceException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class ResourceException extends RuntimeException
{
	 private String msg;

	public ResourceException(String msg) {
		super();
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}
	
	

}
