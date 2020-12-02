package gameObjects;

public class Pipe extends GameObject {

	public Pipe(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	@Override
	public void moveObject(int value) {
		this.x -= value;
	}

}
