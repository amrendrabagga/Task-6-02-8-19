package com.file.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ShowAndDeleteFile {
	public static void main(String args[]) throws IOException {

		System.out.println("ENTER FILE NAME");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String f1 = reader.readLine();
		File file = new File("Files/" + f1);

		if (file.exists()) {
			FileInputStream fis = new FileInputStream(file);
			int size = fis.available();
			byte[] b = new byte[size];
			fis.read(b);
			String fileRead = new String(b);
			System.out.println("FILE DATA IS");
			System.out.println(fileRead);
			fis.close();
			if (file.delete())
				System.out.println("FILE DELETED SUCCESSFULLY");
			else
				System.out.println("ERROR OCCURIED DURING FILE DELETE, TRY AGAIN...");
		} else
			System.out.println("FILE NOT EXIST");
	}
}
