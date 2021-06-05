package sait.bms.managers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import sait.bms.problemdomain.Book;
import sait.bms.problemdomain.ChildrensBook;
import sait.bms.problemdomain.Cookbook;
import sait.bms.problemdomain.Paperback;
import sait.bms.problemdomain.Periodical;

/**
 * Manager class to display the following:
 * 
 * @author Dongyeon Kim
 * @author SeungJin Moon
 * @author Yoonju Baek
 * 
 * @version 4 June 2021
 */
public class Manager {
	private final int LENGTH_OF_ISBN = 13;
	
	private ArrayList<Book> books = new ArrayList<>();
	private static final String FILE_PATH = "res/books.txt";
	Scanner in;

	/**
	 * Create a Manager object.
	 * 
	 * @throws FileNotFoundException if there are any problems opening file.
	 */
	public Manager() throws FileNotFoundException {
		// call a loadBooList method that loads all data from the book.txt file.
		loadBookList();

		while (true) {
			System.out.println("Welcome in ABC Book Company: How May We Assist You?");
			System.out.println("1     Checkout Book");
			System.out.println("2     Find Books by Title");
			System.out.println("3     Display Books by Type");
			System.out.println("4     Produce Random Book List");
			System.out.println("5     Save & Exit");
			System.out.print("\rEnter option: ");

			in = new Scanner(System.in);
			String userInput = in.nextLine().trim();

			int menuNumber = 0;
			if (isDigit(userInput)) {
				menuNumber = Integer.parseInt(userInput);
			}

			// call each method that operates the specific feature selected by a user
			switch (menuNumber) {
			case 1:
				checkout();
				break;
			case 2:
				findBooksByTitle();
				break;
			case 3:
				displayBooksByType();
				break;
			case 4:
				produceRandomBooks();
				break;
			case 5:
				save();
				in.close();
				System.out.println("Program exits!");
				System.exit(0);
			default:
				System.out.println("Incorrect input. Try again.\n");
				break;
			}
		}
	}

	/**
	 * Save data in the ArrayList to books.txt file
	 * 
	 * @throws FileNotFoundException if there are any problems opening file.
	 */
	private void save() throws FileNotFoundException {
		PrintStream output = new PrintStream(FILE_PATH);
		for (Book book : books) {
			if (book instanceof ChildrensBook) {
				ChildrensBook childrensbook = (ChildrensBook) book;
				output.println(childrensbook.getIsbn() + ";" + childrensbook.getCallNumber() + ";"
						+ childrensbook.getAvailable() + ";" + childrensbook.getTotal() + ";" + childrensbook.getTitle()
						+ ";" + childrensbook.getAuthors() + ";" + childrensbook.getFormat());
			} else if (book instanceof Cookbook) {
				Cookbook cookbook = (Cookbook) book;
				output.println(cookbook.getIsbn() + ";" + cookbook.getCallNumber() + ";" + cookbook.getAvailable() + ";"
						+ cookbook.getTotal() + ";" + cookbook.getTitle() + ";" + cookbook.getPublisher() + ";"
						+ cookbook.getDiet());
			} else if (book instanceof Paperback) {
				Paperback paperback = (Paperback) book;
				output.println(paperback.getIsbn() + ";" + paperback.getCallNumber() + ";" + paperback.getAvailable()
						+ ";" + paperback.getTotal() + ";" + paperback.getTitle() + ";" + paperback.getAuthors() + ";"
						+ paperback.getYear() + ";" + paperback.getGenre());
			} else if (book instanceof Periodical) {
				Periodical periodical = (Periodical) book;
				output.println(periodical.getIsbn() + ";" + periodical.getCallNumber() + ";" + periodical.getAvailable()
						+ ";" + periodical.getTotal() + ";" + periodical.getTitle() + ";" + periodical.getFrequency());
			}

		}
		output.close();
	}

	/**
	 * Produce the random Book lists as many as the user wants
	 */
	private void produceRandomBooks() {
		System.out.print("Enter number of books: ");
		String userInput = in.nextLine().trim();

		int randomBooksNum = 0;
		if (isDigit(userInput)) {
			randomBooksNum = Integer.parseInt(userInput);
		} else {
			System.out.println("Incorrect input. Try again.\n");
			return;
		}

		if (randomBooksNum > books.size()) {
			randomBooksNum = books.size();
		}

		Collections.shuffle(books);
		System.out.println("\nRandom books:");
		for (int i = 0; i < randomBooksNum; i++) {
			System.out.println(books.get(i));
		}
	}

