package sait.bms.problemdomain;

public class Periodical extends Book{
	private static final String FREQUENCY_D = "Daily";
	private static final String FREQUENCY_W = "Weekly";
	private static final String FREQUENCY_M = "Monthly";
	private static final String FREQUENCY_B = "Bi-monthly";
	private static final String FREQUENCY_Q = "Quarterly";

	private String frequency;

	public Periodical() {
		super();
	}

	public Periodical(long isbn, String callNumber, int available, int total, String title) {
		super(isbn, callNumber, available, total, title);
	}
	
	public Periodical(long isbn, String callNumber, int available, int total, String title, String frequency) {
		super(isbn, callNumber, available, total, title);
		this.frequency = frequency;
	}

	public String getFrequency() {
		return frequency;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}
	
	public String displayFrequency() {
		String frequencyName = "";
		switch (this.frequency) {
		case "D":
			frequencyName = FREQUENCY_D;
			break;
		case "W":
			frequencyName = FREQUENCY_W;
			break;
		case "M":
			frequencyName = FREQUENCY_M;
			break;
		case "B":
			frequencyName = FREQUENCY_B;
			break;
		case "Q":
			frequencyName = FREQUENCY_Q;
			break;
		}
		
		return frequencyName;
	}

	@Override
	public String toString() {
		return String.format("%-18s" + getIsbn()
			 			 + "%n%-18s" + getCallNumber()
			 			 + "%n%-18s" + getAvailable()
			 			 + "%n%-18s" + getTotal()
			 			 + "%n%-18s" + getTitle()
			 			 + "%n%-18s" + displayFrequency()
			 			 + "%n", 
			 			 "ISBN:", "Call Number:","Available:", "Total:","Title:","Frequency:");
	}
}
