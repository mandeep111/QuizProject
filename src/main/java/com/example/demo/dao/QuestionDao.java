package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Questions;
@Repository
public interface QuestionDao extends JpaRepository<Questions, Integer>{
	@Query(value = "select * from questions where department_id =(:d_id) and level_id=(:l_id)",
            nativeQuery = true)
	public List<Questions> getQuestions(@Param("d_id") int d_id, @Param("l_id") int l_id);
}
