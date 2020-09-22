package com.pk.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LeadsController {

	@Autowired
	LeadDetailsRepository repo;
	
	@CrossOrigin(origins = "http://localhost:8080")
	@RequestMapping(value = "/get", method = RequestMethod.GET)
    public List<LeadDetails> get(){
		String status="";
		List<LeadDetails> res = new ArrayList<>();
		try {
			 res = repo.findAll();
		} catch (Exception e) {
           e.printStackTrace();		}
		return res;
	}
	
	@CrossOrigin(origins = "https://www.quantumnex.com")
	@RequestMapping(value = "/live/get", method = RequestMethod.GET)
    public List<LeadDetails> getLive(){
		String status="";
		List<LeadDetails> res = new ArrayList<>();
		try {
			 res = repo.findAll();
		} catch (Exception e) {
           e.printStackTrace();		}
		return res;
	}
	
	
	@CrossOrigin(origins = "http://localhost:8080")
	@RequestMapping(value = "/post", method = RequestMethod.POST)
    public String post(@RequestBody LeadDetails lead){
		String status="";
		try{
		LeadDetails res = repo.save(lead);
		status = "SUCCESS";
		}catch(Exception e){
			status = "FAILED";
			e.printStackTrace();
		}
		return status;
	}
	
	
	@CrossOrigin(origins = "https://www.quantumnex.com")
	@RequestMapping(value = "/live/post", method = RequestMethod.POST)
    public String savelive(@RequestBody LeadDetails lead){
		String status="";
		try{
		LeadDetails res = repo.save(lead);
		status = "SUCCESS";
		}catch(Exception e){
			status = "FAILED";
			e.printStackTrace();
		}
		return status;
	}
	
}

