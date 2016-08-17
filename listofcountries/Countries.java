package com.listofcountries;

import java.util.Scanner;

public class Countries {

	Scanner lc = new Scanner(System.in);
	
	String countryReader = null;
	String countryWriter = null;
	String menu = null;
	String choice = null;
	boolean userInput = true;
	
	public static void main(String[] args) {
		
		Countries newCountriesRun = new Countries();
		newCountriesRun.runCountries();
	}

	public void runCountries() {
		
		welcomeToCountriesList();
		
		userInput = Validation.validateMove(choice);
		
		do {			
			switch (choice) {
			case "1": ReadAndWrite read = new ReadAndWrite();
				read.reader();
				runCountries();
			case "2": ReadAndWrite write = new ReadAndWrite();
				write.writer();
				runCountries();
			case "3": ReadAndWrite reWrite = new ReadAndWrite();
				reWrite.reWriter();
				runCountries();
			case "4": System.out.println("\nThanks for using the application. Goodbye.");
				System.exit(0);
			default: runCountries();
			}
		} while (!userInput);
	}
	
	public Countries() {
	}
	
	public void welcomeToCountriesList() {
		System.out.println("Countries List");
		System.out.println("Please select from the menu:");
		System.out.println("(1) Display a list of countries.");
		System.out.println("(2) Enter a country to add to the list of countries.");
		System.out.println("(3) Delete a country from the list.");
		System.out.println("(4) Exit the application.");
		choice = lc.nextLine();
	}
}
