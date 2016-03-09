package com.ferdi.game.level.tile;

public class TileCoordinate {
	
	public int x, y;
	private final int TILE_SIZE = 32;
	
	public TileCoordinate(int x, int y){
		this.x = x * TILE_SIZE;
		this.y = y * TILE_SIZE;
	}
	
}
