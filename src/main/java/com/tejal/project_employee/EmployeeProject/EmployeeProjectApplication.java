package com.tejal.project_employee.EmployeeProject;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tejal.project_employee.EmployeeProject.entity.Employee;
import com.tejal.project_employee.EmployeeProject.repository.EmployeeRepository;

@SpringBootApplication
public class EmployeeProjectApplication implements CommandLineRunner{

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(EmployeeProjectApplication.class, args);
		
		//System.out.println("Connected");
	}

	@Override
	public void run(String... args) throws Exception {
		//logger.info("All users -> {}",employeeRepository.findAll() );	
		System.out.println("*************************************");
		List<Employee> employeeList = employeeRepository.findAll();		
        System.out.println("*** List of all Employees *** ");
        for(Employee emp1 : employeeList)
        {
            System.out.println("Employee Id   :"+emp1.getId());
            System.out.println("Employee Name :"+emp1.getName());
            System.out.println("Employee Salary  :"+emp1.getSalary());
            System.out.println("Employee Designation :"+emp1.getDesignation());
            System.out.println();
        }
        System.out.println("*************************************");
        
		logger.info("user id 1001 -> {}",employeeRepository.findById(1001L));
		logger.info("Inserting 1004 -> {} ", employeeRepository.insert(new Employee("James", 50000, "Manager")));
		logger.info("Updating 1001 -> {} ", employeeRepository.update(new Employee(1001L,"Tara", 20000, "Accountant")));
		employeeRepository.deleteById(1002L);
		 List<Employee> employeeList1 = employeeRepository.findAll();
		 System.out.println("*************************************");
	        System.out.println("*** List of all Employees After CRUD Operation *** ");
	        for(Employee emp1 : employeeList1)
	        {
	            System.out.println("Employee Id   :"+emp1.getId());
	            System.out.println("Employee Name :"+emp1.getName());
	            System.out.println("Employee Salary  :"+emp1.getSalary());
	            System.out.println("Employee Designation :"+emp1.getDesignation());
	            System.out.println();
	        }
	        System.out.println("*************************************");
	}

}
