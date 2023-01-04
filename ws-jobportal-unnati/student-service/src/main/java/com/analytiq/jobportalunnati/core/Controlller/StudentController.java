package com.analytiq.jobportalunnati.core.Controlller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.analytiq.jobportalunnati.core.entity.Student;
import com.analytiq.jobportalunnati.core.repository.StudentRepository;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "student-service", description = "The student Service")

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentRepository studentRepository;
	
	
	@Operation(summary = "Get", description = "Any  user can access /student/ for welcome message in this application") 
	@GetMapping("/")
	public String welcomeMessage() {
		return "Welcome to Student Service";
	}
	
	
	@Operation(summary = "Post", description = "Any  user can access /student/save to save a new Student  in this application") 
	@PostMapping("/save")
	public String saveStudent(@RequestBody Student student) {
		
		System.out.println("...Request inside StudentController saveStudent()");
		studentRepository.save(student);
		return "student saved in database";
		
		
	}

}