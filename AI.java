/*
 * This class encompasses the moves that the computer 
 * player will make. 
 *
 * We have multiple algorithms taking place here which 
 * can be derived from nim, a mathematical game of 
 * strategy. More can be found here:
 *
 * https://en.wikipedia.org/wiki/Nim
 *
 * The two difficulties taking place are Easy and 
 * Hard. Easy is simply the opposite of Hard in which 
 * both computations are generally the same but the 
 * we act differently based off of the return values
 * of said computation. 
 *
 * Hard essentially kills boards as soon as possible
 * as this makes it harder for the player to move around
 * throughout the game. Easy does just the opposite to 
 * where the player has plenty of options to manage 
 * their chances throughout each respective board. By 
 * killing the board as fast as possible, we leave the
 * player with little to no option towards the end.
 *
 */

import java.util.*;

public class AI {

	// Easy is 0, Hard is 1;
    	public int difficulty;

	/**
     	 * Constructor for AI object
    	 * @return void
   	 */
	public AI(){}

	/**
	 * Constructor for AI object
	 * @param  int diffMode      integer denoting level of difficulty
	 * @return     void
	 */
	public AI(int diffMode){
		this.difficulty = diffMode;
	}
    

	// Determines which tile the computer will place based on difficulty
	public int determineMove(boolean[] board){
		// perform computation
		if (this.difficulty == 0){
			// set move for Easy difficulty
		}
		else{
			// set move for Hard difficulty
		}
	}

	public static void main(String[] args) {

	}
}
