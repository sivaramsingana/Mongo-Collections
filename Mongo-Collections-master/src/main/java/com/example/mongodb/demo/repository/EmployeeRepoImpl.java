package com.example.mongodb.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.example.mongodb.demo.model.Employee;

@Repository
public class EmployeeRepoImpl{

	@Autowired
	private MongoTemplate mongoTemplate;

	
	public Employee findOne(String empid) {
		// TODO Auto-generated method stub
		
		Query q = new Query().addCriteria(Criteria.where("id").is(empid)) ;
		return mongoTemplate.findOne(q,Employee.class);
	}

}
