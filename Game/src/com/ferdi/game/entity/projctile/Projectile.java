package com.ferdi.game.entity.projctile;

import com.ferdi.game.entity.Entity;
import com.ferdi.game.graphics.Sprite;

public abstract class Projectile extends Entity {

	protected final int xOrigin, yOrigin;
	protected double angle;
	protected Sprite sprite;
	protected double x;
	protected double y;
	protected double nx, ny;
	protected int range, dmg, speed;

	public Projectile(int x, int y, double dir) {
		xOrigin = x;
		yOrigin = y;
		angle = dir;
		this.x = x;
		this.y = y;
	}

	protected void move() {

	}

	public double distance() {
		double dist = 0;
		dist = Math.sqrt(Math.abs((xOrigin - x) * (xOrigin - x)) + Math.abs((yOrigin - y) * (yOrigin - y)));
		return dist;
	}

	public int getDmg() {
		return dmg;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

}
