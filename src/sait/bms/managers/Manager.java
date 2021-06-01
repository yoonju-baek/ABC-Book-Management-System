package sait.bms.managers;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import sait.bms.problemdomain.Book;
import sait.bms.problemdomain.ChildrensBook;
//After completing the following class, enable them
//import sait.bms.problemdomain.Cookbooks;
//import sait.bms.problemdomain.Paperbacks;
//import sait.bms.problemdomain.Periodicals;

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
			System.out.print("Enter option: ");

			in = new Scanner(System.in);
			int menuNumber = in.nextInt();
			String temp = in.nextLine();

			switch (menuNumber) {
			case 1:
				Checkout();
				break;
			case 2:
				FindBooks();
				break;
			case 3:
				DisplayBooks();
				break;
			case 4:
				RandomBooks();
				break;
			case 5:
				Save();
				in.close();
				System.out.println("Program exits!");
				System.exit(0);
			default:
				System.out.println("Incorrect input. Try again.");
				break;
			}
		}
	}

	private void Save() {
		// TODO Auto-generated method stub
		System.out.println("TEST: Save ");
	}

	private void RandomBooks() {
		// TODO Auto-generated method stub
		System.out.println("TEST: RandomBooks ");
	}

	private void DisplayBooks() {
		// TODO Auto-generated method stub
		System.out.println("TEST: DisplayBooks ");
	}

	private void FindBooks() {
		// TODO Auto-generated method stub
		System.out.println("TEST: FindBooks ");
	}

	private void Checkout() {
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
				// After completing Paperbacks class, enable below code
				// books.add(new Paperbacks(Long.parseLong(fields[0]), fields[1],
				// Integer.parseInt(fields[2]), Integer.parseInt(fields[3]), fields[4],
				// fields[5], fields[6], Integer.parseInt(fields[7]));
				break;
			case '8':
			case '9':
				// After completing Periodicals class, enable below code
				// books.add(new Periodicals(Long.parseLong(fields[0]), fields[1],
				// Integer.parseInt(fields[2]), Integer.parseInt(fields[3]), fields[4],
				// fields[5]));
				break;
			}
		}
		in.close();
	}

}
