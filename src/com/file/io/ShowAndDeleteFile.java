package com.file.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class ShowAndDeleteFile {
	public static void main(String args[]) throws IOException {

		//using java8 Files.lines and Files.delete
		System.out.println("ENTER FILE NAME");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String f1 = reader.readLine();
		Path path = Paths.get("Files", f1);

		//using auto-closable try
		try(Stream<String> stream = Files.lines(path)){
			System.out.println("FILE DATA IS");
			stream.forEach(System.out::println);
			Files.delete(path);
			System.out.println("FILE DELETED SUCCESSFULLY");
			
		}
		
	}
}
