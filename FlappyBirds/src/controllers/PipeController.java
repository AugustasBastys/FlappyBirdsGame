package controllers;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;

import constants.*;
import gameObjects.Pipe;

import javax.swing.SpringLayout.Constraints;

public class PipeController {

	private ArrayList<Pipe> pipes;
	private Random random;

	public PipeController() {
		this.pipes = new ArrayList<>();
		random = new Random();
	}

	public void movePipes(int movingSpeed) {
		for (Pipe pipe : pipes) {
			pipe.moveObject(movingSpeed);
		}
		
		
	}

	public void addPipe(int x, int y, int width, int height, boolean atStart) {
		
		height += random.nextInt(250);
		
		
		if (atStart) {
			pipes.add(new Pipe(Constants.SCREEN_WIDTH + width + pipes.size() * Constants.DISTANCE_BETWEEN_FIRST_AND_SECOND_PIPE, 
					Constants.SCREEN_HEIGHT - height - Constants.GROUND_HEIGHT,
					width, height));
			pipes.add(new Pipe(Constants.SCREEN_WIDTH + width + (pipes.size() - 1) * 
					Constants.DISTANCE_BETWEEN_FIRST_AND_SECOND_PIPE, 0, width,
					Constants.SCREEN_HEIGHT - height - Constants.DISTANCE_BETWEEN_FIRST_AND_SECOND_PIPE));
		} else {
			pipes.add(new Pipe(pipes.get(pipes.size() - 1).getX() + Constants.PUSH_PIPE_RIGHT, Constants.SCREEN_HEIGHT - height - Constants.GROUND_HEIGHT, width, height));
			pipes.add(new Pipe(pipes.get(pipes.size() - 1).getX(), 0, width, Constants.SCREEN_HEIGHT - height - Constants.DISTANCE_BETWEEN_FIRST_AND_SECOND_PIPE));
	}

		
		
	}

	public ArrayList<Pipe> getPipes() {
		return pipes;
	}
	
}
