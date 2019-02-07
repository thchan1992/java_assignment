package test_assignement;

/*
 * Construct ArrayList to store collection of objects from company class
 * this class also contains all the methods we will use in the program
 */
//import library 
import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;
//collection library
import java.util.Collections;
import java.util.Comparator;

public class Companies {
	// create arrayList to store company from company class.
	static ArrayList<Company> companies;

	// arrayList constructor
	public Companies() {
		// new container to hold objects from company class
		companies = new ArrayList<Company>();
	}

	// method to get the length of object
	public static int getSize() {
		return companies.size();
	}

	/*
	 * method to show default constructor and register a regular company
	 */
	public static void regularRegistration() {
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
			int selection = CatchException
					.catchException("\n Foreign Company Registration: \n\n1: Registration Example "
							+ "\n2: Registration \n3: Back to the previous menu");
			// switch case for user to select different method
			switch (selection) {
			// options for different method
			case 1:
				// method to show the default constructor
				exampleHandler();
				break;
			case 2:
				// method to take the input to construct a new company item
				detailHandler();
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

	// method to show the default constructor to the users
	public static void exampleHandler() {
		// create an empty container
		Company company = new Company();
		System.out.println("\nThis is a company registration example: ");
		/*
		 * show the object without putting any value to the properties to show
		 * the default value
		 */
		company.print();
	}

	// method to allow users put detail for the new registration of company
	public static void detailHandler() {
		// create a container to store the new object
		Company company = new Company();
		int refNo = CatchException.catchException("\nPlease follow the instruction to register a company\n\n"
				+ "[Please enter an integer only] Enter Reference number: ");
		boolean flag = true;
		/*
		 * for loop to check if the reference in the every single instance in
		 * the arrayList match the new reference inputed by the users if this is
		 * the case, the whole method will terminate(flag = false) if this is
		 * not the case, it starts the ask method to take all the value for the
		 * new instance
		 */
		for (int i = 0; i < companies.size(); i++) {
			/*
			 * use contains to check if the same value of refNo exists in the
			 * arrayList valueOf is to convert from integer to String. due to
			 * the toString method, all instances are stored as string in the
			 * arrayList to check the value of refNo, we have to convert the
			 * reference number to the integer to compare a string
			 */
			if (String.valueOf(companies.get(i).refNo).contains(String.valueOf(refNo))) {
				System.out.println("Reference already exists, please start again with a different reference number.\n");
				flag = false;
			}
		}
		if (flag == true) {
			// ask method to set all input to the new object
			company.askRefNo(refNo);
			company.ask();
			// add method to add the new object to the arrayList
			companies.add(company);
			// show the users' input
			company.print("The new registration detail: ");
		}

	}

	/*
	 * method to show default constructor and register a listed company
	 */
	public static void listedRegistration() {

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
			int selection = CatchException.catchException("\n Foreign Listed Company Registration: "
					+ "\n\n1: Registration Example " + "\n2: Registration \n3: Back to the previous menu");
			// switch case for user to select different method
			switch (selection) {
			// options for different method
			case 1:
				// method to show the default constructor
				listedExampleHandler();
				break;
			case 2:
				// method to take the input to construct a new listed company
				// item
				listedDetailHandler();
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

	// method to allow users put detail for the new registration of company
	public static void listedExampleHandler() {
		// create an empty container
		ListedCompany listedCompany = new ListedCompany();
		System.out.println("\nThis is a listed company registration example: ");
		/*
		 * show the object without putting any value to the properties to show
		 * the default value
		 */
		listedCompany.printListedCompany();
	}

	/*
	 * method to allow users put detail for the new registration of listed
	 * company
	 */
	public static void listedDetailHandler() {
		// create a container to store the new object
		ListedCompany listedCompany = new ListedCompany();
		int refNo = CatchException.catchException("\nPlease follow the instruction to register a company\n\n"
				+ "[Please enter an integer only] Enter Reference number: ");
		boolean flag = true;
		/*
		 * for loop to check if the reference in the every single instance in
		 * the arrayList match the new reference inputed by the users if this is
		 * the case, the whole method will terminate(flag = false) if this is
		 * not the case, it starts the ask method to take all the value for the
		 * new instance
		 */
		for (int i = 0; i < companies.size(); i++) {
			/*
			 * use contains to check if the same value of refNo exists in the
			 * arrayList valueOf is to convert from string to integer. due to
			 * the toString method, all instances are stored as string in the
			 * arrayList to check the value of refNo, we have to convert the
			 * reference number back to the integer
			 */
			if (String.valueOf(companies.get(i).refNo).contains(String.valueOf(refNo))) {
				System.out.println("Reference already exists, please start again with a different reference number.\n");
				flag = false;
			}
		}
		if (flag == true) {

			// ask method to set all input to the new object
			listedCompany.askListed(refNo);
			// add method to add the new object to the arrayList
			companies.add(listedCompany);
			// show the users' input
			System.out.println("The new listed registration detail:\n");
			listedCompany.printListedCompany();
		}
	}

	/*
	 * This method contains a sub menu for the users to chose which field they
	 * want to edit
	 */
	public static void editDeatil() {
		/*
		 * show all the items in the arrayList and assign a number next to each
		 * item
		 */
		System.out.println("Registration List:");
		for (int i = 0; i < companies.size(); i++) {
			System.out.print("Press [" + (i + 1) + "] " + companies.get(i));
		}

		/*
		 * users selects an object to edit according to the registration list
		 * above
		 */
		int edit = CatchException.catchException("Press a number to select the object to edit");
		/*
		 * if condition to see if edit is within the range of arrayList by
		 * checking the arrayList size if users' input is out of the range, the
		 * system would ask the users to chose the item again
		 */
		if (companies.size() >= edit && edit > 0) {
			/*
			 * while loop keeps the users staying in the same menu so users can
			 * keep amending the same item without going back to the main menu
			 */
			boolean endOfSubMenu = false;
			while (!endOfSubMenu) {

				// show the sub menu in the console
				int selection = CatchException
						.catchException("\nSelect the detail you want to edit \n1: Company Name \n2: Company country"
								+ "\n3: Director's name \n4: Shareholder's name \n5: Back to the previous menu");
				// switch case for users to select method
				switch (selection) {
				case 1:
					/*
					 * method to edit company name and pass the parameter from
					 * the user to find the sequence of the specified property,
					 * we need to minus one from the choice of the users to
					 * chose the property because of the fact that the sequence
					 * of the property start from zero
					 *
					 */
					editCompanyNameHandler((edit - 1));
					break;
				case 2:
					// method to edit country
					editCountryHandler((edit - 1));
					break;
				case 3:
					// method to edit director name
					editDirectorNameHandler((edit - 1));
					break;
				case 4:
					// method to edit shareholder name
					editShareholderNameHandler((edit - 1));
					break;
				case 5:
					// quit the sub menu
					endOfSubMenu = true;
					break;
				default:
					System.out.println("\nIncorrect option, please try again\n");
				}
			}
		} else {
			/*
			 * it happens if users' company choice for editing is out of range
			 * of the company
			 */
			System.out.println("\n*Please select one of the company above to edit\n");
		}

	}

	// edit company name method
	public static void editCompanyNameHandler(int index) {

		@SuppressWarnings("resource")
		// take input from users
		Scanner input = new Scanner(System.in);
		System.out.println("\nEnter the new name for the company: \n");
		String newCompanyName = input.nextLine();
		/*
		 * use the parameter from above to get the object the user need to edit
		 * then use the setter from the Company class to set a new value for the
		 * field and then show the object with new value
		 */
		companies.get(index).setCompanyName(newCompanyName);
		System.out.println(companies.get(index));
	}

	// edit Country origin method
	public static void editCountryHandler(int index) {
		@SuppressWarnings("resource")
		// take input from users
		Scanner input = new Scanner(System.in);
		System.out.println("\nEnter the new country for the company: \n");
		String newcountry = input.nextLine();
		/*
		 * use the parameter from above to get the object the user need to edit
		 * then use the setter from the Company class to set a new value for the
		 * field and then show the object with new value
		 */
		companies.get(index).setCountry(newcountry);
		System.out.println(companies.get(index));
	}

	// edit director name method
	public static void editDirectorNameHandler(int index) {
		@SuppressWarnings("resource")
		// take input from users
		Scanner input = new Scanner(System.in);
		System.out.println("\nEnter the new director name for the company: \n");
		String newDirectorName = input.nextLine();
		/*
		 * use the parameter from above to get the object the user need to edit
		 * then use the setter from the Company class to set a new value for the
		 * field and then show the object with new value
		 */
		companies.get(index).setDirectorName((newDirectorName));
		System.out.println(companies.get(index));
	}

	// edit shareholder name method
	public static void editShareholderNameHandler(int index) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		// take input from users
		System.out.println("\nEnter the name of the new shareholder for the company: \n");
		String newShareholderName = input.nextLine();
		/*
		 * use the parameter from above to get the object the user need to edit
		 * then use the setter from the Company class to set a new value for the
		 * field and then show the object with new value
		 */
		companies.get(index).setShareholderName(newShareholderName);
		System.out.println(companies.get(index));
	}

	/*
	 * sub menu to contain two methods for users to select: 1. users select one
	 * Item to delete 2. users delete everything in the arrayList
	 */
	public static void remove() {
		boolean flag = false;
		// switch case for users to select method
		while (!flag) {
			int selection = CatchException.catchException("\n1: Select a registration to remove"
					+ "\n2: Remove all registration \n3: Back to the previous menu\n");
			switch (selection) {
			case 1:
				// Method to remove one company
				removeCompanyHandler();
				break;
			case 2:
				// Method to remove all company
				removeAllHandler();
				flag = true;
				break;
			case 3:
				// go back to the main menu
				flag = true;
				break;
			default:
				System.out.println("\nIncorrect option, please try again\n");
			}
		}
	}

	// Method to remove one company
	public static void removeCompanyHandler() {
		// show all the Item in the arrayList and assign each item a number
		for (int i = 0; i < companies.size(); i++) {
			System.out.print(" [" + (i + 1) + "] " + companies.get(i));
		}
		// get the input by using CatchException class
		int delete = CatchException.catchException("\nDelete company: ");
		// try catch to prevent from user putting incorrect company number
		try {
			/*
			 * we minus one from delete to chose the item. because of the
			 * sequence of the item start from zero
			 */
			companies.remove((delete - 1));
			System.out.println("\nDeletion Finished\n");
		} // catch the Exception
		catch (IndexOutOfBoundsException ex) {
			System.out.println("\ncompany not found\n");
		}
	}

	// method to clear everything in the arrayList
	public static void removeAllHandler() {
		// clear all the objects in the arrayList
		companies.clear();
		System.out.println("\nAll registration have been removed\n");
	}

	/*
	 * sort method contains a sub menu which allows the users to chose one
	 * particular field to sort then shows it in the console
	 */
	public static void sort() {
		// user chose methods to implement
		int choice = CatchException
				.catchException("\nSelect the field to sort al the registration" + "\n1: Reference number"
						+ "\n2: Company Name" + "\n3: Country" + "\n4: Director's name" + "\n5: Shareholder's name");
		switch (choice) {
		case 1:
			// sort reference number method
			sortRefNoHandler();
			break;
		case 2:
			// sort company name method
			sortCompanyNameHandler();
			break;
		case 3:
			// sort country method
			sortCountryHandler();
			break;
		case 4:
			// sort director name method
			sortDirectorNameHandler();
			break;
		case 5:
			// sort shareholder name method
			sortShareholderNameHandler();
			break;
		default:
			System.out.print("\nIncorrect option, please try again\n");
		}
	}

	/*
	 * sort reference number method contains two comparator so we can compare
	 * integers the first comparator is for sorting items in an ascending order
	 * the second comparator is for sorting items in a descending order
	 */
	public static void sortRefNoHandler() {
		// users select sorting in either an ascending order or descending order
		int choice = CatchException.catchException("\n1: Ascending order \n2: Descending Order");
		switch (choice) {
		case 1:
			/*
			 * this is the method to sort items in an ascending order
			 */
			// create a new comparator
			Comparator<Company> asRefNoList = new Comparator<Company>() {
				// method to compare objects
				public int compare(Company a, Company b) {
					// if object a is bigger than the other, return 1 to
					// comparator
					if (a.getRefNo() > b.getRefNo()) {
						return 1;
					}
					// if object a is smaller than the other, return -1 to
					// comparator
					if (a.getRefNo() < b.getRefNo()) {
						return -1;
					}
					//any other situation i.e a == b, return 0
					return 0;
				}
			};// collections method to sort the comparator according to the
				// the comparator above
			Collections.sort(Companies.companies, asRefNoList);
			// display all the item in arrayList after sorting
			System.out.println("\ncompany order are now:");
			for (int count = 0; count < companies.size(); count++) {
				System.out.print(companies.get(count) + "\n");
			}
			break;
		case 2:
			/*
			 * this is the method to sort items in a descending order
			 */
			// create a new comparator
			Comparator<Company> deRefNoList = new Comparator<Company>() {
				// method to compare objects
				public int compare(Company a, Company b) {
					// if integer b is bigger than the other, return 1 to
					// comparator

					if (b.getRefNo() > a.getRefNo()) {
						return 1;
					}
					// if integer b is smaller than the other, return -1 to
					// comparator

					if (b.getRefNo() < a.getRefNo()) {
						return -1;
					}
					//any other situation i.e a == b, return 0
					return 0;
				}
			};// collections method to sort the comparator according to the
				// comparator above
			Collections.sort(Companies.companies, deRefNoList);
			// display all the item in arrayList after sorting
			System.out.println("\ncompany order are now:");
			for (int count = 0; count < companies.size(); count++) {
				System.out.print(companies.get(count) + "\n");
			}
			break;
		default:
			System.out.println("\nIncorrect option, please try again\n");
		}
	}

	/*
	 * sort company name method contains two comparator so we can compare
	 * integers the first comparator is for sorting items in an ascending order
	 * the second comparator is for sorting items in a descending order
	 */
	public static void sortCompanyNameHandler() {
		// users select sorting in either an ascending order or descending order
		int choice = CatchException.catchException("1: Ascending order \n2: Descending Order");
		switch (choice) {
		case 1:
			/*
			 * this is the method to sort items in an ascending order
			 */
			// create a new comparator
			Comparator<Company> asCompanyNameList = new Comparator<Company>() {
				public int compare(Company a, Company b) {
					//compareTo method to compare two strings, the result is
					// positive if the first string is lexicographically greater
					return a.getCompanyName().compareTo(b.getCompanyName());
				}
			};
			/*
			 * collections method to sort the comparator according to the comparator above
			 */
			Collections.sort(Companies.companies, asCompanyNameList);
			// display all the items in the arrayList after sorting
			System.out.println("\ncompany order are now:");
			for (int count = 0; count < companies.size(); count++) {
				System.out.print(companies.get(count) + "\n");
			}
			break;
		case 2:
			/*
			 * this is the method to sort items in a descending order
			 */
			// create a new comparator
			Comparator<Company> deCompanyNameList = new Comparator<Company>() {
				public int compare(Company a, Company b) {
					/*
					 * compareTo method to compare two strings, the result is
					 * positive if the first string is lexicographically smaller
					 */
					return b.getCompanyName().compareTo(a.getCompanyName());
				}
			};
			// collections method to sort the comparator according to the comparator above
			Collections.sort(Companies.companies, deCompanyNameList);
			// display all the items in the arrayList after sorting
			System.out.println("\ncompany order are now:");
			for (int count = 0; count < companies.size(); count++) {
				System.out.print(companies.get(count) + "\n");
			}
			break;
		default:
			System.out.println("\nIncorrect option, please try again\n");
			break;

		}
	}

	/*
	 * method to sort country of the company contains two comparator so we can
	 * compare integers the first comparator is for sorting items in an
	 * ascending order the second comparator is for sorting items in a
	 * descending order
	 */
	public static void sortCountryHandler() {
		// users select sorting in either an ascending order or descending order
		int choice = CatchException.catchException("1: Ascending order \n2: Descending Order");
		switch (choice) {
		case 1:
			/*
			 * this is the method to sort items in an ascending order
			 */
			// create a new comparator
			Comparator<Company> ascountryList = new Comparator<Company>() {

				public int compare(Company a, Company b) {
					/*
					 * compareTo method to compare two strings, the result is
					 * positive if the first string is lexicographically bigger
					 */
					return a.getCountry().compareTo(b.getCountry());
				}
			};
			// collections method to sort the comparator according to the comparator above
			Collections.sort(Companies.companies, ascountryList);
			// display all the items in the arrayList after sorting
			System.out.println("\ncompany order are now:");
			for (int count = 0; count < companies.size(); count++) {
				System.out.print(companies.get(count) + "\n");

			}

			break;
		case 2:
			/*
			 * this is the method to sort items in a descending order
			 */
			// create a new comparator
			Comparator<Company> decountryList = new Comparator<Company>() {

				public int compare(Company a, Company b) {
					/*
					 * compareTo method to compare two strings, the result is
					 * positive if the first string is lexicographically smaller
					 */
					return b.getCountry().compareTo(a.getCountry());
				}
			};
			// collections method to sort the comparator according to the comparator above
			Collections.sort(Companies.companies, decountryList);
			// display all the items in the arrayList after sorting
			System.out.println("\ncompany order are now:");
			for (int count = 0; count < companies.size(); count++) {
				System.out.print(companies.get(count) + "\n");

			}
			break;
		default:
			System.out.println("\nIncorrect option, please try again\n");
			break;
		}
	}

	/*
	 * method to sort the director name contains two comparator so we can
	 * compare integers the first comparator is for sorting items in an
	 * ascending order the second comparator is for sorting items in a
	 * descending order
	 */
	public static void sortDirectorNameHandler() {
		// users select sorting in either an ascending order or descending order
		int choice = CatchException.catchException("1: Ascending order \n2: Descending Order");
		switch (choice) {
		case 1:
			/*
			 * this is the method to sort items in an ascending order
			 */
			// create a new comparator
			Comparator<Company> asDirectorNameList = new Comparator<Company>() {
				/*
				 * compareTo method to compare two strings, the result is
				 * positive if the first string is lexicographically bigger
				 */
				public int compare(Company a, Company b) {
					return a.getDirectorName().compareTo(b.getDirectorName());
				}
			};
			// collections method to sort the comparator according to the comparator above
			Collections.sort(Companies.companies, asDirectorNameList);
			// display all the items in the arrayList after sorting
			System.out.println("\ncompany order are now:");
			for (int count = 0; count < companies.size(); count++) {
				System.out.print(companies.get(count) + "\n");
			}
			break;
		case 2:
			/*
			 * this is the method to sort items in a descending order
			 */
			// create a new comparator
			Comparator<Company> deDirectorNameList = new Comparator<Company>() {
				/*
				 * compareTo method to compare two strings, the result is
				 * positive if the first string is lexicographically smaller
				 */
				public int compare(Company a, Company b) {
					return b.getDirectorName().compareTo(a.getDirectorName());
				}
			};
			// collections method to sort the comparator according to the comparator above
			Collections.sort(Companies.companies, deDirectorNameList);
			// display all the items in the arrayList after sorting
			System.out.println("\ncompany order are now:");
			for (int count = 0; count < companies.size(); count++) {
				System.out.print(companies.get(count) + "\n");
			}
			break;
		default:
			System.out.println("\nIncorrect option, please try again\n");

		}
	}

	/*
	 * method to sort the shareholder name contains two comparator so we can
	 * compare integers the first comparator is for sorting items in an
	 * ascending order the second comparator is for sorting items in a
	 * descending order
	 */
	public static void sortShareholderNameHandler() {
		// users select sorting in either an ascending order or descending order
		int choice = CatchException.catchException("1: Ascending order \n2: Descending Order");
		switch (choice) {
		case 1:
			/*
			 * this is the method to sort items in an ascending order
			 */
			// create a new comparator
			Comparator<Company> asShareholderNameList = new Comparator<Company>() {
				/*
				 * compareTo method to compare two strings, the result is
				 * positive if the first string is lexicographically bigger
				 */
				public int compare(Company a, Company b) {
					return a.getShareholderName().compareTo(b.getShareholderName());
				}
			};
			// collections method to sort the comparator according to the comparator above
			Collections.sort(Companies.companies, asShareholderNameList);
			// display all the items in the arrayList after sorting
			System.out.println("\ncompany order are now:");
			for (int count = 0; count < companies.size(); count++) {
				System.out.print(companies.get(count) + "\n");
			}
			break;
		case 2:
			/*
			 * this is the method to sort items in an descending order
			 */
			// create a new comparator
			Comparator<Company> deShareholderNameList = new Comparator<Company>() {
				/*
				 * compareTo method to compare two strings, the result is
				 * positive if the first string is lexicographically smaller
				 */
				public int compare(Company a, Company b) {
					return b.getShareholderName().compareTo(a.getShareholderName());
				}
			};
			// collections method to sort the comparator according to the comparator above
			Collections.sort(Companies.companies, deShareholderNameList);
			// display all the items in the arrayList after sorting
			System.out.println("\ncompany order are now:");
			for (int count = 0; count < companies.size(); count++) {
				System.out.print(companies.get(count) + "\n");
			}
			break;
		default:
			System.out.println("\nIncorrect option, please try again\n");
			break;
		}
	}

	/*
	 * method to find a item by creating another arrayList where we put only a
	 * integer "reference number" into then, we take the users' input, next, we
	 * check each integer in the arrayList to see if it matches the input from
	 * users
	 */
	public static void findCompany() {
		int RefNo = CatchException.catchException("\nEnter reference number you like to search: ");
		// show the result from findCompany method
		// declare a string
		String result = "\nReference number not found\n";
		// create a new arrayList
		ArrayList<Integer> search = new ArrayList<>();
		// copy a refNo from companies arrayList to the new arrayList
		for (int i = 0; i < Companies.companies.size(); i++) {
			search.add(Companies.companies.get(i).getRefNo());
		}
		// the system goes through to check which refNo matches the input in the
		// integer in the new arrayList
		for (int i = 0; i < search.size(); i++) {
			// check if the refNo matches the input from the users
			if (search.get(i) == RefNo) {
				System.out.println("\nSearch Result: \n");
				// return the targeted refNo with the whole string
				result = Companies.companies.get(i).toString();
				// remove the new arrayList
				search.clear();
				break;
			}
		}
		// System shows the unchanged result
		System.out.println(result);
		// remove the new arrayList
		search.clear();

	}
	
	//Save method
	public static void save() {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		String fileName = "Companies";
		String fileType = "dat";
		FileOutputStream outFile;
		ObjectOutputStream dataFile;
		boolean endOfSubMenu = false;

		if (companies.size() <= 0) {
			System.out.println(
					"\nWarning: There is no registration in the system. You are creating an empty data file.\n");
		}

		while (!endOfSubMenu) {
			int selection = CatchException
					.catchException("\nDo you want to name your data file and choose a data type? "
							+ "Otherwise, the default data file name and type is Companies.dat "
							+ "\n\n1: Input a new name with other data type "
							+ "\n2: Companies.dat is fine");

			switch (selection) {
			case 1:
				System.out.println("\nInput a file name \n");
				fileName = input.nextLine();
				System.out.println("\nInput a data type \nExample: dat ser\n\n");
				fileType = input.nextLine();
				System.out.println(fileName + "." + fileType + " has been created\n");
				endOfSubMenu = true;
				break;
			case 2:
				System.out.println("\nThe name of data file will be " + fileName + "." + fileType + "\n");
				endOfSubMenu = true;
				break;
			default:
				System.out.println("\nIncorrect option, please try again\n");
			}
		}

		System.out.println("Now choose a location to store " + fileName + "." + fileType
				+ "\nInput the directory location you would like to save: "
				+ "\n\n\nDirectory Location Example: /Users/xxx/ \n\n");
		String location = input.nextLine();

		try {
			// create a file output stream object
			outFile = new FileOutputStream(location + fileName + "." + fileType);
			// create a datafile which can be written
			dataFile = new ObjectOutputStream(outFile);
			// write the object
			dataFile.writeObject(companies);
			// close the object
			dataFile.close();
			System.out.println("\n" + fileName + "." + fileType + " has been saved to " + location);
		} catch (IOException io) {
			System.out.println("\nSaving failure \nReason: " + io.getMessage() + "\n");
		}
	}

	/*
	 * this is the method to open the data file
	 */
	@SuppressWarnings("unchecked")
	public static void open() {
		FileInputStream fileInput;
		ObjectInputStream dataFile;
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.println("\nDirectory Location and Example: /Users/xxx/Companies.dat \n"
				+ "Input the directory of the file and the file name you would like to load: ");
		String location = input.nextLine();
		try {
			fileInput = new FileInputStream(location);
			dataFile = new ObjectInputStream(fileInput);
			try {
				// let the program knows that the computer should load the
				// arraylist inside the data file
				companies = (ArrayList<Company>) dataFile.readObject();
				dataFile.close();
				System.out.println("\nLoading Finished\n");
			} catch (ClassNotFoundException e) {

				System.out.println("\nLoading failure \nReason: " + e.getMessage() + "\n");
			}
		} catch (IOException e1) {

			System.out.println("\nLoading failure \nReason: " + e1.getMessage() + "\n");
		}
	}

}
