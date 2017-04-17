import java.util.*;
import java.io.PrintWriter;
import java.io.FileReader;

public class Game {

public int currentPlayer;
public AI ai_player;
public boolean isAi;

/**
 * Constructor for Game object
 * @return void
 */
public Game(){
        this.isAi = false;
}

/**
 * Constructor for Game object
 * @param  boolean usesAI        instance variable denoting if an AI object is being used
 * @return         void
 */
public Game(boolean usesAI){
        if(usesAI) {
                this.isAi = true;
                this.ai_player = new AI(0);
        }
        else{
                this.isAi = false;
        }
}

/**
 * if a player has won
 * @return if function ran successfully
 */
public boolean hasWon(boolean[] board){
        strArr = Array.asList(board);
        if(
                strArr[0] && strArr[1] && strArr[2] ||
                strArr[3] && strArr[4] && strArr[5] ||
                strArr[6] && strArr[7] && strArr[8] ||
                strArr[0] && strArr[3] && strArr[6] ||
                strArr[1] && strArr[4] && strArr[7] ||
                strArr[2] && strArr[5] && strArr[8] ||
                strArr[0] && strArr[4] && strArr[8] ||
                strArr[2] && strArr[4] && strArr[6] ||

                strArr.[9] && strArr.[10]) && strArr.[11]) ||
                strArr.[12]) && strArr.[13]) && strArr.[14]) ||
                strArr.[15]) && strArr.[16]) && strArr.[17]) ||
                strArr.[9] && strArr.[12]) && strArr.[15]) ||
                strArr.[10]) && strArr.[13]) && strArr.[16]) ||
                strArr.[11]) && strArr.[14]) && strArr.[17]) ||
                strArr.[0] && strArr.[13]) && strArr.[17]) ||
                strArr.[11]) && strArr.[13]) && strArr.[15]) ||

                strArr.[18] && strArr.[19] && strArr.[20] ||
                strArr.[21] && strArr.[22] && strArr.[23] ||
                strArr.[24] && strArr.[25] && strArr.[26] ||
                strArr.[18] && strArr.[21] && strArr.[22] ||
                strArr.[19] && strArr.[22] && strArr.[25] ||
                strArr.[20] && strArr.[23] && strArr.[26] ||
                strArr.[18] && strArr.[22] && strArr.[26] ||
                strArr.[20] && strArr.[22] && strArr.[24] ||
                ) {
                return true;
        }

        return false;
}

/**
 * Saves game, writes board status to saveGame.txt as a String
 * @param  String saveString    input String from GUI object representing the board
 * @return        if function ran successfully
 */
public boolean saveGame(boolean[] saveArray){
        String saveString = "";
        for(item : saveArray) {
                saveString += item + " ";
        }
        try{
                PrintWriter writer = new PrintWriter("saveGame.txt", "UTF-8");
                writer.println(saveString);
                writer.close();
                return true;
        }
        catch (Exception e) {
                System.out.println("There was an error saving the game.");
                System.out.println(e);
        }
        return false;
}

/**
 * loads String from saveGame.txt
 * @return if function ran successfully
 */
public String[] loadGame(){
        result = String[26];
        try{
                Scanner in = new Scanner(new FileReader("saveGame.txt"));
                while(in.hasNext()) {
                        result.append(in.next());
                }
                return true;
        }
        catch(Exception e) {
                System.out.println("There was an error loading the game save.");
                System.out.println(e);
        }
        return false;
}
}
