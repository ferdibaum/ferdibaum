package com.ferdi.game.graphics;

public class Sprite {

	public final int SIZE;
	private int x, y;
	public int[] pixels;
	private SpriteSheet sheet;

	//layer 1
	public static Sprite grass = new Sprite(32, 22, 5, SpriteSheet.tiles_32);

	//layer 2
	public static Sprite tree00 = new Sprite(32, 24, 15, SpriteSheet.tiles_32);
	public static Sprite tree01 = new Sprite(32, 25, 15, SpriteSheet.tiles_32);
	public static Sprite tree02 = new Sprite(32, 26, 15, SpriteSheet.tiles_32);
	public static Sprite tree10 = new Sprite(32, 24, 16, SpriteSheet.tiles_32);
	public static Sprite tree11 = new Sprite(32, 25, 16, SpriteSheet.tiles_32);
	public static Sprite tree12 = new Sprite(32, 26, 16, SpriteSheet.tiles_32);
	public static Sprite tree20 = new Sprite(32, 24, 17, SpriteSheet.tiles_32);
	public static Sprite tree21 = new Sprite(32, 25, 17, SpriteSheet.tiles_32);
	public static Sprite tree22 = new Sprite(32, 26, 17, SpriteSheet.tiles_32);

	public static Sprite water00 = new Sprite(32, 6, 11, SpriteSheet.tiles_32);
	public static Sprite water01 = new Sprite(32, 7, 11, SpriteSheet.tiles_32);
	public static Sprite water02 = new Sprite(32, 8, 11, SpriteSheet.tiles_32);
	public static Sprite water10 = new Sprite(32, 6, 12, SpriteSheet.tiles_32);
	public static Sprite water11 = new Sprite(32, 7, 12, SpriteSheet.tiles_32);
	public static Sprite water12 = new Sprite(32, 8, 12, SpriteSheet.tiles_32);
	public static Sprite water20 = new Sprite(32, 6, 13, SpriteSheet.tiles_32);
	public static Sprite water21 = new Sprite(32, 7, 13, SpriteSheet.tiles_32);
	public static Sprite water22 = new Sprite(32, 8, 13, SpriteSheet.tiles_32);

	public static Sprite bridge00 = new Sprite(32, 13, 16, SpriteSheet.tiles_32);
	public static Sprite bridge01 = new Sprite(32, 14, 16, SpriteSheet.tiles_32);
	public static Sprite bridge02 = new Sprite(32, 15, 16, SpriteSheet.tiles_32);
	public static Sprite bridge10 = new Sprite(32, 13, 17, SpriteSheet.tiles_32);
	public static Sprite bridge11 = new Sprite(32, 14, 17, SpriteSheet.tiles_32);
	public static Sprite bridge12 = new Sprite(32, 15, 17, SpriteSheet.tiles_32);

	public static Sprite rock00 = new Sprite(32, 18, 12, SpriteSheet.tiles_32);
	public static Sprite rock01 = new Sprite(32, 19, 12, SpriteSheet.tiles_32);
	public static Sprite rock10 = new Sprite(32, 18, 13, SpriteSheet.tiles_32);
	public static Sprite rock11 = new Sprite(32, 19, 13, SpriteSheet.tiles_32);

	//layer 3

	//player
	public static Sprite playerRight0 = new Sprite(32, 1, 2, SpriteSheet.tiles_player);
	public static Sprite playerRight1 = new Sprite(32, 0, 2, SpriteSheet.tiles_player);
	public static Sprite playerRight2 = new Sprite(32, 2, 2, SpriteSheet.tiles_player);

	public static Sprite playerLeft0 = new Sprite(32, 1, 1, SpriteSheet.tiles_player);
	public static Sprite playerLeft1 = new Sprite(32, 0, 1, SpriteSheet.tiles_player);
	public static Sprite playerLeft2 = new Sprite(32, 2, 1, SpriteSheet.tiles_player);

	public static Sprite playerUp0 = new Sprite(32, 1, 3, SpriteSheet.tiles_player);
	public static Sprite playerUp1 = new Sprite(32, 0, 3, SpriteSheet.tiles_player);
	public static Sprite playerUp2 = new Sprite(32, 2, 3, SpriteSheet.tiles_player);

	public static Sprite playerDown0 = new Sprite(32, 1, 0, SpriteSheet.tiles_player);
	public static Sprite playerDown1 = new Sprite(32, 0, 0, SpriteSheet.tiles_player);
	public static Sprite playerDown2 = new Sprite(32, 2, 0, SpriteSheet.tiles_player);

	public static Sprite player2Right0 = new Sprite(32, 1, 2, SpriteSheet.tiles_player2);
	public static Sprite player2Right1 = new Sprite(32, 0, 2, SpriteSheet.tiles_player2);
	public static Sprite player2Right2 = new Sprite(32, 2, 2, SpriteSheet.tiles_player2);

	public static Sprite player2Left0 = new Sprite(32, 1, 1, SpriteSheet.tiles_player2);
	public static Sprite player2Left1 = new Sprite(32, 0, 1, SpriteSheet.tiles_player2);
	public static Sprite player2Left2 = new Sprite(32, 2, 1, SpriteSheet.tiles_player2);

	public static Sprite player2Up0 = new Sprite(32, 1, 3, SpriteSheet.tiles_player2);
	public static Sprite player2Up1 = new Sprite(32, 0, 3, SpriteSheet.tiles_player2);
	public static Sprite player2Up2 = new Sprite(32, 2, 3, SpriteSheet.tiles_player2);

	public static Sprite player2Down0 = new Sprite(32, 1, 0, SpriteSheet.tiles_player2);
	public static Sprite player2Down1 = new Sprite(32, 0, 0, SpriteSheet.tiles_player2);
	public static Sprite player2Down2 = new Sprite(32, 2, 0, SpriteSheet.tiles_player2);

	public static Sprite enemy = new Sprite(32, 1, 0, SpriteSheet.enemy);

	public static Sprite projectile = new Sprite(16, 7, 0, SpriteSheet.tiles);
	public static Sprite projectile2 = new Sprite(16, 6, 0, SpriteSheet.tiles);
	public static Sprite projectileEnemy = new Sprite(16, 1, 0, SpriteSheet.tiles);
	public static Sprite projectileEnemy2 = new Sprite(16, 2, 0, SpriteSheet.tiles);

	public static Sprite voidSprite = new Sprite(32, 0x1B87E0);
	public static Sprite blankSprite = new Sprite(32, 0xFFFF00FF);

	public Sprite(int size, int x, int y, SpriteSheet sheet) {
		SIZE = size;
		this.x = x * SIZE;
		this.y = y * SIZE;
		this.sheet = sheet;
		pixels = new int[SIZE * SIZE];
		load();
	}

	public Sprite(int size, int colour) {
		SIZE = size;
		pixels = new int[SIZE * SIZE];
		setColour(colour);
	}

	private void setColour(int colour) {
		for (int i = 0; i < SIZE * SIZE; i++) {
			pixels[i] = colour;
		}

	}

	private void load() {
		for (int y = 0; y < SIZE; y++) {
			for (int x = 0; x < SIZE; x++) {
				pixels[x + y * SIZE] = sheet.pixels[(x + this.x + sheet.gap * this.x / SIZE) + (y + this.y + sheet.gap * this.y / SIZE) * sheet.width];
			}
		}
	}
}
