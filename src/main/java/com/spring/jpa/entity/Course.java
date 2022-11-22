package com.spring.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "course")
public class Course {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "coursename")
	private String courseName;
	
	@Column(name = "courseprice")
	private double coursePrice;
	
	@Column(name = "noofseats")
	private long noOfSeats;

	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Course(long id, String courseName, double coursePrice, long noOfSeats) {
		super();
		this.id = id;
		this.courseName = courseName;
		this.coursePrice = coursePrice;
		this.noOfSeats = noOfSeats;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public double getCoursePrice() {
		return coursePrice;
	}

	public void setCoursePrice(double coursePrice) {
		this.coursePrice = coursePrice;
	}

	public long getNoOfSeats() {
		return noOfSeats;
	}

	public void setNoOfSeats(long noOfSeats) {
		this.noOfSeats = noOfSeats;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", courseName=" + courseName + ", coursePrice=" + coursePrice + ", noOfSeats="
				+ noOfSeats + "]";
	}

}
