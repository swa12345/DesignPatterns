package com.citiustech.auth.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.citiustech.auth.entity.Status;

@Repository
public interface StatusRepository extends CrudRepository<Status, Integer> {

}
