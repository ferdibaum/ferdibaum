package com.ferdi.game.entity.mob;

import com.ferdi.game.Game;
import com.ferdi.game.entity.projctile.EnemyProjectile;
import com.ferdi.game.entity.projctile.EnemyProjectile2;
import com.ferdi.game.entity.projctile.Projectile;
import com.ferdi.game.graphics.Screen;
import com.ferdi.game.graphics.Sprite;

public class Enemy extends Mob {

	private static final int RATE = 60;

	private Mob p;
	private int playerNum;

	public Enemy(int x, int y, int playerNum) {
		this.x = x;
		this.y = y;

		rateOfFire = RATE;

		this.playerNum = playerNum;
		if (playerNum == 1) p = Game.player;
		else
			p = Game.player2;

		sprite = Sprite.enemy;
		dir = 2;
	}

	public void update() {
		updateShooting();
		clear();
	}

	private void clear() {
		for (int i = 0; i < shoots.size(); i++) {
			if (shoots.get(i).isRemoved()) shoots.remove(i);
		}

	}

	private void updateShooting() {
		rateOfFire--;
		if (rateOfFire <= 0) {
			double dx = p.x - x;
			double dy = p.y - y;
			double dir = Math.atan2(dy, dx);
			shooting(x, y, dir);
		}

		for (int i = 0; i < shoots.size(); i++) {
			shoots.get(i).update();
		}

		for (int i = 0; i < shoots.size(); i++) {
			if (shoots.get(i).getX() < p.x + 20 && shoots.get(i).getX() > p.x - 20 && shoots.get(i).getY() < p.y + 20 && shoots.get(i).getY() > p.y - 20) {
				p.life -= shoots.get(i).getDmg();
				shoots.get(i).remove();
			}
		}

	}

	protected void shooting(int x, int y, double dir) {
		Projectile p;
		if (playerNum == 1) {
			p = new EnemyProjectile(x - Sprite.projectile.SIZE / 2, y - Sprite.projectile.SIZE / 2, dir);
		} else {
			p = new EnemyProjectile2(x - Sprite.projectile.SIZE / 2, y - Sprite.projectile.SIZE / 2, dir);
		}
		shoots.add(p);
		rateOfFire = RATE;
	}

	public void render(Screen screen) {

		screen.renderPlayer(x - sprite.SIZE / 2, y - sprite.SIZE / 2, sprite, 0);

		for (int i = 0; i < shoots.size(); i++) {
			shoots.get(i).render(screen);
		}

	}

}
