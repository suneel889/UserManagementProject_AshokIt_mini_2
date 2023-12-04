package com.example.service;


import java.util.Map;


import com.example.bindings.UserDetails;

public interface UserRegistrationServiceInterface {
	
	public boolean userRegistration(UserDetails userdetails);
	public Map<Integer , String> getAllStatesByCountryId(Integer countryId);
	public Map<Integer, String> getAllCitiesByStatesId(Integer stateId);
	public Map< Integer , String> getALlCOuntries();
	public boolean  checkUniquemailId(String mailId);

}
