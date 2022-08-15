package com.citiustech.main;

import java.util.Scanner;

import com.citiustech.model.CandidateReport;
import com.citiustech.service.CandidateService;

public class ABCAcademyMainClass {
	public static CandidateReport getCandidateInfo(Scanner sc) {
		CandidateReport cr = new CandidateReport();
		System.out.println("Enter Details");
		System.out.println("candidateId");
		cr.setCandidateId(sc.nextInt());
		System.out.println("candidateName");
		cr.setCandidateName(sc.next());
		System.out.println("mark1");
		cr.setMark1(sc.nextInt());
		System.out.println("mark2");
		cr.setMark2(sc.nextInt());
		System.out.println("mark3");
		cr.setMark3(sc.nextInt());
		System.out.println("Result");
		cr.setResult(sc.next());
		return cr;

	}

	public static void main(String[] args) {

		CandidateService cs = new CandidateService();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Candidate Details");
		int i;
		do {
			System.out.println("Press 1 for Add Candidate");
			System.out.println("Press 2 for Getting Candidate Results");
			System.out.println("Press 9 for Exit");
			i = sc.nextInt();
			switch (i) {
			case 1:
				CandidateReport candidate = getCandidateInfo(sc);
				System.out.println(cs.addCandidate(candidate));
				break;
			case 2:
				cs.getGradesForAllCandidates();
				break;
			}
		} while (i != 9);

	}

}
