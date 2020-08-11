package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Department;
import com.example.demo.model.Level;
import com.example.demo.model.Questions;
import com.example.demo.service.ServiceImpl;

@Controller
@RequestMapping("/admin/")
public class AdminController {
	
	
	@Autowired
	private ServiceImpl service;
	
	@GetMapping("adminPage")
	public String getAdminPage() {
		return "adminPage";
	}
	
	@GetMapping("addDepartment")
	public String getAddDepartmentPage(Model model) {
		model.addAttribute("departments", service.getAllDepartments());
		return "addDepartment";
	}
	
	@GetMapping("addLevel")
	public String getAddLevelPage(Model model) {
		model.addAttribute("departments", service.getAllDepartments());
		return "addLevel";
	}
	@GetMapping("addQuestion/{d_id}")
	public String addQuestionPage(@PathVariable("d_id") int d_id, Model model) {
		model.addAttribute("departments", service.getDepartmentId(d_id));
		Department id = service.getDepartmentId(d_id);
		List<Level> getLevels = service.getLevels(id);
		model.addAttribute("levels", getLevels);
		return "addQuestion";
	}

	
	@PostMapping("addDepartment")
	public String addDepartment(Department department) {
		service.saveDepartment(department);
		return "redirect:/admin/addDepartment";
	}
	
	@PostMapping("addLevel")
	public String addLevel(Level level) {
		service.saveLevel(level);
		return "adminPage";
	}
	
	@PostMapping("addQuestion")
	public String addQuestion (Questions question) {
		service.saveQuestions(question);
		return "redirect:/admin/addDepartment";
	}
	
	@GetMapping("deleteDepartment/{department_id}")
	public String deleteDepartment(@PathVariable("department_id") int department_id, Model model) {
		service.deleteDepartment(department_id);
		model.addAttribute(service.getAllDepartments());
		return "redirect:/admin/addDepartment";
	}
}
