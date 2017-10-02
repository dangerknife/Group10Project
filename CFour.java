import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.NumberFormat;

import javax.imageio.ImageIO;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.Border;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

public class CFour extends JFrame {
	private static final long serialVersionUID = 1L;
	
	public static JFrame frame = new JFrame();
	public static JPanel basePanel = new JPanel();
	public static JPanel connectPanel = new JPanel();
	public static JPanel colorsPanel = new JPanel();
	public static JPanel player1Panel = new JPanel();
	public static JPanel player2Panel = new JPanel();
	public static JPanel colorsPanelCenter = new JPanel();
	public static JPanel colorsPanelTop = new JPanel();
	public static JPanel colorsPanelBottom = new JPanel();
	public static JPanel optionsPanel = new JPanel();
	public static JPanel optionsPanelLeft = new JPanel();
	public static JPanel optionsPanelRight = new JPanel();
	public static JPanel optionsPanelRadio = new JPanel();
	public static JPanel gameBoardPanel = new GameBoard(6).getPanel();
	
	public static JLabel colorSelectLabel = new JLabel("Select your Color: ");
	public static JLabel gameTitle = new JLabel("Welcome to C-Four");
	public static JLabel boardSizeLabel = new JLabel("Select your board size: ");
	public static JLabel player1Label = new JLabel("Player 1");
	public static JLabel player2Label = new JLabel("Player 2");
	
	public static JButton resetButton = new JButton("Reset Game");
	public static JButton greenButton = new JButton();
	public static JButton redButton = new JButton();
	public static JButton blueButton = new JButton();
	public static JButton orangeButton = new JButton();
	
	public static JRadioButton smallRadio = new JRadioButton("6x6");
	public static JRadioButton mediumRadio = new JRadioButton("9x9");
	public static JRadioButton largeRadio = new JRadioButton("12x12");
	public static ButtonGroup sizeRadioGroup = new ButtonGroup();
	
	public static JRadioButton p1RedRadio = new JRadioButton("RED");
	public static JRadioButton p1GreenRadio = new JRadioButton("GREEN");
	public static JRadioButton p1BlueRadio = new JRadioButton("BLUE");
	public static JRadioButton p1OrangeRadio = new JRadioButton("ORANGE");
	public static ButtonGroup p1RadioGroup = new ButtonGroup();
	
	public static JRadioButton p2RedRadio = new JRadioButton("RED");
	public static JRadioButton p2GreenRadio = new JRadioButton("GREEN");
	public static JRadioButton p2BlueRadio = new JRadioButton("BLUE");
	public static JRadioButton p2OrangeRadio = new JRadioButton("ORANGE");
	public static ButtonGroup p2RadioGroup = new ButtonGroup();
		
	static Font buttonFont = new Font("Arial", 3, 30);
	static Font radioFont = new Font("Arial", 1, 60);
	
	static Border defaultBorder = BorderFactory.createLineBorder(Color.BLACK, 3);	
	 
	public static Color p1Color;
	public static Color p2Color;
	public static int boardSize = 6;
	
    public static ActionListener buttonListener = new ResetButtonListener();
    public static ActionListener playerRadioListener = new PlayerRadioListener();
    public static ActionListener boardSizeRadioListener = new BoardSizeRadioListener();
	
	 public static void main(String args[]) {

		createGame();
        
	 }
	 
	 static class BoardSizeRadioListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {

