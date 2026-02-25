# ERMS - Employee Record Management System

## Project Overview

ERMS (Employee Record Management System) is a console-based Java application developed using Core Java and JDBC.  
The system performs CRUD (Create, Read, Update, Delete) operations on employee records stored in a MySQL database.

This project demonstrates the practical implementation of JDBC connectivity, layered architecture, and object-oriented programming concepts.

---

## Technologies Used

- Core Java
- JDBC (Java Database Connectivity)
- MySQL Database
- MySQL Connector/J (JDBC Driver)
- Eclipse IDE

---

## Features

1. Add Employee  
2. View All Employees  
3. Search Employee by ID  
4. Update Employee Details  
5. Delete Employee  
6. Exit Application  

---

## Project Structure

```
ERMS-Employee Record Management System
│
├── com.app.connection
│   └── DbConnection.java
│
├── com.app.model
│   └── Employee.java
│
├── com.app.service
│   └── ERMS_Service.java
│
├── com.app.serviceImp
│   └── ERMS_ServiceImpl.java
│
└── com.app.ui
    └── ERMS_UI.java
```

---

## Database Configuration

### Database Name:
```
employee_db
```

### Table Structure:

```sql
CREATE TABLE employee (
    id INT PRIMARY KEY,
    name VARCHAR(50),
    gender VARCHAR(20),
    department VARCHAR(50),
    salary DOUBLE
);
```

---

## Database Connection

Update your database credentials inside:

```
DbConnection.java
```

```java
DriverManager.getConnection(
    "jdbc:mysql://localhost:3306/employee_db",
    "your_username",
    "your_password"
);
```

---

## How to Run the Project

1. Install MySQL and create the database and table.
2. Add MySQL Connector/J JAR file to your project build path.
3. Update database credentials in DbConnection.java.
4. Run ERMS_UI.java.
5. Choose options from the console menu.

---

## Learning Outcomes

- Understanding of JDBC architecture
- Usage of PreparedStatement and ResultSet
- Implementation of CRUD operations
- Basic layered architecture (Model, Service, UI)
- Exception handling in database applications

---



