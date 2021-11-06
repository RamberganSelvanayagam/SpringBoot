package com.sgic.employee.service;

import com.sgic.employee.dto.EmployeeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.sgic.employee.entities.Employee;
import com.sgic.employee.repositories.EmployeeRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
@Autowired
EmployeeRepository employeeRepository;

@Autowired
 JavaMailSender mailSender;

	@Override
	public Employee saveEmployee(Employee employee) {
		//sendSimpleEmail(employee);
		employeeRepository.save(employee);
		return employee;
	}

	@Override
	public List<Employee> selectAllUser() {
		return employeeRepository.findAll();
	}

	@Override
	public List<EmployeeDto> selectAllUserDto() {
		return employeeRepository.findAll().stream().map(this::convertToEmployeeDto).collect(Collectors.toList());
	}
	public EmployeeDto convertToEmployeeDto(Employee employee)
	{
		EmployeeDto employeeDto=new EmployeeDto();
		employeeDto.setFirstName(employee.getFirstName());
		employeeDto.setEmail(employee.getEmail());

		return employeeDto;
	}

	@Override
	public String UpdateUser(Employee employee) {
		Employee oldEMp = employeeRepository.findById(employee.getId()).orElse(employee);
		oldEMp.setEmail(employee.getEmail());
		oldEMp.setFirstName(employee.getFirstName());
		oldEMp.setLastName(employee.getLastName());
		employeeRepository.save(oldEMp);
		return "Sucess";
	}



	@Override
	public void sendSimpleEmail(Employee employee) {
		SimpleMailMessage message=new SimpleMailMessage();
		message.setFrom("danushaninfo@gmail.com");
		message.setTo(employee.getEmail());
		message.setText("jrjrji");
		message.setSubject("ffjfjkkkr");
		mailSender.send(message);
		System.out.println("mail send");
	}

}