			if (smallRadio.isSelected()) {
				// Change CONNECTPANEL to 6x6
				if (boardSize == 6) {
					JOptionPane.showMessageDialog(null, "The Board is already 6x6");
				} else {
					boardSize = 6;
					basePanel.remove(gameBoardPanel);
					gameBoardPanel = new GameBoard(6).getPanel();
					basePanel.add(gameBoardPanel, BorderLayout.CENTER);
					basePanel.revalidate();
					basePanel.repaint();
				}
			} else if (mediumRadio.isSelected()) {
				// Change CONNECTPANEL to 9x9
				if (boardSize == 9) {
					JOptionPane.showMessageDialog(null, "The Board is already 9x9");
				} else {
					boardSize = 9;
					basePanel.remove(gameBoardPanel);
					gameBoardPanel = new GameBoard(9).getPanel();
					basePanel.add(gameBoardPanel, BorderLayout.CENTER);
					basePanel.revalidate();
					basePanel.repaint();
				}
			} else if (largeRadio.isSelected()) {
				// Change CONNECTPANEL to 12x12
				if (boardSize == 12) {
					JOptionPane.showMessageDialog(null, "The Board is already 12x12");
				} else {
					boardSize = 12;
					basePanel.remove(gameBoardPanel);
					gameBoardPanel = new GameBoard(12).getPanel();
					basePanel.add(gameBoardPanel, BorderLayout.CENTER);
					basePanel.revalidate();
					basePanel.repaint();
				}
			}
		}
	 }
	 
	 static class PlayerRadioListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {

			if (arg0.getSource().equals(p1RedRadio) || arg0.getSource().equals(p1GreenRadio) || 
					arg0.getSource().equals(p1BlueRadio) || arg0.getSource().equals(p1OrangeRadio)) {
				if (p1RedRadio.isSelected() && !p2RedRadio.isSelected()) {
					p1Color = Color.RED;
					removeP1ColorRadios();
				} else if (p1GreenRadio.isSelected() && !p2GreenRadio.isSelected()) {
					p1Color = Color.GREEN;
					removeP1ColorRadios();
				} else if (p1BlueRadio.isSelected() && !p2BlueRadio.isSelected()) {
					p1Color = Color.BLUE;
					removeP1ColorRadios();
				} else if (p1OrangeRadio.isSelected() && !p2OrangeRadio.isSelected()) {
					p1Color = Color.ORANGE;
					removeP1ColorRadios();
				} else {
					JOptionPane.showMessageDialog(null, "YOU MUST PICK DIFFERENT COLORS", "Same Color Selected", 2);
				}
			} else {
				if (p2RedRadio.isSelected() && !p1RedRadio.isSelected()) {
					p2Color = Color.RED;
					removeP2ColorRadios();
				} else if (p2GreenRadio.isSelected() && !p1GreenRadio.isSelected()) {
					p2Color = Color.GREEN;
					removeP2ColorRadios();
				} else if (p2BlueRadio.isSelected() && !p1BlueRadio.isSelected()) {
					p2Color = Color.BLUE;
					removeP2ColorRadios();
				} else if (p2OrangeRadio.isSelected() && !p1OrangeRadio.isSelected()) {
					p2Color = Color.ORANGE;
					removeP2ColorRadios();
				} else {
					JOptionPane.showMessageDialog(null, "YOU MUST PICK DIFFERENT COLORS", "Same Color Selected", 2);
				}
			}
						
			// set player label to the player's desired color
			if (p1Color != p2Color) {
				if (p1Color != null) player1Label.setBackground(p1Color);
				if (p2Color != null) player2Label.setBackground(p2Color);
				frame.revalidate();
				frame.repaint();
			} 
			
			if (p1Color != null && p2Color != null) {
				colorsPanelCenter.setBackground(Color.BLACK);
				colorsPanelCenter.removeAll();
			}
		}
	 }
	 
     static class ResetButtonListener implements ActionListener {
    	 
      	public void actionPerformed(ActionEvent e) {
      		resetGame();
	      }
     }

     static void removeP1ColorRadios() {
    	player1Panel.remove(p1RedRadio);
		player1Panel.remove(p1GreenRadio);
		player1Panel.remove(p1BlueRadio);
		player1Panel.remove(p1OrangeRadio);
		player1Panel.setBackground(Color.black);
     }
     
     static void removeP2ColorRadios() {
     	player2Panel.remove(p2RedRadio);
 		player2Panel.remove(p2GreenRadio);
 		player2Panel.remove(p2BlueRadio);
 		player2Panel.remove(p2OrangeRadio);
 		player2Panel.setBackground(Color.black);
      }

     static void createGame() {
    	 gameTitle.setFont(buttonFont);
 		
    	 colorSelectLabel.setFont(buttonFont);
 		 colorSelectLabel.setHorizontalAlignment(JLabel.CENTER);
 		
 		 boardSizeLabel.setFont(buttonFont);
 		 boardSizeLabel.setBorder(defaultBorder);
 		 boardSizeLabel.setHorizontalAlignment(JLabel.CENTER);
 		
 		 player1Label.setBorder(defaultBorder);
 		 player1Label.setHorizontalAlignment(JLabel.CENTER);
 		 player1Label.setFont(buttonFont);
 		 player1Label.setOpaque(true);
 		 player1Label.setBackground(Color.black);
 		 player1Label.setForeground(Color.white);
 		
 		 player2Label.setBorder(defaultBorder);
 		 player2Label.setHorizontalAlignment(JLabel.CENTER);
 		 player2Label.setFont(buttonFont);
 		 player2Label.setOpaque(true);
 		 player2Label.setBackground(Color.black);
 		 player2Label.setForeground(Color.white);
 				
 		 resetButton.setFont(buttonFont);
 		 resetButton.setBackground(Color.BLACK);
 		 resetButton.setForeground(Color.WHITE);
 		
 		 greenButton.setFont(buttonFont);
 		 greenButton.setEnabled(false);
 		 greenButton.setBackground(Color.green);
 		
 		 redButton.setFont(buttonFont);
 		 redButton.setEnabled(false);
 		 redButton.setBackground(Color.red);
 		
 		 blueButton.setFont(buttonFont);
 		 blueButton.setEnabled(false);
 		 blueButton.setBackground(Color.blue);
 		
 		 orangeButton.setFont(buttonFont);
 		 orangeButton.setEnabled(false);
 		 orangeButton.setBackground(Color.orange);		
 		 
 		 smallRadio.setFont(radioFont);
 		 smallRadio.setSelected(true);
 		 mediumRadio.setFont(radioFont);
 		 largeRadio.setFont(radioFont);
 		 sizeRadioGroup.add(smallRadio);
 		 sizeRadioGroup.add(mediumRadio);
 		 sizeRadioGroup.add(largeRadio);
 		
 		 p1RedRadio.setFont(buttonFont);	
 		 p1GreenRadio.setFont(buttonFont);		
 		 p1BlueRadio.setFont(buttonFont);
 		 p1OrangeRadio.setFont(buttonFont);
 		 p1RedRadio.setHorizontalAlignment(AbstractButton.CENTER);
 		 p1GreenRadio.setHorizontalAlignment(AbstractButton.CENTER);
 		 p1BlueRadio.setHorizontalAlignment(AbstractButton.CENTER);
 		 p1OrangeRadio.setHorizontalAlignment(AbstractButton.CENTER);
 		 p1RadioGroup.add(p1RedRadio);
 		 p1RadioGroup.add(p1GreenRadio);
 		 p1RadioGroup.add(p1BlueRadio);
 		 p1RadioGroup.add(p1OrangeRadio);
 		
 		 p2RedRadio.setFont(buttonFont);	
 		 p2GreenRadio.setFont(buttonFont);
 		 p2BlueRadio.setFont(buttonFont);
 		 p2OrangeRadio.setFont(buttonFont);
 		 p2RedRadio.setHorizontalAlignment(AbstractButton.CENTER);
 		 p2GreenRadio.setHorizontalAlignment(AbstractButton.CENTER);
 		 p2BlueRadio.setHorizontalAlignment(AbstractButton.CENTER);
 		 p2OrangeRadio.setHorizontalAlignment(AbstractButton.CENTER);
 		 p2RadioGroup.add(p2RedRadio);
 		 p2RadioGroup.add(p2GreenRadio);
 		 p2RadioGroup.add(p2BlueRadio);
 		 p2RadioGroup.add(p2OrangeRadio);
 		
 		 player1Panel.setLayout(new GridLayout(5, 1));
 		 player1Panel.setPreferredSize(new Dimension(300, 200));
 		 player1Panel.add(player1Label);
 		 player1Panel.add(p1RedRadio);
 		 player1Panel.add(p1GreenRadio);
 		 player1Panel.add(p1BlueRadio);
 		 player1Panel.add(p1OrangeRadio);
 		
 		 player2Panel.setLayout(new GridLayout(5, 1));
 		 player2Panel.setPreferredSize(new Dimension(300, 200));
 		 player2Panel.add(player2Label);
 		 player2Panel.add(p2RedRadio);
 		 player2Panel.add(p2GreenRadio);
 		 player2Panel.add(p2BlueRadio);
 		 player2Panel.add(p2OrangeRadio);
 		
 		 colorsPanelCenter.setBorder(defaultBorder);
 		 colorsPanelCenter.setLayout(new GridLayout(5, 1));
 		 colorsPanelCenter.add(colorSelectLabel);
 		 colorsPanelCenter.add(redButton);
 		 colorsPanelCenter.add(greenButton);
 		 colorsPanelCenter.add(blueButton);
 		 colorsPanelCenter.add(orangeButton);
 		
 		 colorsPanel.setLayout(new BorderLayout());
 		 colorsPanel.add(colorsPanelCenter, BorderLayout.CENTER);
 		 colorsPanel.add(player1Panel, BorderLayout.WEST);
 		 colorsPanel.add(player2Panel, BorderLayout.EAST);
 		
 		 optionsPanelRadio.setLayout(new GridLayout(1, 3));
 		 optionsPanelRadio.add(smallRadio);
 		 optionsPanelRadio.add(mediumRadio);
 		 optionsPanelRadio.add(largeRadio);
 		
 		 optionsPanelLeft.setLayout(new BorderLayout());
 		 optionsPanelLeft.add(boardSizeLabel, BorderLayout.NORTH);
 		 optionsPanelLeft.add(optionsPanelRadio, BorderLayout.SOUTH);
 		
 		 optionsPanelRight.setLayout(new BorderLayout());
 		 optionsPanelRight.add(resetButton, BorderLayout.EAST);
 		
 		 optionsPanel.setLayout(new BorderLayout());
 		 optionsPanel.add(optionsPanelLeft, BorderLayout.CENTER);
 		 optionsPanel.add(optionsPanelRight, BorderLayout.EAST);
 		
 		 frame.add(basePanel);
 		
 		 basePanel.setLayout(new BorderLayout());
 		 basePanel.add(gameBoardPanel, BorderLayout.CENTER);
 		 basePanel.add(colorsPanel, BorderLayout.NORTH);
 		 basePanel.add(optionsPanel, BorderLayout.SOUTH);
 		
 		 frame.setLocation(2000, 0);
 		 frame.setSize(900, 1100);
 		 frame.setTitle("***** SER215: Group 10 *****");
 	     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 	     frame.setLocationRelativeTo(null);
 	     frame.setResizable(false);
 	    
 		 frame.setVisible(true);
         
         smallRadio.addActionListener(boardSizeRadioListener);
         mediumRadio.addActionListener(boardSizeRadioListener);
         largeRadio.addActionListener(boardSizeRadioListener);
         
         p1RedRadio.addActionListener(playerRadioListener);
         p1GreenRadio.addActionListener(playerRadioListener);
         p1BlueRadio.addActionListener(playerRadioListener);
         p1OrangeRadio.addActionListener(playerRadioListener);
         
         p2RedRadio.addActionListener(playerRadioListener);
         p2GreenRadio.addActionListener(playerRadioListener);
         p2BlueRadio.addActionListener(playerRadioListener);
         p2OrangeRadio.addActionListener(playerRadioListener);
         
         resetButton.addActionListener(buttonListener);
     }

     // Work in Progress
     static void resetGame() {
  		colorSelectLabel.setBackground(Color.WHITE);

  		player1Label.setOpaque(true);
  		player1Label.setBackground(Color.black);
  		
  		player2Label.setOpaque(true);
  		player2Label.setBackground(Color.black);
  		
  		p1RadioGroup.clearSelection();
  		p2RadioGroup.clearSelection();

  		//reset the colors back to null on a reset
  		p1Color = null;
  		player1Panel.add(player1Label);
  		player1Panel.add(p1RedRadio);
  		player1Panel.add(p1GreenRadio);
  		player1Panel.add(p1BlueRadio);
  		player1Panel.add(p1OrangeRadio);
  		player1Panel.setBackground(Color.WHITE);

  		p2Color = null;
  		player2Panel.add(player2Label);
  		player2Panel.add(p2RedRadio);
  		player2Panel.add(p2GreenRadio);
  		player2Panel.add(p2BlueRadio);
  		player2Panel.add(p2OrangeRadio);
  		player2Panel.setBackground(Color.WHITE);
  		
  		colorsPanelCenter.add(colorSelectLabel);
  		colorsPanelCenter.add(redButton);
  		colorsPanelCenter.add(greenButton);
  		colorsPanelCenter.add(blueButton);
  		colorsPanelCenter.add(orangeButton);
  		colorsPanelCenter.setBackground(Color.white);
  		 
  		basePanel.remove(gameBoardPanel);
  		gameBoardPanel = new GameBoard(6).getPanel();
  		//gameBoardPanel.revalidate();
  		basePanel.add(gameBoardPanel, BorderLayout.CENTER);
  		basePanel.revalidate();
  		
     }
}
