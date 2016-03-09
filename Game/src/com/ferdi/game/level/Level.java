package com.ferdi.game.level;

import com.ferdi.game.graphics.Screen;
import com.ferdi.game.level.tile.Tile;

public class Level {

	protected int width, height;
	protected int[] tilesInt;
	protected int[] pixels0;
	protected int[] pixels1;
	protected int[] pixels2;

	public Level(int width, int height) {
		this.width = width;
		this.height = height;
		tilesInt = new int[width * height];
		genarateLevel();
	}

	public Level(String path1, String path2, String path3) {
		loadLevel(path1, path2, path3);
		genarateLevel();
	}

	protected void genarateLevel() {
	}

	protected void loadLevel(String path, String path2, String path3) {

	}

	public void update() {

	}

	public void render(int xScroll, int yScroll, Screen screen) {
		screen.setOffset(xScroll, yScroll);
		int x0 = xScroll >> 5;
		int x1 = (xScroll + screen.width + Tile.voidTile.sprite.SIZE) >> 5;
		int y0 = yScroll >> 5;
		int y1 = (yScroll + screen.height + Tile.voidTile.sprite.SIZE) >> 5;

		for (int y = y0; y < y1; y++) {
			for (int x = x0; x < x1; x++) {
				getTile0(x, y).render(x, y, screen);
				getTile1(x, y).render(x, y, screen);
				getTile2(x, y).render(x, y, screen);
			}
		}
	}

	public Tile getTile0(int x, int y) {
		if (x < 0 || y < 0 || x >= width || y >= height) return Tile.voidTile;
		if (pixels0[x + y * width] == Tile.grass_col) return Tile.grass;
		else
			return Tile.voidTile;
	}

	public Tile getTile1(int x, int y) {
		if (x < 0 || y < 0 || x >= width || y >= height) return Tile.voidTile;
		if (pixels1[x + y * width] == Tile.tree_col00) return Tile.tree[0][0];
		if (pixels1[x + y * width] == Tile.tree_col01) return Tile.tree[0][1];
		if (pixels1[x + y * width] == Tile.tree_col02) return Tile.tree[0][2];
		if (pixels1[x + y * width] == Tile.tree_col10) return Tile.tree[1][0];
		if (pixels1[x + y * width] == Tile.tree_col11) return Tile.tree[1][1];
		if (pixels1[x + y * width] == Tile.tree_col12) return Tile.tree[1][2];
		if (pixels1[x + y * width] == Tile.tree_col20) return Tile.tree[2][0];
		if (pixels1[x + y * width] == Tile.tree_col21) return Tile.tree[2][1];
		if (pixels1[x + y * width] == Tile.tree_col22) return Tile.tree[2][2];
		
		if (pixels1[x + y * width] == Tile.water_col00) return Tile.water[0][0];
		if (pixels1[x + y * width] == Tile.water_col01) return Tile.water[0][1];
		if (pixels1[x + y * width] == Tile.water_col02) return Tile.water[0][2];
		if (pixels1[x + y * width] == Tile.water_col10) return Tile.water[1][0];
		if (pixels1[x + y * width] == Tile.water_col11) return Tile.water[1][1];
		if (pixels1[x + y * width] == Tile.water_col12) return Tile.water[1][2];
		if (pixels1[x + y * width] == Tile.water_col20) return Tile.water[2][0];
		if (pixels1[x + y * width] == Tile.water_col21) return Tile.water[2][1];
		if (pixels1[x + y * width] == Tile.water_col22) return Tile.water[2][2];
		
		if (pixels1[x + y * width] == Tile.rock_col00) return Tile.rock[0][0];
		if (pixels1[x + y * width] == Tile.rock_col01) return Tile.rock[0][1];
		if (pixels1[x + y * width] == Tile.rock_col10) return Tile.rock[1][0];
		if (pixels1[x + y * width] == Tile.rock_col11) return Tile.rock[1][1];
		
		if (pixels1[x + y * width] == Tile.blanksolid_col) return Tile.blankSolidTile;
		else
			return Tile.blankTile;
	}

	public Tile getTile2(int x, int y) {
		if (x < 0 || y < 0 || x >= width || y >= height) return Tile.voidTile;
		if (pixels2[x + y * width] == Tile.bridge_col00) return Tile.bridge[0][0];
		if (pixels2[x + y * width] == Tile.bridge_col01) return Tile.bridge[0][1];
		if (pixels2[x + y * width] == Tile.bridge_col02) return Tile.bridge[0][2];
		if (pixels2[x + y * width] == Tile.bridge_col10) return Tile.bridge[1][0];
		if (pixels2[x + y * width] == Tile.bridge_col11) return Tile.bridge[1][1];
		if (pixels2[x + y * width] == Tile.bridge_col12) return Tile.bridge[1][2];
		else
			return Tile.blankTile;
	}
}
