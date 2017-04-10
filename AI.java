package cs321;

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
	 * @param int diffMode		integer denoting level of difficulty
	 * @return void
	 */
	public AI(int diffMode){
		this.difficulty = diffMode;
	}
    

	/**
	 * Algorithm for calculating which position the computer will take
	 * on either Easy or Hard
	 * @param int[] board	board representation
	 * @return int 	index of board (the tile to be placed)
	 */
	public int determineMove(int[] board){
		// array containing the sum of X's per cross
		int[] crosses = new int[8];
		
		// maximum and minimum cross values on board
		int maxCrossVal =0, minCrossVal = 3;
		
		// maximum and minimum crosses on board
		int maxCross, minCross = 3;
		
		// number of tiles on board
		int count = 0;
		
		// number board (left to right)
		int boardNum = 0;
		
		// return value
		int result = 0;
		
		// loops through the three boards, left to right
		for(int i = 0; i < 3; i+=9){
			// initialize cross values on single board, looks crazy but REALLY computationally simple
			crosses[0] = board[i+0] + board[i+1] + board[i+2]; // top row
			crosses[1] = board[i+3] + board[i+4] + board[i+5]; // middle row
			crosses[2] = board[i+6] + board[i+7] + board[i+8]; // bottom row
			crosses[3] = board[i+0] + board[i+3] + board[i+6]; // left column
			crosses[4] = board[i+1] + board[i+4] + board[i+7]; // middle column
			crosses[5] = board[i+2] + board[i+5] + board[i+8]; // right column
			crosses[6] = board[i+0] + board[i+4] + board[i+8]; // negative slope
			crosses[7] = board[i+2] + board[i+4] + board[i+6]; // positive slope
			
			// Determine Number of X's on maxCross or minCross.
			// Also keeps track of which cross and on which board.
			for (int j = 0; j < 7;j++){
				if (crosses[j] <= minCrossVal){
					minCrossVal = crosses[j];
					minCross = j;
					boardNum = i;
					
				}
				if (crosses[j] >= maxCrossVal){
					maxCrossVal = crosses[j];
					maxCross = j;
					boardNum = i;
				}
			}
			
			// determine Number of X's on all three boards
			for (int j = 0; j < 7; j++){
				count += j;
			}
			
		}
		if (this.difficulty == 0){
			// loop through minCross to figure which tile is empty
		}
		else{
			// loop through maxCross to figure which tile is empty
		}
		
		return result;
	}

	public static void main(String[] args) {

	}
}
