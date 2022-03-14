package com.tejal.jpa.hibernate.demo.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tejal.jpa.hibernate.demo.entity.Course;
import com.tejal.jpa.hibernate.demo.entity.Passport;
import com.tejal.jpa.hibernate.demo.entity.Student;

import jakarta.persistence.EntityManager;

@Repository
@Transactional
public class StudentRepository {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	
	@Autowired
	EntityManager em;
	
	public Student findById(Long id) {
		return em.find(Student.class, id);
	}
	
	public void deleteById(Long id) {
		Student student =findById(id);
		em.remove(student);
	}
	
	public Student save(Student student) {
		if(student.getId()==null) {
			em.persist(student);
		}else {
			em.merge(student);
		}
		return student;
	}
	
	public void saveStudentWithPassport() {
		Passport passport = new Passport("Z123456");
		em.persist(passport);
		Student student= new Student("Mike");
		student.setPassport(passport);
		em.persist(student);
	}
	
	public void insertHardCodedStudentAndCourse() {
		Student student = new Student("Jack");
		Course course = new Course("Microservices");
		em.persist(student);
		em.persist(course);
		student.addCourses(course);
		course.addStudents(student);
		em.persist(student);
	}
}
