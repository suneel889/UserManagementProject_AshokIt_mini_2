package com.example.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.UserDetails;

public interface UserDetailsRepo extends JpaRepository<UserDetails, Integer> {

      UserDetails findByUserMailId(String mailId);

}
