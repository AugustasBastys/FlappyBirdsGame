package launch;

import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.WindowConstants;

import constants.Constants;
import controllers.PipeController;
import gameObjects.Bird;
import graphics.Painter;
import move.MovesInY;
import controls.Controls;
import rules.Rules;

public class Launcher extends JPanel implements ActionListener {

	private Controls controls;
	private PipeController pipeController;
	private Rules rules;
	private Painter painter;
	
	
	public void setEverything() {
		JFrame jframe = new JFrame();
		Timer timer = new Timer(Constants.GAME_SPEED, this);

		jframe.add(this);
		jframe.setSize(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
		jframe.setTitle("FLAPPY BIRDS!!!");
		jframe.setResizable(false);
		jframe.setVisible(true);
		jframe.add(painter); 
		jframe.addKeyListener(controls);
		jframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		pipeController.addPipe(Constants.PIPE_WIDTH, Constants.PIPE_HEIGHT, true);
		pipeController.addPipe(Constants.PIPE_WIDTH, Constants.PIPE_HEIGHT, true);
		
		timer.start();
	}
	
	
	public static void main(String[] args) {
		
		Bird.getInstance().setX(Constants.BIRD_STARTING_X);
		Bird.getInstance().setY(Constants.BIRD_STARTING_Y);
		Bird.getInstance().setWidth(Constants.BIRD_WIDTH);
		Bird.getInstance().setHeight(Constants.BIRD_HEIGHT);
		
		Bird.getInstance().setMove(new MovesInY());
		
		Launcher launcher = new Launcher();
		
		Controls controls = new Controls();
		controls.setBird(Bird.getInstance());
		launcher.setControls(controls);
		
		PipeController pipeController = new PipeController();
		launcher.setPipeController(pipeController);

		Rules rules = new Rules(Bird.getInstance(), pipeController);
		launcher.setRules(rules);
		
		Painter painter = new Painter(Bird.getInstance(), pipeController);
		launcher.setPainter(painter);
		
		launcher.setEverything();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		pipeController.movePipes(Constants.PIPE_SPEED);
		
		pipeController.removePipes();
		
		Bird.getInstance().move(Constants.BIRD_DROPS_DOWN);
		
		rules.checkRules();

		painter.repaint();
		
	}


	public void setControls(Controls controls) {
		this.controls = controls;
	}


	public void setPipeController(PipeController pipeController) {
		this.pipeController = pipeController;
	}


	public void setRules(Rules rules) {
		this.rules = rules;
	}


	public void setPainter(Painter painter) {
		this.painter = painter;
	}

}
