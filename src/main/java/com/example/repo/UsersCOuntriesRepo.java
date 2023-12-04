package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.UserCountries;

public interface UsersCOuntriesRepo extends JpaRepository<UserCountries, Integer> {

}
