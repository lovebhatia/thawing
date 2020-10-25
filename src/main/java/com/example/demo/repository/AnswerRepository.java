package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Answers;

@Repository
public interface AnswerRepository extends JpaRepository<Answers,Long> {
	
	@Query(value="SELECT ans_id,ans as answer FROM answers where question_id=:quesId",nativeQuery = true)
	List<String> getAnswerById(@Param("quesId") Long quesId);

}
