/*
 * File: StoneMasonKarel.java
 * --------------------------
 * The StoneMasonKarel subclass as it appears here does nothing.
 * When you finish writing it, it should solve the "repair the quad"
 * problem from Assignment 1.  In addition to editing the program,
 * you should be sure to edit this comment so that it no longer
 * indicates that the program does nothing.
 */

import stanford.karel.*;

public class StoneMasonKarel extends SuperKarel {
	
	/* run this 12 times,which is the number of spaces
	 * in our world
	 * check if the column needs fixing
	 * skip ahead to the next one
	 */
	public void run(){
		//iterate 13 times(checking 13 columns)
		for(int i=0;i<13;i++){
			check();
			fixColumn();
			keepmoving();
		}
		/*pseudocode
		 * go up the column
		 * check if there is a beeper
		 * if there is one
		 * go back to the start and
		 * fill in the beeper
		 * go check the next column 
		 * repeat
		 */
	}

// move to the wall
	private void movetowall(){
		while(frontIsClear()){
			move();
		}
	}

//keep karel moving through the next column
	private void keepmoving(){
		if(frontIsBlocked()){
			if(facingNorth()){
				backtostart();
			}
		}
			
		if(facingNorth()){
			turnRight();
			move();
			//turnRight();
		}
		if(facingSouth()){
			turnLeft();
			move();
			turnLeft();
		}
		if(facingWest()){
			turnAround();
			move();
		}
		
	}

//skip a beeper
	private void skipbeeper(){
		if(beepersPresent()){
			move();
		}
	}

//fix the broken column
	private void fixColumn(){
		backtostart();
		while(frontIsClear()){
			skipbeeper();
			fillwithbeepers();
		}		
	}

	//move to the next column
	private void nextcolumn(){
		turnLeft();
		move();
		turnLeft();

	}
	
	//back to starting position
	private void backtostart(){
		turnAround();
		movetowall();
		turnAround();
	}
	
	//check if this a column that needs fixing
	private void check(){
		if(facingEast()){
			turnLeft();
		}
		while(noBeepersPresent()){
			if(frontIsClear()){
				move();
			} else {
				turnAround();
				movetowall();
				nextcolumn();
				backtostart();
			}
		}
	}
	
	
	/* If the end of gap is on the end of
	 * the column
	 * put a beeper
	 */
	private void endofthecolumn(){
		if(noBeepersPresent()){
			putBeeper();
		}
		turnAround();
		movetowall();
	}
	
	/* if the gap of beepers is in the 
	 * middle of the column,
	 * fix it
	 */
	private void middleofthecolumn(){
		while(noBeepersPresent()){
			putBeeper();
			move();
		}
	}
	
	/* fix the middle and the 
	 * end of a column
	 */
	private void fillwithbeepers(){
		while(noBeepersPresent()){
			if(frontIsClear()){
				middleofthecolumn();
			} else {
				endofthecolumn();
			}		
		}
	}
}
