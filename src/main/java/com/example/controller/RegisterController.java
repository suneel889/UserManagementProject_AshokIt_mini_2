package com.example.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bindings.UserDetails;
import com.example.constants.AppConstants;
import com.example.service.UserRegistrationServiceInterface;

@RestController
@RequestMapping("/api")
public class RegisterController {
	
	@Autowired
	UserRegistrationServiceInterface service;
	
	@GetMapping("/countries")
	public Map<Integer,String> getAllCountries(@PathVariable Integer stateId){	
		return service.getALlCOuntries();
	}
	
	@GetMapping("/cities/{stateId}")
	public Map<Integer,String> getAllCitiesByStateId(@PathVariable Integer stateId){	
		return service.getAllCitiesByStatesId(stateId);	
	}
	
	@GetMapping("/states/{countriId}")
	public Map<Integer,String> getAllStatesByStateId(@PathVariable Integer countriId){	
		return service.getAllStatesByCountryId(countriId);	
	}
	
	@GetMapping("/chechMailId/{mailId}")
	public String checkMail(@PathVariable String  mailId) {	
		return service.checkUniquemailId(mailId)?AppConstants.DUPLICATE:AppConstants.UNIQUE;
	}
	
	@PostMapping("/registerUser")
	public String registerUser(@RequestBody UserDetails user) {	
		return service.userRegistration(user)?AppConstants.SUCCESS:AppConstants.FAILURE;
	}

}
