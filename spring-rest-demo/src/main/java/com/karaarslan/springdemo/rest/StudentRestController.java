package com.karaarslan.springdemo.rest;

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

import com.karaarslan.springdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	private List<Student> theStudents;

	// define @PostConstruct to load the student data ... only once!

	@PostConstruct
	public void loadData() {
		theStudents = new ArrayList<>();
		theStudents.add(new Student("Erhan1", "Karaarslan"));
		theStudents.add(new Student("Merve2", "Karaarslan"));
		theStudents.add(new Student("Efe Hakan", "Yüksel"));

	}

	@GetMapping("/students")
	public List<Student> getStudent() {
		return theStudents;
	}

	// define endpoint for "/student/{studentId}" - return student at index

	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {

		if (studentId >= theStudents.size() || studentId < 0) {
			throw new StudentNotFoundException("Student not found - " + studentId);
		}

		return theStudents.get(studentId);
	}

	// Add an exception handler using @ExceptionHandler
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException studentNotFoundException) {

		// create a StudentErrorRepsonse
		StudentErrorResponse errorResponse = new StudentErrorResponse();
		errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
		errorResponse.setMessage(studentNotFoundException.getMessage());
		errorResponse.setTimeStamp(System.currentTimeMillis());

		// return ResponseEntity
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}

	// add another exception handler ... to cathc any exception (catch all)
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(Exception exc) {

		// create a StudentErrorRepsonse
		StudentErrorResponse errorResponse = new StudentErrorResponse();

		errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
		errorResponse.setMessage(exc.getMessage());
		errorResponse.setTimeStamp(System.currentTimeMillis());

		// return ResponseEntity
		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}
}
