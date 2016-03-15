package com.ferdi.game.entity.projctile;

public class PlayerProjectile extends Projectile {

	public PlayerProjectile(int x, int y, double dir) {
		super(x, y, dir);
		range = 200;
		dmg = 20;
		speed = 4;
		rateOfFire = 15;
		
		nx  =speed  *Math.cos(angle);
		ny  =speed * Math.sin(angle);
	}
	
	public void update(){
		move();
	}
	
	protected void move(){
		x += nx;
		y += ny;
	}

}
