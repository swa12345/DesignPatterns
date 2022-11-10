package com.citiustech.auth.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.citiustech.auth.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

	User getByEmailId(String email);
	
	@Query("Select u from User u where u.emailId = :emailId AND u.password = :password")
	User getByEmailIdAndPassword(@Param("emailId") String emailId, @Param("password") String password);

	Optional<User> findByEmailId(String username);
	
	@Query("select count(u) from User u where u.role.code = ?1")
    public long getUserCount(String code);
	
	@Query("Select u from User u where u.role.code = 'Physician'")
	public List<User> getAllPhysicians();
}
