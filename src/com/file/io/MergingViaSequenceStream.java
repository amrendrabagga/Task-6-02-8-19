package com.file.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.SequenceInputStream;

public class MergingViaSequenceStream {

	public static void main(String args[]) throws IOException {

		System.out.println("ENTER FILE NAMES");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String f1 = reader.readLine();
		String f2 = reader.readLine();
		File file1 = new File("Files/" + f1);
		File file2 = new File("Files/" + f2);

		if (file1.exists() && file2.exists()) {
			FileInputStream fis1 = new FileInputStream(file1);
			FileInputStream fis2 = new FileInputStream(file2);
			SequenceInputStream sis = new SequenceInputStream(fis1, fis2);

			System.out.println("MERGED DATA IS");
			int j;
			FileOutputStream fos = new FileOutputStream("Files/MergeViaSequence.txt");
			while ((j = sis.read()) != -1) {
				System.out.print((char) j);
				fos.write((char)j);
				fos.flush();
			}
			
			
			sis.close();
			fis1.close();
			fis2.close();

		} else
			System.out.println("EITHER FILE OR BOTH DOESNT EXIST");
	}
}
