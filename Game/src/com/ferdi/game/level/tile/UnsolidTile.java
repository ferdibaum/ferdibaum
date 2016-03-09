package com.ferdi.game.level.tile;

import com.ferdi.game.graphics.Screen;
import com.ferdi.game.graphics.Sprite;

public class UnsolidTile extends Tile {

	public UnsolidTile(Sprite sprite) {
		super(sprite);	}
	
	public void render(int x, int y, Screen screen){
		screen.renderTile(x << 5, y << 5, this);
	}

}
