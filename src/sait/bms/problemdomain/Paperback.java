package sait.bms.problemdomain;

public class Paperback extends Book {
	private static final String GENRE_A = "Adventure";
	private static final String GENRE_D = "Drama";
	private static final String GENRE_E = "Education";
	private static final String GENRE_C = "Classic";
	private static final String GENRE_F = "Fantasy";
	private static final String GENRE_S = "Science Fiction";
	
	private String authors;
	private int year;
	private String genre;
	
	public Paperback() {
		super();
	}
	
	public Paperback(long isbn, String callNumber, int available, int total, String title, String authors, int year, String genre) {
		super(isbn, callNumber, available, total, title);
		this.authors = authors;
		this.year = year;
		this.genre = genre;
	}

	public String getAuthors() {
		return authors;
	}

	public void setAuthors(String authors) {
		this.authors = authors;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	public String displayGenre() {
		String genreName = "";
		switch (this.genre) {
		case "A":
			genreName = GENRE_A;
			break;
		case "D":
			genreName = GENRE_D;
			break;
		case "E":
			genreName = GENRE_E;
			break;
		case "C":
			genreName = GENRE_C;
			break;
		case "F":
			genreName = GENRE_F;
			break;
		case "S":
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
