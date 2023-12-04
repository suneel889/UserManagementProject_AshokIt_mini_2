package com.example.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.UserCities;

public interface UsercitiesRepo extends JpaRepository<UserCities, Integer> {

	List<UserCities> findByStateId(Integer stateId);

	

}
