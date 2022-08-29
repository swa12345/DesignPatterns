package com.citiustech.model;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.transaction.Transactional;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="ProjectDetails")
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int projectId;
	private String title;
	private double budget;
	private int teamSize;
	private int duration;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date endDate;
	private String managerName;
	
	public Project() {
		super();
	}
	
	public Project(int projectId, String title, double budget, int teamSize, int duration, Date endDate,
			String managerName) {
		super();
		this.projectId = projectId;
		this.title = title;
		this.budget = budget;
		this.teamSize = teamSize;
		this.duration = duration;
		this.endDate = endDate;
		this.managerName = managerName;
	}
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getBudget() {
		return budget;
	}
	public void setBudget(double budget) {
		this.budget = budget;
	}
	public int getTeamSize() {
		return teamSize;
	}
	public void setTeamSize(int teamSize) {
		this.teamSize = teamSize;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", title=" + title + ", budget=" + budget + ", teamSize=" + teamSize
				+ ", duration=" + duration + ", endDate=" + endDate + ", managerName=" + managerName + "]";
	}
	
	
}
