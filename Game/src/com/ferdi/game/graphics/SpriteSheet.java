package com.ferdi.game.graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteSheet {
	
	private String path;
	public int width, height;
	public int[] pixels;
	public int gap;
	
	public static SpriteSheet tiles = new SpriteSheet("/textures/spritesheet.png", 0);
	public static SpriteSheet tiles_map = new SpriteSheet("/textures/spritesheet_big.png", 1);
	public static SpriteSheet tiles_player = new SpriteSheet("/textures/player.png", 0);
	public static SpriteSheet tiles_32 = new SpriteSheet("/textures/tileset32.png", 0);
	
	public SpriteSheet(String path, int gap){
		this.path = path;
		this.gap = gap;
		load();
	}
	
	private void load() {
		try {
			BufferedImage image = ImageIO.read(SpriteSheet.class.getResource(path));
			int w = width = image.getWidth();
			int h = height =image.getHeight();
			pixels = new int[w *h];
			image.getRGB(0, 0, w, h, pixels, 0, w);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
