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
     * if a player has won
     * @return if function ran successfully
     */
    public boolean hasWon(String[] board){
        strArr = Array.asList(board);
        if(
        strArr.contains("0") && strArr.contains("1") && strArr.contains("2") ||
        strArr.contains("3") && strArr.contains("4") && strArr.contains("5") ||
        strArr.contains("6") && strArr.contains("7") && strArr.contains("8") ||
        strArr.contains("0") && strArr.contains("3") && strArr.contains("6") ||
        strArr.contains("1") && strArr.contains("4") && strArr.contains("7") ||
        strArr.contains("2") && strArr.contains("5") && strArr.contains("8") ||
        strArr.contains("0") && strArr.contains("4") && strArr.contains("8") ||
        strArr.contains("2") && strArr.contains("4") && strArr.contains("6") ||

        strArr.contains("9") && strArr.contains("10") && strArr.contains("11") ||
        strArr.contains("12") && strArr.contains("13") && strArr.contains("14") ||
        strArr.contains("15") && strArr.contains("16") && strArr.contains("17") ||
        strArr.contains("9") && strArr.contains("12") && strArr.contains("15") ||
        strArr.contains("10") && strArr.contains("13") && strArr.contains("16") ||
        strArr.contains("11") && strArr.contains("14") && strArr.contains("17") ||
        strArr.contains("0") && strArr.contains("13") && strArr.contains("17") ||
        strArr.contains("11") && strArr.contains("13") && strArr.contains("15") ||

        strArr.contains("18") && strArr.contains("19") && strArr.contains("20") ||
        strArr.contains("21") && strArr.contains("22") && strArr.contains("23") ||
        strArr.contains("24") && strArr.contains("25") && strArr.contains("26") ||
        strArr.contains("18") && strArr.contains("21") && strArr.contains("22") ||
        strArr.contains("19") && strArr.contains("22") && strArr.contains("25") ||
        strArr.contains("20") && strArr.contains("23") && strArr.contains("26") ||
        strArr.contains("18") && strArr.contains("22") && strArr.contains("26") ||
        strArr.contains("20") && strArr.contains("22") && strArr.contains("24") ||
        ){
            return true;
        }

        return false;
    }

    /**
     * Saves game, writes board status to saveGame.txt as a String
     * @param  String saveString    input String from GUI object representing the board
     * @return        if function ran successfully
     */
    public boolean saveGame(String[] saveArray){
        String saveString = "";
        for(item : saveArray){
            saveString += item;
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
