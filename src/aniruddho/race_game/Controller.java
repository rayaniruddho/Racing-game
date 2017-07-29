package aniruddho.race_game;

import java.awt.Graphics;

import javax.swing.JOptionPane;

public class Controller {
	public static boolean playerTurn = true;
	public static int p1=1,p2=1;
	public static int p1_row = 1,p2_row = 1;
	public static boolean over = false;
	//public static JOptionPane pane;
	
	public Controller() {
		
	}
	
	public static void paintPlay(Graphics g) {
		if(p1<=8 && p1_row<=8 && p2<=8 && p2_row<=8) {			
			g.fillOval(55+(70*(p1-1)), 55+(70*(p1_row-1)), 25, 25);
			g.fillRect(85+(70*(p2-1)), 55+(70*(p2_row-1)), 30, 30);
			Display.result.setText("Ongoing...");
		}
	
		else if(p1_row>8) {
			g.fillOval(55+(70*(7)), 55+(70*(7)), 25, 25);
			g.fillRect(85+(70*(p2-1)), 55+(70*(p2_row-1)), 30, 30);
			System.out.println("Player1 won");	
			Display.result.setText("Player1 won!");
			
			over = true;
			//JOptionPane.showMessageDialog(null, "Player 1 won");
		}
		
		else if(p2_row>8) {
			g.fillOval(55+(70*(p1-1)), 55+(70*(p1_row-1)), 25, 25);
			g.fillRect(85+(70*(7)), 55+(70*(7)), 30, 30);
			System.out.println("Player2 won");
			Display.result.setText("Player2 won!");
			
			over = true;
			/*JOptionPane.showConfirmDialog(null, "Are you sure?", "Example 4",
					JOptionPane.YES_NO_CANCEL_OPTION);	*/	}
	}
}