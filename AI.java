package cs321;

import java.util.Arrays;

/**
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
 * Hard. Easy is simply making moves on the board that 
 * is alive and has the fewest elements on it. Hard 
 * essentially kills boards as soon as possible
 * as this makes it harder for the player to move around
 * throughout the game. Easy does just the opposite to 
 * where the player has plenty of options to manage 
 * their chances throughout each respective board. By 
 * killing the board as fast as possible, we leave the
 * player with little to no option towards the end.
 *
 * @author Joseph Bessette
 * @version 1.0
 * @since 2017-04-11
 */

public class AI {

	// Easy is 0, Hard is 1;
    public int difficulty;
    
    // board selected by easy difficulty to make a move on
    int easyBoard = 0; 
    // number of X's on easy board
    int easyBoardCount = 0;
    // board selected by hard difficulty to make a move on
    int hardBoard = 0;
    // number of X's on hard board
    int hardBoardCount = 0;

	/**
     * Constructor for AI object
     * @return void
   	 */
	public AI(){}

	/**
	 * Constructor for AI object
	 * @param diffMode integer denoting level of difficulty
	 * @return void
	 */
	public AI(int diffMode){
		this.difficulty = diffMode;
	}
    
	/**
	 * Determines if a specific board is dead
	 * @param board array representation of the 3-X-T board
	 * @param boardNum which board to check if dead (0 for first, 1 for second, 2 for third)
	 * @return int -1 if board is not dead or 1 if board dead
	 */
	public int checkBoardDead(int[] board, int boardNum){
		// array containing all possible combinations of crosses
		int[] crosses = new int[8];
		
		int i = boardNum * 9;
		crosses[0] = board[i+0] + board[i+1] + board[i+2]; // top row
		crosses[1] = board[i+3] + board[i+4] + board[i+5]; // middle row
		crosses[2] = board[i+6] + board[i+7] + board[i+8]; // bottom row
		crosses[3] = board[i+0] + board[i+3] + board[i+6]; // left column
		crosses[4] = board[i+1] + board[i+4] + board[i+7]; // middle column
		crosses[5] = board[i+2] + board[i+5] + board[i+8]; // right column
		crosses[6] = board[i+0] + board[i+4] + board[i+8]; // negative slope
		crosses[7] = board[i+2] + board[i+4] + board[i+6]; // positive slope
			
		// traverse the possible combinations to see if a cross exists
		for(int j = 0; j < 8; j++){
			if (crosses[j] == 3){
				return 1;
			}
		}
		
		// board can't be dead if here since no cross had a total of 3 X's
		return -1;
	}
	
	/**
	 * Figures out which board the computer will make a move on for either difficulty
	 * @param board array representation of the 3-X-T board
	 * @return void
	 */
	public void whichBoardToMakeMove(int[] board){
		// determines which boards are dead from 0 to 2
		int[] deadBoards = new int[3];
		for(int i = 0; i < deadBoards.length; i++){
			deadBoards[i] = checkBoardDead(board, i);
		}
		
		// check if all boards are dead
		int count = 0;
		for(int i = 0; i < deadBoards.length; i++){
			count += deadBoards[i];
		}
		// throw exception if all boards are full (no move can be made).
		if(count == 3){
			throw new RuntimeException("Boards are all Full.");
		}
		
		
		// scan through playable boards to determine which board has the most and the least X's respectively
		boolean firstBoard = true;
		for (int i = 0; i < deadBoards.length; i++){
			int temp = 0;
			// if the board is dead, there is no need to scan it 
			if(deadBoards[i] != 1){
				
				// count up the amount of X's on ith board
				for(int j = 0; j < 8; j++){
					//determine which board has most and least X's
					temp += board[j+(i*9)];
				}
				
				// initialize first non-dead board
				if(firstBoard){
					this.easyBoardCount = temp;
					this.easyBoard = i;
					this.hardBoard = i;
					this.hardBoardCount = temp;
					firstBoard = false;
				}
				// focuses on board with least amount of elements
				if(temp <= this.easyBoardCount){
					this.easyBoardCount = temp;
					this.easyBoard = i;
				}
				// focuses on board with most amount of elements
				if(temp >= this.hardBoardCount){
					this.hardBoardCount = temp;
					this.hardBoard = i;
				}
			
			}
			
			
		}
	}

	/**
	 * Picks the smallest index on the board and plays that move for
	 * the Easy difficulty.
	 * @param board array representation of the 3-X-T board
	 * @return int index of where to mark a new X
	 */
	public int moveEasy(int[] board){
		int result = 0;
		// check available boards
		whichBoardToMakeMove(board);
		// iterate through board finding first available spot
		for(int i = 0; i < 8; i++){
			if(board[(this.easyBoard * 9) + i] == 0){
				result = (this.easyBoard * 9) + i;
				return result;
			}
		}
		
		return 0;
	}
	
