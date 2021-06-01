package sait.bms.problemdomain;

public class ChildrensBook extends Book {
	private String authors;
	private String format;
	
	public ChildrensBook() {
		super();
	}

	public ChildrensBook(long isbn, String callNumber, int available, int total, String title) {
		super(isbn, callNumber, available, total, title);
	}

	public ChildrensBook(long isbn, String callNumber, int available, int total, String title, String authors, String format) {
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

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	@Override
	public String toString() {
		return "ChildrensBook [authors=" + authors + ", format=" + format + ", Isbn()=" + getIsbn()
				+ ", CallNumber()=" + getCallNumber() + ", Available()=" + getAvailable() + ", Total()="
				+ getTotal() + ", Title()=" + getTitle() + "]";
	}
	
}
