package com.file.io;

import java.io.Serializable;

public class Game implements Serializable {

	private int xPos;
	private int yPos;
	private int zPos;

	public int getxPos() {
		return xPos;
	}

	public int getyPos() {
		return yPos;
	}

	public int getzPos() {
		return zPos;
	}

	public void moveX(int x) {
		xPos += x;
	}

	public void moveY(int y) {
		yPos += y;
	}

	public void moveZ(int z) {
		zPos += z;
	}

}
