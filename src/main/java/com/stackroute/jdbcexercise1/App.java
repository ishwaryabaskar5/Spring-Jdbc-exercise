package com.stackroute.jdbcexercise1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class App {
	
	public static void main(String[] args){
	
//		ApplicationContext container object
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
		
//		EmployeeModel object creation
		EmployeeModel employeeModel = applicationContext.getBean("employeeModel",EmployeeModel.class);
		
//		totalEmployeeCount() method call
		System.out.println("Total employee count: "+employeeModel.totalEmployeeCount());
		
//		insertEmployee() method call
		employeeModel.insertEmployee(5,"maniraj",23,"male");
		System.out.println("Total employee count after inserting a row: "+employeeModel.totalEmployeeCount());
		
//		getEmployeeDetail(id) method call
		Employee employee = employeeModel.getEmployeeDetail(1);
		System.out.println("Employee details of id "+employee.getId()+" : name: "+employee.getName()+" age: "+
				employee.getAge()+" gender: "+employee.getGender());
		
//		createTable() method call
		employeeModel.createTable("student");
		
//		dropTable() method call
		employeeModel.dropTable("student1");
	
	
//		updateAge() method call
		employeeModel.updateAge(1,22);

//      deleteRow() method call
		employeeModel.deleteRow(3);
		System.out.println("Total employee count after deleting a row: "+employeeModel.totalEmployeeCount());
		
		
//		employeeDetails() method call
		System.out.println("\n--------------------------\nEmployee Table\n--------------------------");
		SqlRowSet sqlRowSet = employeeModel.employeeDetails();
		while (sqlRowSet.next()){
			System.out.println(sqlRowSet.getInt(1)+"\t"+sqlRowSet.getString(2)+"\t"+sqlRowSet.getInt(3)+
					"\t"+sqlRowSet.getString(4));
		}
	}
}
