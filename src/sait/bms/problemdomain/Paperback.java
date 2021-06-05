package sait.bms.problemdomain;
/**
 * Class Paperback used to create Paperback objects.
 * 
 * @author Group7 (Dongyeon Kim, SeungJin Moon, Yoonju Baek)
 * @version 3 June 2021
 */
public class Paperback extends Book {
	private static final String GENRE_A = "Adventure";
	private static final String GENRE_D = "Drama";
	private static final String GENRE_E = "Education";
	private static final String GENRE_C = "Classic";
	private static final String GENRE_F = "Fantasy";
	private static final String GENRE_S = "Science Fiction";
	
	private String authors;
	private int year;
	private char genre;
	
	/**
	 * Constructor used to create Paperback Object.
	 */
	public Paperback() {
		super();
	}
	
	/**
	 * Constructor used to create Paperback Object providing the isbn, call number, available, total, title, authors, year, and genre.
	 * 
	 * @param isbn International Standard Book Number
	 * @param callNumber call number of book
	 * @param available the number of available
	 * @param total the number of total
	 * @param title title
	 * @param authors authors
	 * @param year year of release
	 * @param genre genre
	 */
	public Paperback(long isbn, String callNumber, int available, int total, String title, String authors, int year, char genre) {
		super(isbn, callNumber, available, total, title);
		this.authors = authors;
		this.year = year;
		this.genre = genre;
	}

	/**
	 * Get the book's authors
	 * @return the authors
	 */
	public String getAuthors() {
		return authors;
	}

	/**
	 * Set the book's authors.
	 * @param authors The book's authors
	 */
	public void setAuthors(String authors) {
		this.authors = authors;
	}

	/**
	 * Get the year of release.
	 * @return the year
	 */
	public int getYear() {
		return year;
	}

	/**
	 * Set the year of release.
	 * @param year year of release
	 */
	public void setYear(int year) {
		this.year = year;
	}

	/**
	 * Get the genre of book.
	 * @return the genre
	 */
	public char getGenre() {
		return genre;
	}

	/**
	 * Set the genre of book.
	 * @param genre the genre
	 */
	public void setGenre(char genre) {
		this.genre = genre;
	}
	
	/**
	 * Get the description of the genre.
	 * @return the description of the genre
	 */
	public String displayGenre() {
		String genreName = "";
		
		switch (this.genre) {
			case 'A':
				genreName = GENRE_A;
				break;
			case 'D':
				genreName = GENRE_D;
				break;
			case 'E':
				genreName = GENRE_E;
				break;
			case 'C':
				genreName = GENRE_C;
				break;
			case 'F':
				genreName = GENRE_F;
				break;
			case 'S':
				genreName = GENRE_S;
				break;
		}
		
		return genreName;
	}

	
	@Override
	public String toString() {
		return String.format("%-18s" + getIsbn()
				 		 + "%n%-18s" + getCallNumber()
				 		 + "%n%-18s" + getAvailable()
				 		 + "%n%-18s" + getTotal()
				 		 + "%n%-18s" + getTitle()
				 		 + "%n%-18s" + authors
				 		 + "%n%-18s" + year
				 		 + "%n%-18s" + displayGenre()
				 		 + "%n", 
				 		 "ISBN:", "Call Number:","Available:", "Total:","Title:","Authors:","Year:","Genre:");
	}
} 
