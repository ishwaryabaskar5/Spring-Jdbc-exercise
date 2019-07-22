package com.stackroute.jdbcexercise1;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeMapper implements RowMapper<Employee> {
	@Override
	public Employee mapRow(ResultSet resultSet, int i) throws SQLException {
		Employee employee = new Employee();
		employee.setId(resultSet.getInt(1));
		employee.setName(resultSet.getString(2));
		employee.setAge(resultSet.getInt(3));
		employee.setGender(resultSet.getString(4));
		return employee;
	}
}
