package test_assignement;
/*
 * this class construct an item (company)
 */
import java.util.Scanner;
import java.io.*;
//implements interface of Serializable interface
@SuppressWarnings("serial")
public class Company implements Serializable {
	// Declare data type
	int refNo;
	String companyName;
	String country;
	String directorName;
	String shareholderName;

	// Default properties
	public Company() {
		set(1234, "UK Government", "United Kingdom", "Theresa May", "Queen Elizabeth II");
	}

	// Create properties constructor
	// this is where we put the object detail
	public Company(int refNo, String companyName, String country, String directorName, String shareholderName) {
		//setter to set all the properties
		set(refNo, companyName, country, directorName, shareholderName);
	}


	// set method for all properties
	public void set(int refNo, String companyName, String country, String directorName, String shareholderName) {
		setRefNo(refNo);
		setCompanyName(companyName);
		setCountry(country);
		setDirectorName(directorName);
		setShareholderName(shareholderName);

	}

	// set method for individual properties
	public void setRefNo(int refNo) {
		this.refNo = refNo;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setDirectorName(String directorName) {
		this.directorName = directorName;
	}

	public void setShareholderName(String shareholderName) {
		this.shareholderName = shareholderName;
	}

	// getter method for individual properties
	public int getRefNo() {
		return refNo;
	}

	public String getCompanyName() {
		return companyName;
	}

	public String getCountry() {
		return country;
	}

	public String getDirectorName() {
		return directorName;
	}

	public String getShareholderName() {
		return shareholderName;
	}
	
	
	// Ask method for setting all the properties except the reference
	public void ask() {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);

		System.out.println("Enter company name: ");
		String companyName = input.nextLine();
		setCompanyName(companyName);

		System.out.println("Enter the country of origin: ");
		String country = input.nextLine();
		setCountry(country);

		System.out.println("Enter director Name of the company: ");
		String directorName = input.nextLine();
		setDirectorName(directorName);

		System.out.println("Enter shareholder Name of the company: ");
		String shareholderName = input.nextLine();
		setShareholderName(shareholderName);

	}
	
	/*
	 * this individual ask method for reference number, 
	 * and the method is receiving a parameters to set the reference number value
	 */
	public void askRefNo(int refNo){
		setRefNo(refNo);
	}
	
	// Method to print all the detail of company
	public void print() {
		System.out.println("\nReference Number: \t" + refNo + "\nCompany Name: \t\t" + companyName + "\nCountry: \t\t" 
		+ country + "\nDirector Name: \t\t" + directorName + "\nShareholder Name: \t" + shareholderName);
	}
	// overloading method
	public void print(String heading) {
		System.out.println(heading);
		print();
	}

	// toString method to prevent system from showing the memory location
	public String toString() {
		return "Ref: " + refNo + 
				"  ||Company Name: " + companyName.toUpperCase() +  
				"  ||Country: " + country.toUpperCase() +  
				"  ||Director: " + directorName.toUpperCase() + 
				"  ||Shareholder: " + shareholderName.toUpperCase() + 
				"\n";

	}
	

}
