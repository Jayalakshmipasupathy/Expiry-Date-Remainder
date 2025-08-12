package com.example.demo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import  org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface ExpremRepository extends JpaRepository<Exprem,Integer> {
		@Query("SELECT e FROM Exprem e WHERE e.expiryDate <= :targetDate")
	    List<Exprem> findByExpiringProducts(@Param("targetDate") LocalDate date);
		@Query("DELETE FROM Exprem e WHERE e.expiryDate < :today")
		@Modifying
		@Transactional
		void deleteExpiredProducts(@Param("today") LocalDate today);
	}

