package com.example.demo.model;

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
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;

@Entity
public class Topics {
	public Topics(){}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "topic_id")
	private  long topicId;
	@Column(name = "topic_name")
	private String topicName;

	@Column(name = "expanded", columnDefinition = "boolean default false")
	private boolean expanded = false;

	@OneToMany(mappedBy = "topics", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JsonManagedReference
	@JsonIgnore

	private Set<SubTopics> topicsSet=new HashSet<SubTopics>();

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="courseId")
	@JsonBackReference
	private Course course;

	@Column
	private int index=0;
	@Column
	private int dashboardFlag=0;

	public long getTopicId() {
		return topicId;
	}
	public void setTopicId(	long topicId) {
		this.topicId = topicId;
	}
	public String getTopicName() {
		return topicName;
	}
	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public Set<SubTopics> getTopicsSet() {
		return topicsSet;
	}
	public void setTopicsSet(Set<SubTopics> topicsSet) {
		this.topicsSet = topicsSet;
	}

	public boolean isExpanded() {
		return expanded;
	}

	public void setExpanded(boolean expanded) {
		this.expanded = expanded;
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

