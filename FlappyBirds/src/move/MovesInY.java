package move;

import gameObjects.GameObject;

public class MovesInY implements Moves{

	@Override
	public void move(int value, GameObject object) {
		object.setY(object.getY() + value);
	}
	
}