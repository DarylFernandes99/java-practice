package main.java;

// Java code​​​​​​‌​‌​​‌‌‌​​‌​‌‌‌‌​​​​​‌​​‌ below
import java.math.BigInteger;
import java.util.*;
import java.util.concurrent.*;

public class ConcurrencyMultithreadingAssignment {

	// Write your answer here, and then test your code.
	// Your job is to implement the findAnswer() method and the FactorialTask class.

	static class Answer {

	    // Change these boolean values to control whether you see
	    // the expected result and/or hints.
	    static boolean showExpectedResult = false;
	    static boolean showHints = false;

	    static Map<Integer, BigInteger> findAnswer(List<Integer> numbers) {
	        // Your code goes here.
	        ExecutorService executor = Executors.newFixedThreadPool(2);
	        
	        List<Future<Map.Entry<Integer, BigInteger>>> futures = new ArrayList<>();
	        for (Integer number: numbers) {
	            futures.add(executor.submit(new FactorialTask(number)));
	        }

	        Map<Integer, BigInteger> results = new HashMap<>();
	        for (Future<Map.Entry<Integer, BigInteger>> future: futures) {
	            try {
	                Map.Entry<Integer, BigInteger> result = future.get();
	                results.put(result.getKey(), result.getValue());
	            } catch (InterruptedException | ExecutionException e) {
	                e.printStackTrace();
	            }
	        }

	        executor.shutdown();
	        return results;
	    }
	}

	static class FactorialTask implements Callable<Map.Entry<Integer, BigInteger>> {
	    private final int number;

	    // Some of your code goes here
	    public FactorialTask(Integer n) {
	        this.number = n;
	    }

	    @Override
	    public Map.Entry<Integer, BigInteger> call() throws Exception {
	        // Your code goes here.
	        BigInteger factorial = BigInteger.ONE;
	        for (int i=2; i<=number; i++) {
	            factorial = factorial.multiply(BigInteger.valueOf(i));
	        }
	        
	        return new AbstractMap.SimpleEntry<>(number, factorial);
	    }
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> numbers = Arrays.asList(5, 10, 15, 20, 25, 30);
		Map<Integer, BigInteger> result = Answer.findAnswer(numbers);
		System.out.println(result);
	}

}
