package com.file.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class PlayGame {

	public static void main(String[] args) throws IOException, ClassNotFoundException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("1.PLAY GAME 2.RESUME TO PREVIOUS GAME");
		int choice = Integer.parseInt(reader.readLine());
		System.out.print("MOVE X ");
		int x = Integer.parseInt(reader.readLine());
		System.out.print("MOVE Y ");
		int y = Integer.parseInt(reader.readLine());
		System.out.print("MOVE Z ");
		int z = Integer.parseInt(reader.readLine());

		if (choice == 1) {
			Game game = new Game();
			game.moveX(x);
			game.moveY(y);
			game.moveZ(z);

			FileOutputStream fos = new FileOutputStream("Files/GameState.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(game);
			System.out.println("Position of x,y,z are " + game.getxPos() + ", " + game.getyPos() + ", " + game.getzPos());
			oos.close();
			fos.close();

		} else {
			// reading object for previous position
			File file = new File("Files/GameState.txt");
			
			if (file.exists() && file.length() != 0) {
				FileInputStream fis = new FileInputStream(file);
				ObjectInputStream ois = new ObjectInputStream(fis);
				Game game = (Game) ois.readObject();
				game.moveX(x);
				game.moveY(y);
				game.moveZ(z);
				System.out.println("Position of x,y,z are " + game.getxPos() + ", " + game.getyPos() + ", " + game.getzPos());
				ois.close();
				fis.close();
			} else
				System.out.println("PLAY AGAIN");
		}
	}
}
