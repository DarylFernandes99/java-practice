package main.java;

import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ConcurrencyMultithreading {

	public static void addHeader(String str) {
		System.out.println("-".repeat(10) + " " + str + " " + "-".repeat(10));
	}
	public static void addSubHeader(String str) {
		System.out.println("-".repeat(3) + " " + str + " " + "-".repeat(3));
	}
	
	// Multi-threading 
	public static class MyRunnable implements Runnable {
		public void run() {
			System.out.println("Heloo multithreading #" + Thread.currentThread().getId());
		}
	}
	
	public static class MyThread extends Thread {
		public void run() {
			System.out.println("Hello from thread #" + Thread.currentThread().getId());
		}
	}
	
	public static void basicMultithreading() {
		System.out.println("This is thread #" + Thread.currentThread().getId());
		MyRunnable myRunnable = new MyRunnable();
		Thread thread = new Thread(myRunnable);
		Thread thread1 = new Thread(myRunnable);
		thread.start();
		thread1.start();
		
		MyThread t1 = new MyThread();
		MyThread t2 = new MyThread();
		t1.start();
		t2.start();
	}
	
	// Synchronized
	public static class SynchronizedExample {
		private int counter = 0;
		
		// synchronized - when multiple threads call this method only one can be accessed at a time, rest are added to queue
		public synchronized void increment() {
			counter++;
		}
	}
	
	// Simplifies the creation and management of threads pool
	// Executors are used to create thread pools that can manage the execution of multiple tasks concurrently while reusing the threads in the pool
	public static void basicExecutors() {
		ExecutorService executor = Executors.newFixedThreadPool(5);
		Runnable task = () -> System.out.println("Hello from Executor on Thread #" + Thread.currentThread().getId());
		for (int i=0; i<10; i++) {
			executor.execute(task);
		}
		executor.shutdown();
	}
	
	// Concurrent hash map
	// This is similar to Hash map but now the data can be accessed by multiple threads
	public static void concurrentHashMap() {
		ConcurrentHashMap<String, Integer> concurrentMap = new ConcurrentHashMap<>();
		concurrentMap.put("One", 1);
		concurrentMap.put("Two", 2);
		
		concurrentMap.forEach((key, value) -> System.out.println(key + ": " + value));
	}
	
	// Callable (similar to runnable but returns value) and future(represents pending computation result)
	public static class FutureCallableExample {
		
	}
	public static void futureCallable() {
		ExecutorService executor = Executors.newFixedThreadPool(2);
		Callable<Integer> task = () -> {
			Thread.sleep(1000);
			return 42;
		};
		
		Future<Integer> future = executor.submit(task);
		
		try {
//			Integer result = future.get();
			Integer result = future.get(100, TimeUnit.MILLISECONDS);
			System.out.println("Result: " + result);
		} catch (InterruptedException | ExecutionException | TimeoutException e) {
			e.printStackTrace();
		} finally {
			executor.shutdown();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		addHeader("Multi-Threading");
		basicMultithreading();
		
		addHeader("Executors");
		basicExecutors();
		
		addHeader("Concurrent Hash Map");
		concurrentHashMap();
		
		addHeader("Future and Callable");
		futureCallable();
	}

}
