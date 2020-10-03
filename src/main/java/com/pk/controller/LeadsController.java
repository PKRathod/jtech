package com.pk.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

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

	@CrossOrigin(origins = "https://www.quantumnex.com")
	@RequestMapping(value = "/wakeup", method = RequestMethod.GET)
	public String wakeup(){
		System.out.println("::::::::::::::::::::::wakeup called:::::::::::::::::::::::::::::");
		return "wakeup";
	}

	@CrossOrigin(origins = "https://www.quantumnex.com")
	@RequestMapping(value = "/live/get", method = RequestMethod.GET)
	public BaseDto getLive(){
		System.out.println(":::::::::::::::::::GetLive called::::::::::::::::::::::::::::::");
		BaseDto base = new BaseDto();
		List<LeadDetails> res = new ArrayList<>();
		try {
			res = repo.getLatestDetail();
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
		try{
			SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = new Date(System.currentTimeMillis());
			lead.setRegistrationdDate(formatter.format(date));
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

			ZoneId zone = ZoneId.systemDefault();
			ZoneId zoneId = ZoneId.of(zone.toString());
			LocalDateTime zonedDateTime = LocalDateTime.now(zoneId);

			lead.setRegistrationdDate(zonedDateTime.toString()+" "+zone.getDisplayName(TextStyle.FULL, Locale.ROOT));

			repo.save(lead);
			base.setResponse("SUCCESS");
		}catch(Exception e){
			e.printStackTrace();
		}
		return base;
	}

}
