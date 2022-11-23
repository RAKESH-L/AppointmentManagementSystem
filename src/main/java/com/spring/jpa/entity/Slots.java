package com.spring.jpa.entity;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "slots")
public class Slots {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "date")
	private LocalDate date;
	
	@Column(name = "time")
	private String time;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Course course;

	public Slots() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Slots(long id, LocalDate date, String time, Course course) {
		super();
		this.id = id;
		this.date = date;
		this.time = time;
		this.course = course;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return "Slots [id=" + id + ", date=" + date + ", time=" + time + ", course=" + course + "]";
	}
	
	
}
