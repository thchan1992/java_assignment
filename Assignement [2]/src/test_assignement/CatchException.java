package test_assignement;
/*
 * The class for catching the exception in which the user put string instead of integer
 */
//import a scanner class
import java.util.Scanner;

public class CatchException {
	//create a scanner object
	private static Scanner a = new Scanner(System.in);
	//method to catch the exception
	public static int catchException (String message){
		
		boolean endOfWhile = false;
		int number = 0;
	
		while(endOfWhile != true){
			try{
				//show the message in the console
				System.out.println(message);
				//String input from the user
				String input = a.nextLine();
				//try to convert the input from users into an integer
				number = Integer.parseInt(input);
				endOfWhile = true;	
		 	}
			//if the user's input cannot be converted into an integer, the system catch the exception
			catch(NumberFormatException ex) {
				System.out.print("\n***Please enter an integer only***\n");
			}
		}//otherwise, return that integer
		return number;
	}
}
