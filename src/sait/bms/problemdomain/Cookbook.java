package sait.bms.problemdomain;

public class Cookbook extends Book{
	private static final String DIET_D = "Diabetic";
	private static final String DIET_G = "Gluten-free";
	private static final String DIET_I = "International";
	private static final String DIET_N = "None";
	private static final String DIET_V = "Vegetarian";
	
	private String publisher;
	private char diet;
	
	public Cookbook() {
		super();
	}

	public Cookbook(long isbn, String callNumber, int available, int total, String title, String publisher, char diet) {
		super(isbn, callNumber, available, total, title);
		this.publisher = publisher;
		this.diet = diet;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public char getDiet() {
		return diet;
	}
	public void setDiet(char diet) {
		this.diet = diet;
	}
	
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
