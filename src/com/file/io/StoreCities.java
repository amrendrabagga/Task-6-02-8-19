package com.file.io;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class StoreCities {

	public static void main(String[] args) throws IOException {
		// using file - Cities.txt
		System.out.println("ENTER CITIES NAME");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		String cities[] = reader.readLine().split("\\s");
		FileOutputStream fos = new FileOutputStream("Files/Cities.txt");
		// using FileOutputStream will override already existing contents
		for (String city : cities) {
			fos.write(city.getBytes());
		}
		System.out.println("CITIES ADDED SUCCESSFULLY");
		fos.close();

	}

}
