package com.spring.jpa.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.jpa.entity.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long>{

}
