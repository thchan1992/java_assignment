package test_assignement;

/*
 * this class construct the listedCompany under the sub class
 */

//the ListedItem Class
@SuppressWarnings("serial")
public class ListedCompany extends Company {

	//declare a new field in the sub class
	boolean listed = true;
	//default constructor
	public ListedCompany() {
		super();
		setListed(true);
	}
	//constructor
	public ListedCompany(int refNo, String companyName, String country, String directorName, String shareholderName,
			boolean listed) {
		super();
		setListed(listed);
	}

	//setter to set the boolean value
	public void setListed(boolean listed) {
		this.listed = listed;
	}

	// getter to get boolean value
	public boolean getListed() {
		return listed;
	}
	
	// ask method to ask the users type value for the new item
	public void askListed(int refNo) {
		//ask method from the super class
		super.askRefNo(refNo);
		super.ask();
		setListed(listed);
	}

	// print method to print the new listed company registration
	public void printListedCompany() {
		super.print();
		System.out.println("Listed Company: \t" + listed);
	}

	// toString method for the listed company instance
	public String toString() {
		return "Ref: " + refNo + "  ||Company Name: " + companyName.toUpperCase() + "  ||Country: "
				+ country.toUpperCase() + "  ||Director: " + directorName.toUpperCase() + "  ||Shareholder: "
				+ shareholderName.toUpperCase() + "  ||Listed Company: " + listed
				+ "\n";
	}

}
