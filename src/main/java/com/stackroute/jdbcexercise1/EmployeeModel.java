package com.stackroute.jdbcexercise1;

import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.ArrayList;
import java.util.List;

public class EmployeeModel extends JdbcDaoSupport {

//	Read total employee count from database
	public int totalEmployeeCount(){
		String sql = "select count(*) from employee";
		return this.getJdbcTemplate().queryForObject(sql,Integer.class);
	}
	
//	Read employee information from database using employee id
	public Employee getEmployeeDetail(int id){
		return this.getJdbcTemplate().queryForObject("select * from employee where id = ?",new  Object[]{id},new EmployeeMapper());
	}

//	insert employee info in employee table
	public void insertEmployee(int id, String name, int age, String gender ){
		Object[] args = new Object[]{id,name,age,gender};
		this.getJdbcTemplate().update("insert into employee values(?,?,?,?)",args);
	}
	
//	update age of corresponding employee id
	public void updateAge(int id, int age){
		this.getJdbcTemplate().update("update employee set age = ? where id = ?",new Object[]{age,id});
	}
	
//	delete row using id
	public void deleteRow(int id){
		this.getJdbcTemplate().update("delete from employee where id = ?",new Object[]{id});
	}
	
//	display all employee info
	public SqlRowSet employeeDetails(){
		return this.getJdbcTemplate().queryForRowSet("select * from employee");
	}
	
	
	
//	create new table
	public void createTable(String tableName){
		String sql = "create table "+tableName+"(id int(5), name varchar(20))";
		this.getJdbcTemplate().execute(sql);
	}
	
//	delete existing table table
	public void dropTable(String tableName){
		String sql = "drop table "+tableName;
		this.getJdbcTemplate().execute(sql);
	}
}
