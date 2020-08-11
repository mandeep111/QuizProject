package com.example.demo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "level")
public class Level {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int level_id;
	private String level_name;
	private int pass_mark;

	@ManyToOne(cascade = CascadeType.ALL, optional = false)
	@JoinColumn(name = "department_id", nullable = false)
	private Department department;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "department")
	private List<Questions> questions;
	
	
	public int getLevel_id() {
		return level_id;
	}

	public void setLevel_id(int level_id) {
		this.level_id = level_id;
	}

	public String getLevel_name() {
		return level_name;
	}

	public void setLevel_name(String level_name) {
		this.level_name = level_name;
	}

	

	public int getPass_mark() {
		return pass_mark;
	}

	public void setPass_mark(int pass_mark) {
		this.pass_mark = pass_mark;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<Questions> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Questions> questions) {
		this.questions = questions;
	}
	
	

}
