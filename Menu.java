package test_assignement;

/*
 * This class contains the main menu of the program
 * This also contains the beginning and quitHandler method including the open and save method so
 * the users can load the data file when the application is opened and 
 * users can save the data file when the application is closed
 */
//import relevant library
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Menu {
	// create objects from the Companies class
	static Companies companies = new Companies();
	// declare boolean and integer to be used in the while loop
	static boolean endOfProgram = false;
	static int selection;
	// create a CatchException object
	public static CatchException input = new CatchException();

	// main method
	public static void main(String args[]) {
		// show the real time and date of opening the application
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		System.out.println("Application opened at: " + dateFormat.format(date) + "\n");
		// while loop to keep the users in the same menu
		while (!endOfProgram) {
			// This is how the main menu looks like
			for (int row = 1; row <= 1; row++) {
				for (int column = 0; column <= 90; column++) {
					System.out.print("_");
				}
				System.out.println();
			}
			// Ask the users select different method
			selection = CatchException.catchException(
					"\t\t***Foreign Company registration menu - [Number of registration: " + Companies.getSize()
							+ "] *** \n\nPress a number to select:\n" + " \n\n1: Register a new foreign company "
							+ "\t\t2: Edit the existing registration \n3: Inquiry\t\t\t\t\t4: Save \n5: Load\t\t\t\t\t\t6: Quit\n");
			// switch case for user to select different method
			switch (selection) {
			// options for different method
			case 1:
				// method to register a new company
				registrationHandler();
				break;
			case 2:
				// method to edit the registration
				modifyRegistrationHandler();
				break;
			case 3:
				// method to show items
				inquiryHandler();
				break;
			case 4:
				// method to save data
				Companies.save();
				break;
			case 5:
				// method to load data
				Companies.open();
				break;
			case 6:
				// method to quit the program
				quitHandler();
				break;
			default:
				System.out.println("\nIncorrect option, please try again\n");

			}

		}
	}

	/*
	 * This sub menu contains two method which are show the item in the default
	 * constructor and also allows users to input the new item to the arrayList
	 */
	public static void registrationHandler() {
		// while loop keeps the users in the same menu
		boolean endOfSubMenu = false;
		while (!endOfSubMenu) {
			// this is how the menu looks like
			for (int row = 1; row <= 1; row++) {
				for (int column = 0; column <= 80; column++) {
					System.out.print("_");
				}
				System.out.println();
			}
			// input from the users and show the indicator of the size of
			// arrayList
			selection = CatchException.catchException("\t\t***Registration Menu - " + "[Number of registration: "
					+ Companies.getSize() + "] *** \n\nPress a number to select:\n"
					+ "\n1: New foreign company registration\t\t\t\t2: New listed foreign company registration"
					+ "\n3: Back to Main Menu");
			// switch case for user to select different method
			switch (selection) {
			// options for different method
			case 1:
				// method to register a regular company
				Companies.regularRegistration();
				break;
			case 2:
				// method to register a listed company
				Companies.listedRegistration();
				break;
			case 3:
				// quit the sub menu
				endOfSubMenu = true;
				break;
			default:
				System.out.println("\nIncorrect option, please try again\n");
			}
		}
	}

	/*
	 * This sub menu contains two method which allows the users to edit the
	 * existing the properties of items and allows the users to delete items
	 */
	public static void modifyRegistrationHandler() {
		// to check if the size of arrayList is bigger than zero
		if (Companies.getSize() > 0) {
			// while loop keeps the users in the same menu
			boolean endOfSubMenu = false;
			while (!endOfSubMenu) {
				// this is how the menu looks like
				for (int row = 1; row <= 1; row++) {
					for (int column = 0; column <= 80; column++) {
						System.out.print("_");
					}
					System.out.println();
				}
				// input from the users
				selection = CatchException.catchException("\t\t***Registration Editing Menu - [Number of registration: "
						+ Companies.getSize() + "] ***\n\nPress a number to select:\n"
						+ "\n1: Edit detail of a registration\t\t2: Removal of registrations \n3: Back to Main Menu");
				// switch case for user to select different method
				switch (selection) {
				// options for different method
				case 1:
					// method to edit the properties of the item
					Companies.editDeatil();
					break;
				case 2:
					// method to remove an item
					Companies.remove();
					break;
				case 3:
					// quit the sub menu
					endOfSubMenu = true;
					break;
				default:
					System.out.println("\nIncorrect option, please try again\n");
				}
			}
		} else {// the method will terminate if the size of arrayList is zero
			System.out.println("\nNo registration in the system\n");
		}

	}

	/*
	 * this sub menu contains three methods: 1.sort all the items by one of
	 * their properties and print them in the console 2.search a specified item
	 * by using its reference number 3.show the numbers of the items in the
	 * arrayList
	 */
	public static void inquiryHandler() {

		if (Companies.getSize() > 0) {
			// while loop keeps the users in the same menu
			boolean endOfSubMenu = false;
			while (!endOfSubMenu) {
				// this is how the menu looks like
				for (int row = 1; row <= 1; row++) {
					for (int column = 0; column <= 80; column++) {
						System.out.print("_");
					}
					System.out.println();
				} // input from the users
				selection = CatchException
						.catchException("\t\t***Inquiry Menu - [Number of registration: " + Companies.getSize() + "]"
								+ " ***\n\nPress a number to select:\n" + "\n1: Print the registrations in the system "
								+ "\t2: Search a registration " + "\n3: Back to main menu");

				// switch case for user to select different method
				switch (selection) {
				// options for different method
				case 1:
					// method to show and sort all the items
					Companies.sort();
					break;
				case 2:
					// method to search an item by using its reference number
					Companies.findCompany();
					break;
				case 3:
					// quit the sub menu
					endOfSubMenu = true;
					break;
				default:
					System.out.println("\nIncorrect option, please try again\n");
				}
			}
		} else {
			System.out.println("\nNo registration in the system\n");
		}
	}

	// method to terminate the while loop
	public static void quitHandler() {
		{ // boolean value to terminate the while loop
			endOfProgram = true;
			// show the real time and date
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date();
			System.out.println("Application closed at: " + dateFormat.format(date));
		}

	}

}
