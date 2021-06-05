package sait.bms.problemdomain;

/**
 * Class Periodical used to create Periodical objects
 * 
 * @author Group7 (Dongyeon Kim, SeungJin Moon, Yoonju Baek)
 * @version 3 June 2021
 */
public class Periodical extends Book{
	private static final String FREQUENCY_D = "Daily";
	private static final String FREQUENCY_W = "Weekly";
	private static final String FREQUENCY_M = "Monthly";
	private static final String FREQUENCY_B = "Bi-monthly";
	private static final String FREQUENCY_Q = "Quarterly";

	private char frequency;

	/**
	 * Constructor used to create Periodical Object.
	 */
	public Periodical() {
		super();
	}
	
	/**
	 * Constructor used to create Periodical Object providing the isbn, call number, available, total, title, and frequency.
	 * 
	 * @param isbn International Standard Book Number
	 * @param callNumber call number of book
	 * @param available the number of available
	 * @param total the number of total
	 * @param title title
	 * @param frequency frequency type
	 */
	public Periodical(long isbn, String callNumber, int available, int total, String title, char frequency) {
		super(isbn, callNumber, available, total, title);
		this.frequency = frequency;
	}
	
	/**
	 * Get the frequency type of periodical.
	 * @return frequency
	 */
	public char getFrequency() {
		return frequency;
	}

	/**
	 * Set the frequency type of periodical.
	 * @param frequency the type of frequency
	 */
	public void setFrequency(char frequency) {
		this.frequency = frequency;
	}
	
	/**
	 * Get the description of the frequency type.
	 * @return the description of the frequency
	 */
	public String displayFrequency() {
		String frequencyName = "";
		
		switch (this.frequency) {
		case 'D':
			frequencyName = FREQUENCY_D;
			break;
		case 'W':
			frequencyName = FREQUENCY_W;
			break;
		case 'M':
			frequencyName = FREQUENCY_M;
			break;
		case 'B':
			frequencyName = FREQUENCY_B;
			break;
		case 'Q':
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
