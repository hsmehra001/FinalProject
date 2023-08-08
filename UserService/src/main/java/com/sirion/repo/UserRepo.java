package com.sirion.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sirion.entity.UserBean;

public interface UserRepo extends JpaRepository<UserBean, String>{
	
}
