package com.SchoolData.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SchoolData.Service.SchoolDataService;

@RestController
@CrossOrigin
public class SchoolDataController {

	
	@Autowired
	SchoolDataService service;
	
	@GetMapping("/getSchooldata")
	public ResponseEntity<?>getSchollData(){
		return service.getSchoolData();
	}
	@GetMapping("/getData")
	public ResponseEntity<?>getData(String School_ID){
		return service.getData(School_ID);
		
	}
	
}
