package errorHandling;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class ErrorHandlingGraceful {

	public static void main(String[] args) {
		int exceptionType;
		
		Scanner reader = new Scanner(System.in);
		
		System.out.println("Select one of the options below to test different exceptions:");
		System.out.println("1 – Arithmetic exception");
		System.out.println("2 – Array out of bound");
		System.out.println("3 – Input mismatch");
		System.out.println("4 – SQL Exception");
		System.out.println("\nType your option (1-4):");

		exceptionType = reader.nextInt();
		
		switch (exceptionType)
		{
			case 1:
			{
				try {
					int a=10, b= 0;
					System.out.println(a/b);
				}
				catch (Exception exception){
					printFriendlyMessage(exception);
					break;
				}
			}
			case 2:
			{
				try {
					int[] testArray = {23,56,78};
					System.out.println(testArray[3]);
				}
				catch (Exception exception){
					printFriendlyMessage(exception);
					break;
				}			
			}
			case 3:
			{
				try {
					System.out.println("What's your name?");
					System.out.println(reader.nextInt());
				}
				catch (Exception exception){
					printFriendlyMessage(exception);
					break;
				}				
			}
			case 4:
			{
				// In this case we MUST have the try/catch block because DriverManager.getConnection() explicitly thorws an exception
				try{
					Connection someDb = DriverManager.getConnection("jdbc:mysql://localhost:3306/someDb", "root", "");
				}
				catch (SQLException exception)
				{
					printFriendlyMessage(exception);
					break;
				}
			}
			default:
			{
				System.out.println("Invalid option. Try again!");
			}
		}
		
		reader.close();
	}
	
	private static void printFriendlyMessage (Exception exc)
	{
		System.out.println("We got the following exception in the program:");
		System.out.println(exc);
		System.out.println("\nAs you see, we are not allowing this program to crash.");
		System.out.println("And ... Don't worry, we will fix this issue!");
	}
}
