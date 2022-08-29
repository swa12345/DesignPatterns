package com.citiustech.services;

import java.util.List;
import org.springframework.stereotype.Service;

import com.citiustech.exception.ProjectManagementException;
import com.citiustech.model.Project;

public interface ProjectService {

	public void addProjectDetails(Project p) throws ProjectManagementException;
	public void updateProjectDetails(int ProjectId,int teamSize,int duration,String name) throws ProjectManagementException;
	public void deleteProjectDetails(int projectId) throws ProjectManagementException;
	public List<Project> listProjectDetails() throws ProjectManagementException;
}
