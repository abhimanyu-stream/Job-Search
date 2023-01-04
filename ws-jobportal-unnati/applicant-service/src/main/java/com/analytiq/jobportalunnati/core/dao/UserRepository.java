package com.analytiq.jobportalunnati.core.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.analytiq.jobportalunnati.core.model.User;



public interface UserRepository extends JpaRepository<User, Long>{
	
	User findByEmail(String email);
    User findByUsername(String username);
    //
    //Optional<User> findByUsername(String username);
	Boolean existsByUsername(String username);
	Boolean existsByEmail(String email);
	
	User findByUsernameAndPassword(String username, String password);

}
