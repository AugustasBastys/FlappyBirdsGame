package move;

import gameObjects.GameObject;

public class MovesInX implements Moves {

	@Override
	public void move(int value, GameObject object) {
		object.setX(object.getX() - value);
	}

}
