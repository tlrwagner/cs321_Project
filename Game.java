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
        if(usesAI){
            this.isAi = true;
            this.ai_player = new AI();
        }
        else{
            this.isAi = false;
        }
    }

    /**
     * determines which player has won
     * @return if function ran successfully
     */
    public boolean hasWon(){
        return true;
    }

    /**
     * Saves game, writes board status to saveGame.txt as a String
     * @param  String saveString    input String from GUI object representing the board
     * @return        if function ran successfully
     */
    public boolean saveGame(String saveString){
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
        return true;
    }

    /**
     * loads String from saveGame.txt
     * @return if function ran successfully
     */
    public boolean loadGame(){
        try{
            Scanner in = new Scanner(new FileReader("saveGame.txt"));
            return true;
        }
        catch(Exception e){
            System.out.println("There was an error loading the game save.");
            System.out.println(e);
        }
        return false;
    }
}