	/**
	 * Plays the board that is alive and has the maximum amount of elements
	 * that are forming a cross. The goal is to kill the board as fast as possible.
	 * @param board array representation of the 3-X-T board
	 * @return int index of where to mark a new X
	 */
	public int moveHard(int[] board){
		int result = 0;
		// check available boards
		whichBoardToMakeMove(board);
		// first move for AI, if necessary 
		if(this.hardBoardCount == 0){
			result = (this.hardBoard * 9) + 4;
		}
		else{

			// Figures out what winning configuration we need to check out of eight total crosses
			int[] crosses = new int[8];
			int maxCross = 0;
			int maxCrossCount = 0;
			
			int i = this.hardBoard * 9;
			crosses[0] = board[i+0] + board[i+1] + board[i+2]; // top row
			crosses[1] = board[i+3] + board[i+4] + board[i+5]; // middle row
			crosses[2] = board[i+6] + board[i+7] + board[i+8]; // bottom row
			crosses[3] = board[i+0] + board[i+3] + board[i+6]; // left column
			crosses[4] = board[i+1] + board[i+4] + board[i+7]; // middle column
			crosses[5] = board[i+2] + board[i+5] + board[i+8]; // right column
			crosses[6] = board[i+0] + board[i+4] + board[i+8]; // negative slope
			crosses[7] = board[i+2] + board[i+4] + board[i+6]; // positive slope
			
			// find the cross most susceptible to a dead board (most amount of X's)
			for(int j=0; j < 8; j++){
				if(maxCrossCount <= crosses[j]){
					maxCross = j;
					maxCrossCount = crosses[j];
				}
			}
			
			// loop through cross to figure which tile is empty

			// scan top row for availability
			if(maxCross == 0){
				for(int j = 0; j < 3; j++){
					if(board[(this.hardBoard * 9) + j] == 0){
						result = (this.hardBoard * 9) + j;
						break;
					}
				}
			}
			// scan middle row for availability
			if(maxCross == 1){
				for(int j = 3; j < 6; j++){
					if(board[(this.hardBoard * 9) + j] == 0){
						result = (this.hardBoard * 9) + j;
						break;
					}
				}
			}
			// scan bottom row for availability
			if(maxCross == 2){
				for(int j = 7; j < 10; j++){
					if(board[(this.hardBoard * 9) + j] == 0){
						result = (this.hardBoard * 9) + j;
						break;
					}
				}
			}
			// scan left column for availability
			if(maxCross == 3){
				for(int j = 0; j < 7; j+=3){
					if(board[(this.hardBoard * 9) + j] == 0){
						result = (this.hardBoard * 9) + j;
						break;
					}
				}
			}
			// scan middle column for availability
			if(maxCross == 4){
				for(int j = 1; j < 8; j+=3){
					if(board[(this.hardBoard * 9) + j] == 0){
						result = (this.hardBoard * 9) + j;
						break;
					}
				}
			}
			// scan right column for availability
			if(maxCross == 5){
				for(int j = 2; j < 9; j+=3){
					if(board[(this.hardBoard * 9) + j] == 0){
						result = (this.hardBoard * 9) + j;
						break;
					}
				}
			}
			// scan negative slope for availability
			if(maxCross == 6){
				for(int j = 0; j < 9; j+=4){
					if(board[(this.hardBoard * 9) + j] == 0){
						result = (this.hardBoard * 9) + j;
						break;
					}
				}
			}
			// scan positive slope for availability
			if(maxCross == 7){
				for(int j = 6; j > 1; j-=2){
					if(board[(this.hardBoard * 9) + j] == 0){
						result = (this.hardBoard * 9) + j;
						break;
					}
				}
			}
		}
		return result;
	}
	
	/**
	 * Actually updates the board by placing a 1 where we want an X to go.
	 * This ultimately will represent an X on the board.
	 * @param board array representation of the 3-X-T board
	 * @return int[] newly updated board with correct move made
	 */
	public int[] makeMove(int[] board){
		// easy difficulty
		if(this.difficulty == 0){
			 int temp = moveEasy(board);
			 board[temp] = 1;
		}
		// hard difficulty
		else{
			int temp = moveHard(board);
			board[temp] = 1;
		}
		return board;
	}
	
	/**
	 * Converts the array to a String representation
	 * @param board array representation of the 3-X-T board
	 * @return String string representation of the board
	 */
	public String toString(int[] board){
		StringBuilder temp = new StringBuilder();
		temp.append("[");
		for(int i = 0; i < board.length; i++){
			temp.append(board[i] + ", ");
		}
		temp.delete(temp.length()-2 , temp.length());
		temp.append("]");
		String result = temp.toString();
		return result;
	}
}
