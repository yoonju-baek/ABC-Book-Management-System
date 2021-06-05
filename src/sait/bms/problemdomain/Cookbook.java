package sait.bms.problemdomain;

/**
 * Class Cookbook used to create Cookbook objects.
 * 
 * @author Dongyeon Kim
 * @author SeungJin Moon
 * @author Yoonju Baek
 * 
 * @version 4 June 2021
 */
public class Cookbook extends Book{
	private static final String DIET_D = "Diabetic";
	private static final String DIET_G = "Gluten-free";
	private static final String DIET_I = "International";
	private static final String DIET_N = "None";
	private static final String DIET_V = "Vegetarian";
	
	private String publisher;
	private char diet;
	
	/**
	 * Constructor used to create Cookbook Object.
	 */
	public Cookbook() {
		super();
	}

	/**
	 * Constructor used to create Cookbook Object providing the isbn, call number, available, total, title, publisher, and diet.
	 * 
	 * @param isbn International Standard Book Number
	 * @param callNumber call number of book
	 * @param available the number of available
	 * @param total the number of total
	 * @param title title
	 * @param publisher publisher of book
	 * @param diet	diet type of book
	 */
	public Cookbook(long isbn, String callNumber, int available, int total, String title, String publisher, char diet) {
		super(isbn, callNumber, available, total, title);
		this.publisher = publisher;
		this.diet = diet;
	}
	
	/**
	 * Get the publisher
	 * @return publisher
	 */
	public String getPublisher() {
		return publisher;
	}
	
	/**
	 * Set the publisher
	 * @param publisher
	 */
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	/**
	 * Get the diet of book
	 * @return the diet of book
	 */
	public char getDiet() {
		return diet;
	}
	
	/**
	 * Set the diet of book
	 * @param diet the diet of book
	 */
	public void setDiet(char diet) {
		this.diet = diet;
	}
	
	/**
	 * Get the description of the diet
	 * @return the description of the diet
	 */
	public String displayDiet() {
		String dietName = "";
		switch (this.diet) {
		case 'D':
			dietName = DIET_D;
			break;
		case 'G':
			dietName = DIET_G;
			break;
		case 'I':
			dietName = DIET_I;
			break;
		case 'N':
			dietName = DIET_N;
			break;
		case 'V':
			dietName = DIET_V;
			break;
		}
		
		return dietName;
	}

	@Override
	public String toString() {
		return String.format("%-18s" + getIsbn()
				 		 + "%n%-18s" + getCallNumber()
				 		 + "%n%-18s" + getAvailable()
				 		 + "%n%-18s" + getTotal()
				 		 + "%n%-18s" + getTitle()
				 		 + "%n%-18s" + publisher
				 		 + "%n%-18s" + displayDiet() 
				 		 + "%n",
				 		 "ISBN:", "Call Number:","Available:", "Total:","Title:","Publisher:");
	}
	
	
}
