package com.sgic.employee.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sgic.employee.dto.EmployeeDto;
import com.sgic.employee.utills.Utills;
import com.sun.xml.bind.v2.schemagen.episode.SchemaBindings;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

import com.sgic.employee.entities.Employee;
import com.sgic.employee.service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	JavaMailSender mailSender;
	@Autowired
	EmployeeService employeeService;


	private ModelMapper modelMapper;


//	@PostMapping("/employee")
//	public ResponseEntity<EmployeeDto> createIncomingSample(@RequestBody EmployeeDto employeeDto) {
//		Employee employeeRequest=modelMapper.map(employeeDto,Employee.class);
//		Employee employee= employeeService.saveEmployee(employeeRequest);
//
//		EmployeeDto employeeResponse=modelMapper.map(employee,EmployeeDto.class);
//		return new ResponseEntity<EmployeeDto>(employeeResponse, HttpStatus.CREATED);
//	}
//

    @PostMapping("/employee")
    public ResponseEntity<Object> createIncomingSample(@RequestBody Employee employee) {

//		if (Utills.notNullValidation(employee.getFirstName()) && Utills.notNullValidation(employee.getLastName()))
//		{
		employeeService.sendSimpleEmail(employee);
			employeeService.saveEmployee(employee);
			return ResponseEntity.ok("saved Success");
//		}else
//			return ResponseEntity.ok("saved failed");


	}

    @RequestMapping("/hello")
	public Map<String, String> callAsyncMethod() {
		Map map = new HashMap<Integer, String>();
		map.put("message", "Hello");

		return map; // returns empty braces
	}

	@GetMapping(path = "/userDetails")
	public List<Employee> selectAllUser()
	{
		return employeeService.selectAllUser();
	}

	@GetMapping(path = "/userDetailsdto")
	public List<EmployeeDto> selectAllUserDto()
	{
		return employeeService.selectAllUserDto();
	}
//	@DeleteMapping("/delete/{id}")
//	@GetMapping("/{id}")
//	public ResponseEntity<Employee>getById(@PathVariable(name = "id") Long id)
//	{
//		Employee emp=
//	}


    @PutMapping(path = "/updateuser")
    public ResponseEntity<Object>updateUser(@RequestBody Employee employee)
    {
        return ResponseEntity.ok(employeeService.UpdateUser(employee));
    }


//@PostMapping(path="/sendmail")
//public ResponseEntity<Object> sendMail(@RequestBody Employee employee) {
//
//
//			employeeService.sendSimpleEmail(employee);
//			return ResponseEntity.ok("saved Success");
//
//	}




}
