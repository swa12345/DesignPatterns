package com.citiustech.auth.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.citiustech.auth.dto.UserCountDto;
import com.citiustech.auth.dto.UserDTO;
import com.citiustech.auth.entity.User;
import com.citiustech.auth.exception.UserException;
import com.citiustech.auth.exception.UserNotFoundException;
import com.citiustech.auth.exception.UsersNotFoundException;
import com.citiustech.auth.jwt.JwtGeneratorInterface;
import com.citiustech.auth.service.HystrixService;
import com.citiustech.auth.service.UserService;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private HystrixService hystService;
	
	@Autowired
	private JwtGeneratorInterface jwtGenerator;
	
	@PostMapping("/register")
	public ResponseEntity<String> registerUser(@RequestBody UserDTO userDto) throws UserException {
		
		userService.registerUser(userDto);
		
		//hystService.sendEmail("USER_ACTIVATION", userDto);
		
		return new ResponseEntity<String>("User has been registered successfully", HttpStatus.CREATED);
	}
	
	@GetMapping("/users")
	public ResponseEntity<List<UserDTO>> getAllUsers() throws UsersNotFoundException{
		List<UserDTO> users = userService.getAllUsers();
		return new ResponseEntity<List<UserDTO>>(users, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable int id) throws UserNotFoundException{
		User user = userService.getUserById(id);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
//	@GetMapping("/{username}")
//	public ResponseEntity<User> getUserByEmail(@PathVariable String email) throws UserNotFoundException{
//		User user = userService.getUserByEmail(email);
//		return new ResponseEntity<User>(user, HttpStatus.OK);
//	}
	
	 //@CrossOrigin(origins = "http://localhost:4200")
	 @PostMapping("/login")
	  public ResponseEntity<?> loginUser(@RequestBody User user) {
	    try {
	    	
	      if(user.getEmailId() == null || user.getPassword() == null) {
	      throw new UserNotFoundException("UserName or Password is Empty");
	    }
	      
	    User userData = userService.getUserByEmailIdAndPassword(user.getEmailId(), user.getPassword());
	    if(userData == null){
	       throw new UserNotFoundException("UserName or Password is Invalid");
	    }
	       return new ResponseEntity<>(jwtGenerator.generateToken(userData), HttpStatus.OK);
	    } catch (UserNotFoundException e) {
	       return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
	    }
	  }
	 
	 @GetMapping("/count")
     public UserCountDto getAllUserCount() {

	        return userService.countUser();

	    }
	 
	 @PutMapping("/{id}")
	 public void updateUser(@PathVariable int userId, @RequestBody User user) throws UserNotFoundException {
		
		 userService.updateUserDetails(userId, user);
	 }
	 
	 @GetMapping("/physicians")
	 public ResponseEntity<List<User>> getAllPhysicians(){
		 List<User> physicans = userService.getAllPhysicians();
		 return new ResponseEntity<List<User>>(physicans, HttpStatus.OK);
	 }
}
