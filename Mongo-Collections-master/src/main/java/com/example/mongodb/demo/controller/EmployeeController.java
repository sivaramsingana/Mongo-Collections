package com.example.mongodb.demo.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.mongodb.demo.model.Employee;
import com.example.mongodb.demo.repository.EmployeeRepoImpl;
import com.example.mongodb.demo.repository.EmployeeRepository;

@RestController
@RequestMapping(value = "employee")
public class EmployeeController {

	
	private final EmployeeRepository emprepo;
	
	private final EmployeeRepoImpl emprepoimpl;
	
	public EmployeeController(EmployeeRepository emprep,EmployeeRepoImpl emprepoimp) {
		super();
		this.emprepo = emprep;
		this.emprepoimpl = emprepoimp;
	}

	@GetMapping("/show")
	public List<Employee> getAllBooks()
	{
		
		return Arrays.asList(new Employee("Testing employee","Hello There,Welcome to Microservices demo!!!","Sivaram",26));
	}


	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Employee addEmployee(@RequestBody Employee employee) {
		System.out.println("Added New Employee"+employee.getName());
		return emprepo.insert(employee);
	}
	
	@RequestMapping(value = "/update/{empId}", method = RequestMethod.PUT)
	public void updateEmployee(@RequestBody Employee employee,@PathVariable String empId) {
		
		Employee employee1 = emprepoimpl.findOne(empId);
		if(employee1 !=null)
		{
			System.out.println("updating employee details ... "+employee1.getName());
			employee1.setId(empId);
			employee1.setDept(employee.getDept());
			employee1.setName(employee.getName());
			System.out.println("Updated Employee "+employee.getName());
			emprepo.save(employee1);	
		}
		else
		{
			System.out.println("Created New Employee "+employee.getName());
			emprepo.insert(employee);
		}
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<Employee> getAllEmployees() {
		return emprepo.findAll();
	}
	
	@RequestMapping(value = "/getDetails/{empId}", method = RequestMethod.GET)
	public  Optional<Employee> searchEmployeeById(@PathVariable String empId) {
		return emprepo.findById(empId);
	}
	
	@RequestMapping(value = "/remove/{empId}", method = RequestMethod.GET)
	public String removeEmployeeById(@PathVariable String empId) {
		 emprepo.deleteById(empId);
		 return "Employee removed";
	}
	
	
}
