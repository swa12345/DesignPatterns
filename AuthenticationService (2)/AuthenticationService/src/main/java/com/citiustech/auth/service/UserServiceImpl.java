package com.citiustech.auth.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.citiustech.auth.dto.UserCountDto;
import com.citiustech.auth.dto.UserDTO;
import com.citiustech.auth.entity.Role;
import com.citiustech.auth.entity.User;
import com.citiustech.auth.exception.UserException;
import com.citiustech.auth.exception.UserNotFoundException;
import com.citiustech.auth.exception.UsersNotFoundException;
import com.citiustech.auth.repo.RoleRepository;
import com.citiustech.auth.repo.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private RoleRepository roleRepo;

	@Override
	public void registerUser(UserDTO userDto) throws UserException {

		User user = new User();
		// user.setUserId(userDto.getUserId());
		user.setTitle(userDto.getTitle());
		user.setFirstName(userDto.getFirstName());
		user.setLastName(userDto.getLastName());
		user.setEmailId(userDto.getEmailId());
		user.setContactNumber(userDto.getContactNumber());
		user.setDob(userDto.getDob());
		user.setPassword(userDto.getPassword());
		user.setCreatedDate(userDto.getCreatedDate());
		user.setCreatedBy(userDto.getCreatedBy());
		user.setModifiedDate(userDto.getModifiedDate());
		user.setModifiedBy(userDto.getModifiedBy());
		user.setSpecialization(userDto.getSpecialization());
		Role role=userDto.getRole();
        if (ObjectUtils.isEmpty(role)) {
            role = roleRepo.findByCode("Patient");
        } else if(!ObjectUtils.isEmpty(role.getCode())){
            role = roleRepo.findByCode(userDto.getRole().getCode());
        }
        user.setRole(role);
		user.setStatus(userDto.getStatus());

		User existingUser = userRepo.getByEmailId(userDto.getEmailId());

		if (existingUser != null) {
			throw new UserException("User already exists with this email ID");
		}
		userRepo.save(user);
//        Optional<User> u = userRepo.findById(2);

//        System.out.println("Special ==== " + u.get().getSpecialization().getCode());
//        System.out.println("role ======== " + u.get().getRole().getCode());
//        System.out.println("Status =============== " + u.get().getStatus().getCode());
	}

	@Override
	public List<UserDTO> getAllUsers() throws UsersNotFoundException {
		Iterable<User> users = userRepo.findAll();
		List<UserDTO> users1 = new ArrayList<>();

		users.forEach(user -> {
			UserDTO udto = new UserDTO();
			udto.setUserId(user.getUserId());
			udto.setFirstName(user.getFirstName());
			udto.setLastName(user.getLastName());
			udto.setEmailId(user.getEmailId());
			udto.setDefaultPassword(user.isDefaultPassword());
			udto.setDob(user.getDob());
			udto.setRole(user.getRole());
			udto.setSpecialization(user.getSpecialization());
			udto.setStatus(user.getStatus());
			users1.add(udto);
		});

		if (users1.isEmpty()) {
			throw new UsersNotFoundException("There are currently no registered Users");
		}

		return users1;
	}

	@Override
	public User getUserById(int userId) throws UserNotFoundException {

		Optional<User> user = userRepo.findById(userId);
		User user1 = user.orElseThrow(() -> new UserNotFoundException("User with this ID not exists"));
		return user1;
	}

	@Override
	public User getUserByEmailIdAndPassword(String emailId, String password) throws UserNotFoundException {
		User user = userRepo.getByEmailIdAndPassword(emailId, password);

		if (user == null) {
			throw new UserNotFoundException("Invalid Email ID and Password");
		}
		return user;
	}

	@Override
	public User getUserByEmail(String username) throws UserNotFoundException {
		Optional<User> user = userRepo.findByEmailId(username);
		User user1 = user.orElseThrow(() -> new UserNotFoundException("User with this ID not exists"));
		return user1;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UserNotFoundException {
		Optional<User> optional = userRepo.findByEmailId(username);
		if (optional.isPresent()) {
			User user = optional.get();
			String roleName = "";
			int roleId = user.getRole().getRoleId();
			if (!ObjectUtils.isEmpty(roleId)) {
				Optional<Role> role = roleRepo.findById(roleId);
				if (role.isPresent()) {
					roleName = role.get().getCode();
				}
			}
			String password = user.getPassword();

			return new org.springframework.security.core.userdetails.User(user.getEmailId(), password,
					Arrays.asList(new SimpleGrantedAuthority("ROLE_" + roleName)));
		} else {
			throw new UserNotFoundException("User with " + username + " does not exist");
		}
	}

	@Override
	public void forgotPassword(String emailId) throws UserNotFoundException {

		User u = getUserByEmail(emailId);

	}

	public UserCountDto countUser() {

		long physicianCount = userRepo.getUserCount("PHYSICIAN");

		long nurseCount = userRepo.getUserCount("NURSE");

		long patientCount = userRepo.getUserCount("PATIENT");

		return new UserCountDto(physicianCount, nurseCount, patientCount);

	}
	
	public void updateUserDetails(int userId, User userr) throws UserNotFoundException {
		
		Optional<User> user = userRepo.findById(userId);
		
		User user1 = user.orElseThrow(() -> new UserNotFoundException("User with this ID not exists"));
		
		User _user = user.get();
		
		_user.setUserId(userr.getUserId());
		_user.setFirstName(userr.getFirstName());
		_user.setLastName(userr.getLastName());
		_user.setEmailId(userr.getEmailId());
		_user.setDefaultPassword(userr.isDefaultPassword());
		_user.setDob(userr.getDob());
		_user.setRole(userr.getRole());
		_user.setSpecialization(userr.getSpecialization());
		_user.setStatus(userr.getStatus());
		
		userRepo.save(_user);
	}
	
	public List<User> getAllPhysicians(){
		return userRepo.getAllPhysicians();
	}
}
