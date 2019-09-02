package com.file.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class RenameFile {

	public static void main(String[] args) throws IOException {
		// using files - File1.txt and Files.txt
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String f1 = reader.readLine();
		String f2 = reader.readLine();

		File file1 = new File("Files/" + f1);
		File file2 = new File("Files/" + f2);

		if (file1.exists()) {
			if (file1.isFile()) {
				if (!file2.exists()) {
					if (file1.length() < 500) {
						file1.renameTo(file2);
						System.out.println("FILE RENAMED SUCCESSFULLY");
					} else
						System.out.println("FILE LENGTH IS MORE THAN 500 BYTES");
				} else
					System.out.println(f2 + " ALREADY EXIST");
			} else
				System.out.println("IT IS NOT A FILE");
		} else
			System.out.println(f1 + " FILE DOESNT EXIST");

	}

}
