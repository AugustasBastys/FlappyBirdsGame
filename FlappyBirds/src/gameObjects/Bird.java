package gameObjects;

public class Bird extends GameObject {

	private static Bird instance = new Bird();

	private Bird() {
	}

	public static Bird getInstance() {
		return instance;
	}

	@Override
	public void moveObject(int value) {
		this.y += value;
	}

}
