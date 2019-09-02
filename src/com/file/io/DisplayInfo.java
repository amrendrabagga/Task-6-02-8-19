package com.file.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DisplayInfo {

	public static void main(String[] args) throws IOException, ClassNotFoundException {

		File file = new File("Files/EmployeeState.txt");

		if (file.exists()) {
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			Employee employee = (Employee) ois.readObject();
			System.out.println("EMPLOYEE DETAILS ARE");
			System.out.println(employee);
			ois.close();
			fis.close();
		} else
			System.out.println("FILE DOESNT EXIST");

	}

}
