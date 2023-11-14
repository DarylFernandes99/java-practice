package main.java;

// Java code​​​​​​‌​‌​​‌‌‌​​​​‌​​‌‌​‌‌​‌​‌‌ below
import java.util.Map;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class LambdaStreamAssignment {

	// Write your answer here, and then test your code.
	// Your job is to implement the findAnswer() method.

	public static class Answer {

	    // Change these boolean values to control whether you see
	    // the expected result and/or hints.
//	    static boolean showExpectedResult = false;
//	    static boolean showHints = false;

	    // Return the highest grade for the students with a specific major
	    static int findAnswer(List<Student> students, String major) {
	        // Your code goes here.
//	        return Collections.max(students.stream()
//	            .filter(student -> student.getMajor() == major)
//	            .map(student -> student.getGrades().values())
//	            .flatMap(Collection::stream)
//	            .collect(Collectors.toList()));
	        
	        return students.stream()
	        		.filter(s -> major.equals(s.getMajor()))
	        		.flatMap(s -> s.getGrades().values().stream())
	        		.max(Integer::compareTo).orElseGet(() -> 0);
	    }

	}

	public static class Student {
	    private String firstname;
	    private String lastname;
	    private String major;
	    private Map<String, Integer> grades;

	    public Student(String firstname, String lastname, String major, Map<String, Integer> grades) {
	        this.firstname = firstname;
	        this.lastname = lastname;
	        this.major = major;
	        this.grades = grades;
	    }

	    public String getFirstname() {
	        return firstname;
	    }

	    public String getLastname() {
	        return lastname;
	    }

	    public String getMajor() {
	        return major;
	    }

	    public Map<String, Integer> getGrades() {
	        return grades;
	    }
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Student> students = Arrays.asList(
                new Student("Amine", "Ousmane", "Computer Science", Map.of("Algorithms", 90, "Data Structures", 80, "Calculus", 85)),
                new Student("Lily-Ann", "Smith", "Mathematics", Map.of("Algorithms", 80, "Data Structures", 75, "Calculus", 88)),
                new Student("Li", "Wei", "Computer Science", Map.of("Algorithms", 92, "Data Structures", 89, "Calculus", 88)),
                new Student("Jessica", "Rodriguez", "Mathematics", Map.of("Algorithms", 85, "Data Structures", 80, "Calculus", 89)));
        String major = "Computer Science";
        int result = Answer.findAnswer(students, major);
        System.out.println(result);
	}

}
