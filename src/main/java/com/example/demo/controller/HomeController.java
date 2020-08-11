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
@RequestMapping("/")
public class HomeController {

	@Autowired
	private ServiceImpl service;
	
	@GetMapping("")
	public String home(Model model) {
		model.addAttribute("departments", service.getAllDepartments());
		return "home";
	}

	@GetMapping("user/depart/{department_id}/levels")
	public String getLevelPage(@PathVariable("department_id") int department_id, Model model) {
		Department id = service.getDepartmentId(department_id);
		List<Level> getLevels = service.getLevels(id);

		model.addAttribute("levels", getLevels);
		return "selectLevel";
	}

	@GetMapping("user/depart/{department_id}/{level_id}")
	public String getQuizPage(@PathVariable("department_id") int department_id, @PathVariable("level_id") int level_id,
			Model model) {
		Department id = service.getDepartmentId(department_id);
		Level level = service.getLevelById(level_id);
		model.addAttribute("department", id);
		model.addAttribute("level", level);
		model.addAttribute("questions", service.getQuestions(department_id, level_id));
		return "quizPage";
	}

	@PostMapping("/showResult/{department_id}/{level_id}")
	public String showResult(@PathVariable("department_id") int department_id, @PathVariable("level_id") int level_id,
			 Model model, Level level, Questions question) {
		
		int score = service.getScore(department_id, level_id, question);
		System.out.println(score);
		Level pass_mark = service.getLevelById(level_id);
		
		int pass = pass_mark.getPass_mark();
		int totalMarks = service.getTotalMarks(department_id, level_id);
		if(score>=pass) {
			model.addAttribute("result", "Congratulations, You have passed the test");
		} else {
			model.addAttribute("result", "Sorry, You have failed the test");
		}
			
		model.addAttribute("score", score);
		model.addAttribute("total", totalMarks);
		return "showResult";
	}

}
