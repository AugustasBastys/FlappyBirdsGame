package graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JPanel;

import constants.Constants;
import controllers.PipeController;
import gameObjects.Bird;
import gameObjects.Pipe;

public class Painter extends JPanel {

	private PipeController pipes;
	private Bird bird;
	
	public Painter(Bird bird, PipeController pipes) {
		this.pipes = pipes;
		this.bird = bird;
	}

	private void paintPipe(Graphics g, Pipe pipe) {
		g.setColor(Color.green.darker());
		g.fillRect(pipe.getX(), pipe.getY(), pipe.getWidth(), pipe.getHeight());
	}
	
	private void paintBird(Graphics g, Bird bird) {
		g.setColor(Color.blue);
		g.fillRect(bird.getX(), bird.getY(), bird.getWidth(), bird.getHeight());
	}
	
	private void paintSky(Graphics g) {
		g.setColor(Color.PINK);
		g.fillRect(0, 0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
	}
	
	private void paintSun(Graphics g) {
		g.setColor(Color.yellow);
		g.fillOval(150, 150, 90, 90);
		
	}
	
	
	private void paintGround(Graphics g) {
		
		g.setColor(Color.GREEN);
		g.fillRect(0,
				Constants.SCREEN_HEIGHT - Constants.GROUND_HEIGHT,
				Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT - Constants.GROUND_HEIGHT);
	}
	
	public void repaint(Graphics g) {
		
		paintSky(g);
			
		paintSun(g);
	
		paintGround(g);
		
		paintBird(g, bird);
		
		for(Pipe p: pipes.getPipes()) {
			paintPipe(g,p);
		}
	}
	
	@Override
	public void paintComponent(Graphics g) {
		repaint(g);
	}
	
}
