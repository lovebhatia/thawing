package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Topics;

import javax.transaction.Transactional;

public interface TopicRepository extends JpaRepository<Topics, Long> {
	@Query(value = "SELECT topic_Name,topic_id FROM  topics WHERE  course_Id = :CourseId", nativeQuery = true)
	List<String> findTopicByCourse(@Param("CourseId") Long courseId);

	@Transactional
	@Modifying
	@Query("update Topics t set t.dashboardFlag = 1 where t.topicId = :id")
	int dashboardFlagSet(@Param("id") Long id);

	@Transactional
	@Modifying
	@Query("update Topics t set t.dashboardFlag = 0 where t.topicId = :id")
	int dashboardFlagUnset(@Param("id") Long id);

	@Transactional
	@Modifying
	@Query("update Topics t set t.index = :number where t.topicId = :id")
	int setIndex(@Param("id") Long id,@Param("number") Long number);
	
	
}
