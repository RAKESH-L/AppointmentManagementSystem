package com.spring.jpa.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.jpa.entity.Slots;

@Repository
public interface SlotsRepository extends JpaRepository<Slots, Long>{

}
