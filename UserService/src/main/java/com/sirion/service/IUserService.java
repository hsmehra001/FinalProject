package com.sirion.service;

import java.util.List;

import com.sirion.entity.UserBean;

public interface IUserService {
	public List<UserBean> addUser(UserBean user);
	public List<UserBean> updateUser(UserBean user);
	public List<UserBean> deleteUser(String uid);
	public UserBean getUser(String uid);
	public List<UserBean> getAllUser();
}
