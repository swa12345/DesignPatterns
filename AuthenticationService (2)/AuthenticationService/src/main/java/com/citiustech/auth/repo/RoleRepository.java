package com.citiustech.auth.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.citiustech.auth.entity.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Integer> {

	Role findByCode(String string);

}
