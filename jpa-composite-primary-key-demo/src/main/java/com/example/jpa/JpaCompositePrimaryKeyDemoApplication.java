package com.example.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.jpa.model.Employee;
import com.example.jpa.model.EmployeeIdentity;
import com.example.jpa.repository.EmployeeRepository;

@SpringBootApplication
public class JpaCompositePrimaryKeyDemoApplication implements CommandLineRunner{

	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(JpaCompositePrimaryKeyDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	
		//cleanup Employee Table
		employeeRepository.deleteAll();
		
		// Insert a new Employee in the database
		EmployeeIdentity identity1 = new EmployeeIdentity("AK1074", "Contata");
		Employee employee1 = new Employee(identity1, "Aman Singla", "aman.singla30@gmail.com", "9873415184");
		employeeRepository.save(employee1);
		EmployeeIdentity identity2 = new EmployeeIdentity("AK1075", "Contata");
		Employee employee2 = new Employee(identity2, "Ninad", "ninad30@gmail.com", "9875645670");
		employeeRepository.save(employee2);
		EmployeeIdentity identity3 = new EmployeeIdentity("AK1074", "Newgen");
		Employee employee3 = new Employee(identity3, "Aman Singla", "aman.singla40@gmail.com", "9582257953");
		employeeRepository.save(employee3);
	}
}
