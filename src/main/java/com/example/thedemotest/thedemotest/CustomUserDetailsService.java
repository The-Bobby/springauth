package com.example.thedemotest.thedemotest;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;



@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserService userService;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userService.getUser(username);
		System.out.println(user);
		
		if (user == null) {// should have proper handling of Exception
			System.out.println("USER IS NULL THROWING EXCEPTION");
			throw new UsernameNotFoundException("User '" + username + "' not found.");
		}
		System.out.println("AUTHENTICATED USER: " + user.toString());
		GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ADMIN");
		UserDetails details = new org.springframework.security.core.userdetails.User(user.getUserName(),
				"N/A", Arrays.asList(grantedAuthority));
		
		return details;
	}

}