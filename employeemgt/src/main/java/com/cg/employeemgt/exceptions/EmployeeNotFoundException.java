package com.cg.employeemgt.exceptions;

public class EmployeeNotFoundException extends RuntimeException{
	
	public EmployeeNotFoundException(String msg) {
		super(msg);
	}
}
