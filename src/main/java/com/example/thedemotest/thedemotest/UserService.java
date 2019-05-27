package com.example.thedemotest.thedemotest;

import org.springframework.stereotype.Service;

@Service
public class UserService {

	public User getUser(String userName) {
		User user = new User();
		
		if(userName == null || userName.trim().equals("")) {
			user = null;
		} else {
			user.setUserName(userName);
			user.setRank("something");
			user.setName(userName);
		}
		return user;
	}
}
