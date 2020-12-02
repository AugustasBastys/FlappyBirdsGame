package controls;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import constants.Constants;
import gameObjects.Bird;


public class Controls implements KeyListener {

	Bird bird;


	public Bird getBird() {
		return bird;
	}

	public void setBird(Bird bird) {
		this.bird = bird;
	}

	
	@Override
	public void keyPressed(KeyEvent e) {
		
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			int setNewY = bird.getY() - Constants.BIRD_JUMPS;
			bird.setY(setNewY);
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
	// not used
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// not used
	}
}