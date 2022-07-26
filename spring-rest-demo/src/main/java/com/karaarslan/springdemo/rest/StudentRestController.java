package com.karaarslan.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

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

}
