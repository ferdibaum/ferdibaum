package com.ferdi.game.entity.mob;

import com.ferdi.game.graphics.Screen;
import com.ferdi.game.graphics.Sprite;
import com.ferdi.game.input.Keyboard;

public class Player extends Mob {

	private Keyboard input;
	private int anim = 0;
	private Sprite[] right = new Sprite[6];
	private Sprite[] up = new Sprite[6];
	private Sprite[] left = new Sprite[6];
	private Sprite[] down = new Sprite[6];
	int counter=0;

	public Player(Keyboard input) {
		this.input = input;
		
		right[0] = Sprite.playerXRight0;
		right[1] = Sprite.playerXRight1;
		right[2] = Sprite.playerXRight2;
		right[3] = Sprite.playerXRight3;
		right[4] = Sprite.playerXRight4;
		right[5] = Sprite.playerXRight5;
		
		left[0] = Sprite.playerXLeft0;
		left[1] = Sprite.playerXLeft1;
		left[2] = Sprite.playerXLeft2;
		left[3] = Sprite.playerXLeft3;
		left[4] = Sprite.playerXLeft4;
		left[5] = Sprite.playerXLeft5;
		
		up[0] = Sprite.playerXUp0;
		up[1] = Sprite.playerXUp1;
		up[2] = Sprite.playerXUp2;
		up[3] = Sprite.playerXUp3;
		up[4] = Sprite.playerXUp4;
		up[5] = Sprite.playerXUp5;
		
		down[0] = Sprite.playerXDown0;
		down[1] = Sprite.playerXDown1;
		down[2] = Sprite.playerXDown2;
		down[3] = Sprite.playerXDown3;
		down[4] = Sprite.playerXDown4;
		down[5] = Sprite.playerXDown5;
		
		sprite = Sprite.playerDown0;
		dir = 2;
	}

	public Player(int x, int y, Keyboard input) {
		this.x = x;
		this.y = y;
		this.input = input;
		
		right[0] = Sprite.playerXRight0;
		right[1] = Sprite.playerXRight1;
		right[2] = Sprite.playerXRight2;
		right[3] = Sprite.playerXRight3;
		right[4] = Sprite.playerXRight4;
		right[5] = Sprite.playerXRight5;
		
		left[0] = Sprite.playerXLeft0;
		left[1] = Sprite.playerXLeft1;
		left[2] = Sprite.playerXLeft2;
		left[3] = Sprite.playerXLeft3;
		left[4] = Sprite.playerXLeft4;
		left[5] = Sprite.playerXLeft5;
		
		up[0] = Sprite.playerXUp0;
		up[1] = Sprite.playerXUp1;
		up[2] = Sprite.playerXUp2;
		up[3] = Sprite.playerXUp3;
		up[4] = Sprite.playerXUp4;
		up[5] = Sprite.playerXUp5;
		
		down[0] = Sprite.playerXDown0;
		down[1] = Sprite.playerXDown1;
		down[2] = Sprite.playerXDown2;
		down[3] = Sprite.playerXDown3;
		down[4] = Sprite.playerXDown4;
		down[5] = Sprite.playerXDown5;
		
		sprite = Sprite.playerDown0;
		dir = 2;
	}

	public void update() {
		int xa = 0, ya = 0;
		if (anim < 7500) anim++;
		else
			anim = 0;
		if (input.up) ya--;
		if (input.down) ya++;
		if (input.left) xa--;
		if (input.right) xa++;

		if (xa != 0 || ya != 0) {
			move(xa, ya);
			moving = true;
		} else {
			moving = false;
		}
	}

	public void render(Screen screen) {
		if (dir == 0) {
			sprite = Sprite.playerUp0;
			if (moving) {
				if (anim % 20 > 10 ) {
					sprite = Sprite.playerUp1;
				} else {
					sprite = Sprite.playerUp2;
				}
			}
			
		}
		if (dir == 1) {
			sprite = Sprite.playerRight0;
			if (moving) {
				if (anim % 20 > 10 ) {
					sprite = Sprite.playerRight1;
				} else {
					sprite = Sprite.playerRight2;
				}
			}
		}
		if (dir == 2) {
			sprite = Sprite.playerDown0;
			if (moving) {
				if (anim % 20 > 10) {
					sprite = Sprite.playerDown1;
				} else {
					sprite = Sprite.playerDown2;
				}
			}
		}
		if (dir == 3) {
			sprite = Sprite.playerLeft0;
			if (moving) {
				if (anim % 20 > 10) {
					sprite = Sprite.playerLeft1;
				} else {
					sprite = Sprite.playerLeft2;
				}
			}
		}
		screen.renderPlayer(x - sprite.SIZE / 2, y - sprite.SIZE / 2, sprite, 0);
	}

}
