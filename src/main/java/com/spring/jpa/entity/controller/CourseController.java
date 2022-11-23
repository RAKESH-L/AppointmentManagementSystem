package com.spring.jpa.entity.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.jpa.entity.Course;
import com.spring.jpa.entity.Slots;
import com.spring.jpa.entity.repository.CourseRepository;
import com.spring.jpa.entity.repository.SlotsRepository;

@RestController
@RequestMapping("/api")
public class CourseController {

	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private SlotsRepository slotsRepository;
	
	@PostMapping("/course/insert")
	public String insertCourse(@RequestBody Course course) {
		String str = "Unable to upload course";
		Course c = courseRepository.save(course);
		if(c != null) {
			str = "Course Uploaded";
		}
		return str;
	}
	
	@GetMapping("/course")
	public List<Course> listAllCourse(){
		return courseRepository.findAll();
	}
	
	@DeleteMapping("/course/delete/{id}")
	public String deleteCourse(@PathVariable("id") long id) {
		String str = "Unable to delete";
		Course c = courseRepository.findById(id).get();
		if(c != null) {
			courseRepository.deleteById(id);
			str = "Course with id: " + id + "deleted";
		}
		return str;
	}
	
	@PostMapping("/slots/insert/{id}")
	public Slots insertSlots(@RequestBody Slots slot, @PathVariable("id") Long id) {
		Optional<Course> optional = courseRepository.findById(id);
		
		if(!optional.isPresent()) {
			throw new RuntimeException("ID is Invalid");
		}
		
		Course c = optional.get();
		slot.setCourse(c);
		
		return slotsRepository.save(slot);
	}
	@GetMapping("/slots")
	public List<Slots> getAllSlote(){
		return slotsRepository.findAll();
	}
	
}
