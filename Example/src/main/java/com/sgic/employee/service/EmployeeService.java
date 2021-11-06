package com.sgic.employee.service;

import com.sgic.employee.dto.EmployeeDto;
import com.sgic.employee.entities.Employee;

import java.util.List;

public interface EmployeeService {
	 Employee saveEmployee(Employee employee);
	 List<Employee>selectAllUser();
	 List<EmployeeDto>selectAllUserDto();
	 String UpdateUser(Employee employee);
	 void sendSimpleEmail(Employee employee);

}
