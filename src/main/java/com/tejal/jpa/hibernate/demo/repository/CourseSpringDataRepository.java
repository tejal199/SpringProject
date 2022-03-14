package com.tejal.jpa.hibernate.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.tejal.jpa.hibernate.demo.entity.Course;


public interface CourseSpringDataRepository extends JpaRepository<Course, Long>{
	//List<Course> findByNameAndId(String name);
	List<Course> findByName(String name);
	/*List<Course> CountByName(String name);
	List<Course> findByNameOrderByIdDesc(String name);*/
	
}
