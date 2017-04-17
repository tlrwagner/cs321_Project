// This is a Misere Game of Tic Tac Toe
import java.util.*;

public class ThreeXT_main {
public Game game;
public GUI gui;
public String lastTurn;

public ThreeXT_main(){
        this.game = new Game();
        this.gui = new GUI();
        this.gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.gui.setSize(1280, 1024);
        this.gui.setLocationRelativeTo(null);
        this.gui.setVisible(true);

        // while(!game.hasWon(gui.getBoard())){
        //
        // }
}

/**
 * runs flow for game object
 * @return if function ran successfully
 */
public boolean runGame(){
        return true;
}

public static void main(String[] args) {

}
}
