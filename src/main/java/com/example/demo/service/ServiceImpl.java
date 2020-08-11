package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.example.demo.dao.DepartmentDao;
import com.example.demo.dao.LevelDao;
import com.example.demo.dao.QuestionDao;
import com.example.demo.dao.UserDao;
import com.example.demo.model.Department;
import com.example.demo.model.Level;
import com.example.demo.model.Questions;
import com.example.demo.model.User;

@Component
public class ServiceImpl {
	@Autowired
	private DepartmentDao departmentDao;
	
	@Autowired
	private LevelDao levelDao;
	
	@Autowired
	private QuestionDao questionDao;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private BCryptPasswordEncoder bCrypt;
	
	
	
	public Department getDepartmentId(int d_id) {
		Department id = departmentDao.findById(d_id).orElseThrow();
		return id;
	}
	
	public List<Level> getLevels(Department id) {
		List<Level> getLevels = id.getLevel();
		return getLevels;
	}
	
	public void saveDepartment(Department department) {
		departmentDao.save(department);
	}
	
	public void saveLevel(Level level) {
		level.setDepartment(level.getDepartment());
		levelDao.save(level);
	}
	
	public void saveQuestions(Questions question) {
		question.setDepartment(question.getDepartment());
		question.setLevel(question.getLevel());
		questionDao.save(question);
	}
	
	public List<Department> getAllDepartments() {
		return departmentDao.findAll();
	}
	
	public Level getLevelById(int level_id) {
		Level l_id = levelDao.findById(level_id).orElseThrow();
		return l_id;
	}
	
	public void saveUser(User user) {
		user.setPassword(bCrypt.encode(user.getPassword()));
		userDao.save(user);
	}
	
	public List<Questions> getQuestions(int department_id, int level_id) {
		return questionDao.getQuestions(department_id, level_id);
	}

	public void deleteDepartment(int department_id) {
		departmentDao.deleteById(department_id);
	}
	
	public int getScore(int department_id, int level_id,Questions question) {
		int i=0;
		int score = 0;
		List<Questions> getQuestions = getQuestions(department_id, level_id);
		List<Integer> userAnswer = question.getUser_answer();
		
		for (Questions q : getQuestions) {
			int correct = q.getCorrect_option();
			if (userAnswer.get(i) == correct) {
				score += Integer.valueOf(q.getWeight());
			}
			i++;
		}

		return score;
	}
	
	public int getTotalMarks(int department_id, int level_id) {
		int marks= 0;
		List<Questions> getQuestions = getQuestions(department_id, level_id);
		for (Questions q: getQuestions) {
			marks += Integer.parseInt(q.getWeight());	
		}

		return marks;
	}

}
