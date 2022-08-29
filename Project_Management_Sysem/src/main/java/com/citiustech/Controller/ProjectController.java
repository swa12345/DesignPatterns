package com.citiustech.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.citiustech.exception.ProjectManagementException;
import com.citiustech.model.Project;
import com.citiustech.services.ProjectService;

@RestController
@RequestMapping("/projects")
public class ProjectController {
	
	@Autowired
	public ProjectService projectService;

	@PostMapping("/addNewProject")
	public ResponseEntity<String> addProjectDetails(@RequestBody Project project) throws ProjectManagementException {
		projectService.addProjectDetails(project);
		return new ResponseEntity<String>("Inserted Successfully", HttpStatus.OK);
		
	}
	
	@PutMapping("/updateProject/{projectId}")
	public ResponseEntity<String> updateProjectDetails(@PathVariable Integer projectId,@RequestBody Project p) throws ProjectManagementException{
		projectService.updateProjectDetails(projectId,p.getTeamSize(),p.getDuration(),p.getManagerName());
		return new ResponseEntity<String>("Updated Successfully",HttpStatus.OK);
		
	}
	
	@DeleteMapping("/deleteProject/{projectId}")
	public ResponseEntity<String> deleteProjectDetails(@PathVariable int projectId) throws ProjectManagementException{
		projectService.deleteProjectDetails(projectId);
		return new ResponseEntity<String>("Project Deleted", HttpStatus.OK);
		
	}
	
	@GetMapping("/getAllProjects")
	public ResponseEntity<List<Project>> listProjectDetails() throws ProjectManagementException{
		List<Project> projects = projectService.listProjectDetails();
		System.out.println(projects);
		return new ResponseEntity<List<Project>>(projects,HttpStatus.OK);
		
		
	}
	
	
	
	
}
