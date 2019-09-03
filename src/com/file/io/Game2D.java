package com.file.io;

import java.io.Serializable;

public class Game2D implements Serializable {

	private static final long serialVersionUID = 1L;
	private int xPos;
	private int yPos;

	public int getxPos() {
		return xPos;
	}

	public int getyPos() {
		return yPos;
	}

	public void moveX(int x) {
		xPos += x;
	}

	public void moveY(int y) {
		yPos += y;
	}

}
