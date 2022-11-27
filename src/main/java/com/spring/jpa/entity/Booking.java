package com.spring.jpa.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "booking")
public class Booking {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@OneToOne
	private User user;
	
	@OneToOne
	private Course course;
	
	@OneToOne
	private Slots slots;
	
	private LocalDate enroll_date;

	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Booking(long id, User user, Course course, Slots slots, LocalDate enroll_date) {
		super();
		this.id = id;
		this.user = user;
		this.course = course;
		this.slots = slots;
		this.enroll_date = enroll_date;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Slots getSlots() {
		return slots;
	}

	public void setSlots(Slots slots) {
		this.slots = slots;
	}

	public LocalDate getEnroll_date() {
		return enroll_date;
	}

	public void setEnroll_date(LocalDate enroll_date) {
		this.enroll_date = enroll_date;
	}

	@Override
	public String toString() {
		return "Booking [id=" + id + ", user=" + user + ", course=" + course + ", slots=" + slots + ", enroll_date="
				+ enroll_date + "]";
	}

	
	
}
