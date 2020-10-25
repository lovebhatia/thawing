package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.lang.annotation.Native;
import java.util.List;

import javax.transaction.Transactional;

import com.example.demo.model.Questions;

@Repository
public interface QuestionRepository extends JpaRepository<Questions,Long> {
    @Transactional
    @Modifying
    @Query("update Questions q set q.likes = :likes where q.question_id = :question_id")
    int updateLikesForQuestion(@Param("question_id") Long question_id, 
    @Param("likes") Integer likes);

    @Transactional
    @Modifying
    @Query("update Questions q set q.flag = 1 where q.question_id = :id")
    int ShowFlag(@Param("id") Long id);

    @Transactional
    @Modifying
    @Query("update Questions q set q.flag = 0 where q.question_id = :id")
    int DeleteFlag(@Param("id") Long id);

    @Transactional
    @Modifying
    @Query("update Questions s set s.dashboardFlag = 1 where s.question_id = :id")
    int dashboardFlagSet(@Param("id") Long id);

    @Transactional
    @Modifying
    @Query("update Questions s set s.dashboardFlag = 1 where s.question_id = :id")
    int dashboardFlagUnset(@Param("id") Long id);

    @Transactional
    @Modifying
    @Query("update Questions s set s.index = :number where s.question_id = :id")
    int setIndex(@Param("id") Long id,@Param("number") int number);
/*
    @Transactional
    @Modifying
    @Query("update Questions s set s.index = s.index+1 where s.question_id > :id")
    int updateIndex(@Param("id") Long id,@Param("number") Long number);
*/
    @Transactional
    @Modifying
    @Query(value = "UPDATE Questions  set index =index+1 where question_id> :id",
        nativeQuery = true)
    int updateIndex(@Param("id") Long id);

    @Query(value = "SELECT questions_name,question_id FROM  questions WHERE  sub_topic_id = :subTopicId", nativeQuery = true)
	List<String> findQuestionBySubTopic(@Param("subTopicId") Long subTopicId);

}
