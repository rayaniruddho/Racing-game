package aniruddho.race_game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Display extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel top, down;
	private JTextField name1, name2, move;
	public static JTextField result;
	private JButton reset, close, play;
	private JLabel p1, p2;
	public static JLabel status;
	public DrawPanel dp;
	//Controller controls = new Controller();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Display frame = new Display();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Display() {
		init();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(900, 700);
		setLocationRelativeTo(null);
	}

	public void init() {
		top = new JPanel();

		p1 = new JLabel("Player1 :");
		p2 = new JLabel("Player2 :");

		name1 = new JTextField(5);
		name1.setText("Circle");
		name1.setEditable(false);
		name1.setBackground(Color.WHITE);
		name2 = new JTextField(5);
		name2.setText("Square");
		name2.setEditable(false);
		name2.setBackground(Color.WHITE);
		move = new JTextField(2);
		move.setEditable(false);
		move.setBackground(Color.WHITE);

		reset = new JButton("Reset");
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controller.playerTurn = true;
				Controller.over = false;
				Controller.p1 = 1;
				Controller.p2 = 1;
				Controller.p1_row = 1;
				Controller.p2_row = 1;
			}
		});
		close = new JButton("Close");
		close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		play = new JButton("Play");
		play.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Random random = new Random();
				int value = random.nextInt(6);
				move.setText("" + (value + 1));
				if(!Controller.over) {
					if(Controller.playerTurn) {
						Controller.p1 += value+1;
						if(Controller.p1>8) {
							Controller.p1 = Controller.p1 % 8;
							Controller.p1_row += 1;
						}
						Controller.playerTurn = false;
					}
					else {
						Controller.p2 += value+1;
						if(Controller.p2>8) {
							Controller.p2 = Controller.p2 % 8;
							Controller.p2_row += 1;
						}
						Controller.playerTurn = true;
					}
				}				
			}
		});

		top.add(p1);
		top.add(name1);
		top.add(p2);
		top.add(name2);
		top.add(reset);
		top.add(close);
		top.add(play);
		top.add(move);

		getContentPane().add(top, BorderLayout.NORTH);
		
		dp = new DrawPanel();
		add(dp,BorderLayout.CENTER);	
		
		down = new JPanel();
		result = new JTextField(15);
		result.setEditable(false);
		result.setBackground(Color.WHITE);
		status = new JLabel("Status:");
		down.add(status);		
		down.add(result);
		add(down,BorderLayout.EAST);
	}
}