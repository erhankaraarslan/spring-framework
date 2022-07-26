package com.karaarslan.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.karaarslan.springdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	@GetMapping("/students")
	public List<Student> getStudent() {
		List<Student> students = new ArrayList<>();

		students.add(new Student("Erhan", "Karaarslan"));
		students.add(new Student("Merve", "Karaarslan"));
		students.add(new Student("Efe Hakan", "Yüksel"));

		return students;
	}
}
