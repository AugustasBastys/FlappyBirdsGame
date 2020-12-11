package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import constants.Constants;
import gameObjects.Bird;
import rules.Rules;

class TestRules {

	@Test
	void isBirdTouchingGround() {

		Bird.getInstance().setX(Constants.BIRD_STARTING_X);
		Bird.getInstance().setY(Constants.BIRD_STARTING_Y + 351);
		Bird.getInstance().setWidth(Constants.BIRD_WIDTH);
		Bird.getInstance().setHeight(Constants.BIRD_HEIGHT);

		Rules rules = new Rules(null, null);

		assertEquals(true, rules.birdIsNotInBounds(Bird.getInstance()));
	}

	@Test
	void isBirdNotTouchingGround() {

		Bird.getInstance().setX(Constants.BIRD_STARTING_X);
		Bird.getInstance().setY(Constants.BIRD_STARTING_Y + 350);
		Bird.getInstance().setWidth(Constants.BIRD_WIDTH);
		Bird.getInstance().setHeight(Constants.BIRD_HEIGHT);

		Rules rules = new Rules(null, null);

		assertEquals(false, rules.birdIsNotInBounds(Bird.getInstance()));
	}
	
	@Test
	void isBirdTouchingScreenTop() {

		Bird.getInstance().setX(Constants.BIRD_STARTING_X);
		Bird.getInstance().setY(Constants.BIRD_STARTING_Y - 301);
		Bird.getInstance().setWidth(Constants.BIRD_WIDTH);
		Bird.getInstance().setHeight(Constants.BIRD_HEIGHT);

		Rules rules = new Rules(null, null);

		assertEquals(true, rules.birdIsNotInBounds(Bird.getInstance()));
	}
	
}
