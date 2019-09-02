package com.file.io;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;

public class SaveEmployee {

	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("ENTER ENO ");
		int eno = Integer.parseInt(reader.readLine());
		System.out.print("ENTER ENAME ");
		String ename = reader.readLine();
		System.out.print("ENTER SALARY ");
		int sal = Integer.parseInt(reader.readLine());
		System.out.print("ENTER DESIGNATION ");
		String desg = reader.readLine();
		System.out.print("ENTER DEPARTMENT ");
		String dept = reader.readLine();

		Employee employee = new Employee();
		employee.setEno(eno);
		employee.setEname(ename);
		employee.setSal(sal);
		employee.setDesg(desg);
		employee.setDept(dept);

		FileOutputStream fos = new FileOutputStream("Files/EmployeeState.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(employee);
		System.out.println("EMPLOYEE STATE SAVED");

		reader.close();
		oos.close();
		fos.close();

	}

}
