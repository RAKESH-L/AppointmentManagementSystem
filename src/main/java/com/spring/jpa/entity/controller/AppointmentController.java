package com.spring.jpa.entity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.jpa.entity.Appointment;
import com.spring.jpa.entity.repository.AppointmentRepository;

@RestController
@RequestMapping("/api")
public class AppointmentController {

	@Autowired
	private AppointmentRepository appointmentRepository;
	
	@PostMapping("/appointment/insert")
	public String insertAppointment(@RequestBody Appointment appointment) {
		String str = "Unable to upload appointment";
		Appointment a = appointmentRepository.save(appointment);
		if(a != null) {
			str = "appointment Uploaded";
		}
		return str;
	}
	@GetMapping("/appointment")
	public List<Appointment> listAllAppointment(){
		return appointmentRepository.findAll();
		
	}
	
	@DeleteMapping("/appointment/delete/{id}")
	public String deleteAppointment(@PathVariable("id") long id) {
		String str = "Unable to delete";
		Appointment a = appointmentRepository.findById(id).get();
		if(a != null) {
			appointmentRepository.deleteById(id);
			str = "Appointment with id: " + id + "deleted";
		}
		return str;
	}
	
}
