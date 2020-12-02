package main;

 import gameObjects.Bird;

public class MainMeniu {

	public static void main(String[] args) {
		
	
		
		Controls controls = new Controls();
		FlappyBird flappy = new FlappyBird();
  		//Renderer rend = new Renderer(flappy);
  		flappy.setControls(controls);
	//	flappy.setRenderer(rend);
		flappy.setEverything(); 
	
	}

}
