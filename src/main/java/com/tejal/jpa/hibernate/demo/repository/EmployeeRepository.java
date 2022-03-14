package com.tejal.jpa.hibernate.demo.repository;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tejal.jpa.hibernate.demo.entity.Course;
import com.tejal.jpa.hibernate.demo.entity.Employee;
import com.tejal.jpa.hibernate.demo.entity.Review;

import jakarta.persistence.EntityManager;

@Repository
@Transactional
public class EmployeeRepository {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	
	@Autowired
	EntityManager em;
	
	public void insert(Employee employee) {
		em.persist(employee);
	}
	
	public List<Employee> retrieveAllEmployees() {
		return em.createQuery("select e from Employee e", Employee.class).getResultList();
	}
	
}

