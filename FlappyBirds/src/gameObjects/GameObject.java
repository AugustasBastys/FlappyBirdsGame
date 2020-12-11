package gameObjects;

import move.Moves;

public abstract class GameObject {

	protected int x;
	protected int y;
	protected int width;
	protected int height;
	
	public Moves moves;
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	
	
	public void move(int movingValue) {
		moves.move(movingValue, this);
	}
	
	public void setMove(Moves moves) {
		this.moves = moves;
	}
	
}
