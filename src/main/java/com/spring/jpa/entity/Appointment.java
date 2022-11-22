package com.spring.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "appointment")
public class Appointment {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "membername")
	private String memberName;
	
	@Column(name = "courseid")
	private Integer courseId;
	
	@Column(name = "slotid")
	private Integer slotId;
	
	@Column(name = "status")
	private String status;

	public Appointment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Appointment(long id, String memberName, Integer courseId, Integer slotId, String status) {
		super();
		this.id = id;
		this.memberName = memberName;
		this.courseId = courseId;
		this.slotId = slotId;
		this.status = status;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public Integer getCourseId() {
		return courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	public Integer getSlotId() {
		return slotId;
	}

	public void setSlotId(Integer slotId) {
		this.slotId = slotId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Appointment [id=" + id + ", memberName=" + memberName + ", courseId=" + courseId + ", slotId=" + slotId
				+ ", status=" + status + "]";
	}
	
	
}
