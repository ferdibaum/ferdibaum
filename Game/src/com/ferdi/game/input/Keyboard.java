package com.ferdi.game.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener {

	private boolean[] keys = new boolean[1024];
	public boolean up, down, left, right, space, w, a, s, d, enter, back;

	public void update() {
		up = keys[KeyEvent.VK_UP];
		left = keys[KeyEvent.VK_LEFT];
		down = keys[KeyEvent.VK_DOWN];
		right = keys[KeyEvent.VK_RIGHT];
		w = keys[KeyEvent.VK_W];
		a = keys[KeyEvent.VK_A];
		s = keys[KeyEvent.VK_S];
		d = keys[KeyEvent.VK_D];
		enter = keys[KeyEvent.VK_ENTER];
		back = keys[KeyEvent.VK_BACK_SPACE];
		space = keys[KeyEvent.VK_SPACE];
	}

	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
	}

	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}

	public void keyTyped(KeyEvent e) {

	}

}
