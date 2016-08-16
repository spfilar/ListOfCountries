package com.listofcountries;

public class Validation {
	
	String validEntry = null;
	
	public Validation(int validEntry) {
	}
	
	public String getValidEntry() {
		return validEntry;
	}
	
	public static boolean validateMove(String validEntry) {
		
		try {
			int isValid = Integer.parseInt(validEntry);
			if ((isValid < 0) || (isValid > 4)) {
				System.out.println("Invalid entry. Please enter a number 1 - 3");
				return true;
			}
				return false;
		}
		catch (NumberFormatException e) {
			System.out.println("Invalid entry. Please enter a number 1 - 3.");
			return true;
		}
	}
}
