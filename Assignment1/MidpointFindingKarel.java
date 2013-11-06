/*
 * File: MidpointFindingKarel.java
 * -------------------------------
 * When you finish writing it, the MidpointFindingKarel class should
 * leave a beeper on the corner closest to the center of 1st Street
 * (or either of the two central corners if 1st Street has an even
 * number of corners).  Karel can put down additional beepers as it
 * looks for the midpoint, but must pick them up again before it
 * stops.  The world may be of any size, but you are allowed to
 * assume that it is at least as tall as it is wide.
 */

import stanford.karel.*;

public class MidpointFindingKarel extends SuperKarel {
	public void run(){
		
		/*
		 * Pseudocode
		 * 1.laybeepers
		 * 2.pick them up one end to the other
		 * 
		 * Decomposition
		 *  * solves one problem
		 *  * 1-15 lines
		 *  * good names
		 *  * comments /preconditions
		 *  *          /postconditions
		 * 
		 */
		LayBeepers();
		BackToStart();
		
		/* FindTheMiddle
		 * here is the method that
		 * does the work
		 */
		FindTheMiddle();	
	}
	
	/*
	 * LayBeeper
	 * put beepers from one end to the other
	 * pre: unlimited beepers, front is clear
	 * post: wall in front, beeper where iam standing
	 */
	private void LayBeepers(){
		while(frontIsClear()){
			putBeeper();
			move();
		}
		putBeeper();
	}
	
	/* BackToStart
	 * moves Karel to the starting position
	 * pre: front is blocked
	 * post:front is clear
	 */
	private void BackToStart(){
		turnAround();
		MoveToWall();
		turnAround();
	}
	
	/* MoveToWall
	 * keep moving until karel hits a wall
	 * pre: front clear
	 * post : front blocked
	 */
	private void MoveToWall(){
		while(frontIsClear()){
			move();
		}
	}
	
	/* FindTheMiddle
	 * Finds the midpoint of a line
	 * Pre: beepers present in front
	 * post: no more beepers in front
	 * 
	 */
	private void FindTheMiddle(){
		if(beepersPresent()){
			pickBeeper();
			}
		while(noBeepersPresent()){
			GotoTheOtherEnd();
			if(frontIsClear()){
				checkabeeper();
			}
			pickBeeper();
		}
	}
	
	/*
	 * Gootheotherend
	 * traverse the line of beepers
	 */
	private void GotoTheOtherEnd(){
		FirstBeeper();
		EndingBeeper();
	}
	
	/* FirstBeeper
	 * go to the first beeper
	 */
	private void FirstBeeper(){
		if(noBeepersPresent()){
			move();
		}
	}
	
	/* endingbeeper
	 * check the lastbeeper
	 * 
	 */
	private void EndingBeeper(){
		while(frontIsClear()){
			move();
		}
		turnAround();

		while(noBeepersPresent()){
			move();
		}
	}
	
	/* checkabeeper
	 * checks if there is still a beeper for the last 
	 * time
	 */
	private void checkabeeper(){
		if(beepersPresent()){
			move();
			if(beepersPresent()){
				MoveBack();
			} else {
				MoveBack();
				putBeeper();
			}
		}
	}
	
	/*moveback
	 * movesback one step
	 */
	private void MoveBack(){
		turnAround();
		move();
		turnAround();
	}
}
