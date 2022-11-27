package com.spring.jpa.entity.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring.jpa.entity.Booking;
import com.spring.jpa.entity.Course;
import com.spring.jpa.entity.Slots;
import com.spring.jpa.entity.User;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long>{

	@Query("select b.user from Booking b where b.course.id=?1")
	List<User> getUserByCourse(long cid);

	@Query("select b.course from Booking b where b.user.id=?1")
	List<Course> getCourseByUserId(long uid);

	@Query("select b.slots from Booking b where b.user.id=?1")
	List<Slots> getSlotByUderId(long uid);

	List<Booking> findByUserId(long id);

}
