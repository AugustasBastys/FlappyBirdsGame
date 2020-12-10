package gameObjects;

import move.Moves;

public class Pipe extends GameObject {

	public Pipe(int x, int y, int width, int height, Moves movingBehavior) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
		this.moves = movingBehavior;
	}

}
