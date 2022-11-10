package com.citiustech.auth.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;

import com.citiustech.auth.dto.UserCountDto;
import com.citiustech.auth.dto.UserDTO;
import com.citiustech.auth.entity.User;
import com.citiustech.auth.exception.UserException;
import com.citiustech.auth.exception.UserNotFoundException;
import com.citiustech.auth.exception.UsersNotFoundException;

public interface UserService {

	public void registerUser(UserDTO userDto) throws UserException;
	
	public List<UserDTO> getAllUsers() throws UsersNotFoundException;
	
	public User getUserById(int userId) throws UserNotFoundException;
	
	//public void updateUser();
	
	public User getUserByEmailIdAndPassword(String emailId, String password) throws UserNotFoundException;

	public User getUserByEmail(String username) throws UserNotFoundException;

	public UserDetails loadUserByUsername(String username) throws UserNotFoundException;
	
	public void forgotPassword(String emailId) throws UserNotFoundException;

	public UserCountDto countUser();
	
	public void updateUserDetails(int userId, User userr) throws UserNotFoundException;
	
	public List<User> getAllPhysicians();
	
	

}
