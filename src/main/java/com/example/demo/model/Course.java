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
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;

@Entity
//@SecondaryTable(name = "questions", pkJoinColumns = @PrimaryKeyJoinColumn(name = "courseId", referencedColumnName = "courseId"))
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long courseId;
	@Column(name="courseName",length = 2000)
	private String courseName;
	@OneToMany(mappedBy = "course",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JsonManagedReference
	//@LazyToOne(LazyToOneOption.NO_PROXY)
	@JsonIgnore
	private Set<Topics> topics=new HashSet<Topics>();

	public long getCourseId() {
		return courseId;
	}
	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public Set<Topics> getTopics() {
		return topics;
	}
	public void setTopics(Set<Topics> topics) {
		this.topics = topics;
	}

}

