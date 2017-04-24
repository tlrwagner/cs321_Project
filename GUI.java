import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.PrintWriter;
import java.io.FileReader;
import java.util.*;

public class GUI extends JFrame
{

   JScrollPane scrollPane;
   ImageIcon icon;
   Image image;
   private JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, b16, b17, b18, b19, b20, b21, b22, b23, b24, b25, b26, b27, exit, AI, save, load;
   JLabel title, playerTurn, board1Complete, board2Complete, board3Complete;
   private int numTurn = 1, count_win = 0, count1 = 0, count2 = 0, count3 = 0, count4 = 0, count5 = 0, count6 = 0, count7 = 0, count8 = 0, count9 = 0, count10 = 0, count11 = 0, count12 = 0, count13 = 0, count14 = 0, count15 = 0, count16 = 0, count17 = 0, count18 = 0, count19 = 0, count20 = 0, count21 = 0, count22 = 0, count23 = 0, count24 = 0, count25 = 0, count26 = 0, count27 = 0;
   JFrame frame2;

   public boolean [] buttonsPressed = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};


   public AI ai_player;
   public boolean hasAI = false;
   public int aiDifficulty = 0;
   public int[] buttonsPressedToInt(){
       int[] result = new int[27];
       int i = 0;
       for(boolean item : this.buttonsPressed){
           if(item){
               result[i] = 1;
           }
           else{
               result[i] = 0;
           }
           i++;
       }
       return result;
   }
   public int getAiMove(){
       if(this.ai_player.difficulty == 0){
           return this.ai_player.moveEasy(this.buttonsPressedToInt());
       }
       else{
           return this.ai_player.moveHard(this.buttonsPressedToInt());
       }

   }
   public void aiPressButton(){
       int move = getAiMove();
       switch (move){
           case 0: b1.doClick(); break;
           case 1: b2.doClick();break;
           case 2: b3.doClick();break;
           case 3: b4.doClick();break;
           case 4: b5.doClick();break;
           case 5: b6.doClick();break;
           case 6: b7.doClick();break;
           case 7: b8.doClick();break;
           case 8: b9.doClick();break;
           case 9: b10.doClick();break;
           case 10: b11.doClick();break;
           case 11: b12.doClick();break;
           case 12: b13.doClick();break;
           case 13: b14.doClick();break;
           case 14: b15.doClick();break;
           case 15: b16.doClick();break;
           case 16: b17.doClick();break;
           case 17: b18.doClick();break;
           case 18: b19.doClick();break;
           case 19: b20.doClick();break;
           case 20: b21.doClick();break;
           case 21: b22.doClick();break;
           case 22: b23.doClick();break;
           case 23: b24.doClick();break;
           case 24: b25.doClick();break;
           case 25: b26.doClick();break;
           case 26: b27.doClick();break;
           default:
               break;

       }
   }
   public void pressButton(int buttonToPress){
       switch (buttonToPress){
           case 0: b1.doClick(); break;
           case 1: b2.doClick();break;
           case 2: b3.doClick();break;
           case 3: b4.doClick();break;
           case 4: b5.doClick();break;
           case 5: b6.doClick();break;
           case 6: b7.doClick();break;
           case 7: b8.doClick();break;
           case 8: b9.doClick();break;
           case 9: b10.doClick();break;
           case 10: b11.doClick();break;
           case 11: b12.doClick();break;
           case 12: b13.doClick();break;
           case 13: b14.doClick();break;
           case 14: b15.doClick();break;
           case 15: b16.doClick();break;
           case 16: b17.doClick();break;
           case 17: b18.doClick();break;
           case 18: b19.doClick();break;
           case 19: b20.doClick();break;
           case 20: b21.doClick();break;
           case 21: b22.doClick();break;
           case 22: b23.doClick();break;
           case 23: b24.doClick();break;
           case 24: b25.doClick();break;
           case 25: b26.doClick();break;
           case 26: b27.doClick();break;
           default:
               break;

       }
   }
   public boolean saveGame(boolean[] saveArray){
           String saveString = "";
           for(boolean item : saveArray) {
                   saveString += String.valueOf(item) + " ";
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
   public boolean loadGame(){
           String[] result = new String[26];
           try{
                   Scanner in = new Scanner(new FileReader("saveGame.txt"));
                   int i = 0;
                   while(in.hasNext()) {
                           // result.append(in.next());
                           if(Boolean.parseBoolean(in.next())){
                               pressButton(i);
                           }
                           i++;
                   }
                   return true;
           }
           catch(Exception e) {
                   System.out.println("There was an error loading the game save.");
                   System.out.println(e);
           }
           return false;
   }

   public GUI()
   {
      icon = new ImageIcon("bckgrnd.jpg");
      this.ai_player = new AI(0);



      JPanel panel =
         new JPanel()
         {
            protected void paintComponent(Graphics g)
            {
               //Display image at full size
               g.drawImage(icon.getImage(), 0, 0, null);

               //Scale image to size of component
               Dimension d = getSize();
               g.drawImage(icon.getImage(), 0, 0, d.width, d.height, null);

               super.paintComponent(g);
            }
         };

      panel.setLayout(new GridLayout(5,1));
      panel.setOpaque(false);
      panel.setPreferredSize( new Dimension(400, 400) );
      scrollPane = new JScrollPane(panel);
      getContentPane().add(scrollPane);

      title = new JLabel("3-X-T", JLabel.CENTER);
      title.setFont(new Font("consolas", Font.BOLD, 70));
      title.setForeground(Color.WHITE);
      panel.add(title);

      JPanel boardResults = new JPanel(new GridLayout(1,3));
      boardResults.setOpaque(false);
      panel.add(boardResults);

      board1Complete = new JLabel("", JLabel.CENTER);
      boardResults.add(board1Complete);

      JLabel empty = new JLabel("");
      boardResults.add(empty);

      board3Complete = new JLabel("", JLabel.CENTER);
      boardResults.add(board3Complete);

      JPanel panel2 = new JPanel(new GridLayout(1,3));
      panel2.setOpaque(false);
      panel.add(panel2);

      JPanel tic = new JPanel(new GridLayout(3,3, 5, 5));
      tic.setOpaque(false);
      panel2.add(tic);

      b1 = new JButton();
      b1.setOpaque(false);
      b1.addActionListener(new Listener());
      tic.add(b1);

      b2 = new JButton();
      b2.setOpaque(false);
      b2.addActionListener(new Listener2());
      tic.add(b2);

      b3 = new JButton();
      b3.setOpaque(false);
      b3.addActionListener(new Listener3());
      tic.add(b3);

      b4 = new JButton();
      b4.setOpaque(false);
      b4.addActionListener(new Listener4());
      tic.add(b4);

      b5 = new JButton();
      b5.setOpaque(false);
      b5.addActionListener(new Listener5());
      tic.add(b5);

      b6 = new JButton();
      b6.setOpaque(false);
      b6.addActionListener(new Listener6());
      tic.add(b6);

      b7 = new JButton();
      b7.setOpaque(false);
      b7.addActionListener(new Listener7());
      tic.add(b7);

      b8 = new JButton();
      b8.setOpaque(false);
      b8.addActionListener(new Listener8());
      tic.add(b8);

      b9 = new JButton();
      b9.setOpaque(false);
      b9.addActionListener(new Listener9());
      tic.add(b9);

      board2Complete = new JLabel("", JLabel.CENTER);
      panel2.add(board2Complete);

      JPanel toe = new JPanel(new GridLayout(3,3, 5, 5));
      toe.setOpaque(false);
      panel2.add(toe);

      b19 = new JButton();
      b19.setOpaque(false);
      b19.addActionListener(new Listener19());
      toe.add(b19);

      b20 = new JButton();
      b20.setOpaque(false);
      b20.addActionListener(new Listener20());
      toe.add(b20);

      b21 = new JButton();
      b21.setOpaque(false);
      b21.addActionListener(new Listener21());
      toe.add(b21);

      b22 = new JButton();
      b22.setOpaque(false);
      b22.addActionListener(new Listener22());
      toe.add(b22);

      b23 = new JButton();
      b23.setOpaque(false);
      b23.addActionListener(new Listener23());
      toe.add(b23);

      b24 = new JButton();
      b24.setOpaque(false);
      b24.addActionListener(new Listener24());
      toe.add(b24);

      b25 = new JButton();
      b25.setOpaque(false);
      b25.addActionListener(new Listener25());
      toe.add(b25);

      b26 = new JButton();
      b26.setOpaque(false);
      b26.addActionListener(new Listener26());
      toe.add(b26);

      b27 = new JButton();
      b27.setOpaque(false);
      b27.addActionListener(new Listener27());
      toe.add(b27);

      JPanel DUMMIES = new JPanel(new GridLayout(1,3));
      DUMMIES.setOpaque(false);
      panel.add(DUMMIES);

      JPanel dummy2 = new JPanel(new GridLayout(3,3));
      dummy2.setOpaque(false);
      DUMMIES.add(dummy2);

      JPanel tac = new JPanel(new GridLayout(3,3, 5, 5));
      tac.setOpaque(false);
      DUMMIES.add(tac);

      b10 = new JButton();
      b10.setOpaque(false);
      b10.addActionListener(new Listener10());
      tac.add(b10);

      b11 = new JButton();
      b11.setOpaque(false);
      b11.addActionListener(new Listener11());
      tac.add(b11);

      b12 = new JButton();
      b12.setOpaque(false);
      b12.addActionListener(new Listener12());
      tac.add(b12);

      b13 = new JButton();
      b13.setOpaque(false);
      b13.addActionListener(new Listener13());
      tac.add(b13);

      b14 = new JButton();
      b14.setOpaque(false);
      b14.addActionListener(new Listener14());
      tac.add(b14);

      b15 = new JButton();
      b15.setOpaque(false);
      b15.addActionListener(new Listener15());
      tac.add(b15);

      b16 = new JButton();
      b16.setOpaque(false);
      b16.addActionListener(new Listener16());
      tac.add(b16);

      b17 = new JButton();
      b17.setOpaque(false);
      b17.addActionListener(new Listener17());
      tac.add(b17);

      b18 = new JButton();
      b18.setOpaque(false);
      b18.addActionListener(new Listener18());
      tac.add(b18);

      JPanel dummy3 = new JPanel(new GridLayout(3,3));
      dummy3.setOpaque(false);
      DUMMIES.add(dummy3);

      JPanel panel3 = new JPanel(new BorderLayout());
      panel3.setOpaque(false);
      panel.add(panel3);

      playerTurn = new JLabel("Player:  " + numTurn);
      playerTurn.setFont(new Font("consolas", Font.BOLD, 20));
      playerTurn.setForeground(Color.WHITE);
      panel3.add(playerTurn, BorderLayout.WEST);

      JPanel panelExit = new JPanel(new FlowLayout());
      panelExit.setOpaque(false);
      panel3.add(panelExit, BorderLayout.SOUTH);

      exit = new JButton("EXIT");
      exit.setOpaque(false);
      exit.addActionListener(new exit_Listener());
      panelExit.add(exit);

      JPanel panelAI = new JPanel(new GridLayout(3,1));
      panelAI.setOpaque(false);
      panel3.add(panelAI, BorderLayout.EAST);

      AI = new JButton("AI off");
      AI.setOpaque(false);
      AI.addActionListener(new AIToggle_Listener());
      panelAI.add(AI);
      save = new JButton("Save Game");
      save.setOpaque(false);
      save.addActionListener(new Save_Listener());
      panelAI.add(save);
      load = new JButton("Load Game");
      load.setOpaque(false);
      load.addActionListener(new Load_Listener());
      panelAI.add(load);
   }

   private class AIToggle_Listener implements ActionListener{
       public void actionPerformed(ActionEvent e){
           if(hasAI && ai_player.difficulty == 1){
               hasAI = !hasAI;
               AI.setText("AI off");
           }
           else if(hasAI && ai_player.difficulty == 0){
               ai_player.difficulty = 1;
               AI.setText("AI Hard");
           }
           else{
               hasAI = !hasAI;
               ai_player.difficulty = 0;
               AI.setText("AI Easy");
           }

       }
   }
   private class Save_Listener implements ActionListener{
       public void actionPerformed(ActionEvent e){
           saveGame(buttonsPressed);
           JOptionPane.showMessageDialog(frame2,"Game Saved");

       }
   }private class Load_Listener implements ActionListener{
       public void actionPerformed(ActionEvent e){
           loadGame();
           JOptionPane.showMessageDialog(frame2,"Game Loaded");

       }
   }

   private class exit_Listener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         System.exit(1);
      }

   }

   private class Listener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         b1.setText("X");
         b1.setFont(new Font("consolas", Font.BOLD, 30));
         b1.setForeground(Color.BLACK);
         count1++;


         buttonsPressed[0] = true;



         if(count1 == 1)
         {
            if(numTurn == 1)
               numTurn = numTurn + 1;
            else
               numTurn = numTurn - 1;

            playerTurn.setText("Player:  " + numTurn);
         }

         if((count4 > 0 && count7 > 0) || (count5 > 0 && count9 > 0) || (count2 > 0 && count3 > 0))
         {
            b1.setEnabled(false);
            b2.setEnabled(false);
            b3.setEnabled(false);
            b4.setEnabled(false);
            b5.setEnabled(false);
            b6.setEnabled(false);
            b7.setEnabled(false);
            b8.setEnabled(false);
            b9.setEnabled(false);
            board1Complete.setText("X");
            board1Complete.setFont(new Font("consolas", Font.BOLD, 50));
            board1Complete.setForeground(Color.WHITE);

            count_win++;

            if(count_win==3)
            {
               JOptionPane.showMessageDialog(frame2,"The winner is Player " + numTurn);
            }

         }
         if(hasAI && numTurn == 2){
             aiPressButton();
         }
      }

   }

   private class Listener2 implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         b2.setText("X");
         b2.setFont(new Font("consolas", Font.BOLD, 30));
         b2.setForeground(Color.BLACK);
         count2++;

         buttonsPressed[1] = true;

         if(count2 == 1)
         {
            if(numTurn == 1)
               numTurn = numTurn + 1;
            else
               numTurn = numTurn - 1;

            playerTurn.setText("Player:  " + numTurn);
         }

         if((count1>0 && count3>0) || (count5>0 && count8>0))
         {
            b1.setEnabled(false);
            b2.setEnabled(false);
            b3.setEnabled(false);
            b4.setEnabled(false);
            b5.setEnabled(false);
            b6.setEnabled(false);
            b7.setEnabled(false);
            b8.setEnabled(false);
            b9.setEnabled(false);
            board1Complete.setText("X");
            board1Complete.setFont(new Font("consolas", Font.BOLD, 50));
            board1Complete.setForeground(Color.WHITE);

            count_win++;

            if(count_win==3)
            {
               JOptionPane.showMessageDialog(frame2,"The winner is Player " + numTurn);
            }
         }
         if(hasAI && numTurn == 2){
             aiPressButton();
         }
      }

   }

   private class Listener3 implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         b3.setText("X");
         b3.setFont(new Font("consolas", Font.BOLD, 30));
         b3.setForeground(Color.BLACK);
         count3++;


         buttonsPressed[2] = true;

         if(count3 == 1)
         {
            if(numTurn == 1)
               numTurn = numTurn + 1;
            else
               numTurn = numTurn - 1;

            playerTurn.setText("Player:  " + numTurn);
         }

         if((count1>0 && count2>0) || (count6>0 && count9>0) || (count7>0 && count5>0))
         {
            b1.setEnabled(false);
            b2.setEnabled(false);
            b3.setEnabled(false);
            b4.setEnabled(false);
            b5.setEnabled(false);
            b6.setEnabled(false);
            b7.setEnabled(false);
            b8.setEnabled(false);
            b9.setEnabled(false);
            board1Complete.setText("X");
            board1Complete.setFont(new Font("consolas", Font.BOLD, 50));
            board1Complete.setForeground(Color.WHITE);

            count_win++;

            if(count_win==3)
            {
               JOptionPane.showMessageDialog(frame2,"The winner is Player " + numTurn);
            }
         }
         if(hasAI && numTurn == 2){
             aiPressButton();
         }
      }

   }

   private class Listener4 implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         b4.setText("X");
         b4.setFont(new Font("consolas", Font.BOLD, 30));
         b4.setForeground(Color.BLACK);
         count4++;


         buttonsPressed[3] = true;

         if(count4 == 1)
         {
            if(numTurn == 1)
               numTurn = numTurn + 1;
            else
               numTurn = numTurn - 1;

            playerTurn.setText("Player:  " + numTurn);
         }

         if((count1>0 && count7>0) || (count5>0 && count6>0))
         {
            b1.setEnabled(false);
            b2.setEnabled(false);
            b3.setEnabled(false);
            b4.setEnabled(false);
            b5.setEnabled(false);
            b6.setEnabled(false);
            b7.setEnabled(false);
            b8.setEnabled(false);
            b9.setEnabled(false);
            board1Complete.setText("X");
            board1Complete.setFont(new Font("consolas", Font.BOLD, 50));
            board1Complete.setForeground(Color.WHITE);

            count_win++;

            if(count_win==3)
            {
               JOptionPane.showMessageDialog(frame2,"The winner is Player " + numTurn);
            }
         }
         if(hasAI && numTurn == 2){
             aiPressButton();
         }
      }

   }

   private class Listener5 implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         b5.setText("X");
         b5.setFont(new Font("consolas", Font.BOLD, 30));
         b5.setForeground(Color.BLACK);
         count5++;


         buttonsPressed[4] = true;

         if(count5 == 1)
         {
            if(numTurn == 1)
               numTurn = numTurn + 1;
            else
               numTurn = numTurn - 1;

            playerTurn.setText("Player:  " + numTurn);
         }

         if((count1>0 && count9>0) || (count2>0 && count8>0) || (count3>0 && count7>0) || (count4>0 && count6>0))
         {
            b1.setEnabled(false);
            b2.setEnabled(false);
            b3.setEnabled(false);
            b4.setEnabled(false);
            b5.setEnabled(false);
            b6.setEnabled(false);
            b7.setEnabled(false);
            b8.setEnabled(false);
            b9.setEnabled(false);
            board1Complete.setText("X");
            board1Complete.setFont(new Font("consolas", Font.BOLD, 50));
            board1Complete.setForeground(Color.WHITE);

            count_win++;

            if(count_win==3)
            {
               JOptionPane.showMessageDialog(frame2,"The winner is Player " + numTurn);
            }
         }
         if(hasAI && numTurn == 2){
             aiPressButton();
         }
      }

   }

   private class Listener6 implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         b6.setText("X");
         b6.setFont(new Font("consolas", Font.BOLD, 30));
         b6.setForeground(Color.BLACK);
         count6++;


         buttonsPressed[5] = true;

         if(count6 == 1)
         {
            if(numTurn == 1)
               numTurn = numTurn + 1;
            else
               numTurn = numTurn - 1;

            playerTurn.setText("Player:  " + numTurn);
         }

         if((count3>0 && count9>0) || (count4>0 && count5>0))
         {
            b1.setEnabled(false);
            b2.setEnabled(false);
            b3.setEnabled(false);
            b4.setEnabled(false);
            b5.setEnabled(false);
            b6.setEnabled(false);
            b7.setEnabled(false);
            b8.setEnabled(false);
            b9.setEnabled(false);
            board1Complete.setText("X");
            board1Complete.setFont(new Font("consolas", Font.BOLD, 50));
            board1Complete.setForeground(Color.WHITE);

            count_win++;

            if(count_win==3)
            {
               JOptionPane.showMessageDialog(frame2,"The winner is Player " + numTurn);
            }
         }
         if(hasAI && numTurn == 2){
             aiPressButton();
         }
      }

   }

   private class Listener7 implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         b7.setText("X");
         b7.setFont(new Font("consolas", Font.BOLD, 30));
         b7.setForeground(Color.BLACK);
         count7++;


         buttonsPressed[6] = true;

         if(count7 == 1)
         {
            if(numTurn == 1)
               numTurn = numTurn + 1;
            else
               numTurn = numTurn - 1;

            playerTurn.setText("Player:  " + numTurn);
         }

         if((count1>0 && count4>0) || (count5>0 && count3>0) || (count8>0 && count9>0))
         {
            b1.setEnabled(false);
            b2.setEnabled(false);
            b3.setEnabled(false);
            b4.setEnabled(false);
            b5.setEnabled(false);
            b6.setEnabled(false);
            b7.setEnabled(false);
            b8.setEnabled(false);
            b9.setEnabled(false);
            board1Complete.setText("X");
            board1Complete.setFont(new Font("consolas", Font.BOLD, 50));
            board1Complete.setForeground(Color.WHITE);

            count_win++;

            if(count_win==3)
            {
               JOptionPane.showMessageDialog(frame2,"The winner is Player " + numTurn);
            }
         }
         if(hasAI && numTurn == 2){
             aiPressButton();
         }
      }

   }

   private class Listener8 implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         b8.setText("X");
         b8.setFont(new Font("consolas", Font.BOLD, 30));
         b8.setForeground(Color.BLACK);
         count8++;


         buttonsPressed[7] = true;

         if(count8 == 1)
         {
            if(numTurn == 1)
               numTurn = numTurn + 1;
            else
               numTurn = numTurn - 1;

            playerTurn.setText("Player:  " + numTurn);
         }

         if((count7>0 && count9>0) || (count2>0 && count5>0))
         {
            b1.setEnabled(false);
            b2.setEnabled(false);
            b3.setEnabled(false);
            b4.setEnabled(false);
            b5.setEnabled(false);
            b6.setEnabled(false);
            b7.setEnabled(false);
            b8.setEnabled(false);
            b9.setEnabled(false);
            board1Complete.setText("X");
            board1Complete.setFont(new Font("consolas", Font.BOLD, 50));
            board1Complete.setForeground(Color.WHITE);

            count_win++;

            if(count_win==3)
            {
               JOptionPane.showMessageDialog(frame2,"The winner is Player " + numTurn);
            }
         }
         if(hasAI && numTurn == 2){
             aiPressButton();
         }
      }

   }

   private class Listener9 implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         b9.setText("X");
         b9.setFont(new Font("consolas", Font.BOLD, 30));
         b9.setForeground(Color.BLACK);
         count9++;


         buttonsPressed[8] = true;

         if(count9 == 1)
         {
            if(numTurn == 1)
               numTurn = numTurn + 1;
            else
               numTurn = numTurn - 1;

            playerTurn.setText("Player:  " + numTurn);
         }

         if((count3>0 && count6>0) || (count1>0 && count5>0) || (count7>0 && count8>0))
         {
            b1.setEnabled(false);
            b2.setEnabled(false);
            b3.setEnabled(false);
            b4.setEnabled(false);
            b5.setEnabled(false);
            b6.setEnabled(false);
            b7.setEnabled(false);
            b8.setEnabled(false);
            b9.setEnabled(false);
            board1Complete.setText("X");
            board1Complete.setFont(new Font("consolas", Font.BOLD, 50));
            board1Complete.setForeground(Color.WHITE);

            count_win++;

            if(count_win==3)
            {
               JOptionPane.showMessageDialog(frame2,"The winner is Player " + numTurn);
            }
         }
         if(hasAI && numTurn == 2){
             aiPressButton();
         }
      }

   }

   private class Listener19 implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         b19.setText("X");
         b19.setFont(new Font("consolas", Font.BOLD, 30));
         b19.setForeground(Color.BLACK);
         count19++;



         buttonsPressed[18] = true;

         if(count19 == 1)
         {
            if(numTurn == 1)
               numTurn = numTurn + 1;
            else
               numTurn = numTurn - 1;

            playerTurn.setText("Player:  " + numTurn);
         }

         if((count22 > 0 && count25 > 0) || (count20 > 0 && count21 > 0) || (count23 > 0 && count27 > 0))
         {
            b19.setEnabled(false);
            b20.setEnabled(false);
            b21.setEnabled(false);
            b22.setEnabled(false);
            b23.setEnabled(false);
            b24.setEnabled(false);
            b25.setEnabled(false);
            b26.setEnabled(false);
            b27.setEnabled(false);
            board3Complete.setText("X");
            board3Complete.setFont(new Font("consolas", Font.BOLD, 50));
            board3Complete.setForeground(Color.WHITE);

            count_win++;

            if(count_win==3)
            {
               JOptionPane.showMessageDialog(frame2,"The winner is Player " + numTurn);
            }

         }
         if(hasAI && numTurn == 2){
             aiPressButton();
         }
      }

   }

   private class Listener20 implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         b20.setText("X");
         b20.setFont(new Font("consolas", Font.BOLD, 30));
         b20.setForeground(Color.BLACK);
         count20++;


         buttonsPressed[19] = true;

         if(count20 == 1)
         {
            if(numTurn == 1)
               numTurn = numTurn + 1;
            else
               numTurn = numTurn - 1;

            playerTurn.setText("Player:  " + numTurn);
         }

         if((count19>0 && count21>0) || (count23>0 && count26>0))
         {
            b19.setEnabled(false);
            b20.setEnabled(false);
            b21.setEnabled(false);
            b22.setEnabled(false);
            b23.setEnabled(false);
            b24.setEnabled(false);
            b25.setEnabled(false);
            b26.setEnabled(false);
            b27.setEnabled(false);
            board3Complete.setText("X");
            board3Complete.setFont(new Font("consolas", Font.BOLD, 50));
            board3Complete.setForeground(Color.WHITE);

            count_win++;

            if(count_win==3)
            {
               JOptionPane.showMessageDialog(frame2,"The winner is Player " + numTurn);
            }
         }
         if(hasAI && numTurn == 2){
             aiPressButton();
         }
      }

   }

   private class Listener21 implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         b21.setText("X");
         b21.setFont(new Font("consolas", Font.BOLD, 30));
         b21.setForeground(Color.BLACK);
         count21++;


         buttonsPressed[20] = true;

         if(count21 == 1)
         {
            if(numTurn == 1)
               numTurn = numTurn + 1;
            else
               numTurn = numTurn - 1;

            playerTurn.setText("Player:  " + numTurn);
         }

         if((count19>0 && count20>0) || (count23>0 && count25>0) || (count24>0 && count27>0))
         {
            b19.setEnabled(false);
            b20.setEnabled(false);
            b21.setEnabled(false);
            b22.setEnabled(false);
            b23.setEnabled(false);
            b24.setEnabled(false);
            b25.setEnabled(false);
            b26.setEnabled(false);
            b27.setEnabled(false);
            board3Complete.setText("X");
            board3Complete.setFont(new Font("consolas", Font.BOLD, 50));
            board3Complete.setForeground(Color.WHITE);

            count_win++;

            if(count_win==3)
            {
               JOptionPane.showMessageDialog(frame2,"The winner is Player " + numTurn);
            }
         }
         if(hasAI && numTurn == 2){
             aiPressButton();
         }
      }

   }

   private class Listener22 implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         b22.setText("X");
         b22.setFont(new Font("consolas", Font.BOLD, 30));
         b22.setForeground(Color.BLACK);
         count22++;

         buttonsPressed[21] = true;

         if(count22 == 1)
         {
            if(numTurn == 1)
               numTurn = numTurn + 1;
            else
               numTurn = numTurn - 1;

            playerTurn.setText("Player:  " + numTurn);
         }

         if((count19>0 && count25>0) || (count23>0 && count24>0))
         {
            b19.setEnabled(false);
            b20.setEnabled(false);
            b21.setEnabled(false);
            b22.setEnabled(false);
            b23.setEnabled(false);
            b24.setEnabled(false);
            b25.setEnabled(false);
            b26.setEnabled(false);
            b27.setEnabled(false);
            board3Complete.setText("X");
            board3Complete.setFont(new Font("consolas", Font.BOLD, 50));
            board3Complete.setForeground(Color.WHITE);

            count_win++;

            if(count_win==3)
            {
               JOptionPane.showMessageDialog(frame2,"The winner is Player " + numTurn);
            }
         }
         if(hasAI && numTurn == 2){
             aiPressButton();
         }
      }

   }

   private class Listener23 implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         b23.setText("X");
         b23.setFont(new Font("consolas", Font.BOLD, 30));
         b23.setForeground(Color.BLACK);
         count23++;

         buttonsPressed[22] = true;

         if(count23 == 1)
         {
            if(numTurn == 1)
               numTurn = numTurn + 1;
            else
               numTurn = numTurn - 1;

            playerTurn.setText("Player:  " + numTurn);
         }

         if((count19>0 && count27>0) || (count20>0 && count26>0) || (count21>0 && count25>0) || (count22>0 && count24>0))
         {
            b19.setEnabled(false);
            b20.setEnabled(false);
            b21.setEnabled(false);
            b22.setEnabled(false);
            b23.setEnabled(false);
            b24.setEnabled(false);
            b25.setEnabled(false);
            b26.setEnabled(false);
            b27.setEnabled(false);
            board3Complete.setText("X");
            board3Complete.setFont(new Font("consolas", Font.BOLD, 50));
            board3Complete.setForeground(Color.WHITE);

            count_win++;

            if(count_win==3)
            {
               JOptionPane.showMessageDialog(frame2,"The winner is Player " + numTurn);
            }
         }
         if(hasAI && numTurn == 2){
             aiPressButton();
         }
      }

   }

   private class Listener24 implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         b24.setText("X");
         b24.setFont(new Font("consolas", Font.BOLD, 30));
         b24.setForeground(Color.BLACK);
         count24++;

         buttonsPressed[23] = true;

         if(count24 == 1)
         {
            if(numTurn == 1)
               numTurn = numTurn + 1;
            else
               numTurn = numTurn - 1;

            playerTurn.setText("Player:  " + numTurn);
         }

         if((count21>0 && count27>0) || (count22>0 && count23>0))
         {
            b19.setEnabled(false);
            b20.setEnabled(false);
            b21.setEnabled(false);
            b22.setEnabled(false);
            b23.setEnabled(false);
            b24.setEnabled(false);
            b25.setEnabled(false);
            b26.setEnabled(false);
            b27.setEnabled(false);
            board3Complete.setText("X");
            board3Complete.setFont(new Font("consolas", Font.BOLD, 50));
            board3Complete.setForeground(Color.WHITE);

            count_win++;

            if(count_win==3)
            {
               JOptionPane.showMessageDialog(frame2,"The winner is Player " + numTurn);
            }
         }
         if(hasAI && numTurn == 2){
             aiPressButton();
         }
      }

   }

   private class Listener25 implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         b25.setText("X");
         b25.setFont(new Font("consolas", Font.BOLD, 30));
         b25.setForeground(Color.BLACK);
         count25++;

         buttonsPressed[24] = true;

         if(count25 == 1)
         {
            if(numTurn == 1)
               numTurn = numTurn + 1;
            else
               numTurn = numTurn - 1;

            playerTurn.setText("Player:  " + numTurn);
         }

         if((count19>0 && count22>0) || (count23>0 && count21>0) || (count26>0 && count27>0))
         {
            b19.setEnabled(false);
            b20.setEnabled(false);
            b21.setEnabled(false);
            b22.setEnabled(false);
            b23.setEnabled(false);
            b24.setEnabled(false);
            b25.setEnabled(false);
            b26.setEnabled(false);
            b27.setEnabled(false);
            board3Complete.setText("X");
            board3Complete.setFont(new Font("consolas", Font.BOLD, 50));
            board3Complete.setForeground(Color.WHITE);

            count_win++;

            if(count_win==3)
            {
               JOptionPane.showMessageDialog(frame2,"The winner is Player " + numTurn);
            }
         }
         if(hasAI && numTurn == 2){
             aiPressButton();
         }
      }

   }

   private class Listener26 implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         b26.setText("X");
         b26.setFont(new Font("consolas", Font.BOLD, 30));
         b26.setForeground(Color.BLACK);
         count26++;

         buttonsPressed[25] = true;

         if(count26 == 1)
         {
            if(numTurn == 1)
               numTurn = numTurn + 1;
            else
               numTurn = numTurn - 1;

            playerTurn.setText("Player:  " + numTurn);
         }

         if((count25>0 && count27>0) || (count20>0 && count23>0))
         {
            b19.setEnabled(false);
            b20.setEnabled(false);
            b21.setEnabled(false);
            b22.setEnabled(false);
            b23.setEnabled(false);
            b24.setEnabled(false);
            b25.setEnabled(false);
            b26.setEnabled(false);
            b27.setEnabled(false);
            board3Complete.setText("X");
            board3Complete.setFont(new Font("consolas", Font.BOLD, 50));
            board3Complete.setForeground(Color.WHITE);

            count_win++;

            if(count_win==3)
            {
               JOptionPane.showMessageDialog(frame2,"The winner is Player " + numTurn);
            }
         }
         if(hasAI && numTurn == 2){
             aiPressButton();
         }
      }

   }

   private class Listener27 implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         b27.setText("X");
         b27.setFont(new Font("consolas", Font.BOLD, 30));
         b27.setForeground(Color.BLACK);
         count27++;

         buttonsPressed[26] = true;

         if(count27 == 1)
         {
            if(numTurn == 1)
               numTurn = numTurn + 1;
            else
               numTurn = numTurn - 1;

            playerTurn.setText("Player:  " + numTurn);
         }

         if((count25>0 && count26>0) || (count19>0 && count23>0) || (count21>0 && count24>0))
         {
            b19.setEnabled(false);
            b20.setEnabled(false);
            b21.setEnabled(false);
            b22.setEnabled(false);
            b23.setEnabled(false);
            b24.setEnabled(false);
            b25.setEnabled(false);
            b26.setEnabled(false);
            b27.setEnabled(false);
            board3Complete.setText("X");
            board3Complete.setFont(new Font("consolas", Font.BOLD, 50));
            board3Complete.setForeground(Color.WHITE);

            count_win++;

            if(count_win==3)
            {
               JOptionPane.showMessageDialog(frame2,"The winner is Player " + numTurn);
            }
         }
         if(hasAI && numTurn == 2){
             aiPressButton();
         }
      }

   }

   private class Listener10 implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         b10.setText("X");
         b10.setFont(new Font("consolas", Font.BOLD, 30));
         b10.setForeground(Color.BLACK);
         count10++;

         buttonsPressed[9] = true;

         if(count10 == 1)
         {
            if(numTurn == 1)
               numTurn = numTurn + 1;
            else
               numTurn = numTurn - 1;

            playerTurn.setText("Player:  " + numTurn);
         }

         if((count13 > 0 && count16 > 0) || (count11 > 0 && count12 > 0) || (count14 > 0 && count18 > 0))
         {
            b10.setEnabled(false);
            b11.setEnabled(false);
            b12.setEnabled(false);
            b13.setEnabled(false);
            b14.setEnabled(false);
            b15.setEnabled(false);
            b16.setEnabled(false);
            b17.setEnabled(false);
            b18.setEnabled(false);
            board2Complete.setText("X");
            board2Complete.setFont(new Font("consolas", Font.BOLD, 50));
            board2Complete.setForeground(Color.WHITE);

            count_win++;

            if(count_win==3)
            {
               JOptionPane.showMessageDialog(frame2,"The winner is Player " + numTurn);
            }

         }
         if(hasAI && numTurn == 2){
             aiPressButton();
         }
      }

   }

   private class Listener11 implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         b11.setText("X");
         b11.setFont(new Font("consolas", Font.BOLD, 30));
         b11.setForeground(Color.BLACK);
         count11++;

         buttonsPressed[10] = true;

         if(count11 == 1)
         {
            if(numTurn == 1)
               numTurn = numTurn + 1;
            else
               numTurn = numTurn - 1;

            playerTurn.setText("Player:  " + numTurn);
         }

         if((count14>0 && count17>0) || (count10>0 && count12>0))
         {
            b10.setEnabled(false);
            b11.setEnabled(false);
            b12.setEnabled(false);
            b13.setEnabled(false);
            b14.setEnabled(false);
            b15.setEnabled(false);
            b16.setEnabled(false);
            b17.setEnabled(false);
            b18.setEnabled(false);
            board2Complete.setText("X");
            board2Complete.setFont(new Font("consolas", Font.BOLD, 50));
            board2Complete.setForeground(Color.WHITE);

            count_win++;

            if(count_win==3)
            {
               JOptionPane.showMessageDialog(frame2,"The winner is Player " + numTurn);
            }
         }
         if(hasAI && numTurn == 2){
             aiPressButton();
         }
      }

   }

   private class Listener12 implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         b12.setText("X");
         b12.setFont(new Font("consolas", Font.BOLD, 30));
         b12.setForeground(Color.BLACK);
         count12++;

         buttonsPressed[11] = true;

         if(count12 == 1)
         {
            if(numTurn == 1)
               numTurn = numTurn + 1;
            else
               numTurn = numTurn - 1;

            playerTurn.setText("Player:  " + numTurn);
         }

         if((count10>0 && count11>0) || (count14>0 && count16>0) || (count15>0 && count18>0))
         {
            b10.setEnabled(false);
            b11.setEnabled(false);
            b12.setEnabled(false);
            b13.setEnabled(false);
            b14.setEnabled(false);
            b15.setEnabled(false);
            b16.setEnabled(false);
            b17.setEnabled(false);
            b18.setEnabled(false);
            board2Complete.setText("X");
            board2Complete.setFont(new Font("consolas", Font.BOLD, 50));
            board2Complete.setForeground(Color.WHITE);

            count_win++;

            if(count_win==3)
            {
               JOptionPane.showMessageDialog(frame2,"The winner is Player " + numTurn);
            }
         }
         if(hasAI && numTurn == 2){
             aiPressButton();
         }
      }

   }

   private class Listener13 implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         b13.setText("X");
         b13.setFont(new Font("consolas", Font.BOLD, 30));
         b13.setForeground(Color.BLACK);
         count13++;

         buttonsPressed[12] = true;

         if(count13 == 1)
         {
            if(numTurn == 1)
               numTurn = numTurn + 1;
            else
               numTurn = numTurn - 1;

            playerTurn.setText("Player:  " + numTurn);
         }

         if((count10>0 && count16>0) || (count14>0 && count15>0))
         {
            b10.setEnabled(false);
            b11.setEnabled(false);
            b12.setEnabled(false);
            b13.setEnabled(false);
            b14.setEnabled(false);
            b15.setEnabled(false);
            b16.setEnabled(false);
            b17.setEnabled(false);
            b18.setEnabled(false);
            board2Complete.setText("X");
            board2Complete.setFont(new Font("consolas", Font.BOLD, 50));
            board2Complete.setForeground(Color.WHITE);

            count_win++;

            if(count_win==3)
            {
               JOptionPane.showMessageDialog(frame2,"The winner is Player " + numTurn);
            }
         }
         if(hasAI && numTurn == 2){
             aiPressButton();
         }
      }

   }

   private class Listener14 implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         b14.setText("X");
         b14.setFont(new Font("consolas", Font.BOLD, 30));
         b14.setForeground(Color.BLACK);
         count14++;

         buttonsPressed[13] = true;

         if(count14 == 1)
         {
            if(numTurn == 1)
               numTurn = numTurn + 1;
            else
               numTurn = numTurn - 1;

            playerTurn.setText("Player:  " + numTurn);
         }

         if((count10>0 && count18>0) || (count11>0 && count17>0) || (count12>0 && count16>0) || (count13>0 && count15>0))
         {
            b10.setEnabled(false);
            b11.setEnabled(false);
            b12.setEnabled(false);
            b13.setEnabled(false);
            b14.setEnabled(false);
            b15.setEnabled(false);
            b16.setEnabled(false);
            b17.setEnabled(false);
            b18.setEnabled(false);
            board2Complete.setText("X");
            board2Complete.setFont(new Font("consolas", Font.BOLD, 50));
            board2Complete.setForeground(Color.WHITE);

            count_win++;

            if(count_win==3)
            {
               JOptionPane.showMessageDialog(frame2,"The winner is Player " + numTurn);
            }
         }
         if(hasAI && numTurn == 2){
             aiPressButton();
         }
      }

   }

   private class Listener15 implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         b15.setText("X");
         b15.setFont(new Font("consolas", Font.BOLD, 30));
         b15.setForeground(Color.BLACK);
         count15++;

         buttonsPressed[14] = true;

         if(count15 == 1)
         {
            if(numTurn == 1)
               numTurn = numTurn + 1;
            else
               numTurn = numTurn - 1;

            playerTurn.setText("Player:  " + numTurn);
         }

         if((count12>0 && count18>0) || (count13>0 && count14>0))
         {
            b10.setEnabled(false);
            b11.setEnabled(false);
            b12.setEnabled(false);
            b13.setEnabled(false);
            b14.setEnabled(false);
            b15.setEnabled(false);
            b16.setEnabled(false);
            b17.setEnabled(false);
            b18.setEnabled(false);
            board2Complete.setText("X");
            board2Complete.setFont(new Font("consolas", Font.BOLD, 50));
            board2Complete.setForeground(Color.WHITE);

            count_win++;

            if(count_win==3)
            {
               JOptionPane.showMessageDialog(frame2,"The winner is Player " + numTurn);
            }
         }
         if(hasAI && numTurn == 2){
             aiPressButton();
         }
      }

   }

   private class Listener16 implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         b16.setText("X");
         b16.setFont(new Font("consolas", Font.BOLD, 30));
         b16.setForeground(Color.BLACK);
         count16++;

         buttonsPressed[15] = true;

         if(count16 == 1)
         {
            if(numTurn == 1)
               numTurn = numTurn + 1;
            else
               numTurn = numTurn - 1;

            playerTurn.setText("Player:  " + numTurn);
         }

         if((count10>0 && count13>0) || (count14>0 && count12>0) || (count17>0 && count18>0))
         {
            b10.setEnabled(false);
            b11.setEnabled(false);
            b12.setEnabled(false);
            b13.setEnabled(false);
            b14.setEnabled(false);
            b15.setEnabled(false);
            b16.setEnabled(false);
            b17.setEnabled(false);
            b18.setEnabled(false);
            board2Complete.setText("X");
            board2Complete.setFont(new Font("consolas", Font.BOLD, 50));
            board2Complete.setForeground(Color.WHITE);

            count_win++;

            if(count_win==3)
            {
               JOptionPane.showMessageDialog(frame2,"The winner is Player " + numTurn);
            }
         }
         if(hasAI && numTurn == 2){
             aiPressButton();
         }
      }

   }

   private class Listener17 implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         b17.setText("X");
         b17.setFont(new Font("consolas", Font.BOLD, 30));
         b17.setForeground(Color.BLACK);
         count17++;

         buttonsPressed[16] = true;

         if(count17 == 1)
         {
            if(numTurn == 1)
               numTurn = numTurn + 1;
            else
               numTurn = numTurn - 1;

            playerTurn.setText("Player:  " + numTurn);
         }

         if((count16>0 && count18>0) || (count11>0 && count14>0))
         {
            b10.setEnabled(false);
            b11.setEnabled(false);
            b12.setEnabled(false);
            b13.setEnabled(false);
            b14.setEnabled(false);
            b15.setEnabled(false);
            b16.setEnabled(false);
            b17.setEnabled(false);
            b18.setEnabled(false);
            board2Complete.setText("X");
            board2Complete.setFont(new Font("consolas", Font.BOLD, 50));
            board2Complete.setForeground(Color.WHITE);

            count_win++;

            if(count_win==3)
            {
               JOptionPane.showMessageDialog(frame2,"The winner is Player " + numTurn);
            }
         }
         if(hasAI && numTurn == 2){
             aiPressButton();
         }
      }

   }

   private class Listener18 implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         b18.setText("X");
         b18.setFont(new Font("consolas", Font.BOLD, 30));
         b18.setForeground(Color.BLACK);
         count18++;

         buttonsPressed[17] = true;

         if(count18 == 1)
         {
            if(numTurn == 1)
               numTurn = numTurn + 1;
            else
               numTurn = numTurn - 1;

            playerTurn.setText("Player:  " + numTurn);
         }

         if((count12>0 && count15>0) || (count10>0 && count14>0) || (count16>0 && count17>0))
         {
            b10.setEnabled(false);
            b11.setEnabled(false);
            b12.setEnabled(false);
            b13.setEnabled(false);
            b14.setEnabled(false);
            b15.setEnabled(false);
            b16.setEnabled(false);
            b17.setEnabled(false);
            b18.setEnabled(false);
            board2Complete.setText("X");
            board2Complete.setFont(new Font("consolas", Font.BOLD, 50));
            board2Complete.setForeground(Color.WHITE);

            count_win++;

            if(count_win==3)
            {
               JOptionPane.showMessageDialog(frame2,"The winner is Player " + numTurn);
            }
         }
         if(hasAI && numTurn == 2){
             aiPressButton();
         }
      }

   }

   public void buttonPressed(){
       System.out.println(this.buttonsPressed);
      }

   public static void main(String[] args)
   {
      GUI frame = new GUI();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(1280, 1024);
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);
   }
}
