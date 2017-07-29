package aniruddho.race_game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

public class DrawPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ArrayList<Grid> lines = new ArrayList<Grid>();
	//Controller control = new Controller();

	public DrawPanel() {
		this.setPreferredSize(new Dimension(500, 500));
		this.setBackground(Color.WHITE);
		init();
	}
	
	private void init() {
		for(int i=0;i<9;i++) {
			Grid l = new Grid(50+(70*i),50,Color.BLUE,50+(70*i),610);
			lines.add(l);
		}
		for(int j=0;j<9;j++) {
			Grid l = new Grid(50,50+(70*j),Color.BLUE,610,50+(70*j));
			lines.add(l);
		}
	}

	public void paint(Graphics g) {
		
		super.paint(g);
		for (Grid line : lines) {
			g.setColor(line.color);
			g.drawLine(line.posX, line.posY, line.width, line.height);
			
		}
		Controller.paintPlay(g);
		repaint();
	}
}