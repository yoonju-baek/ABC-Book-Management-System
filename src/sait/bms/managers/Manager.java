package sait.bms.managers;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import sait.bms.problemdomain.Book;
import sait.bms.problemdomain.ChildrensBook;
import sait.bms.problemdomain.Cookbook;
//After completing the following class, enable them
//import sait.bms.problemdomain.Cookbooks;
import sait.bms.problemdomain.Paperback;
import sait.bms.problemdomain.Periodical;

public class Manager {
	private ArrayList<Book> books = new ArrayList<>();
	private static final String FILE_PATH = "res/books.txt";
	Scanner in;

	public Manager() throws FileNotFoundException {
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
			int menuNumber = in.nextInt();
			String temp = in.nextLine();

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

	private void save() {
		// TODO Auto-generated method stub
		System.out.println("TEST: Save ");
	}

	private void produceRandomBooks() {
		System.out.print("Enter number of books: ");
		int randomBooksNum = in.nextInt();
		
		if(randomBooksNum > books.size()) {
			randomBooksNum = books.size();
		}
		
		Collections.shuffle(books);
		System.out.println("\nRandom books:");
		for (int i = 0; i < randomBooksNum; i++) {
			System.out.println(books.get(i));
		}
	}
	
	private void displayBooksByType() {
		System.out.println("#     Type");
		System.out.println("1     Children's Books");
		System.out.println("2     Cookbooks");
		System.out.println("3     Paperbacks");
		System.out.println("4     Periodicals");
		System.out.print("\nEnter type of book: ");
		int bookType = in.nextInt();
		
		switch (bookType) {
		case 1:
			System.out.print("Enter a format (P for Picture book, E for Early Readers, or C for Chapter book): ");
			break;
		case 2:
			System.out.print("Enter a diet (D for Diabetic, V for Vegetarian, G for Gluten-free, I for International, or N for None): ");
			break;
		case 3:
			System.out.print("Enter a genre (A for Adventure, D for Drama, E for Education, C for Classic, F for Fantasy, or S for Science Fiction): ");
			break;
		case 4:
			System.out.print("Enter a frequency (D for Daily, W for Weekly, M for Monthly, B for Bimonthly, or Q for Quarterly): ");
			break;
		default:
			System.out.println("Incorrect input. Try again.\n");
			return;
		}
		String category = in.next();
		searchBooksByCategoryOfType(bookType, category);	
	}


	private void findBooksByTitle() {
		Boolean ismatch = false;
		
		System.out.print("Enter title to search for: ");
		String title = in.nextLine();
		
		System.out.println("Matching books:");
		for (Book book : books) {
			if(book.getTitle().toLowerCase().contains(title.toLowerCase())) {
				ismatch = true;
				System.out.println(book);
			}
		}
		
		//display for no any match book list
		if(!ismatch) {
			System.out.println("Sorry, we can't find any matches for \"" + title + "\"\n");
		}
	}

	private void checkout() {
		// TODO Auto-generated method stub
		System.out.println("TEST: Checkout ");
	}

	private void loadBookList() throws FileNotFoundException {
		in = new Scanner(new File(FILE_PATH));

		while (in.hasNext()) {
			String line = in.nextLine();
			String[] fields = line.split(";");
			char lastDigit = fields[0].charAt(12);

			switch (lastDigit) {
			case '0':
			case '1':
				books.add(new ChildrensBook(Long.parseLong(fields[0]), fields[1], Integer.parseInt(fields[2]),
						Integer.parseInt(fields[3]), fields[4], fields[5], fields[6]));
				break;
			case '2':
			case '3':
				// After complete Cookbooks class, enable below code
				// books.add(new Cookbooks(Long.parseLong(fields[0]), fields[1],
				// Integer.parseInt(fields[2]), Integer.parseInt(fields[3]), fields[4],
				// fields[5], fields[6])));
				break;
			case '4':
			case '5':
			case '6':
			case '7':
				books.add(new Paperback(Long.parseLong(fields[0]), fields[1], Integer.parseInt(fields[2]), 
						Integer.parseInt(fields[3]), fields[4],	fields[5], Integer.parseInt(fields[6]), fields[7]));
				break;
			case '8':
			case '9':
				books.add(new Periodical(Long.parseLong(fields[0]), fields[1], Integer.parseInt(fields[2]), 
						Integer.parseInt(fields[3]), fields[4],	fields[5]));
				break;
			}
		}
		in.close();
	}
	
	private void searchBooksByCategoryOfType(int bookType, String category) {
		Boolean ismatch = false;
		
		System.out.println("\nMatching books:");
		
		for (Book book : books) {
			if(book instanceof ChildrensBook && bookType == 1) {
				ChildrensBook childrensBook = (ChildrensBook)book;
				if(childrensBook.getFormat().toUpperCase().equals(category)) {
					ismatch = true;
					System.out.println(book);
				}
			}
			else if(book instanceof Cookbook && bookType == 2) {
				Cookbook cookbook = (Cookbook)book;
				// working after Cookbook class complete
			}
			else if(book instanceof Paperback && bookType == 3) {
				Paperback paperback = (Paperback)book;
				if(paperback.getGenre().toUpperCase().equals(category)) {
					ismatch = true;
					System.out.println(book);
				}
			}
			else if(book instanceof Periodical && bookType == 4) {	
				Periodical periodical = (Periodical)book;
				if(periodical.getFrequency().toUpperCase().equals(category)) {
					ismatch = true;
					System.out.println(book);
				}
			}
		}
		
		//display for no any match book list
		if(!ismatch) {
			System.out.println("Sorry, we can't find any matches");

		}
	}
}
