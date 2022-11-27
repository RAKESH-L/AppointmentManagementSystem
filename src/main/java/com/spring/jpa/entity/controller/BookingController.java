package com.spring.jpa.entity.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.jpa.entity.Booking;
import com.spring.jpa.entity.Course;
import com.spring.jpa.entity.Slots;
import com.spring.jpa.entity.User;
import com.spring.jpa.entity.repository.BookingRepository;
import com.spring.jpa.entity.repository.CourseRepository;
import com.spring.jpa.entity.repository.RegistrationRepository;
import com.spring.jpa.entity.repository.SlotsRepository;

@RestController
@RequestMapping("/api")
public class BookingController {

	@Autowired
	private RegistrationRepository userRepository;
	
	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private SlotsRepository slotsRepository;
	
	@Autowired
	private BookingRepository bookingRepository;
	
	@PostMapping("/user/course/{uid}/{cid}/{sid}")
	public Booking enrollStudentInCourse(@PathVariable("uid") long uid, 
										@PathVariable("cid") long cid,
										@PathVariable("sid") long sid) {
		User user = userRepository.fetchUserRecord(uid);
		if(user == null)
			throw new RuntimeException("User ID Invalid");
		
		Course course = courseRepository.fetchCourseRecord(cid);
		if(course == null)
			throw new RuntimeException("Course ID Invalid");
		
		Slots slot = slotsRepository.fetchSlotRecord(sid);
		if(slot == null)
			throw new RuntimeException("Slot ID Invalid");
		
		Booking booking = new Booking();
		booking.setUser(user);
		booking.setCourse(course);
		booking.setSlots(slot);
		booking.setEnroll_date(LocalDate.now());
		
		return bookingRepository.save(booking);
		
	}
	
	@GetMapping("/user/course/{cid}")
	public List<User> getUserByCourseId(@PathVariable("cid") long cid){
		List<User> list = bookingRepository.getUserByCourse(cid);
		return list;
	}
	
	@GetMapping("/course/user/{uid}")
	public List<Course> getCourseByUserId(@PathVariable("uid") long uid){
		List<Course> list = bookingRepository.getCourseByUserId(uid);
		return list;
	}
	
	@GetMapping("/slots/user/{uid}")
	public List<Slots> getSlotsByUserId(@PathVariable("uid") long uid){
		List<Slots> list = bookingRepository.getSlotByUderId(uid);
		return list;
	}
	
	@GetMapping("/booking/user/{id}")
	public List<Booking> getBookingByUserId(@PathVariable("id") long id) {
		List<Booking> booking = bookingRepository.findByUserId(id);
		return booking;
	}
}
