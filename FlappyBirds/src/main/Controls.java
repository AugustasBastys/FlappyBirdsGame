package main;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import gameObjects.Bird;


public class Controls implements KeyListener {

	Rectangle bird;

	public Controls() {
	}

	public Rectangle getBird() {
		return bird;
	}

	public void setBird(Rectangle bird) {
		this.bird = bird;
	}

	
	@Override
	public void keyPressed(KeyEvent e) {
		
		int birdJumpsBy = 50;
		
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			bird.y -= birdJumpsBy;
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
	
	}
	@Override
	public void keyReleased(KeyEvent e)
	{
		
	}
}