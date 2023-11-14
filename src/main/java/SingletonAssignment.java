package main.java;

public class SingletonAssignment {
	
	final static class DatabaseConnection {
	    private String databaseURL;
	    private static volatile DatabaseConnection instance;

	    private DatabaseConnection(String databaseURL) {
	        if (instance == null) {
	            throw new IllegalStateException("Instance is already created!");
	        }
	        this.databaseURL = databaseURL;
	    }

	    public static DatabaseConnection getInstance() {
	        if (instance == null) {
	            synchronized (DatabaseConnection.class) {
	                if (instance == null) {
	                    instance = new DatabaseConnection("jdbc:mysql://localhost:3306/mydatabase");
	                }
	            }
	        }
	        return instance;
	    }

	    // dummy implementation of executing a query
	    public void executeQuery(String query) {
	        System.out.println("Executing query on " + databaseURL + ": " + query);
	    }

	    // dummy implementation of closing the connection
	    public void close() {
	        System.out.println("Closing connection with: " + databaseURL);
	    }
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DatabaseConnection databaseConnection = DatabaseConnection.getInstance();
	}

}
