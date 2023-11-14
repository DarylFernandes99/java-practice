package main.java;

import java.util.*;

public class CollectionsGenerics {

	public static void addHeader(String str) {
		System.out.println("-".repeat(10) + " " + str + " " + "-".repeat(10));
	}
	public static void addSubHeader(String str) {
		System.out.println("-".repeat(3) + " " + str + " " + "-".repeat(3));
	}
	
	// Collections and Generics
	public static void collectionsGenerics() {
		List<String> names = new ArrayList<String>();
		names.add("Mary-Ann");
		names.add("Carlos");
		names.add("Apurav");
		names.remove(1);
		System.out.println(names);
		
		List<Integer> numbers = new ArrayList<>();
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
		int sum = 0;
		for (int number: numbers) {
			sum += number;
		}
		
		System.out.println("Sum: " + sum);
	}
	
	// Class with generic type (Classes with parameterized types)
	public static class Pair<T> {
		private T first;
		private T second;
		
		public Pair(T first, T second) {
			this.first = first;
			this.second = second;
		}

		public T getFirst() {
			return first;
		}

		public void setFirst(T first) {
			this.first = first;
		}

		public T getSecond() {
			return second;
		}

		public void setSecond(T second) {
			this.second = second;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		addHeader("Collections and Generics");
		collectionsGenerics();
		
		addHeader("Generic class");
		Pair<String> namePair = new Pair<>("Gaia", "Jonas");
		Pair<Integer> agePair = new Pair<>(8, 5);
		
		String firstName = namePair.getFirst();
		int firstAge = agePair.getFirst();
		
		System.out.println("FirstName: " + firstName + ", FirstAge: " + firstAge);
	}

}
