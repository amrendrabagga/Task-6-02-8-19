package com.file.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class CopyContentOfFile {

	public static void main(String args[]) throws IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String f1 = reader.readLine();
		String f2 = reader.readLine();
		File file1 = new File("Files/" + f1);
		File file2 = new File("Files/" + f2);

		if (file1.exists()) {
			FileInputStream fis = new FileInputStream(file1);
			FileOutputStream fos = new FileOutputStream(file2);
			int available = fis.available();
			byte b[] = new byte[available];
			fis.read(b);
			fos.write(b);
			System.out.println("FILE COPIED SUCCESSFULLY");
			fis.close();
			fos.close();

		} else
			System.out.println("FILE DOESNT EXIST");
	}

}
