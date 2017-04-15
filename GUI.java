import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class GUI extends JFrame
{
   
   JScrollPane scrollPane;
   ImageIcon icon;
   Image image;
   private JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, b16, b17, b18, b19, b20, b21, b22, b23, b24, b25, b26, b27, exit;
   JLabel title, playerTurn;
   private int numTurn = 1, count1 = 0, count2 = 0, count3 = 0, count4 = 0, count5 = 0, count6 = 0, count7 = 0, count8 = 0, count9 = 0, count10 = 0, count11 = 0, count12 = 0, count13 = 0, count14 = 0, count15 = 0, count16 = 0, count17 = 0, count18 = 0, count19 = 0, count20 = 0, count21 = 0, count22 = 0, count23 = 0, count24 = 0, count25 = 0, count26 = 0, count27 = 0;


   public GUI()
   {
      icon = new ImageIcon("bckgrnd.jpg");
   
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
          
      panel.setLayout(new GridLayout(4,1));
      panel.setOpaque(false);
      panel.setPreferredSize( new Dimension(400, 400) );
      scrollPane = new JScrollPane(panel);
      getContentPane().add(scrollPane);
      
      title = new JLabel("3-X-T", JLabel.CENTER);
      title.setFont(new Font("consolas", Font.BOLD, 70));
      title.setForeground(Color.WHITE);
      panel.add(title);
      
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
      
      JPanel dummy = new JPanel(new GridLayout(3,3));
      dummy.setOpaque(false);
      panel2.add(dummy);
      
      JPanel toe = new JPanel(new GridLayout(3,3, 5, 5));
      toe.setOpaque(false);
      panel2.add(toe);
      
      b19 = new JButton("19");
      b19.setOpaque(false);
      toe.add(b19);
      
      b20 = new JButton("20");
      b20.setOpaque(false);
      toe.add(b20);
      
      b21 = new JButton("21");
      b21.setOpaque(false);
      toe.add(b21);
      
      b22 = new JButton("22");
      b22.setOpaque(false);
      toe.add(b22);
      
      b23 = new JButton("23");
      b23.setOpaque(false);
      toe.add(b23);
      
      b24 = new JButton("24");
      b24.setOpaque(false);
      toe.add(b24);
      
      b25 = new JButton("25");
      b25.setOpaque(false);
      toe.add(b25);
      
      b26 = new JButton("26");
      b26.setOpaque(false);
      toe.add(b26);
      
      b27 = new JButton("27");
      b27.setOpaque(false);
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
      
      b10 = new JButton("10");
      b10.setOpaque(false);
      tac.add(b10);
      
      b11 = new JButton("11");
      b11.setOpaque(false);
      tac.add(b11);
      
      b12 = new JButton("12");
      b12.setOpaque(false);
      tac.add(b12);
      
      b13 = new JButton("13");
      b13.setOpaque(false);
      tac.add(b13);
      
      b14 = new JButton("14");
      b14.setOpaque(false);
      tac.add(b14);
      
      b15 = new JButton("15");
      b15.setOpaque(false);
      tac.add(b15);
      
      b16 = new JButton("16");
      b16.setOpaque(false);
      tac.add(b16);
      
      b17 = new JButton("17");
      b17.setOpaque(false);
      tac.add(b17);
      
      b18 = new JButton("18");
      b18.setOpaque(false);
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
   
   }

   /*public String getBoard(){
      return "";
   }

   public boolean hasWon(){
      return true;
   }

   public boolean createBoard(){
      return true;
   }*/
   
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
         
         if(count1 == 1)
         {
            if(numTurn == 1)
               numTurn = numTurn + 1;
            else
               numTurn = numTurn - 1;
         
            playerTurn.setText("Player:  " + numTurn);
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
         
         if(count2 == 1)
         {
            if(numTurn == 1)
               numTurn = numTurn + 1;
            else
               numTurn = numTurn - 1;
         
            playerTurn.setText("Player:  " + numTurn);
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
         
         if(count3 == 1)
         {
            if(numTurn == 1)
               numTurn = numTurn + 1;
            else
               numTurn = numTurn - 1;
         
            playerTurn.setText("Player:  " + numTurn);
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
         
         if(count4 == 1)
         {
            if(numTurn == 1)
               numTurn = numTurn + 1;
            else
               numTurn = numTurn - 1;
         
            playerTurn.setText("Player:  " + numTurn);
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
         
         if(count5 == 1)
         {
            if(numTurn == 1)
               numTurn = numTurn + 1;
            else
               numTurn = numTurn - 1;
         
            playerTurn.setText("Player:  " + numTurn);
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
         
         if(count6 == 1)
         {
            if(numTurn == 1)
               numTurn = numTurn + 1;
            else
               numTurn = numTurn - 1;
         
            playerTurn.setText("Player:  " + numTurn);
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
         
         if(count7 == 1)
         {
            if(numTurn == 1)
               numTurn = numTurn + 1;
            else
               numTurn = numTurn - 1;
         
            playerTurn.setText("Player:  " + numTurn);
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
         
         if(count8 == 1)
         {
            if(numTurn == 1)
               numTurn = numTurn + 1;
            else
               numTurn = numTurn - 1;
         
            playerTurn.setText("Player:  " + numTurn);
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
         
         if(count9 == 1)
         {
            if(numTurn == 1)
               numTurn = numTurn + 1;
            else
               numTurn = numTurn - 1;
         
            playerTurn.setText("Player:  " + numTurn);
         }
         
      }
      
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
