package com.app.serviceImp;

import com.app.service.ERMS_Service;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.app.connection.DbConnection;
import com.app.model.*;

public class ERMS_ServiceImpl implements ERMS_Service{

	Employee e = new Employee();
	Scanner sc = new Scanner(System.in);

	@Override
	public void addEmployee() throws SQLException {
		
		Connection con = DbConnection.getConnection();
		
		String insertData = "insert into employee values (?,?,?,?,?)";
		
		PreparedStatement ps = con.prepareStatement(insertData);
		
		System.out.println("Enter Employee Id : ");
		e.setId(sc.nextInt());
		sc.nextLine();
		
		System.out.println("Enter Employee Name : ");
		e.setName(sc.nextLine());
		
		System.out.println("Enter Employee Gender : ");
		e.setGender(sc.nextLine());
		
		System.out.println("Enter Employee Department : ");
		e.setDept(sc.nextLine());
		
		System.out.println("Enter Employee Salary : ");
		e.setSalary(sc.nextDouble());
		
		
		ps.setInt(1, e.getId());
		ps.setString(2, e.getName());
		ps.setString(3, e.getGender());
		ps.setString(4, e.getDept());
		ps.setDouble(5, e.getSalary());
		
		ps.execute();
		
		ps.close();
		con.close();
		System.out.println("Employee added succesfully.");
		System.out.println("------------------------------------------------------------");

	}

	@Override
	public void ViewEmployee() throws SQLException {
		
		Connection con = DbConnection.getConnection();
		
		String viewData = "select * from employee";
		
		Statement smt  = con.createStatement();
		
		ResultSet rs = smt.executeQuery(viewData);
		
		System.out.println("=============================================================");
		System.out.println("Id" + " | "+ "Name" + " | " + "Gender" + " | "+ "Department "+ " | "+ "Salary ");
		System.out.println("=============================================================");
		
		while(rs.next()) {
			
			System.out.println(rs.getInt(1)+"       " + " | "+ rs.getString(2)+"     " + "  | " + rs.getString(3) +"        " + " | "+ rs.getString(4)+"        " + " | "+ rs.getDouble(5));
		}
				
		rs.close();
		
		smt.close();
		
		con.close();
		
		System.out.println("------------------------------------------------------------");
		
	}

	@Override
	public void searchEmployeeByID() throws SQLException {
		
		Connection con = DbConnection.getConnection();
		
		String viewDataById = "select * from employee where id = ?";
		
		PreparedStatement ps = con.prepareStatement(viewDataById);

	    System.out.println("Enter Employee Id : ");
	    int id = sc.nextInt();

	    ps.setInt(1, id);

	    ResultSet rs = ps.executeQuery();
	    System.out.println("=============================================================");
		System.out.println("Id" + " | "+ "Name" + " | " + "Gender" + " | "+ "Department "+ " | "+ "Salary ");
		System.out.println("=============================================================");

	    if (rs.next()) {

			System.out.println(rs.getInt(1)+"       " + " | "+ rs.getString(2)+"     " + "  | " + rs.getString(3) +"        " + " | "+ rs.getString(4)+"        " + " | "+ rs.getDouble(5));


	    } else {
	        System.out.println("Employee Not Found ");
	    }

	    rs.close();
	    ps.close();
	    con.close();
		
		System.out.println("------------------------------------------------------------");

	}

	@Override
	public void updateEmployee() throws SQLException {
	
		System.out.println("1.Update Name\n2.Update Gender \n3.Update Department \n4.Update Salary");

		System.out.println("Enter Your Choice for updation : ");
		int ch = sc.nextInt();
		
		System.out.println("Enter Employee ID : ");
		int e_id = sc.nextInt();
		sc.nextLine();
		
		
		switch(ch) {
		
		case 1:{
		
			Connection con = DbConnection.getConnection();
			
			String updateRecord = "update employee set name = ? where id = ?";
			
			PreparedStatement ps = con.prepareStatement(updateRecord);
			
			System.out.println("Enter Name :");
			ps.setString(1, sc.nextLine());
			
			ps.setInt(2, e_id);
			
			ps.execute();
			
			ps.close();
			con.close();
			
			System.out.println("Employee name updated successfully");

			
		}
		break;
		case 2:{
			Connection con = DbConnection.getConnection();
			
			String updateRecord = "update employee set gender = ? where id = ?";
			
			PreparedStatement ps = con.prepareStatement(updateRecord);
			
			System.out.println("Enter Gender :");
			ps.setString(1, sc.nextLine());
			
			ps.setInt(2, e_id);
			
			ps.execute();
			
			ps.close();
			con.close();
			
			System.out.println("Employee gender updated successfully");
		}
		break;
		case 3:{
			Connection con = DbConnection.getConnection();
			
			String updateRecord = "update employee set department = ? where id = ?";
			
			PreparedStatement ps = con.prepareStatement(updateRecord);
			
			System.out.println("Enter department :");
			ps.setString(1, sc.nextLine());
			
			ps.setInt(2, e_id);
			
			ps.execute();
			
			ps.close();
			con.close();
			
			System.out.println("Employee department updated successfully");
		}
		break;
		case 4:{
			Connection con = DbConnection.getConnection();
			
			String updateRecord = "update employee set salary = ? where id = ?";
			
			PreparedStatement ps = con.prepareStatement(updateRecord);
			
			System.out.println("Enter salary :");
			ps.setDouble(1, sc.nextDouble());
			
			ps.setInt(2, e_id);
			
			ps.execute();
			
			ps.close();
			con.close();
			
			System.out.println("Employee salary updated successfully");
		}
		break;
		
		default:
			System.out.println("Invalid Choice");
		}
		
	}

	@Override
	public void DeleteEmployee() throws SQLException {

		System.out.println("Are you sure.");
		System.out.println("Enter yes/no");
		sc.nextLine(); 
		String s = sc.nextLine();
		
		if(s.equals("yes")) {
			Connection con = DbConnection.getConnection();
			
			String deleteEmployee = "delete from employee where id = ?";
			
			PreparedStatement ps = con.prepareStatement(deleteEmployee);
			
			System.out.println("Enter Employee ID :");
			int id = sc.nextInt();
			
			ps.setInt(1, id);
			
			ps.execute();
			
			ps.close();
			
			con.close();
			
			System.out.println("Employee record deleted successfully");
		}
		else {
			System.out.println("Try to choose other option");
		}
	
		
	}

}
