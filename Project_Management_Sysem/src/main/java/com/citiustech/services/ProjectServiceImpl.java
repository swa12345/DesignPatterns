package com.citiustech.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citiustech.DAO.ProjectRepository;
import com.citiustech.exception.ProjectManagementException;
import com.citiustech.model.Project;


@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {
	
	@Autowired
	public ProjectRepository projectRepository;

	@Override
	public void addProjectDetails(Project p) throws ProjectManagementException {
		Project newProject = new Project(p.getProjectId(),p.getTitle(),p.getBudget(),p.getTeamSize(),p.getDuration(),p.getEndDate(),p.getManagerName());
		projectRepository.save(newProject);	
		System.out.println("Testing "+newProject);
	}

	@Override
	public void updateProjectDetails(int ProjectId,int teamSize,int duration,String name) throws ProjectManagementException{
		Optional<Project> project =  projectRepository.findById(ProjectId);
		Project updateProject = project.orElseThrow(()->new ProjectManagementException("Service.CUSTOMERS_NOT_FOUND"));
		updateProject.setTeamSize(teamSize);
		updateProject.setDuration(duration);
		updateProject.setManagerName(name);
		projectRepository.save(updateProject);
	}

	@Override
	public void deleteProjectDetails(int projectId) throws ProjectManagementException{
		projectRepository.deleteById(projectId);
	}

	@Override
	public List<Project> listProjectDetails() throws ProjectManagementException{
		List<Project> listOfprojects = (List<Project>) projectRepository.findAll();
		return listOfprojects;
	}
	
	

}
