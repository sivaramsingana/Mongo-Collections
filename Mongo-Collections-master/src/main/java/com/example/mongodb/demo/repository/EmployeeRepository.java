package com.example.mongodb.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.mongodb.demo.model.Employee;

public interface EmployeeRepository extends MongoRepository<Employee, String>{

//	Employee findOne(Query q, Class<Employee> class1);

//	void findOne(Query query, Class<Employee> class1);

//	public List<Employee> findAll();
	
	
	
}
