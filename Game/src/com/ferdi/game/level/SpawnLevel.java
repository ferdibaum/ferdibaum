package com.ferdi.game.level;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpawnLevel extends Level {

	public SpawnLevel(String path1, String path2, String path3) {
		super(path1, path2, path3);
	}

	protected void loadLevel(String path1, String path2, String path3) {
		try {
			BufferedImage image = ImageIO.read(SpawnLevel.class.getResource(path1));
			int w = width = image.getWidth();
			int h = height = image.getHeight();
			pixels0 = new int[w * h];
			image.getRGB(0, 0, w, h, pixels0, 0, w);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Exception! Could not load level file!");
		}
		try {
			BufferedImage image = ImageIO.read(SpawnLevel.class.getResource(path2));
			int w  = image.getWidth();
			int h  = image.getHeight();
			pixels1 = new int[w * h];
			image.getRGB(0, 0, w, h, pixels1, 0, w);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Exception! Could not load level file!");
		}
		try {
			BufferedImage image = ImageIO.read(SpawnLevel.class.getResource(path3));
			int w  = image.getWidth();
			int h  = image.getHeight();
			pixels2 = new int[w * h];
			image.getRGB(0, 0, w, h, pixels2, 0, w);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Exception! Could not load level file!");
		}
	}


	protected void genarateLevel() {
	}

}
