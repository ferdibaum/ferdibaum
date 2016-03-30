package com.ferdi.game.level.tile;

import com.ferdi.game.graphics.Screen;
import com.ferdi.game.graphics.Sprite;

public class Tile {

	public int x, y;
	public Sprite sprite;

	//layer1
	public static Tile grass = new UnsolidTile(Sprite.grass);
	public static int grass_col = 0xFF00FF00;

	//layer2
	public static Tile[][] tree = new Tile[3][3];
	public static Tile[][] water = new Tile[3][3];
	public static Tile[][] bridge = new Tile[2][3];
	static {
		tree[0][0] = new UnsolidTile(Sprite.tree00);
		tree[0][1] = new SolidTile(Sprite.tree01);
		tree[0][2] = new UnsolidTile(Sprite.tree02);
		tree[1][0] = new SolidTile(Sprite.tree10);
		tree[1][1] = new SolidTile(Sprite.tree11);
		tree[1][2] = new SolidTile(Sprite.tree12);
		tree[2][0] = new SolidTile(Sprite.tree20);
		tree[2][1] = new SolidTile(Sprite.tree21);
		tree[2][2] = new SolidTile(Sprite.tree22);

		water[0][0] = new SolidTile(Sprite.water00);
		water[0][1] = new SolidTile(Sprite.water01);
		water[0][2] = new SolidTile(Sprite.water02);
		water[1][0] = new SolidTile(Sprite.water10);
		water[1][1] = new SolidTile(Sprite.water11);
		water[1][2] = new SolidTile(Sprite.water12);
		water[2][0] = new SolidTile(Sprite.water20);
		water[2][1] = new SolidTile(Sprite.water21);
		water[2][2] = new SolidTile(Sprite.water22);

		bridge[0][0] = new UnsolidTile(Sprite.bridge00);
		bridge[0][1] = new UnsolidTile(Sprite.bridge01);
		bridge[0][2] = new UnsolidTile(Sprite.bridge02);
		bridge[1][0] = new SolidTile(Sprite.bridge10);
		bridge[1][1] = new SolidTile(Sprite.bridge11);
		bridge[1][2] = new SolidTile(Sprite.bridge12);

	}

	public static Tile[][] rock = new SolidTile[2][2];
	static {
		rock[0][0] = new SolidTile(Sprite.rock00);
		rock[0][1] = new SolidTile(Sprite.rock01);
		rock[1][0] = new SolidTile(Sprite.rock10);
		rock[1][1] = new SolidTile(Sprite.rock11);
	}
	public static int tree_col00 = 0xFF00FF00;
	public static int tree_col01 = 0xFF00FF01;
	public static int tree_col02 = 0xFF00FF02;
	public static int tree_col10 = 0xFF00FF10;
	public static int tree_col11 = 0xFF00FF11;
	public static int tree_col12 = 0xFF00FF12;
	public static int tree_col20 = 0xFF00FF20;
	public static int tree_col21 = 0xFF00FF21;
	public static int tree_col22 = 0xFF00FF22;

	public static int water_col00 = 0xFF00F000;
	public static int water_col01 = 0xFF00F001;
	public static int water_col02 = 0xFF00F002;
	public static int water_col10 = 0xFF00F010;
	public static int water_col11 = 0xFF00F011;
	public static int water_col12 = 0xFF00F012;
	public static int water_col20 = 0xFF00F020;
	public static int water_col21 = 0xFF00F021;
	public static int water_col22 = 0xFF00F022;

	public static int bridge_col00 = 0xFF555500;
	public static int bridge_col01 = 0xFF555501;
	public static int bridge_col02 = 0xFF555502;
	public static int bridge_col10 = 0xFF555510;
	public static int bridge_col11 = 0xFF555511;
	public static int bridge_col12 = 0xFF555512;

	public static int rock_col00 = 0xFFFFFF00;
	public static int rock_col01 = 0xFFFFFF01;
	public static int rock_col10 = 0xFFFFFF10;
	public static int rock_col11 = 0xFFFFFF11;

	//layer3

	//void
	public static Tile voidTile = new VoidTile(Sprite.voidSprite);
	public static Tile blankTile = new VoidTile(Sprite.blankSprite);

	public static Tile blankSolidTile = new SolidTile(Sprite.blankSprite);
	public static int blanksolid_col = 0xFFFF00FF;

	public Tile(Sprite sprite) {
		this.sprite = sprite;
	}

	public void render(int x, int y, Screen screen) {
	}

	public boolean solid() {
		return false;
	}
}
