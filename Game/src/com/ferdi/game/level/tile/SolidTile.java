package com.ferdi.game.level.tile;

import com.ferdi.game.graphics.Screen;
import com.ferdi.game.graphics.Sprite;

public class SolidTile extends Tile {

	public SolidTile(Sprite sprite) {
		super(sprite);
	}

	public void render(int x, int y, Screen screen){
		screen.renderTile(x << 5, y << 5, this);
	}
	
	public boolean solid(){
		return true;
	}
}
