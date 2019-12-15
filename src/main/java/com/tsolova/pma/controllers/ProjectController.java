package com.tsolova.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tsolova.pma.dao.EmployeeRepository;
import com.tsolova.pma.dao.ProjectRepository;
import com.tsolova.pma.entities.Employee;
import com.tsolova.pma.entities.Project;

@Controller
@RequestMapping("/projects")
public class ProjectController {
	@Autowired
	ProjectRepository projectRpeository;

	@Autowired
	EmployeeRepository employeeRepository;

	@GetMapping
	public String displayProjects(Model model) {

		List<Project> projects = projectRpeository.findAll();
		model.addAttribute("projects", projects);
		return "projects/list-projects";
	}

	@GetMapping("/new")
	public String displayProjectForm(Model model) {

		Project aProject = new Project();
		List<Employee> employees = employeeRepository.findAll();
		model.addAttribute("project", aProject);
		model.addAttribute("allEmployees", employees);
		return "projects/new-project";
	}

	@PostMapping("/save")
	public String createProject(Project project, Model model) {
		projectRpeository.save(project);

		// use redirect to avoid duplicate submissions
		return "redirect:/projects";
	}
}
