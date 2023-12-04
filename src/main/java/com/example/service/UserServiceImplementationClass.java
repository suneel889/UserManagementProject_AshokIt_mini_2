package com.example.service;

import java.applet.AppletContext;
import java.nio.file.Files;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Stream;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bindings.UserDetails;
import com.example.constants.AppConstants;
import com.example.entity.UserCities;
import com.example.entity.UserCountries;
import com.example.entity.UserStates;
import com.example.repo.UserDetailsRepo;
import com.example.repo.UserStatesRepo;
import com.example.repo.UsercitiesRepo;
import com.example.repo.UsersCOuntriesRepo;
import com.example.EmailService;

@Service
public class UserServiceImplementationClass implements UserRegistrationServiceInterface {
	
	@Autowired
	private UsercitiesRepo citiesrepo;
	@Autowired
	private UserDetailsRepo userDetailsrepo;
	@Autowired
	private UserStatesRepo statesrepo; 
	@Autowired
	private UsersCOuntriesRepo countriesrepo;
	
	@Autowired
	private static EmailService emailservice;
	
	@Override
	public boolean userRegistration(UserDetails userdetails) {
		com.example.entity.UserDetails userDetails1=new com.example.entity.UserDetails();
		userDetails1.setUserPassword(generateTempPass());
		userDetails1.setUserAccStatus(false);
		BeanUtils.copyProperties(userdetails, userDetails1);
		
		
		UserServiceImplementationClass.registerMail(userdetails);
		return ((userDetailsrepo.save(userDetails1))!=null?true:false);
	}
	@Override
	public Map<Integer, String> getAllCitiesByStatesId(Integer stateId) {
		List<UserCities> citiesList = citiesrepo.findByStateId(stateId);
		Map <Integer , String > citiesmap=new HashMap<>();
		citiesList.forEach(x->{
			citiesmap.put(x.getCityId(), x.getCityName());
		});
		return citiesmap ;
	}
	@Override
	public Map<Integer, String> getAllStatesByCountryId(Integer countryId) {
		List<UserStates> statesList = statesrepo.findByCountryId(countryId);
		Map <Integer , String > statesmap=new HashMap<>();
		statesList.forEach(x->{
			statesmap.put(x.getStateId(), x.getStateName());
		});
		return statesmap ;
	}
	@Override
	public Map<Integer, String> getALlCOuntries() {
		List<UserCountries> countriesList = countriesrepo.findAll();
		Map <Integer , String > countriesmap=new HashMap<>();
		countriesList.forEach(x->{
			countriesmap.put(x.getCountryId(), x.getCountryName());
		});
		
		return countriesmap;
	}
	@Override
	public boolean checkUniquemailId(String mailId) {
		com.example.entity.UserDetails user=userDetailsrepo.findByUserMailId(mailId);
		return (user != null ? true : false);
	}
	
	
	private static String generateTempPass() {
		String s1 =new Random().ints(97, 122 + 1)
			      .limit(5)
			      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
			      .toString();
		return s1;
	}
	
	private static String sendMail(String filepath,UserDetails user) {
		
		String mailBody="";
		StringBuffer buffer=new StringBuffer();
		Path path = Paths.get("UNLOCK-ACC-EMAIL-BODY-TEMPLATE.txt");
		try(Stream<String> stream =Files.lines(path)){
			stream.forEach(line->
			buffer.append(line));
			mailBody=buffer.toString();
			mailBody.replaceAll(AppConstants.FNAME, user.getUserFirstName());
			mailBody.replaceAll(AppConstants.LNAME, user.getUserLastName());
			mailBody.replaceAll(AppConstants.EMAIL, user.getUserMailId());
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return mailBody;
	}
	
	private static boolean registerMail(UserDetails user) {
		String mailSubject="Registration done Sucessfully";
		String mailBody=sendMail(mailSubject, user);
		String mailSendTo=user.getUserMailId();
		
		 emailservice.sendEmail(mailSendTo,mailSubject,mailBody);
		 return true;
	}

	
}
