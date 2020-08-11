package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Department;

@Repository
public interface DepartmentDao extends JpaRepository<Department, Integer>{

}
