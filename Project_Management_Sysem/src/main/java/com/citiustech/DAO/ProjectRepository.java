package com.citiustech.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.citiustech.model.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {

	
}
