package com.springRestDemo.REST;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springRestDemo.Entity.Student;

@RestController
@RequestMapping("/api")
public class StudentController 
{
	private List<Student> students;
	
	@PostConstruct
	public void LoadData()
	{
		students = new ArrayList<Student>();
		
		students.add(new Student("Rocky", "Kumar"));
		students.add(new Student("New", "name"));
		students.add(new Student("Mark", "Boucher"));
	}
	
	@GetMapping("/students")
	public List<Student> getStudents()
	{
		// JAckson will convert this list into JSON
		return students;
	}
	
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId)
	{
		// JAckson will convert this into JSON
		if(studentId >= students.size() || studentId<0)
			throw new StudentNotFoundException("Student not found with ID - " + studentId);	
		return students.get(studentId);
	}
	
	// add exception handler to catch all exceptions (generic exception handler)
	// this will only work for this controller.
	/*@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(Exception ex)
	{
		StudentErrorResponse error = new StudentErrorResponse();
		
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(ex.getMessage());
		error.setTimestamp(System.currentTimeMillis());
		
		return new ResponseEntity<StudentErrorResponse>(error, HttpStatus.BAD_REQUEST);
	}*/
}