	/**
	 * Display the information of books by a type of book
	 */
	private void displayBooksByType() {
		System.out.println("#     Type");
		System.out.println("1     Children's Books");
		System.out.println("2     Cookbooks");
		System.out.println("3     Paperbacks");
		System.out.println("4     Periodicals");
		System.out.print("\nEnter type of book: ");
		String userInput = in.nextLine().trim();

		int bookType = 0;
		if (isDigit(userInput)) {
			bookType = Integer.parseInt(userInput);
		}

		switch (bookType) {
		case 1:
			System.out.print("Enter a format (P for Picture book, E for Early Readers, or C for Chapter book): ");
			break;
		case 2:
			System.out.print(
					"Enter a diet (D for Diabetic, V for Vegetarian, G for Gluten-free, I for International, or N for None): ");
			break;
		case 3:
			System.out.print(
					"Enter a genre (A for Adventure, D for Drama, E for Education, C for Classic, F for Fantasy, or S for Science Fiction): ");
			break;
		case 4:
			System.out.print(
					"Enter a frequency (D for Daily, W for Weekly, M for Monthly, B for Bimonthly, or Q for Quarterly): ");
			break;
		default:
			System.out.println("Incorrect input. Try again.\n");
			return;
		}

		userInput = in.nextLine().trim();

		char category = '\u0000';
		if ((userInput.length() == 1) && Character.isLetter(userInput.charAt(0))) {
			category = userInput.toUpperCase().charAt(0);
		} else {
			System.out.println("Incorrect input. Try again.\n");
			return;
		}

		boolean ismatch = false;

		System.out.println("\nMatching books:");

		for (Book book : books) {
			if (book instanceof ChildrensBook && bookType == 1) {
				ChildrensBook childrensBook = (ChildrensBook) book;
				if (childrensBook.getFormat() == category) {
					ismatch = true;
					System.out.println(book);
				}
			} else if (book instanceof Cookbook && bookType == 2) {
				Cookbook cookbook = (Cookbook) book;
				if (cookbook.getDiet() == category) {
					ismatch = true;
					System.out.println(book);
				}
			} else if (book instanceof Paperback && bookType == 3) {
				Paperback paperback = (Paperback) book;
				if (paperback.getGenre() == category) {
					ismatch = true;
					System.out.println(book);
				}
			} else if (book instanceof Periodical && bookType == 4) {
				Periodical periodical = (Periodical) book;
				if (periodical.getFrequency() == category) {
					ismatch = true;
					System.out.println(book);
				}
			}
		}

		// display for any no matching book list
		if (!ismatch) {
			System.out.println("Sorry, we can't find any matches.\n");
		}
	}

	/**
	 * Display the information of books by a title of book
	 */
	private void findBooksByTitle() {
		Boolean ismatch = false;

		System.out.print("Enter title to search for: ");
		String title = in.nextLine().trim();

		if (title.isBlank()) {
			System.out.println("Sorry, incorrect input. Please enter the input.\n");
			return;
		}

		System.out.println("Matching books:");
		for (Book book : books) {
			if (book.getTitle().toLowerCase().contains(title.toLowerCase())) {
				ismatch = true;
				System.out.println(book);
			}
		}

		// display for any no matching book list
		if (!ismatch) {
			System.out.println("Sorry, we can't find any matches for \"" + title + "\"\n");
		}
	}

	/**
	 * Checkout a book and decrement the available number of book.
	 */
	private void checkout() {
		System.out.print("Enter ISBN of book: ");
		String isbn = in.nextLine().trim();

		// check if the isbn was input correctly
		if (!isbnValidation(isbn)) {
			System.out.println("Incorrect input. Try again.\n");
			return;
		}
		
		// find the book matched the isbn and display title and call number and decrement the available number
		for (Book book : books) {
			if (book.getIsbn() == Long.parseLong(isbn)) {
				if (book.getAvailable() != 0) {
					book.setAvailable(book.getAvailable() - 1);
					System.out.println("The book \"" + book.getTitle() + "\" has been checked out.");
					System.out.println("It can be located using a call number: " + book.getCallNumber() + "\n");
					return;
				} else {
					System.out.println("The book \"" + book.getTitle() + "\" is not available.\n");
					return;
				}
			}
		}

		System.out.println("Sorry, we can't find any matches for \"" + isbn + "\"\n");
		return;
	}

	/**
	 * Validate the ISBN number is a digit and the length is 13.
	 * 
	 * @param isbn International Standard Book Number
	 * @return is Digit or not
	 */
	private boolean isbnValidation(String isbn) {
		boolean isIsbn = true;

		if (isbn.length() != LENGTH_OF_ISBN) {
			isIsbn = false;
		} else {
			isIsbn = isDigit(isbn);
		}
		return isIsbn;
	}

	/**
	 * Load book lists from books.txt file
	 * 
	 * @throws FileNotFoundException if there are any problems opening file.
	 */
	private void loadBookList() throws FileNotFoundException {
		in = new Scanner(new File(FILE_PATH));

		while (in.hasNext()) {
			String line = in.nextLine();
			String[] fields = line.split(";");
			char lastDigit = fields[0].charAt(LENGTH_OF_ISBN - 1);
			
			// add data into the ArrayList matched the correct object type
			switch (lastDigit) {
			case '0':
			case '1':
				books.add(new ChildrensBook(Long.parseLong(fields[0]), fields[1], Integer.parseInt(fields[2]),
						Integer.parseInt(fields[3]), fields[4], fields[5], fields[6].charAt(0)));
				break;
			case '2':
			case '3':
				books.add(new Cookbook(Long.parseLong(fields[0]), fields[1], Integer.parseInt(fields[2]),
						Integer.parseInt(fields[3]), fields[4], fields[5], fields[6].charAt(0)));
				break;
			case '4':
			case '5':
			case '6':
			case '7':
				books.add(new Paperback(Long.parseLong(fields[0]), fields[1], Integer.parseInt(fields[2]),
						Integer.parseInt(fields[3]), fields[4], fields[5], Integer.parseInt(fields[6]),
						fields[7].charAt(0)));
				break;
			case '8':
			case '9':
				books.add(new Periodical(Long.parseLong(fields[0]), fields[1], Integer.parseInt(fields[2]),
						Integer.parseInt(fields[3]), fields[4], fields[5].charAt(0)));
				break;
			}
		}
		in.close();
	}

	/**
	 * Validate the input is a digit
	 * 
	 * @param input the user input
	 * @return is Digit or not
	 */
	private boolean isDigit(String input) {
		boolean isDigit = true;

		if (input.isBlank()) {
			isDigit = false;
		} else {
			for (int i = 0; i < input.length(); i++) {
				if (!Character.isDigit(input.charAt(i))) {
					isDigit = false;
					break;
				}
			}
		}

		return isDigit;
	}

}
