package com.ferdi.game;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

import com.ferdi.game.entity.mob.Enemy;
import com.ferdi.game.entity.mob.Player;
import com.ferdi.game.entity.mob.Player2;
import com.ferdi.game.graphics.Screen;
import com.ferdi.game.input.Keyboard;
import com.ferdi.game.input.Mouse;
import com.ferdi.game.level.Level;
import com.ferdi.game.level.SpawnLevel;
import com.ferdi.game.level.tile.TileCoordinate;

public class Game extends Canvas implements Runnable {
	private static final long serialVersionUID = 1L;

	public static String title = "FerdiGame";

	private static int width = 500;
	private static int height = width / 16 * 9;
	private static int scale = 2;

	private Thread thread;
	private JFrame frame;
	private Level level;
	private static final Keyboard key = new Keyboard();;

	private static final TileCoordinate playerSpawn = new TileCoordinate(14, 9);
	public static Player player = new Player(playerSpawn.x + 180, playerSpawn.y, key, "Ferdi");
	public static Player2 player2 = new Player2(playerSpawn.x - 100, playerSpawn.y, key, "Fidi");
	private Enemy enemy1;
	private Enemy enemy2;

	private boolean running = false;
	private boolean gameing = false;
	private String end = "";

	private Screen screen;

	private BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();

	public Game() {
		Dimension size = new Dimension(width * scale, height * scale);
		setPreferredSize(size);

		screen = new Screen(width, height);
		frame = new JFrame();
		level = new SpawnLevel("/textures/level1.png", "/textures/level2.png", "/textures/level3.png");
		player.init(level);
		player2.init(level);

		enemy1 = new Enemy(playerSpawn.x - 150, playerSpawn.y - 90, 1);
		enemy2 = new Enemy(playerSpawn.x + 240, playerSpawn.y - 90, 2);
		level.add(enemy1);
		level.add(enemy2);

		addKeyListener(key);

		Mouse mouse = new Mouse();
		addMouseListener(mouse);
		addMouseMotionListener(mouse);
	}

	public synchronized void start() {
		running = true;
		thread = new Thread(this, "Display");
		thread.start();
	}

	public synchronized void stop() {
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
		if (key.back) {
			gameing = true;
			player.reset(playerSpawn.x + 180, playerSpawn.y, 100);
			player2.reset(playerSpawn.x - 100, playerSpawn.y, 100);
			enemy1.reset(playerSpawn.x - 150, playerSpawn.y - 90, 100);
			enemy2.reset(playerSpawn.x + 240, playerSpawn.y - 90, 100);
			end = "";
		}
		if (gameing) {
			player.update();
			player2.update();
			level.update();

			if (player.getLife() <= 0) {
				end = player2.name + " hat gewonnen !!";
				render();
				gameing = false;
			}
			if (player2.getLife() <= 0) {
				end = player.name + " hat gewonnen !!";
				render();
				gameing = false;
			}
		}
	}

	public void render() {
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}

		screen.clear();
		int xScroll = screen.width / 2;//int xScroll = player2.x - screen.width / 2;
		int yScroll = screen.height / 2 + 10; //int yScroll = player2.y  - screen.height / 2 +10;
		level.render(xScroll, yScroll, screen);
		player2.render(screen);
		player.render(screen);

		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = screen.pixels[i];
		}

		Graphics g = bs.getDrawGraphics();

		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		g.setColor(Color.WHITE);
		g.setFont(new Font("Verdana", 0, 50));

		//		if (Mouse.mouseB() == 1){
		//			g.drawLine(Mouse.mouseX(), Mouse.mouseY(), 500, (500 / 16 * 9));
		//		}

		g.setColor(Color.RED);
		g.fillRect(40, 20, player2.getLife() * 2, 40);
		g.fillRect(750, 20, player.getLife() * 2, 40);
		g.setColor(Color.BLACK);
		g.drawRect(40, 20, 100 * 2, 40);
		g.drawRect(750, 20, 100 * 2, 40);
		g.setFont(new Font("Verdana", 0, 25));
		g.drawString(player2.name, 50, 48);
		g.drawString(player.name, 760, 48);
		g.setFont(new Font("Verdana", 0, 70));
		g.drawString(end, 100, 200);
		g.dispose();

		bs.show();
	}

	public static int getWinWidth() {
		return width * scale;
	}

	public static int getWinHeight() {
		return height * scale;
	}

	public static void main(String[] args) {
		Game game = new Game();
		game.frame.setResizable(false);
		game.frame.setTitle(Game.title);
		game.frame.add(game);
		game.frame.pack();
		game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.frame.setLocationRelativeTo(null);
		game.frame.setVisible(true);

		game.start();
	}

}
