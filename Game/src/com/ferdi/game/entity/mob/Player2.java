package com.ferdi.game.entity.mob;

import com.ferdi.game.Game;
import com.ferdi.game.entity.projctile.PlayerProjectile;
import com.ferdi.game.graphics.Screen;
import com.ferdi.game.graphics.Sprite;
import com.ferdi.game.input.Keyboard;
import com.ferdi.game.input.Mouse;

public class Player2 extends Mob {

	private static final int RATE = 15;
	private static final int SPEED = 2;

	private Keyboard input;
	private int anim = 0;

	private boolean shooting = false;
	public String name;

	public Player2(int x, int y, Keyboard input, String name) {
		this.x = x;
		this.y = y;
		this.input = input;
		this.name = name;

		rateOfFire = RATE;
		speed = SPEED;

		sprite = Sprite.player2Down0;
		dir = 2;
		life = 100;
	}

	public void update() {
		int xa = 0, ya = 0;
		if (anim < 7500) anim++;
		else
			anim = 0;
		if (input.w) ya--;
		if (input.s) ya++;
		if (input.a) xa--;
		if (input.d) xa++;

		updateShooting();
		clear();

		if (xa != 0 || ya != 0) {
			move(xa, ya);
			moving = true;
		} else {
			moving = false;
		}
		if (shooting) speed = 1;
		else
			speed = 2;
	}

	private void clear() {
		for (int i = 0; i < shoots.size(); i++) {
			if (shoots.get(i).isRemoved()) shoots.remove(i);
		}

	}

	private void updateShooting() {
		rateOfFire--;
		if (Mouse.mouseB() == 2) {
			shooting = true;
			if (rateOfFire <= 0) {
				double dx = Mouse.mouseX() - Game.getWinWidth() / 2;
				double dy = Mouse.mouseY() - Game.getWinHeight() / 2;
				double dir = Math.atan2(dy, dx);
				shooting(x, y, dir);
			}
		} else if (input.space) {
			shooting = true;
			if (rateOfFire <= 0) {
				double dir = 0;
				if (this.dir == 0) dir = 3 * Math.PI / 2;
				else if (this.dir == 1) dir = 0;
				else if (this.dir == 2) dir = Math.PI / 2;
				else if (this.dir == 3) dir = Math.PI;
				shooting(x, y, dir);
			}
		} else
			shooting = false;

		for (int i = 0; i < shoots.size(); i++) {
			shoots.get(i).update();
		}

		for (int i = 0; i < shoots.size(); i++) {
			if (shoots.get(i).getX() < Game.player.x + 20 && shoots.get(i).getX() > Game.player.x - 20 && shoots.get(i).getY() < Game.player.y + 20 && shoots.get(i).getY() > Game.player.y - 20) {
				Game.player.life -= shoots.get(i).getDmg();
				shoots.get(i).remove();
			}
		}
	}

	protected void shooting(int x, int y, double dir) {
		PlayerProjectile p = new PlayerProjectile(x - Sprite.projectile.SIZE / 2, y - Sprite.projectile.SIZE / 2, dir);
		shoots.add(p);
		rateOfFire = RATE;
	}

	public void render(Screen screen) {

		if (dir == 0) {
			sprite = Sprite.player2Up0;
			if (moving) {
				if (anim % 20 > 10) {
					sprite = Sprite.player2Up1;
				} else {
					sprite = Sprite.player2Up2;
				}
			}

		}
		if (dir == 1) {
			sprite = Sprite.player2Right0;
			if (moving) {
				if (anim % 20 > 10) {
					sprite = Sprite.player2Right1;
				} else {
					sprite = Sprite.player2Right2;
				}
			}
		}
		if (dir == 2) {
			sprite = Sprite.player2Down0;
			if (moving) {
				if (anim % 20 > 10) {
					sprite = Sprite.player2Down1;
				} else {
					sprite = Sprite.player2Down2;
				}
			}
		}
		if (dir == 3) {
			sprite = Sprite.player2Left0;
			if (moving) {
				if (anim % 20 > 10) {
					sprite = Sprite.player2Left1;
				} else {
					sprite = Sprite.player2Left2;
				}
			}
		}
		screen.renderPlayer(x - sprite.SIZE / 2, y - sprite.SIZE / 2, sprite, 0);

		for (int i = 0; i < shoots.size(); i++) {
			shoots.get(i).render(screen);
		}

	}

}
