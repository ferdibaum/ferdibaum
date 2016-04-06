package com.ferdi.game;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.WindowEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

import com.ferdi.game.input.Keyboard;

public class MainMenu extends Canvas implements Runnable {
	private static final long serialVersionUID = 1L;

	public static String title = "FerdiGame";

	private static int width = 500;
	private static int height = width / 16 * 9;
	private static int scale = 2;

	private Thread thread;

	private static final Keyboard key = new Keyboard();

	private boolean running = false;

	private static Game game;
	private JFrame frame;

	private BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	
	public MainMenu(){
		Dimension size = new Dimension(width * scale, height * scale);
		setPreferredSize(size);
		
		addKeyListener(key);
		
		frame = new JFrame();
	}

	public static void main(String[] args) {
		
		MainMenu menu= new MainMenu();
		menu.frame.setResizable(false);
		menu.frame.setTitle(Game.title);
		menu.frame.add(menu);
		menu.frame.pack();
		menu.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		menu.frame.setLocationRelativeTo(null);
		menu.frame.setVisible(true);

		menu.start();
		
	}
	
	public synchronized void start() {
		running = true;
		thread = new Thread(this, "Display");
		thread.start();
	}

	public synchronized void stop() {
		startGame();
		frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		final double ns = 1000000000.0 / 60.0;
		double delta = 0;
		int frames = 0;
		int updates = 0;

		requestFocus();
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;

			while (delta >= 1) {
				update();
				updates++;
				delta--;
			}

			render();
			frames++;

			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;

				frame.setTitle(title + " | " + updates + " ups, " + frames + " frames");
				System.out.println(updates + " ups, " + frames + " frames");

				frames = 0;
				updates = 0;
			}
		}
		stop();
	}

	public void update() {
		key.update();
		if(key.back){
			stop();
		}
	}

	public void render() {
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}

		

		Graphics g = bs.getDrawGraphics();

		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		g.setColor(Color.WHITE);
		g.setFont(new Font("Verdana", 0, 50));
		
		g.drawString("Player1: ", 100, 100);

		g.setColor(Color.RED);
		
		g.dispose();

		bs.show();
	}

	public static int getWinWidth() {
		return width * scale;
	}

	public static int getWinHeight() {
		return height * scale;
	}

	private static void startGame() {
		game = new Game();
		game.getFrame().setResizable(false);
		game.getFrame().setTitle(Game.title);
		game.getFrame().add(game);
		game.getFrame().pack();
		game.getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.getFrame().setLocationRelativeTo(null);
		game.getFrame().setVisible(true);

		game.start();
	}
}
