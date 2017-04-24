// This is a Misere Game of Tic Tac Toe
import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

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


public static void main(String[] args) {
    ThreeXT_main g = new ThreeXT_main();

}
}
