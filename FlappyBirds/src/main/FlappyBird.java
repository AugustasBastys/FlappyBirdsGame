package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.Timer;
import javax.swing.WindowConstants;

public class FlappyBird implements ActionListener{
	
	Renderer renderer;
	Rectangle bird;
	Random random;
	Controls controls;
	
	
	public void setControls(Controls controls) {
		this.controls = controls;
	}

	ArrayList<Rectangle> pipes;
	
	public final int SCREEN_WIDTH = 1000;
	public final int SCREEN_HEIGHT = 800;
	public final int GROUND_HEIGHT = 150;
	
	int ticks;
	int birdYMotion = 9;
	private boolean gameOver = false;
	
	
	public void setRenderer(Renderer renderer) {
		this.renderer = renderer;
	}

	
	public void setEverything() {
		JFrame jframe = new JFrame();
		Timer timer = new Timer(45, this);

		jframe.add(renderer);
		jframe.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
		jframe.setTitle("FLAPPY BIRDS!!!");
		jframe.setResizable(false);
		jframe.setVisible(true);
		jframe.addKeyListener(controls);
		jframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		bird = new Rectangle(SCREEN_WIDTH / 2 - 100, SCREEN_HEIGHT / 2 - 100, 20, 20);
		pipes = new ArrayList<>();
		random = new Random();
		
		addPipe(true);
		addPipe(true);
		
		timer.start();
	}
	
	public void addPipe(boolean atStart) {
		int space = 300;
		int distanceBetweenFirstAndSecondPipe = 300; 
		int pushRight = 600;
		int width = 100;
		int height = 100 + random.nextInt(250);
		
	
		if (atStart) {
			pipes.add(new Rectangle(SCREEN_WIDTH + width + pipes.size() * distanceBetweenFirstAndSecondPipe, SCREEN_HEIGHT - height - GROUND_HEIGHT,
					width, height));
			pipes.add(new Rectangle(SCREEN_WIDTH + width + (pipes.size() - 1) * distanceBetweenFirstAndSecondPipe, 0, width,
					SCREEN_HEIGHT - height - space));
		} else {
			pipes.add(new Rectangle(pipes.get(pipes.size() - 1).x + pushRight, SCREEN_HEIGHT - height - GROUND_HEIGHT, width, height));
			pipes.add(new Rectangle(pipes.get(pipes.size() - 1).x, 0, width, SCREEN_HEIGHT - height - space));
	}

		
	}
	
	public void paintPipe(Graphics g, Rectangle pipe) {
		g.setColor(Color.green.darker());
		g.fillRect(pipe.x, pipe.y, pipe.width, pipe.height);
	}

	public void repaint(Graphics g) {
		g.setColor(Color.PINK);
		g.fillRect(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);

		g.setColor(Color.yellow);
		g.fillOval(150, 150, 90, 90);
		
		g.setColor(Color.LIGHT_GRAY.brighter());
		g.fillOval(230, 200, 50, 25);
		g.fillOval(250, 202, 50, 25);
		g.fillOval(270, 204, 50, 25);
		
		g.fillOval(125, 200, 50, 25);
		g.fillOval(145, 202, 50, 25);
		g.fillOval(165, 204, 50, 25);


		
		g.setColor(Color.green);
		g.fillRect(0, SCREEN_HEIGHT - GROUND_HEIGHT, SCREEN_WIDTH, SCREEN_HEIGHT - GROUND_HEIGHT);

		
		g.setColor(Color.blue);
		g.fillRect(bird.x, bird.y, bird.width, bird.height);
		
		for(Rectangle rect: pipes) {
			paintPipe(g,rect);
		}
		
	}

	 
	
	@Override
	public void actionPerformed(ActionEvent e) {

		int pipeSpeed = 12;
		KeyEvent b = null;
		controls.setBird(bird);
		
		for (int i = 0; i < pipes.size(); i++) {
			pipes.get(i).x -= pipeSpeed;
		}
		

		for (int i = 0; i < pipes.size(); i++) {
			Rectangle pipe = pipes.get(i);

			if (pipe.x + pipe.width < 0) {
				pipes.remove(pipe);
				if(pipes.size()<6) {
					addPipe(false);
				}
 			}
		}
		
		bird.y += birdYMotion;
		
		
		for (Rectangle rectangle : pipes) {
			if(rectangle.intersects(bird)) {
				gameOver = true;
				System.exit(0);
			}
		}
		
		if(bird.y < 0 || bird.y > SCREEN_HEIGHT - GROUND_HEIGHT) {
			gameOver = true;
			System.exit(0);
		}
		
		renderer.repaint();
		
	}

	

}
