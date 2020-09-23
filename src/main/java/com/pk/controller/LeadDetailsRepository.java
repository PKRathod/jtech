package com.pk.controller;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LeadDetailsRepository extends JpaRepository<LeadDetails, Long>{

	@Query("FROM LeadDetails l WHERE l.registrationdDate >= DATE(NOW()) - INTERVAL 7 DAY ORDER BY l.registrationdDate DESC")
	List<LeadDetails> getLatestDetail();
	
}
