package com.listofcountries;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class ReadAndWrite {

	ArrayList<String> listOfCountries = new ArrayList<>();
	String countries;
	String write;
	
	Path newPath = Paths.get("\\Users\\admin\\newWorkspace\\ListOfCountries\\src\\com\\listofcountries\\MyCountries");
	File newFileObject = newPath.toFile();
	Scanner lc = new Scanner(System.in);
	
	public ReadAndWrite(String countries, String write) {
		
		this.countries = countries;
		this.write = write;	
	}
	
	public ReadAndWrite() {
	}
	
	public void reader() {
			
		try (BufferedReader in = new BufferedReader(new FileReader(newFileObject))) {
			
			while((countries = in.readLine()) != null) {
				listOfCountries.add(countries);
				System.out.println(countries);
				
			} in.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("");
	}
	
	public void writer () {
		
		System.out.println("Please enter the country name:");

		try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(newFileObject, true)))) {
			
			write = lc.nextLine();
			out.println(write);
			out.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("");
	}
	
	public void reWriter () {
		
		try (BufferedReader in = new BufferedReader(new FileReader(newFileObject))) {
			
			while((countries = in.readLine()) != null) {
				listOfCountries.add(countries);
				
			} in.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("\nPlease enter the country you would like to delete:");
		String write = lc.nextLine();
		
		if (listOfCountries.contains(write)) {
			for (int i = 0; i < listOfCountries.size(); i++) {
				if (listOfCountries.get(i).equalsIgnoreCase(write)) {
					listOfCountries.remove(i);
					break;
				}
			}
		} else { System.out.println("\nCountry not found.");
			listOfCountries.clear();
			reWriter();
		}
		System.out.println(write + " has been deleted\n");

		try (BufferedWriter out = new BufferedWriter(new FileWriter(newFileObject))) {
			
			for (int j = 0; j < listOfCountries.size(); j++) {
				write = listOfCountries.get(j).toString();
				out.append(write + "\n");
	
			} out.close();
	
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}

	public String getCountries() {
		return countries;
	}

	public void setCountries(String countries) {
		this.countries = countries;
	}

	public String getWrite() {
		return write;
	}

	public void setWrite(String write) {
		this.write = write;
	}
}
