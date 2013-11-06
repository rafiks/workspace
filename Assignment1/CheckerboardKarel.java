/*
 * File: CheckerboardKarel.java
 * ----------------------------
 * When you finish writing it, the CheckerboardKarel class should draw
 * a checkerboard using beepers, as described in Assignment 1.  You
 * should make sure that your program works for all of the sample
 * worlds supplied in the starter folder.
 */

import stanford.karel.*;

public class CheckerboardKarel extends SuperKarel {

	public void run(){
		//turnleft to go up the column
		turnLeft();
	// iterate how many times depending on the size of the world
	// putting a beeper and skipping alternately	
		for(int i=0;i<32;i++){
			putBeeper();
			skip();
		}
	}
	
	// skip method
	private void skip(){
		if(frontIsClear()){
			move();
			//doubleskip();
		}
			
		if(frontIsBlocked()){
			if(facingNorth()){
				if(beepersPresent()){
					skipright();
				} else {
					movedown();
				}
				
			} else {
				if(facingSouth()){
					if(beepersPresent()){
						skipleft();
					} else {
						moveup();
					}
				} 
			}
			
		} else {
			move();
		}
	}
	
	private void moveup(){
		turnLeft();
		move();
		turnLeft();
	}
	
	private void movedown(){
		turnRight();
		move();
		turnRight();
	}
	
	private void doubleskip(){
		move();
		move();
	}
	
	private void skipright(){
		moveright();
		moveright();
	}
	
	private void skipleft(){
		moveleft();
		moveleft();
	}
	
	private void moveright(){
		turnRight();
		if(frontIsBlocked()){
			moveleft();
		} else {
			move();
		}
	}
	
	private void moveleft(){
		turnLeft();
		if(frontIsBlocked()){
			moveright();
		} else {
			move();
		}
	}
	
	
	
}