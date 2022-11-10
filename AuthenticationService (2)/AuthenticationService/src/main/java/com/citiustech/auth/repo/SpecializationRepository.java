package com.citiustech.auth.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.citiustech.auth.entity.Specialization;

@Repository
public interface SpecializationRepository extends CrudRepository<Specialization, Integer> {

}
