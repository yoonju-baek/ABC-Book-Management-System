Project title:	CPRG 251 Assignment 1
Authors:		DongYeon Kim 
				Seungjin Moon
				Yoonju Baek
Date:			5 June, 2021
==============================================================================================

This program is to manage the ABC Book Company's books more efficiently using some features 
such as checkout, find, and list books from books' data file named "books.txt." It can be used
by both employees and patrons. The features the program has is the following:

1.	Checkout a book
  - Allows a patron to check out a book using its ISBN. If the book is unavailable, the user 
	will be informed and the program will return back to the main menu. Otherwise, if the book
	is available, the available count will be decremented and the book information will be 
	displayed.
	
  - Input "1" in the main menu to run "Checkout Book" and then, enter the ISBN of the book you 
	want to checkout.
	
2.	Find books by title
  - Allows a patron to enter a search term and the program will display a list of books that
	have a title matching the search term.
	
  - Input "2" in the main menu to run "Find Books by Title" and then, enter the title to 
	search for.

3.	Display books of a specific type
  - Allows a patron to view a list of books of a specific type. The user will also enter a
	format, diet, genre, or frequency (depending on the type of book) and the book list will 
	be narrowed down further.
	
  - Input "3" in the main menu to run "Display Books by Type" and then, enter type of book 
	among Children's Books, Cookbooks, Paperbacks, and periodicals. And enter the subtype of the 
	type of book.

4.	Produce a list of random books
  - Allows a patron to print a list of random books. The list of books can contain any type of
	book.
	
  - Input "4" in the main menu to run "Produce Random Book List" and then, enter the number of
    books you want to find.

5.	Save and Exit program
  - Allows a patron to save all revised data into the book.txt file and exit the program.

  - Input "5" in the main menu to run save and exit.
 