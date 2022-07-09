package com.mukesh.kb.controller;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.mukesh.kb.entity.MyFamily;
import com.mukesh.kb.service.MyFamilyService;

//@Api("Family API")
@RestController
@RequestMapping("/family")
public class MyFamilyRestController {
	
	@Autowired
	private MyFamilyService service;
	
	// Show all members of Family
	//@ApiOperation("Showing All Member")
	@GetMapping("/all")
	public ResponseEntity<List<MyFamily>> getAllFaimily(){
		List<MyFamily> list = service.getAllMyFamilies();
		return new ResponseEntity<List<MyFamily>>(list,HttpStatus.OK);
	}
	// Add new member in Family
	@PostMapping("/create")
	public ResponseEntity<String> saveFamily(@RequestBody MyFamily family){
		int id = service.saveMyFamily(family);
		String message = "One Family member is added, ID : "+id;
		return new ResponseEntity<String>(message,HttpStatus.OK);
	}
	
	// Get details of one member
	@GetMapping("/find/{id}")
	public ResponseEntity<MyFamily> getOneMember(@PathVariable Integer id){
		MyFamily family = service.getOneMyFamily(id);
		return new ResponseEntity<MyFamily>(family,HttpStatus.OK);
	}
	
	//Remove one member from family
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<String> removeOneMember(@PathVariable Integer id){
		service.deleteFamily(id);
		return ResponseEntity.ok("One member is removed || ID :: "+id);
	}
	
	// Say Good morning
	@GetMapping("/wish")
	public ResponseEntity<String> wishMe (){
		//Date dt = new Date();
		Calendar dt = Calendar.getInstance();
		//@SuppressWarnings("deprecation")
		//int hour = dt.getHours();
		int hour = dt.get(Calendar.HOUR_OF_DAY);
		String msg=null;
		if(hour>=1 || hour<=12)
			msg = "Good Morning";
		else if (hour>12 || hour<16) 
			msg = "Good After Noon";
		else if(hour>16 || hour<=20)
			msg="Good Evening";
		else msg = "Good Night";
		msg=msg+" and Time is : "+hour+":"+dt.get(Calendar.MINUTE)+":"+dt.get(Calendar.SECOND);
		return ResponseEntity.ok(msg);
	}
	
	// Consume REST API
	@GetMapping("/consumeWish")
	public ResponseEntity<?> consumeAPI(){
		String uri = "http://localhost:8282/family/wish";
		RestTemplate rest = new RestTemplate();
		String msg = rest.getForObject(uri, String.class)+" ::: MUKESH";
		return ResponseEntity.ok(msg);
	}
	
	// Consume Object
	@GetMapping("/consumeAll")
	public ResponseEntity<?> getAnyObject(){
		String uri = "http://localhost:8282/family/all";
		RestTemplate temp = new RestTemplate();
		@SuppressWarnings("unchecked")
		List<MyFamily> list = (List<MyFamily>) temp.getForObject(uri, MyFamily.class);
		return ResponseEntity.ok(list);
	}
	

}
