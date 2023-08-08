package com.sirion.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sirion.entity.UserBean;
import com.sirion.service.UserService;
import com.sirion.validation.UserValidation;

@RestController
@RequestMapping("user")
public class UserController {
	@Autowired
	private UserService uService;
	@Autowired
	private UserValidation validity;
	@GetMapping(value="all")
	public List<UserBean> getAllUser(){
		return uService.getAllUser();
	}
	@GetMapping(value="/{uid}")
	public ResponseEntity<UserBean> getUser(@PathVariable String uid){
		UserBean u=uService.getUser(uid);
		if(u!=null) {
			return new ResponseEntity<>(u,HttpStatus.OK);
		}
		else {
			return new ResponseEntity("User not found",HttpStatus.NOT_FOUND);
		}
	}
	@PostMapping
	public ResponseEntity<String> addUser(@RequestBody UserBean u){
		try {
			validity.ValidUser(u);
			uService.addUser(u);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
			// TODO: handle exception
		}
		return new ResponseEntity<String>("User Saved with Id:"+u.getUserId(), HttpStatus.ACCEPTED);
	}
	@PutMapping
	public List<UserBean> updateUser(@RequestBody UserBean u){
		return uService.updateUser(u);
	}
	@DeleteMapping
	public List<UserBean> deleteUser(@RequestBody String uid){
		return uService.deleteUser(uid);
	}
}
