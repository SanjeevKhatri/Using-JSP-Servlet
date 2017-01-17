package edu.mum.lab1.service;

import edu.mum.lab1.domain.User;

public class LoginService {

	public Boolean loginVerification(String username, String password, User user) {
		if (username.equals(user.getUser_name()) && password.equals(user.getPassword())) {
			return true;
		} else {
			return false;
		}

	}
}
