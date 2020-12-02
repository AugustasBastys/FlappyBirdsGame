package graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JPanel;

import constants.Constants;
import gameObjects.Bird;
import gameObjects.Pipe;
import gameObjects.PipeController;

public class Painter extends JPanel {

	PipeController pipes;
	Bird bird;
	
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
	
	private void paintGround(Graphics g) {
		g.setColor(Color.green);
		g.fillRect(Constants.SCREEN_WIDTH - Constants.SCREEN_WIDTH,
				Constants.SCREEN_HEIGHT - Constants.GROUND_HEIGHT,
				Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT - Constants.GROUND_HEIGHT);
	}
	
	public void repaint(Graphics g) {
		
		paintGround(g);
		
		paintSky(g);
		
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
