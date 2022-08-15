package com.citiustech.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.citiustech.model.CandidateReport;

public class CandidateService {

	static Connection connection = null;
	static PreparedStatement pstmt = null;

	public static String addCandidate(CandidateReport candidate) {
		try {
			if ((candidate.getMark1() < 50 || candidate.getMark2() < 50 || candidate.getMark3() < 50)
					&& candidate.getResult().equalsIgnoreCase("P")) {
				System.out.println("Result should be 'F' (Fail) if student scores less than 50 in any one subject");
			} else if ((candidate.getMark1() >= 50 && candidate.getMark2() >= 50 && candidate.getMark3() >= 50)
					&& candidate.getResult().equalsIgnoreCase("F")) {
				System.out.println("Result should be 'P' (Pass) if student scores more than 50 in all the subjects");
			} else {
				System.out.println("Insertion Started");
				connection = DriverManager.getConnection(
						"jdbc:sqlserver://IMC5BCP39-MSL2\\SQLEXPRESS2019;databaseName=Assignment2_ABCAcademy;user=sa;password=password_123");
				pstmt = connection.prepareStatement("insert into CandidateReport values(?,?,?,?,?,?,?)");
				pstmt.setInt(1, candidate.getCandidateId());
				pstmt.setString(2, candidate.getCandidateName());
				pstmt.setInt(3, candidate.getMark1());
				pstmt.setInt(4, candidate.getMark2());
				pstmt.setInt(5, candidate.getMark3());
				pstmt.setString(6, candidate.getResult());
				pstmt.setString(7, calculateGrade(candidate));
				pstmt.executeUpdate();
				System.out.println("Details added to database");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "Candidate details are successfully added.";

	}

	public static String calculateGrade(CandidateReport candidateReportTO) {
		if (candidateReportTO.getResult().equalsIgnoreCase("F")) {
			candidateReportTO.setGrade("NA");
		} else {
			int averageOfMarks = ((candidateReportTO.getMark1()) + (candidateReportTO.getMark2())
					+ (candidateReportTO.getMark3())) / 3;
			if (averageOfMarks >= 85) {
				candidateReportTO.setGrade("A");
			} else if (averageOfMarks < 85 && averageOfMarks >= 75) {
				candidateReportTO.setGrade("B");
			} else {
				candidateReportTO.setGrade("C");
			}
		}

		return candidateReportTO.getGrade();

	}

	public static List<CandidateReport> getGradesForAllCandidates() {
		List<CandidateReport> li = new ArrayList<>();
		try {
			connection = DriverManager.getConnection(
					"jdbc:sqlserver://IMC5BCP39-MSL2\\SQLEXPRESS2019;databaseName=Assignment2_ABCAcademy;user=sa;password=password_123");
			pstmt = connection.prepareStatement("select * from CandidateReport");
			ResultSet resultSet = pstmt.executeQuery();
			System.out.println("Here are the list of Candidates");
			while (resultSet.next()) {
				CandidateReport canReport = new CandidateReport();
				canReport.setCandidateId(resultSet.getInt("candidateId"));
				canReport.setGrade(resultSet.getString("grade"));
				li.add(canReport);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		for (CandidateReport c : li) {
			System.out.println(c.getCandidateId() + "---" + c.getGrade());
		}

		return li;

	}

}
