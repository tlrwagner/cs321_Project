import java.util.*;
// Immutable.  Stores 3 strings referred to as entity, relation, and
// property. Each Record has a unique integer ID which is set on
// creation.  All records are made through the factory method
// Record.makeRecord(e,r,p).  Record which have some fields wild are
// created using Record.makeQuery(wild,e,r,p)
public class Game {

    public int currentPlayer;
    public AI ai_player;
    public boolean isAi;

    public Game(){

    }

    public boolean hasWon(){
        return true;
    }

    public boolean saveGame(){
        return true;
    }

    public boolean loadGame(){
        return true;
    }

    public static void main(String[] args) {

    }
}
