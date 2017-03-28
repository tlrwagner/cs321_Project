import java.util.*;
import java.io.PrintWriter;
import java.io.FileReader;

public class Game {

    public int currentPlayer;
    public AI ai_player;
    public boolean isAi;

    public Game(){
        this.isAi = false;
    }

    public Game(boolean usesAI){
        if(usesAI){
            this.isAi = true;
            this.ai_player = new AI();
        }
        else{
            this.isAi = false;
        }
    }

    public boolean hasWon(){
        return true;
    }

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

    public boolean loadGame(){
        try{
            Scanner in = new Scanner(new FileReader("saveGame.txt"));
            // System.out.println(in.nextLine());
            return true;
        }
        catch(Exception e){
            System.out.println("There was an error loading the game save.");
            System.out.println(e);
        }
        return false;
    }

    // public static void main(String[] args) {
    //     Game g = new Game();
    //     g.saveGame("test save");
    //     g.loadGame();
    // }
}
