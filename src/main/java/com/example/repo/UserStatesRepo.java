package com.example.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.entity.UserStates;

public interface UserStatesRepo extends JpaRepository<UserStates, Integer>{

	List<UserStates> findByCountryId(Integer countryId);

}
