package com.example.demo.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

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
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "questions")
public class Questions implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "question_id")
	private Long question_id;
	@Column(name = "questions_name",length = 2000)
	private String questions_name;
	@Column(name="year")
	private int year;
	@Column(name="likes")
	public int likes;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="sub_topic_id")
	//@JsonBackReference
	private SubTopics subTopics;

	@Column
	private Long courseId;
	@Column
	private String courseName;

	@Column
	private Long topicId;
	@Column
	private String topicName;
	@Column
	private Long subSubTopicId;
	@Column
	private String subTopicName;
	@Column
	private int index=0;
	@Column
	private int dashboardFlag=0;
	
	@Column(name="flag",length = 2)
	private String flag;

	@Column(name = "expanded", columnDefinition = "boolean default false")
	private boolean expanded = false;

	@OneToMany(mappedBy = "questions",cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
	@JsonManagedReference
	private Set<Answers> answers=new HashSet<Answers>();


	//@OneToMany(mappedBy = "questions",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	//@JsonManagedReference
	//private Set<DBFile> dbFiles =new HashSet<DBFile>();

	public Long getQuestion_id() {
		return question_id;
	}
	public void setQuestion_id(long question_id) {
		this.question_id = question_id;
	}
	public String getQuestions_name() {
		return questions_name;
	}
	public void setQuestions_name(String questions_name) {
		this.questions_name = questions_name;
	}
	public Set<Answers> getAnswers() {
		return answers;
	}
	public void setAnswers(Set<Answers> answers) {
		this.answers = answers;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public SubTopics getSubTopics() {
		return subTopics;
	}
	public void setSubTopics(SubTopics subTopics) {
		this.subTopics = subTopics;
	}
	public void setQuestion_id(Long question_id) {
		this.question_id = question_id;
	}
	public Long getCourseId() {
		return courseId;
	}
	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}
	public int getLikes() {
		return likes;
	}
	public void setLikes(int likes) {
		this.likes = likes;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}
	public Long getTopicId() {
		return topicId;
	}
	public void setTopicId(Long topicId) {
		this.topicId = topicId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getTopicName() {
		return topicName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

	public Long getSubSubTopicId() {
		return subSubTopicId;
	}

	public void setSubSubTopicId(Long subSubTopicId) {
		this.subSubTopicId = subSubTopicId;
	}

	public String getSubTopicName() {
		return subTopicName;
	}

	public void setSubTopicName(String subTopicName) {
		this.subTopicName = subTopicName;
	}
	public boolean isExpanded() {
		return expanded;
	}
	public void setExpanded(boolean expanded) {
		this.expanded = expanded;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getDashboardFlag() {
		return dashboardFlag;
	}

	public void setDashboardFlag(int dashboardFlag) {
		this.dashboardFlag = dashboardFlag;
	}

	
}