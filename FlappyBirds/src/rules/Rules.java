package rules;

import java.awt.Rectangle;

import constants.Constants;
import gameObjects.Bird;
import gameObjects.GameObject;
import gameObjects.Pipe;
import gameObjects.PipeController;

public class Rules {

	Bird bird;
	PipeController pipes;
	
	public void checkRules() {
		
		for (Pipe p : pipes.getPipes()) {
			if(intersects(p, bird)) {
				System.exit(0);
			}
		}
		
		if(bird.getY() < 0 || bird.getY() > Constants.SCREEN_HEIGHT - Constants.GROUND_HEIGHT) {
			System.exit(0);
		}
	}
	
	 private boolean intersects(GameObject pipe, GameObject bird) {

	     int leftX = Math.max(pipe.getX(), bird.getX());

	     int rightX =  Math.min(pipe.getX() + pipe.getWidth(), 
	    		 bird.getX() + bird.getWidth());

	     int topY = Math.max(pipe.getY(),bird.getY());

	     int botY =  Math.min(pipe.getY() + pipe.getHeight(),
	    		 bird.getY() + bird.getHeight());

	     if ((rightX > leftX) && (botY > topY)) {
	         return true;
	     }

	     return false;
	 }
	
	
	
}
