package main.java;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class LambdaStreamExpressions {

	public static void addHeader(String str) {
		System.out.println("-".repeat(10) + " " + str + " " + "-".repeat(10));
	}
	public static void addSubHeader(String str) {
		System.out.println("-".repeat(3) + " " + str + " " + "-".repeat(3));
	}
	
	// Basic Lambda Expressions
	public static void functionalPredicate(Predicate<String> func) {
		System.out.println(func.test("helo"));
	}
	
	public static void basicLambdaExpressions() {
		// Predicate lambda can be used by .test(), Predicate returns boolean
		Predicate<String> lasrgerThan5 = s -> s.length() > 5;
		boolean result = lasrgerThan5.test("hello");
		System.out.println(result);
		
		// Consumer is called using .accept()
		Consumer<String> printUpperCase = s -> System.out.println(s.toUpperCase());
		printUpperCase.accept("hello functional programming");
		
		functionalPredicate(lasrgerThan5);
		functionalPredicate(s -> s.startsWith("A"));
	}
	
	// Basic stream
	public static void basicStreams() {
		// creating stream from a collection
		List<String> names = Arrays.asList("Lori", "Christa", "Maaike");
		Stream<String> namesStream = names.stream();
		
		// creating stream from an array
		String[] namesArray = {"Isra", "Jonas", "Gaia"};
		Stream<String> namesArrayStream = Arrays.stream(namesArray);
		
		// Creating a stream using Stream.of()
		Stream<String> namesOfStream = Stream.of("Ismael", "David", "Andreas");
		
		List<String> moreNames = Arrays.asList("Nabeel", "Youssef", "Ali", "Adam", "Syed");
		
		List<String> filteredNames = moreNames.stream()
				.filter(name -> name.startsWith("A"))
				.map(String::toUpperCase)
				.collect(Collectors.toList());
		
		System.out.println(filteredNames);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		addHeader("Lambda Expressions");
		basicLambdaExpressions();
		
		addHeader("Streams");
		basicStreams();
	}

}
