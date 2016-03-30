package com.ferdi.game.entity.mob;

import java.util.ArrayList;
import java.util.List;

import com.ferdi.game.entity.Entity;
import com.ferdi.game.entity.projctile.Projectile;
import com.ferdi.game.graphics.Sprite;
import com.ferdi.game.level.tile.Tile;

public abstract class Mob extends Entity {

	protected Sprite sprite;
	protected int dir;
	protected int speed;
	protected boolean moving = false;
	protected int rateOfFire;
	protected int life;

	public List<Projectile> shoots = new ArrayList<Projectile>();

	public void move(int xa, int ya) {
		if (xa != 0 && ya != 0) {
			move(xa, 0);
			move(0, ya);
			return;
		}
		if (xa > 0) dir = 1;
		if (xa < 0) dir = 3;
		if (ya > 0) dir = 2;
		if (ya < 0) dir = 0;

		if (!collision(xa, ya)) {
			x += speed * xa;
			y += speed * ya;
		}
	}

	public void update() {
	}

	protected void shooting(int x, int y, double dir) {
	}

	public void render() {
	}

	protected boolean collision(int xa, int ya) {
		boolean solid = false;

		for (int c = 0; c < 4; c++) {
			int xt = ((x + xa) + c % 2 - 2) / 32;
			int yt = ((y + ya) + c / 2 + 8) / 32;
			if (level.getTile2(xt, yt).equals(Tile.blankTile) && level.getTile1(xt, yt).solid()) solid = true;
			else if (level.getTile1(xt, yt).solid() && level.getTile2(xt, yt).solid()) solid = true;
			else if (level.getTile1(xt, yt).solid() && !level.getTile2(xt, yt).solid()) solid = false;
		}

		return solid;
	}
	
	public int getRate(){
		return rateOfFire;
	}
	
	public int getLife(){
		return life;
	}
	
	public void setLife(int life){
		this.life = life;
	}
	
	public void reset(int x, int y, int life){
		this.x = x;
		this.y = y;
		this.life = life;
		
		dir = 2;
		
		for(int i = 0; i < shoots.size(); i++){
			shoots.get(i).remove();
			shoots.remove(i);
		}
		
	}
}
