package citiustech.com;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CandidateStreamingOperationsTask {

	public static void main(String[] args) {

		List<Candidate> cd = InterviewRepository.getCandidateList();

		// list candidate names from Pune city
		System.out.println("List of Pune Candidates:");
		cd.stream().filter(names -> names.getCity().equalsIgnoreCase("Pune"))
				.forEach(x -> System.out.println("Candidates from Pune City :" + x.getName()));

		printLine();

		// list city and count of candidates per city
		System.out.println("Candidate count per city");
		Map<String,Long> citiesCount=cd.stream().collect(Collectors.groupingBy(Candidate::getCity,Collectors.counting()));
		System.out.println(citiesCount);

		printLine();

		// list technical expertise and count of candidates
		System.out.println("Candidate count by Technical Expertise");
		Map<String,Long> tech= cd.stream().collect(Collectors.groupingBy(Candidate::getTechnicalExpertise,
				Collectors.counting()));
		System.out.println(tech);
		printLine();
		
		// list fresher candidates
		System.out.println("Fresher Candidate list");
		List<Candidate> f = cd.stream().filter(i1 -> (i1.getYearsOfExperience() < 1)).collect(Collectors.toList());
		for (Candidate ca : f) {
			System.out.println(ca.getName() + ", Years of exp :" + ca.getYearsOfExperience());
		}
		printLine();
		
		// listing candidates with highest experience
		System.out.println("Sorted List of Candidates by Experience");
		cd.stream().sorted((a, b) -> a.getYearsOfExperience() > b.getYearsOfExperience() ? 1: a.getYearsOfExperience() < b.getYearsOfExperience() ? -1 : 0)
				.forEach(n -> System.out.println(n));
		printLine();

		// sort the candidates by city name
		System.out.println("Sorted List of Candidates by City Name");
		cd.stream().sorted((t, t1) -> t.getCity().compareTo(t1.getCity())).forEach(c -> System.out.println(c));
	}

	private static void printLine() {
		// TODO Auto-generated method stub
		System.out.println("======================================================");
	}

}
