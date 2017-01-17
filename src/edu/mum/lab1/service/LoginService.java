package edu.mum.lab1.service;

import edu.mum.lab1.domain.User;
import edu.mum.lab1.repository.UserRepository;

public class LoginService {

	UserRepository userRepository = new UserRepository();

	public Boolean loginVerification(String username, String password) {
		User user = userRepository.getUserData();
		if (username.equals(user.getUser_name()) && password.equals(user.getPassword())) {
			return true;
		} else {
			return false;
		}

	}
}
