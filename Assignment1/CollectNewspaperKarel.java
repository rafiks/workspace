/*
 * File: CollectNewspaperKarel.java
 * --------------------------------
 * At present, the CollectNewspaperKarel subclass does nothing.
 * Your job in the assignment is to add the necessary code to
 * instruct Karel to walk to the door of its house, pick up the
 * newspaper (represented by a beeper, of course), and then return
 * to its initial position in the upper left corner of the house.
 */

import stanford.karel.*;

public class CollectNewspaperKarel extends SuperKarel {

	/* run method for CollectNewspaperKarel
	 * It moves Karel to the Newspaper,pick it
	 * up and return to the starting position
	 */
		public void run(){
			MoveToNewsPaper();
			pickBeeper();
			MoveBackToStart();
		}

	/* MoveToNewspaper method
	 * move to the wall and turn right move
	 * and turns left and move
	 */
		private void MoveToNewsPaper(){
			movetowall();
			rightturn();
			leftturn();
			
		}
		
		/* Move back to 
		 * starting position
		 */

		private void MoveBackToStart(){
			moveturn();
			rightturn();
			turnLeft();
			movetowall();
			turnAround();

		}


	/*
	 *  right turn and move
	 *
	*/
		private void rightturn(){
			turnRight();
			move();
		}
		
		/* turn Left and move
		 *
		 */
		private void leftturn(){
			turnLeft();
			move();
		}
		
		/* Turns around Karel and move
		 * 
		 * 
		 */
		private void moveturn(){
			turnAround();
			move();
		}
		
		/* Keep moving while front is clear
		 * 
		 */
		private void movetowall(){
			while(frontIsClear()){
				move();
			}
		}
}