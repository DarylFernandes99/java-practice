package main.java;

import java.lang.reflect.Method;
import java.util.Arrays;

public class AnnotationsReflection {

	public static void addHeader(String str) {
		System.out.println("-".repeat(10) + " " + str + " " + "-".repeat(10));
	}
	public static void addSubHeader(String str) {
		System.out.println("-".repeat(3) + " " + str + " " + "-".repeat(3));
	}
	
	// Custom annotation
	@CustomAnnotation(priority = 2, tags = {"important", "feature"})
	public class Info {
		@CustomAnnotation(tags = {"details"})
		public void getDetailedInfo() {
			System.out.println("Giving important details");
		}
	}
	
	public static void reflections() {
		// Get the info class object
		Class<Info> classData = Info.class;
		
		// Check if the class has the custom annotation
		if (classData.isAnnotationPresent(CustomAnnotation.class)) {
			CustomAnnotation annotation = classData.getAnnotation(CustomAnnotation.class);
			System.out.println("Priority: " + annotation.priority());
			System.out.println("Tags: " + Arrays.toString(annotation.tags()));
		}
		
		// Iterate over the methods in Info
		for (Method method: classData.getDeclaredMethods()) {
			// Check if the method has our custom annotation
			if (method.isAnnotationPresent(CustomAnnotation.class)) {
				CustomAnnotation annotation = classData.getAnnotation(CustomAnnotation.class);
				System.out.println("Method: " + method.getName());
				System.out.println("Priority: " + annotation.priority());
				System.out.println("Tags: " + Arrays.toString(annotation.tags()));
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		addHeader("Custom annotations");
		reflections();
	}

}
