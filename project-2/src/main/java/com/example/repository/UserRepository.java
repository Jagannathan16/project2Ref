package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.UserAccount;

@Repository
public interface UserRepository extends JpaRepository<UserAccount, Integer>{

	public UserAccount findByEmail(String email); 
}
