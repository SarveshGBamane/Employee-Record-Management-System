package com.app.service;

import java.sql.SQLException;

public interface ERMS_Service {

	public void addEmployee() throws SQLException;
	
	public void ViewEmployee() throws SQLException;
	
	public void searchEmployeeByID() throws SQLException;
	
	public void updateEmployee() throws SQLException;
	
	public void DeleteEmployee() throws SQLException;
	
}
