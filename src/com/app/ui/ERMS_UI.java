package com.app.ui;
import java.sql.SQLException;
import java.util.Scanner;

import com.app.serviceImp.ERMS_ServiceImpl;

public class ERMS_UI {
	
	public static void main(String[] args) throws SQLException {
		
		Scanner sc = new Scanner(System.in);
		
		boolean k = true;
		
		ERMS_ServiceImpl es = new ERMS_ServiceImpl();
		
		
		while(k) {
			
			System.out.println("-----Welcome to ERMS -------");
			System.out.println("1.Add Employee\n2.View Employee \n3.Search Employee by ID \n4.Update Employee \n5.Delete Employee \n6.Exit");
			
			System.out.println("-----------------------------");
			
			System.out.println("Enter Choice : ");
			int ch = sc.nextInt();
			
			switch(ch) {

			case 1:{
				es.addEmployee();
			}
			break;
			
			case 2:{
				es.ViewEmployee();
			}
			break;
			case 3:{
				es.searchEmployeeByID();
			}
			break;
			case 4:{
				es.updateEmployee();
			}
			break;
			case 5:{
				es.DeleteEmployee();
			}
			break;
			case 6:{
				k = false;
			}
			break;
			
			default:
				System.out.println("Enter valid choice");
			}
			
			

			
		}
	}
}
