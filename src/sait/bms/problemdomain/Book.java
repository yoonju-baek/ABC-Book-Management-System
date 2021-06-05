package sait.bms.problemdomain;

/**
 * Class Book used to create Book objects.
 * 
 * @author Dongyeon Kim
 * @author SeungJin Moon
 * @author Yoonju Baek
 * 
 * @version 4 June 2021
 */
public class Book {
	private long isbn;
	private String callNumber;
	private int available;
	private int total;
	private String title;
	
	/**
	 * Constructor used to create Book Object.
	 */
	public Book() {
	}

	/**
	 * Constructor used to create Book Object providing the isbn, call number, available, total, and title.
	 * 
	 * @param isbn International Standard Book Number
	 * @param callNumber call number of book
	 * @param available the available number of book
	 * @param total the total number of book
	 * @param title the book title
	 */
	public Book(long isbn, String callNumber, int available, int total, String title) {
		this.isbn = isbn;
		this.callNumber = callNumber;
		this.available = available;
		this.total = total;
		this.title = title;
	}

	/**
	 * Get the International Standard Book Number
	 * @return the International Standard Book Number
	 */
	public long getIsbn() {
		return isbn;
	}

	/**
	 * Set the International Standard Book Number
	 * @param isbn the International Standard Book Number
	 */
	public void setIsbn(long isbn) {
		this.isbn = isbn;
	}

	/**
	 * Get the call number of book
	 * @return the call number of book
	 */
	public String getCallNumber() {
		return callNumber;
	}

	/**
	 * Set the call number of book
	 * @param callNumber the call number of book
	 */
	public void setCallNumber(String callNumber) {
		this.callNumber = callNumber;
	}

	/**
	 * Get the available number of book
	 * @return the available number of book
	 */
	public int getAvailable() {
		return available;
	}

	/**
	 * Set the available number of book
	 * @param available the available number of book
	 */
	public void setAvailable(int available) {
		this.available = available;
	}

	/**
	 * Get the total number of book
	 * @return the total number of book
	 */
	public int getTotal() {
		return total;
	}

	/**
	 * Set the total number of book
	 * @param total the total number of book
	 */
	public void setTotal(int total) {
		this.total = total;
	}

	/**
	 * Get the book title
	 * @return the book title
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * Set the book title
	 * @param title the book title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", callNumber=" + callNumber + ", available=" + available + ", total=" + total
				+ ", title=" + title + "]";
	}
	
}
