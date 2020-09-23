package com.pk.controller;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LeadDetailsRepository extends JpaRepository<LeadDetails, Long>{

	@Query("FROM LeadDetails l ORDER BY l.registrationdDate DESC limit 50")
	List<LeadDetails> getLatestDetail();
	
}
