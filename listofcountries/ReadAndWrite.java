package com.listofcountries;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
	}
	
	public void reWriter () {
		
		System.out.println("Please enter the country you would like to delete:");
		String userInput = lc.nextLine();
		
		try (BufferedReader reader = new BufferedReader(new FileReader(newFileObject))) {
			
			while((countries = reader.readLine()) != null) {
				listOfCountries.add(countries);
				
			} reader.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		for (int i = 0; i < listOfCountries.size(); i++) {
			if (listOfCountries.get(i).equalsIgnoreCase(userInput)) {
				listOfCountries.remove(i);
				break;
			}
		}

		try (BufferedWriter delete = new BufferedWriter(new FileWriter(newFileObject))) {
			
			for (int j = 0; j < listOfCountries.size(); j++) {
				write = listOfCountries.get(j).toString();
				delete.append(write + "\n");
	
			} delete.close();
	
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
