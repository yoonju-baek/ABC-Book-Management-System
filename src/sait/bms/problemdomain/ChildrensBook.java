package sait.bms.problemdomain;

public class ChildrensBook extends Book {
	private static final String FORMAT_P = "Picture Book";
	private static final String FORMAT_E = "Early Readers";
	private static final String FORMAT_C = "Chapter Book";
	
	private String authors;
	private char format;

	public ChildrensBook() {
		super();
	}

	public ChildrensBook(long isbn, String callNumber, int available, int total, String title, String authors, char format) {
		super(isbn, callNumber, available, total, title);
		this.authors = authors;
		this.format = format;
	}

	public String getAuthors() {
		return authors;
	}

	public void setAuthors(String authors) {
		this.authors = authors;
	}

	public char getFormat() {
		return format;
	}

	public void setFormat(char format) {
		this.format = format;
	}
	
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
