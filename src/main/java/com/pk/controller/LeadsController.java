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
    public BaseDto get(){
		System.out.println("getlocal called..");
		BaseDto base = new BaseDto();
		List<LeadDetails> res = new ArrayList<>();
		try {
			 res = repo.findAll();
			 base.setResponse(res);
		} catch (Exception e) {
           e.printStackTrace();		}
		return base;
	}
	
	@CrossOrigin(origins = "https://www.quantumnex.com")
	@RequestMapping(value = "/live/get", method = RequestMethod.GET)
    public BaseDto getLive(){
		System.out.println("getLive called..");
		BaseDto base = new BaseDto();
		List<LeadDetails> res = new ArrayList<>();
		try {
			 res = repo.findAll();
			 base.setResponse(res);
		} catch (Exception e) {
           e.printStackTrace();		}
		return base;
	}
	
	
	@CrossOrigin(origins = "http://localhost:8080")
	@RequestMapping(value = "/post", method = RequestMethod.POST)
    public BaseDto savelocal(@RequestBody LeadDetails lead){
		System.out.println("savelocal called..");
		BaseDto base = new BaseDto();
		String status="";
		try{
		repo.save(lead);
		base.setResponse("SUCCESS");  
		}catch(Exception e){
			e.printStackTrace();
		}
		return base;
	}
	
	
	@CrossOrigin(origins = "https://www.quantumnex.com")
	@RequestMapping(value = "/live/post", method = RequestMethod.POST)
    public BaseDto savelive(@RequestBody LeadDetails lead){
		System.out.println("savelive called..");
		BaseDto base = new BaseDto();
		try{
		 repo.save(lead);
		 base.setResponse("SUCCESS");
		}catch(Exception e){
			e.printStackTrace();
		}
		return base;
	}
	
}

