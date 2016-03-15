package com.ferdi.game.entity.projctile;

import com.ferdi.game.entity.Entity;
import com.ferdi.game.graphics.Sprite;

public abstract class Projectile extends Entity{
	
	final protected int xOrigin, yOrigin;
	protected double angle;
	protected Sprite sprite;
	protected double nx, ny;
	protected int range, dmg, rateOfFire, speed;
	
	public Projectile(int x, int y, double dir){
		xOrigin = x;
		yOrigin = y;
		angle = dir;
	}

}
