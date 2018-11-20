package errorHandling;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class ErrorHandling {

	public static void main(String[] args) {
		int exceptionType;
		
		Scanner reader = new Scanner(System.in);
		
		System.out.println("Select one of the options below to test different exceptions:");
		System.out.println("1 – Arithmetic exception");
		System.out.println("2 – Index out of bounds");
		System.out.println("3 – Input mismatch");
		System.out.println("4 – SQL Exception");
		System.out.println("\nType your option (1-4):");

		exceptionType = reader.nextInt();
		
		switch (exceptionType)
		{
			case 1:
			{
				int a=10, b= 0;
				System.out.println(a/b);
			}
			case 2:
			{
				int[] testArray = {23,56,78};
				System.out.println(testArray[3]);
			}
			case 3:
			{
				System.out.println("What's your name?");
				System.out.println(reader.nextInt());
			}
			case 4:
			{
				// In this case we MUST have the try/catch block because DriverManager.getConnection() explicitly throws an exception
				try{
					Connection someDb = DriverManager.getConnection("jdbc:mysql://localhost:3306/someDb", "root", "");
				}
				catch (SQLException exception)
				{
					System.out.println("Oops! We are catching a SQLException!");
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
}
