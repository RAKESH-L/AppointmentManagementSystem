package com.spring.jpa.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring.jpa.entity.Slots;

@Repository
public interface SlotsRepository extends JpaRepository<Slots, Long>{

	@Query("select s from Slots s where s.id=?1")
	Slots fetchSlotRecord(long sid);

}
