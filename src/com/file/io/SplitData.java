package com.file.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SplitData {

	public static void main(String[] args) throws IOException {

		System.out.println("ENTER FILE NAME AND SPLIT NUMBER");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String f1 = reader.readLine();
		int n = Integer.parseInt(reader.readLine());
		File file = new File("Files/" + f1);

		if (file.exists()) {
			FileInputStream fis = new FileInputStream(file);
			int size = fis.available();
			byte[] b = new byte[size];
			fis.read(b);
			String fileRead = new String(b);

			ArrayList<String> list = new ArrayList<>(n);
			int split = fileRead.length() / n;
			int start = 0;
			int end = split;

			for (int j = 0; j < n - 1; j++) {
				list.add(fileRead.substring(start, end));
				start = end;
				end += split;
			}

			String last = fileRead.substring(start, fileRead.length());
			list.add(last);
			fis.close();

			String commonFile = f1.substring(0, f1.lastIndexOf('.'));
			File folder = new File("Files/datasplit");

			boolean folderCreated = folder.mkdir();
			if (folderCreated) {
				for (int i = 1; i <= n; i++) {
					String newFile = commonFile + i + ".txt";
					FileOutputStream fos = new FileOutputStream(folder.getAbsolutePath() + "/" + newFile);
					fos.write(list.get(i - 1).getBytes());
					fos.close();
				}
				System.out.println("FILE SUCCESSFULLY SPLITTED");

			} else {
				// deleting files if folder already exist

				folder.delete();
				File newFolder = new File("Files/datasplit");

				newFolder.mkdir();

				for (int i = 1; i <= n; i++) {
					String newFile = commonFile + i + ".txt";
					FileOutputStream fos = new FileOutputStream(folder.getAbsolutePath() + "/" + newFile);
					fos.write(list.get(i - 1).getBytes());
					fos.close();
				}
				System.out.println("FILE SUCCESSFULLY SPLITTED");

			}

		} else
			System.out.println("FILE NOT FOUND");

	}

}
