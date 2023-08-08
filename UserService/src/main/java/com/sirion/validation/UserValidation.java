package com.sirion.validation;

import org.springframework.stereotype.Component;

import com.sirion.entity.UserBean;
import com.sirion.exception.UserException;

@Component
public class UserValidation {
	public boolean ValidUser(UserBean user) throws UserException{
		String pattern="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
		if(!user.getPassword().matches(pattern)) {
			throw new UserException("Weak Password");
		}
		if(!(user.getRole().matches("Customer") || user.getRole().matches("Admin"))) {
			throw new UserException("Wrong role");
		}
		return true;
	}
}
