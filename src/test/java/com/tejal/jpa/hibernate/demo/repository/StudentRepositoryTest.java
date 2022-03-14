package com.tejal.jpa.hibernate.demo.repository;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertNull;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.tejal.jpa.hibernate.demo.DemoApplication;
import com.tejal.jpa.hibernate.demo.entity.Course;
import com.tejal.jpa.hibernate.demo.entity.Passport;
import com.tejal.jpa.hibernate.demo.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=DemoApplication.class)
class StudentRepositoryTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	StudentRepository repository;
	
	@Autowired
	EntityManager em;
	
	@Test
	@Transactional
	public void SomeTest() {
		Student student = em.find(Student.class, 20001L);//Retrieve Student
		Passport passport = student.getPassport();//Retrieve Passport
		passport.setNumber("E123457");//Update Passport
		student.setName("Ranga - Updated");//Update Student
		
	}
	
	@Test
	@Transactional
	public void retrieveStudentAndPassportDetails() {
		Student student = em.find(Student.class, 20001L);
		logger.info("Student -> {}",student);
		logger.info("Passport -> {}",student.getPassport());
	}
	
	@Test
	@Transactional
	public void retrievePassportAndAssociatedStudents() {
		Passport passport = em.find(Passport.class, 20001L);
		logger.info("passport -> {}",passport);
		logger.info("student -> {}",passport.getStudent());
	}
	
	@Test
	@Transactional
	public void retrieveStudentAndCourses() {
		Student student = em.find(Student.class, 20001L);
		logger.info("student -> {}",student);
		//logger.info("courses -> {}",student,getCourses());

		
		Passport passport = em.find(Passport.class, 20001L);
		
		logger.info("student -> {}",passport.getStudent());
	}
}
