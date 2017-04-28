package cs321;


import org.junit.Test; // fixes some compile problems with annotations
import static org.junit.Assert.*;

import java.util.Arrays;


public class AITests {
	public static void main(String args[]) {
		org.junit.runner.JUnitCore.main("AITests");
	}
	public static void failFmt(String fmt, Object... args) {
		fail(String.format(fmt, args));
	}
	
	// Sample Boards
	int[] a1 = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}; // empty board
	
	int[] a2 = {1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}; // first board dead (top row)
	int[] a3 = {0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}; // first board dead (middle row)
	int[] a4 = {0,0,0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}; // first board dead (bottom row)
	int[] a5 = {1,0,0,1,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}; // first board dead (left column)
	int[] a6 = {0,1,0,0,1,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}; // first board dead (middle column)
	int[] a7 = {0,0,1,0,0,1,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}; // first board dead (right column)
	int[] a8 = {0,0,1,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}; // first board dead (positive slope)
	int[] a9 = {1,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}; // first board dead (negative slope)
	
	int[] a10 = {0,0,0,0,0,0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}; // second board dead (top row)
	int[] a11 = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1}; // third board dead (bottom row)
	
	int[] a12 = {1,1,1,0,0,0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1}; // all boards dead
	
	int[] a13 = {1,1,1,0,0,0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}; // only third board alive
	int[] a14 = {1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1}; // only second board alive
	int[] a15 = {0,0,0,0,0,0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1}; // only first board alive
	
	// board 2 with least amount of tiles, board 1 with most, board 3 dead
	int[] a16 = {1,1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1}; 
	// board 1 dead, board 2 dead, board 3 only has losing moves available
	int[] a17 = {1,1,1,0,0,0,0,0,0,1,1,1,0,0,0,0,0,0,1,1,0,1,0,1,0,1,1}; 
	
	
	// Test Constructor
	
	// check Easy Difficulty
	@Test(timeout = 1000)
	public void constructor1(){
		AI a = new AI(0);
		if(a.difficulty != 0){
			failFmt("FAIL");
		}
	}
	
	// check Hard Difficulty
	@Test(timeout = 1000)
	public void constructor2(){
		AI a = new AI(1);
		if(a.difficulty != 1){
			failFmt("FAIL");
		}
	}
	
	// Test checkBoardDead
	
	// check empty board
	@Test(timeout = 1000)
	public void checkBoardDead1(){
		AI a = new AI(0);
		if(a.checkBoardDead(a1, 0) != -1){
			failFmt("FAIL");
		}
	}
	
	// check top row dead
	@Test(timeout = 1000)
	public void checkBoardDead2(){
		AI a = new AI(0);
		if(a.checkBoardDead(a2, 0) != 1){
			failFmt("FAIL");
		}
	}
	
	// check middle row dead
	@Test(timeout = 1000)
	public void checkBoardDead3(){
		AI a = new AI(0);
		if(a.checkBoardDead(a3, 0) != 1){
			failFmt("FAIL");
		}
	}
	
	// check bottom row dead
	@Test(timeout = 1000)
	public void checkBoardDead4(){
		AI a = new AI(0);
		if(a.checkBoardDead(a4, 0) != 1){
			failFmt("FAIL");
		}
	}
	
	// check left column dead
	@Test(timeout = 1000)
	public void checkBoardDead5(){
		AI a = new AI(0);
		if(a.checkBoardDead(a5, 0) != 1){
			failFmt("FAIL");
		}
	}
	
	// check middle column dead
	@Test(timeout = 1000)
	public void checkBoardDead6(){
		AI a = new AI(0);
		if(a.checkBoardDead(a6, 0) != 1){
			failFmt("FAIL");
		}
	}
	
	// check right column dead
	@Test(timeout = 1000)
	public void checkBoardDead7(){
		AI a = new AI(0);
		if(a.checkBoardDead(a7, 0) != 1){
			failFmt("FAIL");
		}
	}
	
	// check positive slope dead
	@Test(timeout = 1000)
	public void checkBoardDead8(){
		AI a = new AI(0);
		if(a.checkBoardDead(a8, 0) != 1){
			failFmt("FAIL");
		}
	}
	
	// check negative slope dead
	@Test(timeout = 1000)
	public void checkBoardDead9(){
		AI a = new AI(0);
		if(a.checkBoardDead(a9, 0) != 1){
			failFmt("FAIL");
		}
	}
	
	// check second board dead
	@Test(timeout = 1000)
	public void checkBoardDead10(){
		AI a = new AI(0);
		if(a.checkBoardDead(a10, 1) != 1){
			failFmt("FAIL");
		}
	}
	
	// check third board dead
	@Test(timeout = 1000)
	public void checkBoardDead11(){
		AI a = new AI(0);
		if(a.checkBoardDead(a11, 2) != 1){
			failFmt("FAIL");
		}
	}
	
	// Test whichBoardToMakeMove
	
	// check if all boards are dead
	@Test(timeout = 1000)
	public void whichBoardToMakeMove1(){
		boolean thrown;
		thrown = false;
		AI a = new AI(0);
		try{
			a.whichBoardToMakeMove(a12);
		}catch(Exception e){
			thrown = true;
		}
		if(!thrown){
			failFmt("FAIL");
		}
	}
	
	// check play board with first board dead (Easy and Hard)
	@Test(timeout = 1000)
	public void whichBoardToMakeMove2(){
		AI a = new AI(0);
		AI b = new AI(1);
		a.whichBoardToMakeMove(a2);
		b.whichBoardToMakeMove(a2);
		int aBoard = a.easyBoard;
		int bBoard = b.hardBoard;
		if ((aBoard == 0) || (bBoard == 0)){
			failFmt("FAIL");
		}
	}
	
	// check play board with second board dead (Easy and Hard)
	@Test(timeout = 1000)
	public void whichBoardToMakeMove3(){
		AI a = new AI(0);
		AI b = new AI(1);
		a.whichBoardToMakeMove(a10);
		b.whichBoardToMakeMove(a10);
		int aBoard = a.easyBoard;
		int bBoard = b.hardBoard;
		if ((aBoard == 1) || (bBoard == 1)){
			failFmt("FAIL");
		}
	}
	
	// check play board with third board dead (Easy and Hard)
	@Test(timeout = 1000)
	public void whichBoardToMakeMove4(){
		AI a = new AI(0);
		AI b = new AI(1);
		a.whichBoardToMakeMove(a11);
		b.whichBoardToMakeMove(a11);
		int aBoard = a.easyBoard;
		int bBoard = b.hardBoard;
		if ((aBoard == 2) || (bBoard == 2)){
			failFmt("FAIL");
		}
	}
	
	// check play board with first and second boards dead (Easy and Hard)
	@Test(timeout = 1000)
	public void whichBoardToMakeMove5(){
		AI a = new AI(0);
		AI b = new AI(1);
		a.whichBoardToMakeMove(a13);
		b.whichBoardToMakeMove(a13);
		int aBoard = a.easyBoard;
		int bBoard = b.hardBoard;
		if ((aBoard != 2) || (bBoard != 2)){
			failFmt("FAIL");
		}
	}
	
	// check play board with first and third boards dead (Easy and Hard)
	@Test(timeout = 1000)
	public void whichBoardToMakeMove6(){
		AI a = new AI(0);
		AI b = new AI(1);
		a.whichBoardToMakeMove(a14);
		b.whichBoardToMakeMove(a14);
		int aBoard = a.easyBoard;
		int bBoard = b.hardBoard;
		if ((aBoard != 1) || (bBoard != 1)){
			failFmt("FAIL");
		}
	}
	
	// check play board with second and third boards dead (Easy and Hard)
	@Test(timeout = 1000)
	public void whichBoardToMakeMove7(){
		AI a = new AI(0);
		AI b = new AI(1);
		a.whichBoardToMakeMove(a15);
		b.whichBoardToMakeMove(a15);
		int aBoard = a.easyBoard;
		int bBoard = b.hardBoard;
		if ((aBoard != 0) || (bBoard != 0)){
			failFmt("FAIL");
		}
	}
	
	// check play board with least amount of X's (Easy)
	@Test(timeout = 1000)
	public void whichBoardToMakeMove8(){
		AI a = new AI(0);
		a.whichBoardToMakeMove(a16);
		int aBoard = a.easyBoard;
		if (aBoard != 1){
			failFmt("FAIL");
		}
	}
	
	// check play board with most amount of X's (Hard)
	@Test(timeout = 1000)
	public void whichBoardToMakeMove9(){
		AI a = new AI(0);
		a.whichBoardToMakeMove(a16);
		int aBoard = a.hardBoard;
		if (aBoard != 0){
			failFmt("FAIL");
		}
	}
	
	// Test moveEasy
	
	// check move is made on third board
	@Test(timeout = 1000)
	public void moveEasy1(){
		AI a = new AI(0);
		int result = a.moveEasy(a13);
		if(result != 18){
			failFmt("FAIL");
		}

	}
	
	// check move is made on second board
	@Test(timeout = 1000)
	public void moveEasy2(){
		AI a = new AI(0);
		int result = a.moveEasy(a14);
		if(result != 9){
			failFmt("FAIL");
		}
	}
	
	// check move is made on first board
	@Test(timeout = 1000)
	public void moveEasy3(){
		AI a = new AI(0);
		int result = a.moveEasy(a15);
		if(result != 0){
			failFmt("FAIL");
		}
	}
	
	// check move is made on second board, since its least number of tiles
	@Test(timeout = 1000)
	public void moveEasy4(){
		AI a = new AI(0);
		int result = a.moveEasy(a16);
		if(result != 10){
			failFmt("FAIL");
		}
	}
	
	// check that Easy AI will make a losing move
	@Test(timeout = 1000)
	public void moveEasy5(){
		AI a = new AI(0);
		int result = a.moveEasy(a17);
		if(result != 20){
			failFmt("FAIL");
		}

	}
	
	// Test moveHard
	
	// check move is made on third board
	@Test(timeout = 1000)
	public void moveHard1(){
		AI a = new AI(0);
		int result = a.moveHard(a13);
		if(result != 22){
			failFmt("FAIL");
		}

	}
	
	// check move is made on second board
	@Test(timeout = 1000)
	public void moveHard2(){
		AI a = new AI(0);
		int result = a.moveHard(a14);
		if(result != 13){
			failFmt("FAIL");
		}
	}
	
	// check move is made on first board
	@Test(timeout = 1000)
	public void moveHard3(){
		AI a = new AI(0);
		int result = a.moveHard(a15);
		if(result != 4){
			failFmt("FAIL");
		}
	}
	
	// check move is made on first board, since its most number of tiles
	@Test(timeout = 1000)
	public void moveHard4(){
		AI a = new AI(0);
		int result = a.moveHard(a16);
		if(result != 2){
			failFmt("FAIL");
		}
	}
	
	// check that Hard AI will make a losing move
	@Test(timeout = 1000)
	public void moveHard5(){
		AI a = new AI(0);
		int result = a.moveHard(a17);
		if(result != 22){
			failFmt("FAIL");
		}

	}
	
	// Test makeMove
	
	// make moves for Easy difficulty
	@Test(timeout = 1000)
	public void makeMove1(){
		AI a = new AI(0);
		int[] temp = a.makeMove(a13);
		if(temp[18] != 1){
			failFmt("FAIL");
		}

	}
	
	@Test(timeout = 1000)
	public void makeMove2(){
		AI a = new AI(0);
		int[] temp = a.makeMove(a14);
		if(temp[9] != 1){
			failFmt("FAIL");
		}
	}
	
	@Test(timeout = 1000)
	public void makeMove3(){
		AI a = new AI(0);
		int[] temp = a.makeMove(a15);
		if(temp[0] != 1){
			failFmt("FAIL");
		}
	}
	
	@Test(timeout = 1000)
	public void makeMove4(){
		AI a = new AI(0);
		int[] temp = a.makeMove(a16);
		if(temp[10] != 1){
			failFmt("FAIL");
		}
	}
	
	@Test(timeout = 1000)
	public void makeMove5(){
		AI a = new AI(0);
		int[] temp = a.makeMove(a17);
		if(temp[20] != 1){
			failFmt("FAIL");
		}

	}
	
	// make move for Hard difficulty
	
	@Test(timeout = 1000)
	public void makeMove6(){
		AI a = new AI(1);
		int[] temp = a.makeMove(a13);
		if(temp[22] != 1){
			failFmt("FAIL");
		}

	}
	
	@Test(timeout = 1000)
	public void makeMove7(){
		AI a = new AI(1);
		int[] temp = a.makeMove(a14);
		if(temp[13] != 1){
			failFmt("FAIL");
		}
	}
	
	@Test(timeout = 1000)
	public void makeMove8(){
		AI a = new AI(1);
		int[] temp = a.makeMove(a15);
		if(temp[4] != 1){
			failFmt("FAIL");
		}
	}
	
	@Test(timeout = 1000)
	public void makeMove9(){
		AI a = new AI(1);
		int[] temp = a.makeMove(a16);
		if(temp[2] != 1){
			failFmt("FAIL");
		}
	}
	
	@Test(timeout = 1000)
	public void makeMove10(){
		AI a = new AI(1);
		int[] temp =a.makeMove(a17);
		if(temp[22] != 1){
			failFmt("FAIL");
		}

	}
	
	// Stress Tests
	
	// Stress test where easy v. itself
	@Test(timeout = 1000)
	public void stress1(){
		int[] ans = {1,1,1,0,0,0,0,0,0,1,1,1,0,0,0,0,0,0,1,1,1,0,0,0,0,0,0};
		AI a= new AI(0);
		int[] temp = a1;
		try{
			while(true){
				a.makeMove(temp);
			}
			
		}catch (Exception e){
			for(int i = 0; i < 27; i++){
				if(temp[i] != ans[i]){
					failFmt("FAIL");
				}
			}
		}
	}
	
	// Stress test where hard v. itself
	@Test(timeout = 1000)
	public void stress2(){
		int[] ans = {0,0,1,0,1,0,1,0,0,0,0,1,0,1,0,1,0,0,0,0,1,0,1,0,1,0,0};
		AI a = new AI(1);
		int[] temp = a1;
		try{
			while(true){
				a.makeMove(temp);
			}
			
		}catch (Exception e){
			for(int i = 0; i < 27; i++){
				if(temp[i] != ans[i]){
					failFmt("FAIL");
				}
			}
		}
	}
	
	// Stress test where easy v. easy
	@Test(timeout = 1000)
	public void stress3(){
		int[] ans = {1,1,1,0,0,0,0,0,0,1,1,1,0,0,0,0,0,0,1,1,1,0,0,0,0,0,0};
		AI a = new AI(0);
		AI b = new AI(0);
		int[] temp = a1;
		try{
			while(true){
				a.makeMove(temp);
				b.makeMove(temp);
			}
			
		}catch (Exception e){
			for(int i = 0; i < 27; i++){
				if(temp[i] != ans[i]){
					failFmt("FAIL");
				}
			}
		}
	}
	
	// Stress test where hard v. hard
	@Test(timeout = 1000)
	public void stress4(){
		int[] ans = {0,0,1,0,1,0,1,0,0,0,0,1,0,1,0,1,0,0,0,0,1,0,1,0,1,0,0};
		AI a = new AI(1);
		AI b = new AI(1);
		int[] temp = a1;
		try{
			while(true){
				a.makeMove(temp);
				b.makeMove(temp);
			}
			
		}catch (Exception e){
			for(int i = 0; i < 27; i++){
				if(temp[i] != ans[i]){
					failFmt("FAIL");
				}
			}
		}
	}
	
	// Stress test where easy v. hard
	@Test(timeout = 1000)
	public void stress5(){
		int[] ans = {1,1,1,0,0,0,0,0,0,1,0,0,0,1,0,0,0,1,1,0,0,0,1,0,0,0,1};
		AI a = new AI(0);
		AI b = new AI(1);
		int[] temp = a1;
		try{
			while(true){
				a.makeMove(temp);
				b.makeMove(temp);
			}
			
		}catch (Exception e){
			for(int i = 0; i < 27; i++){
				if(temp[i] != ans[i]){
					failFmt("FAIL");
				}
			}
		}
	}
}
