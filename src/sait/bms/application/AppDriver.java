package sait.bms.application;

import java.io.FileNotFoundException;

import sait.bms.managers.Manager;

/**
 * AppDriver class for the ABC Book Management System.
 * 
 * @author Dongyeon Kim
 * @author SeungJin Moon
 * @author Yoonju Baek
 * 
 * @version 4 June 2021
 */
public class AppDriver {

	public static void main(String[] args) throws FileNotFoundException {
		new Manager();
	}

}
