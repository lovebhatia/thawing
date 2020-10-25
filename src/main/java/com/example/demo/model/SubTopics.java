package com.example.demo.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class SubTopics implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sub_topic_id")
	private long subTopicId;
	@Column(name = "sub_topic_name")
	private String subTopicName;
	@Column(name = "sub_topic_year")
	private String SubTopicYear;
	
	@OneToMany(mappedBy = "subTopics",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	//@JsonManagedReference
	@JsonIgnore
	private Set<Questions> questionsSet=new HashSet<Questions>();
	
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name="topic_id")
	@JsonBackReference
	private Topics topics;

	@Column
	private int index=0;
	@Column
	private int dashboardFlag=0;

	public long getSubTopicId() {
		return subTopicId;
	}

	public void setSubTopicId(long subTopicId) {
		this.subTopicId = subTopicId;
	}

	public String getSubTopicName() {
		return subTopicName;
	}

	public void setSubTopicName(String subTopicName) {
		this.subTopicName = subTopicName;
	}

	public String getSubTopicYear() {
		return SubTopicYear;
	}

	public void setSubTopicYear(String subTopicYear) {
		SubTopicYear = subTopicYear;
	}

	public Set<Questions> getQuestionsSet() {
		return questionsSet;
	}

	public void setQuestionsSet(Set<Questions> questionsSet) {
		this.questionsSet = questionsSet;
	}

	public Topics getTopics() {
		return topics;
	}

	public void setTopics(Topics topics) {
		this.topics = topics;
	}

	

	public int getDashboardFlag() {
		return dashboardFlag;
	}

	public void setDashboardFlag(int dashboardFlag) {
		this.dashboardFlag = dashboardFlag;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
}



/*
{
"courseId": 1,
"courseName": "testing",
"topics": [
  {
"topicId": 8,
"topicName": "oops",
"topicsSet": [
  {
"subTopicId": 6,
"subTopicName": "polumorphism",
"questionsSet": [
  {
"question_id": 6,
"questions_name": "What is polymorphism",
"year": 2,
"answers": [
  {
"ans": "polumorphism",
"id": 6
}
],
}
],
"subTopicYear": null
}
],
}
],
}
*/