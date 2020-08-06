package frogger_arcade.actors;
/**
 * Animal class
 * @author psymp5
 */

import java.util.ArrayList;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import frogger_arcade.stage.End;

/**
 * Animal class is a concrete version of actor. Functions and visuals such as movement of objects.
 */

public class Animal extends Actor {

	Image imgW1, imgA1, imgS1, imgD1, imgW2, imgA2, imgS2, imgD2;

	int points, end, carD = 0;;
	private boolean second = false;
	double movement = 13.3333333*2;
	double movementX = 10.666666*2;
	int imgSize = 40;
	boolean carDeath, waterDeath, stop, changeScore, noMove = false;
	double w = 800;

	public static Animal animal = new Animal("frogger_arcade/media/FroggerMove/froggerUp.png");

	ArrayList<End> inter = new ArrayList<End>();
	private Animal(String imageLink) {
		setImage(new Image(imageLink, imgSize, imgSize, true, true));
		/**
		Sets the initial position of the frog
		 */
		setX(300);
		setY(679.8+movement);
		/**
		 * Allocating each image to a png file.
		 */


		imgW1 = new Image("frogger_arcade/media/FroggerMove/froggerUp.png", imgSize, imgSize, true, true);
		imgA1 = new Image("frogger_arcade/media/FroggerMove/froggerLeft.png", imgSize, imgSize, true, true);
		imgS1 = new Image("frogger_arcade/media/FroggerMove/froggerDown.png", imgSize, imgSize, true, true);
		imgD1 = new Image("frogger_arcade/media/FroggerMove/froggerRight.png", imgSize, imgSize, true, true);
		imgW2 = new Image("frogger_arcade/media/FroggerMove/froggerUpJump.png", imgSize, imgSize, true, true);
		imgA2 = new Image("frogger_arcade/media/FroggerMove/froggerLeftJump.png", imgSize, imgSize, true, true);
		imgS2 = new Image("frogger_arcade/media/FroggerMove/froggerDownJump.png", imgSize, imgSize, true, true);
		imgD2 = new Image("frogger_arcade/media/FroggerMove/froggerRightJump.png", imgSize, imgSize, true, true);
		setOnKeyPressed(new EventHandler<KeyEvent>() {

			/**
			 * This method handle, applies the visuals of the frog depending on the input of the user. A,S,D,W for basic movement.
			 * @param event
			 */
			public void handle(KeyEvent event){
				if (noMove) {
					
				}
				else {
				if (second) {
					if (event.getCode() == KeyCode.W) {	  
		                move(0, -movement);
		                changeScore = false;
		                setImage(imgW1);
		                second = false;
		            }
		            else if (event.getCode() == KeyCode.A) {	            	
		            	 move(-movementX, 0);
		            	 setImage(imgA1);
		            	 second = false;
		            }
		            else if (event.getCode() == KeyCode.S) {	            	
		            	 move(0, movement);
		            	 setImage(imgS1);
		            	 second = false;
		            }
		            else if (event.getCode() == KeyCode.D) {	            	
		            	 move(movementX, 0);
		            	 setImage(imgD1);
		            	 second = false;
		            }
				}
				else if (event.getCode() == KeyCode.W) {	            	
	                move(0, -movement);
	                setImage(imgW2);
	                second = true;
	            }
	            else if (event.getCode() == KeyCode.A) {	            	
	            	 move(-movementX, 0);
	            	 setImage(imgA2);
	            	 second = true;
	            }
	            else if (event.getCode() == KeyCode.S) {	            	
	            	 move(0, movement);
	            	 setImage(imgS2);
	            	 second = true;
	            }
	            else if (event.getCode() == KeyCode.D) {	            	
	            	 move(movementX, 0);
	            	 setImage(imgD2);
	            	 second = true;
	            }
	        }
			}
		});
		/**
		 * This method waits for the user to  release the key, and depending how long they hold it down, how far the frog will move, as long as it's animation.
		 */
		setOnKeyReleased(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event) {
				if (noMove) {}
				else {
				if (event.getCode() == KeyCode.W) {	  
					if (getY() < w) {
						changeScore = true;
						w = getY();
						points+=10;
					}
	                move(0, -movement);
	                setImage(imgW1);
	                second = false;
	            }
	            else if (event.getCode() == KeyCode.A) {	            	
	            	 move(-movementX, 0);
	            	 setImage(imgA1);
	            	 second = false;
	            }
	            else if (event.getCode() == KeyCode.S) {	            	
	            	 move(0, movement);
	            	 setImage(imgS1);
	            	 second = false;
	            }
	            else if (event.getCode() == KeyCode.D) {	            	
	            	 move(movementX, 0);
	            	 setImage(imgD1);
	            	 second = false;
	            }
	        }
			}
			
		});
	}

	/**
	 *
	 * @return returns the only instance of animal, which is accessed inside the animal class.
	 */
	public static Animal getAnimal()
	{
		return animal;
	}

	/**
	 * act receives the boundaries of the frogger, deciding if it colliding with any of the obstacles or drowning, and if so applying death method and assigning death images. As well as changing the score.
	 * @param now
	 */
	@Override
	public void act(long now) {
		int bounds = 0;
		if (getY()<0 || getY()>734) {
			setX(300);
			setY(679.8+movement);
		}
		if (getX()<0) {
			move(movement*2, 0);
		}
		if (carDeath) {
			noMove = true;
			if ((now)% 11 ==0) {
				carD++;
			}
			if (carD==1) {
				setImage(new Image("frogger_arcade/media/deaths/cardeath1.png", imgSize, imgSize, true, true));
			}
			if (carD==2) {
				setImage(new Image("frogger_arcade/media/deaths/cardeath2.png", imgSize, imgSize, true, true));
			}
			if (carD==3) {
				setImage(new Image("frogger_arcade/media/deaths/cardeath3.png", imgSize, imgSize, true, true));
			}
			if (carD == 4) {
				setX(300);
				setY(679.8+movement);
				carDeath = false;
				carD = 0;
				setImage(new Image("frogger_arcade/media/FroggerMove/froggerUp.png", imgSize, imgSize, true, true));
				noMove = false;
				if (points>50) {
					points-=50;
					changeScore = true;
				}
			}

		}

		if (waterDeath) {
			noMove = true;
			if ((now)% 11 ==0) {
				carD++;
			}
			if (carD==1) {
				setImage(new Image("frogger_arcade/media/deaths/waterdeath1.png", imgSize,imgSize , true, true));
			}
			if (carD==2) {
				setImage(new Image("frogger_arcade/media/deaths/waterdeath2.png", imgSize,imgSize , true, true));
			}
			if (carD==3) {
				setImage(new Image("frogger_arcade/media/deaths/waterdeath3.png", imgSize,imgSize , true, true));
			}
			if (carD == 4) {
				setImage(new Image("frogger_arcade/media/deaths/waterdeath4.png", imgSize,imgSize , true, true));
			}
			if (carD == 5) {
				setX(300);
				setY(679.8+movement);
				waterDeath = false;
				carD = 0;
				setImage(new Image("frogger_arcade/media/FroggerMove/froggerUp.png", imgSize, imgSize, true, true));
				noMove = false;
				if (points>50) {
					points-=50;
					changeScore = true;
				}
			}

		}

		if (getX()>600) {
			move(-movement*2, 0);
		}
		if (getIntersectingObjects(Obstacle.class).size() >= 1) {
			carDeath = true;
		}
		if (getX() == 240 && getY() == 82) {
			stop = true;
		}
		if (getIntersectingObjects(Log.class).size() >= 1 && !noMove) {
			if(getIntersectingObjects(Log.class).get(0).getLeft())
				move(-.75,0);
			else
				move (.75,0);
		}
		else if (getIntersectingObjects(Turtle.class).size() >= 1 && !noMove) {
			move(-1,0);
		}
		else if (getIntersectingObjects(WetTurtle.class).size() >= 1) {
			if (getIntersectingObjects(WetTurtle.class).get(0).isSunk()) {
				waterDeath = true;
			} else {
				move(-1,0);
			}
		}
		/**
		 * This else if statement Decreases players score by 50 if they intersect a vehicle or die.
		 */
		else if (getIntersectingObjects(End.class).size() >= 1) {
			inter = (ArrayList<End>) getIntersectingObjects(End.class);
			if (getIntersectingObjects(End.class).get(0).isActivated()) {
				end--;
				points-=50;
			}
			points+=50;
			changeScore = true;
			w=800;
			getIntersectingObjects(End.class).get(0).setEnd();
			end++;
			setX(300);
			setY(679.8+movement);
		}
		else if (getY()<413){
			waterDeath = true;

		}
	}
	public boolean getStop() {
		return end==5;
	}
	
	public int getPoints() {
		return points;
	}
	
	public boolean changeScore() {
		if (changeScore) {
			changeScore = false;
			return true;
		}
		return false;
		
	}
	

}
