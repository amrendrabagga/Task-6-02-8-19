package com.file.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MergeData {

	public static void main(String[] args) throws IOException {

		System.out.println("ENTER FOLDER NAME");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String folderName = reader.readLine();
		File folder = new File("Files/" + folderName);

		if (folder.isDirectory()) {
			File[] files = folder.listFiles();// File[] returned in not in order, so we sort them
			StringBuffer sb = new StringBuffer();
			Arrays.sort(files);

			for (File file : files) {
				FileInputStream fis = new FileInputStream(file);
				int size = fis.available();
				byte[] b = new byte[size];
				fis.read(b);
				sb.append(new StringBuffer(new String(b)));
				fis.close();

			}
			// creating file to store merged data
			FileOutputStream fos = new FileOutputStream("Files/datamerge.txt");
			fos.write(sb.toString().getBytes());
			System.out.println(sb);
			System.out.println("MERGED FILES SUCCESSFULLY");
			fos.close();
		} else
			System.out.println("ENTER DIRECTORY NAME");

	}

}
