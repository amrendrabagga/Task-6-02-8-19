package com.file.io;

public class Game3D extends Game2D {

	private static final long serialVersionUID = 1L;
	private int zPos;

	public int getzPos() {
		return zPos;
	}

	public void moveZ(int z) {
		zPos += z;
	}

}
