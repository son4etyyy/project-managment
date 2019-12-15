package com.tsolova.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.tsolova.pma.dao.EmployeeRepository;
import com.tsolova.pma.dao.ProjectRepository;
import com.tsolova.pma.entities.Employee;
import com.tsolova.pma.entities.Project;

@Controller
public class HomeController {

	@Autowired
	ProjectRepository projectRepository;

	@Autowired
	EmployeeRepository employeeRepository;

	@GetMapping("/")
	public String displayHome(Model model) {
		List<Project> projects = projectRepository.findAll();
		model.addAttribute("projectsList", projects);

		List<Employee> employees = employeeRepository.findAll();
		model.addAttribute("employeesList", employees);

		return "main/home";
	}

}
