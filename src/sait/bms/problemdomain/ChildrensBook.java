package sait.bms.problemdomain;

/**
 * Class ChildrensBook used to create ChildrensBook objects.
 * 
 * @author Dongyeon Kim
 * @author SeungJin Moon
 * @author Yoonju Baek
 * 
 * @version 4 June 2021
 */
public class ChildrensBook extends Book {
	private static final String FORMAT_P = "Picture Book";
	private static final String FORMAT_E = "Early Readers";
	private static final String FORMAT_C = "Chapter Book";
	
	private String authors;
	private char format;

	/**
	 * Constructor used to create ChildrensBook Object.
	 */
	public ChildrensBook() {
		super();
	}
	
	/**
	 * Constructor used to create ChildrensBook Object providing the isbn, call number, available, total, title, authors, and format.
	 * 
	 * @param isbn International Standard Book Number
	 * @param callNumber call number of book
	 * @param available the number of available
	 * @param total the number of total
	 * @param title title
	 * @param authors authors
	 * @param format book format
	 */
	public ChildrensBook(long isbn, String callNumber, int available, int total, String title, String authors, char format) {
		super(isbn, callNumber, available, total, title);
		this.authors = authors;
		this.format = format;
	}

	/**
	 * Get the book author
	 * @return the book author
	 */
	public String getAuthors() {
		return authors;
	}

	/**
	 * Set the book author
	 * @param authors the book author
	 */
	public void setAuthors(String authors) {
		this.authors = authors;
	}

	/**
	 * Get the book format
	 * @return the book format
	 */
	public char getFormat() {
		return format;
	}

	/**
	 * Get the book format
	 * @param format the book format
	 */
	public void setFormat(char format) {
		this.format = format;
	}
	
	/**
	 * Get the description of the format
	 * @return description of the format.
	 */
	public String displayFormat() {
		String formatName = "";
		switch (this.format) {
		case 'P':
			formatName = FORMAT_P;
			break;
		case 'E':
			formatName = FORMAT_E;
			break;
		case 'C':
			formatName = FORMAT_C;
			break;
		}
		
		return formatName;
	}

	@Override
	public String toString() {
		return String.format("%-18s" + getIsbn()
				 		 + "%n%-18s" + getCallNumber()
				 		 + "%n%-18s" + getAvailable()
				 		 + "%n%-18s" + getTotal()
				 		 + "%n%-18s" + getTitle()
				 		 + "%n%-18s" + authors
				 		 + "%n%-18s" + displayFormat() 
				 		 + "%n",
				 		 "ISBN:", "Call Number:","Available:", "Total:","Title:","Authors:","Format:");
	}
	
}
