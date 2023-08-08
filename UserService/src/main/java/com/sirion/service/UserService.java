package com.sirion.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sirion.entity.UserBean;
import com.sirion.repo.UserRepo;

@Service
public class UserService implements IUserService {
	@Autowired
	private UserRepo repo;
	@Override
	public List<UserBean> addUser(UserBean user) {
		if(user!=null) {
			repo.saveAndFlush(user);
			System.out.println("User Created...");
		}
		return repo.findAll();
	}

	@Override
	public List<UserBean> updateUser(UserBean user) {
		if(user!=null) {
			repo.saveAndFlush(user);
		}
		else {
			System.out.println("User not found");
		}
		return repo.findAll();
	}

	@Override
	public UserBean getUser(String uid) {
		Optional<UserBean> op=repo.findById(uid);
		if(op.isPresent()) {
			return op.get();
		}
		return null;
	}

	@Override
	public List<UserBean> deleteUser(String uid) {
		if(getUser(uid)!=null) {
			repo.deleteById(uid);
		}
		else {
			System.out.println("Employee not found");
		}
		return repo.findAll();
	}

	@Override
	public List<UserBean> getAllUser() {
		List<UserBean> li=repo.findAll();
		return li;
	}


}
