package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.SubTopics;

import javax.transaction.Transactional;

public interface SubTopicRepository extends JpaRepository<SubTopics, Long> {
	@Query(value = "SELECT sub_topic_name,sub_topic_id FROM  sub_topics WHERE  topic_id = :TopicId", nativeQuery = true)
	List<String> findSubTopicByTopic(@Param("TopicId") Long TopicId);

	@Transactional
	@Modifying
	@Query("update SubTopics s set s.dashboardFlag = 1 where s.subTopicId = :id")
	int dashboardFlagSet(@Param("id") Long id);

	@Transactional
	@Modifying
	@Query("update SubTopics s set s.dashboardFlag = 0 where s.subTopicId = :id")
	int dashboardFlagUnset(@Param("id") Long id);

	@Transactional
	@Modifying
	@Query("update SubTopics s set s.index = :number where s.subTopicId = :id")
	int setIndex(@Param("id") Long id,@Param("number") Long number);

}
