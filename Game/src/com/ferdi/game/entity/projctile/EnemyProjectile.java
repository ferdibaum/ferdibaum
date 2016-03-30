package com.ferdi.game.entity.projctile;

import com.ferdi.game.graphics.Screen;
import com.ferdi.game.graphics.Sprite;

public class EnemyProjectile extends Projectile {

	public EnemyProjectile(int x, int y, double dir) {
		super(x, y, dir);
		range = 350;
		dmg = 2;
		speed = 4;
		sprite = Sprite.projectileEnemy;

		nx = speed * Math.cos(angle);
		ny = speed * Math.sin(angle);
	}

	public void update() {
		move();
	}

	protected void move() {
		x += nx;
		y += ny;

		if (distance() > range) remove();
	}

	public void render(Screen screen) {
		screen.renderTile((int) x, (int) y, sprite);
	}
}
