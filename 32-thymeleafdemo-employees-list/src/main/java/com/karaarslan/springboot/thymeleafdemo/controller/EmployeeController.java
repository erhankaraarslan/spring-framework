package com.karaarslan.springboot.thymeleafdemo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.karaarslan.springboot.thymeleafdemo.model.Employee;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	private List<Employee> theEmployees;

	@PostConstruct
	private void loadData() {
		theEmployees = new ArrayList<>();
		theEmployees.add(new Employee(1, "Erhan", "Karaarslan", "erhannkaraarslan@gmail.com"));
		theEmployees.add(new Employee(2, "Merve", "Karaarslan", "merveekaraarslan@gmail.com"));
		theEmployees.add(new Employee(3, "Efe Hakan", "Yüksel", "efehakanyuksel@gmail.com"));
	}

	@GetMapping("/list")
	public String listEmployees(Model theModel) {
		theModel.addAttribute("employees", theEmployees);

		return "list-employees";
	}

}
