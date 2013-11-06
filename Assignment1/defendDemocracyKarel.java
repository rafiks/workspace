/*
 * File:defendDemocracyKarel.java
 * clean up the bad ballots
 */
import stanford.karel.SuperKarel;

public class defendDemocracyKarel extends SuperKarel {
	public void run(){
		while(frontIsClear()){
			move();
			cleanLine();
		}
	}
	
	/*
	 * cleanallchads
	 * pre: facing east before a line
	 * post: exit the line facing east
	 */
	private void cleanChads(){
		move();
		cleanLine();
		move();
	}
	
	/*
	 * cleanuptheline
	 * pre :midfle of the avenue
	 * post middle of the avenue
	 */
	private void cleanLine(){
		if(beepersPresent()){
			move();
		} else {
			checkChads();
			move();
		}
	}
	
	/*
	 * checkChads - 
	 * check if there are beepers left
	 * pre: middle of the avenue with no beepers
	 * post : middle of the avenue with no beepers
	 */
	private void checkChads(){
		turnLeft();
		move();
		checkBeeper();
		turnAround();
		movetowall();
		checkBeeper();
		turnAround();
		move();
		turnRight();
	}
	
	/*
	 * checkBeeper
	 * removes beeper if beeper is present 
	 * 
	 */
	private void checkBeeper(){
		while(beepersPresent()){
			pickBeeper();
		}
	}
	
	/* movetowall
	 * move to the end
	 */
	private void movetowall(){
		while(frontIsClear()){
			move();
		}
	}

	
}
