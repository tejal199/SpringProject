package com.tejal.jpa.hibernate.demo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tejal.jpa.hibernate.demo.entity.Course;
import com.tejal.jpa.hibernate.demo.entity.FullTimeEmployee;
import com.tejal.jpa.hibernate.demo.entity.PartTimeEmployee;
import com.tejal.jpa.hibernate.demo.entity.Review;
import com.tejal.jpa.hibernate.demo.repository.CourseRepository;
import com.tejal.jpa.hibernate.demo.repository.EmployeeRepository;
import com.tejal.jpa.hibernate.demo.repository.StudentRepository;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner{

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*List<Review> reviews= new ArrayList<>();
		reviews.add(new Review("5","Great Hands-on Stuff."));
		reviews.add(new Review("5","Hatsoff."));
		courseRepository.addReviewsForCourse(10003L, reviews);*/
		
		//studentrepository.saveStudentWithPassport();
		//courseRepository.addHardCodedReviewsForCourse();
		
		//repository.playWithEntityManager();
		/*Course course = repository.findById(10001L);
		logger.info("Course 10001 -> {}", course);
		repository.deleteById(10001L);
		repository.save(new Course("Microservices"));*/
		
		//studentRepository.insertHardCodedStudentAndCourse();
		employeeRepository.insert(new PartTimeEmployee("Jill", new BigDecimal("50")));
		employeeRepository.insert(new FullTimeEmployee("Jack", new BigDecimal("10000")));
		logger.info("All Employees -> {}", employeeRepository.retrieveAllEmployees());
	}

}
