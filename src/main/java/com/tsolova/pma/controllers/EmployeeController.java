package com.tsolova.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tsolova.pma.dao.EmployeeRepository;
import com.tsolova.pma.entities.Employee;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	EmployeeRepository employeeRpeository;

	@GetMapping
	public String displayEmployees(Model model) {

		List<Employee> employees = employeeRpeository.findAll();
		model.addAttribute("employees", employees);
		return "employees/list-employees";
	}

	@GetMapping("/new")
	public String displayEmployeeForm(Model model) {

		Employee aEmployee = new Employee();
		model.addAttribute("employee", aEmployee);
		return "employees/new-employee";
	}

	@PostMapping("/save")
	public String createEmployee(Employee employee, Model model) {
		employeeRpeository.save(employee);

		// use redirect to avoid duplicate submissions
		return "redirect:/employees/new";
	}
}
