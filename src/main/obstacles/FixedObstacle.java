package main.obstacles;

import java.awt.Graphics2D;
import main.utilities.CommonMethods;
import main.utilities.Constants;
import main.utilities.Movable;
import main.utilities.Position;
import main.utilities.Skin;

/**
 * A class that implements a fixed Obstacle
 */
public class FixedObstacle extends Movable {

	public static final double space = (Constants.SCREEN_SIZE.getHeight()) / 7;
	private Skin skin;

	/**
	 * @param position - the obstacle initial position
	 * @param skin     - the obstacle Skin
	 */
	public FixedObstacle(Position position, Skin skin) {
		super(position);
		this.skin = skin;
	}

	/*
	 * getter method for Skin
	 */
	public Skin getSkin() {
		return skin;
	}

	/**
	 * setter method for Skin
	 */
	public void setSkin(Skin skin) {
		this.skin = skin;
	}

	@Override
	public void animate(Graphics2D canvas) {
		canvas.drawImage(getSkin().getImage(), getPosition().getX(), (int) (getPosition().getY() + (space) / 2),
				(int) (Constants.SCREEN_SIZE.getWidth()) / 10,
				(int) (Constants.SCREEN_SIZE.getHeight() - (getPosition().getY() + (space) / 2)), null);
		canvas.drawImage(CommonMethods.getAngledImage(getSkin().getImage(), 180), getPosition().getX(), 0,
				(int) (Constants.SCREEN_SIZE.getWidth()) / 10, (int) (getPosition().getY() - (space) / 2), null);

		updatePosition();
	}

	/**
	 * updatePosition is a method that as its name says updates the position, the X,
	 * of the fixedobstacle
	 */
	private void updatePosition() {
		getPosition().setX(getPosition().getX() - Constants.MOVING_FACTOR);
	}

}
