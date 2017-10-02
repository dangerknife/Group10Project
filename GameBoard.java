import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;


public class GameBoard {
	
	// this panel will hold the board
	private static JPanel boardPanel = new JPanel();
	// this panel will hold the arrows to drop pieces into columns
	private static JPanel placementPanel = new JPanel();
	// this panel will be the container for the arrow panel and board panel
	private static JPanel combinedPanel = new JPanel();

	// buttons will be displayed as arrows to indicate which column to drop a game piece
    //buttons declared in constructor
	private static JButton c0;
	private static JButton c1;
	private static JButton c2;
	private static JButton c3;
	private static JButton c4;
	private static JButton c5;
	// Counter for indicating who's turn it is (odd is Player 1, even is Player 2)
	private static int playerCounter = 1;
	
	private static Border defaultBorder = BorderFactory.createLineBorder(Color.BLACK, 5);	
	
	public static Color pieceColor;

	// This is the background for the gameboard
	private Image backgroundWood;

	//create board with size dependent on user input
	public GameBoard(int sizeOfBoard) {
		clearPanel();
		
		// find and load board image background
		try {
			backgroundWood = ImageIO.read(new File("resources//wood.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// creates boardPanel with background image loaded
		boardPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundWood, 0, 0, null);
            }
		};
		
		combinedPanel.setLayout(new BorderLayout());
		boardPanel.setBorder(defaultBorder);
		boardPanel.setBackground(Color.LIGHT_GRAY);
		boardPanel.setLayout(new GridLayout(6, 6));
		placementPanel.setLayout(new GridLayout(1, 6));
		placementPanel.setPreferredSize(new Dimension(100, 100));
		
		// always add the basic 6x6, then decide if more need to be added
		// create header with arrow selection for piece drop

        c0 = new JButton();
        c1 = new JButton();
        c2 = new JButton();
        c3 = new JButton();
        c4 = new JButton();
        c5 = new JButton();

		try {
			ImageIcon arrow = new ImageIcon("resources/downarrow.png");
			c0.setIcon(arrow);
			c1.setIcon(arrow);
			c2.setIcon(arrow);
			c3.setIcon(arrow);
			c4.setIcon(arrow);
			c5.setIcon(arrow);
		} catch (Exception except) {
			JOptionPane.showMessageDialog(null, "NOT Added");
		}
		
		c1.setBackground(Color.BLACK);
		c1.setForeground(Color.BLACK);
		c2.setBackground(Color.BLACK);
		c3.setBackground(Color.BLACK);
		c4.setBackground(Color.BLACK);
		c5.setBackground(Color.BLACK);
		placementPanel.add(c0);
		placementPanel.add(c1);
		placementPanel.add(c2);
		placementPanel.add(c3);
		placementPanel.add(c4);
		placementPanel.add(c5);
	
		// Allows buttons to activate piece placement
		c0.addActionListener(new ButtonListener());
		c1.addActionListener(new ButtonListener());
		c2.addActionListener(new ButtonListener());
		c3.addActionListener(new ButtonListener());
		c4.addActionListener(new ButtonListener());
		c5.addActionListener(new ButtonListener());
		//reenables column buttons after a reset
		enableColumnButtons();
		
		buildEmptyBoard();
		
		// determine if board needs to be expanded
		switch (sizeOfBoard) {
			case 6: 
				// add panels to master panel
				combinedPanel.add(placementPanel, BorderLayout.NORTH);
				combinedPanel.add(boardPanel, BorderLayout.CENTER);
				break;
			case 9: 
				// create header with arrow selection for piece drop
				
				combinedPanel.add(placementPanel, BorderLayout.NORTH);
				combinedPanel.add(boardPanel);
				break;
			case 12:
				// create header with arrow selection for piece drop
				
				combinedPanel.add(placementPanel, BorderLayout.NORTH);
				combinedPanel.add(boardPanel, BorderLayout.CENTER);
				break;
			default:
					break;
		}
	}

	
	private static void disableColumnButtons(){
        c0.setEnabled(false);
        c1.setEnabled(false);
        c2.setEnabled(false);
        c3.setEnabled(false);
        c4.setEnabled(false);
        c5.setEnabled(false);
    }

    public static void enableColumnButtons(){
        c0.setEnabled(true);
        c1.setEnabled(true);
        c2.setEnabled(true);
        c3.setEnabled(true);
        c4.setEnabled(true);
        c5.setEnabled(true);
    }

	public JPanel getPanel() {
		return combinedPanel;
	}
	
	// creates empty containers on board for piece placement
	public void buildEmptyBoard() {
		int rowCount = 0, columnCount = 0, boardIndexCounter = 0;
		
		while (rowCount < 6) {
			columnCount = 0;
			while (columnCount < 6) {
				//boardColorArray[rowCount][columnCount] = Color.black;
				boardPanel.add(new DrawCircle());
				boardPanel.getComponent(boardIndexCounter).setForeground(Color.BLACK);
	    		columnCount++;
	    		boardIndexCounter++;
			}
			rowCount++;
		}
	}
	
	// will remove all components from the board for reconstruction
	public void clearPanel() {
		boardPanel.removeAll();
		placementPanel.removeAll();
		combinedPanel.removeAll();
	}

	// actionListener for the placement buttons
    static class ButtonListener implements ActionListener {
   	     	
      	public void actionPerformed(ActionEvent e) {
      		// when a button is clicked, call the placePiece() method
      		placePiece(e);
	    }
     }

    
    // MAY NOT BE NEEDED
    public static String boardArray() {
    	String arrayComponentList = "Start: \n";
    	int countComponent = 0;
    	
    	for (Component c: boardPanel.getComponents()) {
    		arrayComponentList += "\t" + countComponent + ": " + c.getForeground().getRGB();
    		
    		if (countComponent == 5 || countComponent==11 || countComponent==17 ||
    				 countComponent==23 || countComponent==29) {
    			arrayComponentList += "\n";
    		}
    		countComponent++;
    	}
    	return arrayComponentList;
    }
 
    // CHANGES COLOR OF PIECE TO BE PLACED THEN PLACES PIECE
    public static void placePiece(ActionEvent e) {
    	// set color of piece to be placed based on who's turn it is
  		if (playerCounter%2 == 0) {
  			// then it is player 2's turn and turn color to p2Color
  			pieceColor = CFour.p2Color;
  		} else {
  			// then it is player 1's turn and turn color to p1Color
  			pieceColor = CFour.p1Color;
  		}
  		
  		if (CFour.p1Color != null && CFour.p2Color != null) {
  				if (e.getSource().equals(c0)) {
         			if (boardPanel.getComponent(30).getForeground().equals(Color.BLACK)) {
         				boardPanel.remove(boardPanel.getComponent(30));
             			boardPanel.add(new FillCircle(), 30);
             			boardPanel.getComponent(30).setForeground(pieceColor);
         			} else if (boardPanel.getComponent(24).getForeground().equals(Color.BLACK)) {
         				boardPanel.remove(boardPanel.getComponent(24));
             			boardPanel.add(new FillCircle(), 24);
             			boardPanel.getComponent(24).setForeground(pieceColor);
         			} else if (boardPanel.getComponent(18).getForeground().equals(Color.BLACK)) {
         				boardPanel.remove(boardPanel.getComponent(18));
             			boardPanel.add(new FillCircle(), 18);
             			boardPanel.getComponent(18).setForeground(pieceColor);
         			} else if (boardPanel.getComponent(12).getForeground().equals(Color.BLACK)) {
         				boardPanel.remove(boardPanel.getComponent(12));
             			boardPanel.add(new FillCircle(), 12);
             			boardPanel.getComponent(12).setForeground(pieceColor);
         			} else if (boardPanel.getComponent(6).getForeground().equals(Color.BLACK)) {
         				boardPanel.remove(boardPanel.getComponent(6));
             			boardPanel.add(new FillCircle(), 6);
             			boardPanel.getComponent(6).setForeground(pieceColor);
         			} else if (boardPanel.getComponent(0).getForeground().equals(Color.BLACK)) {
         				boardPanel.remove(boardPanel.getComponent(0));
             			boardPanel.add(new FillCircle(), 0);
             			boardPanel.getComponent(0).setForeground(pieceColor);
             			c0.setEnabled(false);
         			} 
 				} else if (e.getSource().equals(c1)) {
 					if (boardPanel.getComponent(31).getForeground().equals(Color.BLACK)) {
         				boardPanel.remove(boardPanel.getComponent(31));
             			boardPanel.add(new FillCircle(), 31);
             			boardPanel.getComponent(31).setForeground(pieceColor);
         			} else if (boardPanel.getComponent(25).getForeground().equals(Color.BLACK)) {
         				boardPanel.remove(boardPanel.getComponent(25));
             			boardPanel.add(new FillCircle(), 25);
             			boardPanel.getComponent(25).setForeground(pieceColor);
         			} else if (boardPanel.getComponent(19).getForeground().equals(Color.BLACK)) {
         				boardPanel.remove(boardPanel.getComponent(19));
             			boardPanel.add(new FillCircle(), 19);
             			boardPanel.getComponent(19).setForeground(pieceColor);
         			} else if (boardPanel.getComponent(13).getForeground().equals(Color.BLACK)) {
         				boardPanel.remove(boardPanel.getComponent(13));
             			boardPanel.add(new FillCircle(), 13);
             			boardPanel.getComponent(13).setForeground(pieceColor);
         			} else if (boardPanel.getComponent(7).getForeground().equals(Color.BLACK)) {
         				boardPanel.remove(boardPanel.getComponent(7));
             			boardPanel.add(new FillCircle(), 7);
             			boardPanel.getComponent(7).setForeground(pieceColor);
         			} else if (boardPanel.getComponent(1).getForeground().equals(Color.BLACK)) {
         				boardPanel.remove(boardPanel.getComponent(1));
             			boardPanel.add(new FillCircle(), 1);
             			boardPanel.getComponent(1).setForeground(pieceColor);
             			c1.setEnabled(false);
         			} 
         		} else if (e.getSource().equals(c2)) {
         			if (boardPanel.getComponent(32).getForeground().equals(Color.BLACK)) {
         				boardPanel.remove(boardPanel.getComponent(32));
             			boardPanel.add(new FillCircle(), 32);
             			boardPanel.getComponent(32).setForeground(pieceColor);
         			} else if (boardPanel.getComponent(26).getForeground().equals(Color.BLACK)) {
         				boardPanel.remove(boardPanel.getComponent(26));
             			boardPanel.add(new FillCircle(), 26);
             			boardPanel.getComponent(26).setForeground(pieceColor);
         			} else if (boardPanel.getComponent(20).getForeground().equals(Color.BLACK)) {
         				boardPanel.remove(boardPanel.getComponent(20));
             			boardPanel.add(new FillCircle(), 20);
             			boardPanel.getComponent(20).setForeground(pieceColor);
         			} else if (boardPanel.getComponent(14).getForeground().equals(Color.BLACK)) {
         				boardPanel.remove(boardPanel.getComponent(14));
             			boardPanel.add(new FillCircle(), 14);
             			boardPanel.getComponent(14).setForeground(pieceColor);
         			} else if (boardPanel.getComponent(8).getForeground().equals(Color.BLACK)) {
         				boardPanel.remove(boardPanel.getComponent(8));
             			boardPanel.add(new FillCircle(), 8);
             			boardPanel.getComponent(8).setForeground(pieceColor);
         			} else if (boardPanel.getComponent(2).getForeground().equals(Color.BLACK)) {
         				boardPanel.remove(boardPanel.getComponent(2));
             			boardPanel.add(new FillCircle(), 2);
             			boardPanel.getComponent(2).setForeground(pieceColor);
             			c2.setEnabled(false);
         			} 
         		} else if (e.getSource().equals(c3)) {
         			if (boardPanel.getComponent(33).getForeground().equals(Color.BLACK)) {
         				boardPanel.remove(boardPanel.getComponent(33));
             			boardPanel.add(new FillCircle(), 33);
             			boardPanel.getComponent(33).setForeground(pieceColor);
         			} else if (boardPanel.getComponent(27).getForeground().equals(Color.BLACK)) {
         				boardPanel.remove(boardPanel.getComponent(27));
             			boardPanel.add(new FillCircle(), 27);
             			boardPanel.getComponent(27).setForeground(pieceColor);
         			} else if (boardPanel.getComponent(21).getForeground().equals(Color.BLACK)) {
         				boardPanel.remove(boardPanel.getComponent(21));
             			boardPanel.add(new FillCircle(), 21);
             			boardPanel.getComponent(21).setForeground(pieceColor);
         			} else if (boardPanel.getComponent(15).getForeground().equals(Color.BLACK)) {
         				boardPanel.remove(boardPanel.getComponent(15));
             			boardPanel.add(new FillCircle(), 15);
             			boardPanel.getComponent(15).setForeground(pieceColor);
         			} else if (boardPanel.getComponent(9).getForeground().equals(Color.BLACK)) {
         				boardPanel.remove(boardPanel.getComponent(9));
             			boardPanel.add(new FillCircle(), 9);
             			boardPanel.getComponent(9).setForeground(pieceColor);
         			} else if (boardPanel.getComponent(3).getForeground().equals(Color.BLACK)) {
         				boardPanel.remove(boardPanel.getComponent(3));
             			boardPanel.add(new FillCircle(), 3);
             			boardPanel.getComponent(3).setForeground(pieceColor);
             			c3.setEnabled(false);
         			} 
         		} else if (e.getSource().equals(c4)) {
         			if (boardPanel.getComponent(34).getForeground().equals(Color.BLACK)) {
         				boardPanel.remove(boardPanel.getComponent(34));
             			boardPanel.add(new FillCircle(), 34);
             			boardPanel.getComponent(34).setForeground(pieceColor);
         			} else if (boardPanel.getComponent(28).getForeground().equals(Color.BLACK)) {
         				boardPanel.remove(boardPanel.getComponent(28));
             			boardPanel.add(new FillCircle(), 28);
             			boardPanel.getComponent(28).setForeground(pieceColor);
         			} else if (boardPanel.getComponent(22).getForeground().equals(Color.BLACK)) {
         				boardPanel.remove(boardPanel.getComponent(22));
             			boardPanel.add(new FillCircle(), 22);
             			boardPanel.getComponent(22).setForeground(pieceColor);
         			} else if (boardPanel.getComponent(16).getForeground().equals(Color.BLACK)) {
         				boardPanel.remove(boardPanel.getComponent(16));
             			boardPanel.add(new FillCircle(), 16);
             			boardPanel.getComponent(16).setForeground(pieceColor);
         			} else if (boardPanel.getComponent(10).getForeground().equals(Color.BLACK)) {
         				boardPanel.remove(boardPanel.getComponent(10));
             			boardPanel.add(new FillCircle(), 10);
             			boardPanel.getComponent(10).setForeground(pieceColor);
         			} else if (boardPanel.getComponent(4).getForeground().equals(Color.BLACK)) {
         				boardPanel.remove(boardPanel.getComponent(4));
             			boardPanel.add(new FillCircle(), 4);
             			boardPanel.getComponent(4).setForeground(pieceColor);
             			c4.setEnabled(false);
         			} 
         		} else if (e.getSource().equals(c5)) {
         			if (boardPanel.getComponent(35).getForeground().equals(Color.BLACK)) {
         				boardPanel.remove(boardPanel.getComponent(35));
             			boardPanel.add(new FillCircle(), 35);
             			boardPanel.getComponent(35).setForeground(pieceColor);
         			} else if (boardPanel.getComponent(29).getForeground().equals(Color.BLACK)) {
         				boardPanel.remove(boardPanel.getComponent(29));
             			boardPanel.add(new FillCircle(), 29);
             			boardPanel.getComponent(29).setForeground(pieceColor);
         			} else if (boardPanel.getComponent(23).getForeground().equals(Color.BLACK)) {
         				boardPanel.remove(boardPanel.getComponent(23));
             			boardPanel.add(new FillCircle(), 23);
             			boardPanel.getComponent(23).setForeground(pieceColor);
         			} else if (boardPanel.getComponent(17).getForeground().equals(Color.BLACK)) {
         				boardPanel.remove(boardPanel.getComponent(17));
             			boardPanel.add(new FillCircle(), 17);
             			boardPanel.getComponent(17).setForeground(pieceColor);
         			} else if (boardPanel.getComponent(11).getForeground().equals(Color.BLACK)) {
         				boardPanel.remove(boardPanel.getComponent(11));
             			boardPanel.add(new FillCircle(), 11);
             			boardPanel.getComponent(11).setForeground(pieceColor);
         			} else if (boardPanel.getComponent(5).getForeground().equals(Color.BLACK)) {
         				boardPanel.remove(boardPanel.getComponent(5));
             			boardPanel.add(new FillCircle(), 5);
             			boardPanel.getComponent(5).setForeground(pieceColor);
             			c5.setEnabled(false);
         			} 
         		}
 				// increments only if the column selected is not full
         		playerCounter++;
     			boardPanel.revalidate();
     			boardPanel.repaint();
     		 
  		}
			if (isWinningPlay() == true) {
				// Disable additional plays if someone has won
				disableColumnButtons();
			} else if (isBoardFull()) {
				JOptionPane.showMessageDialog(null, "No Moves Left. This game is a draw!");
			}
    }
    
    // will check if all moves have been taken
    public static boolean isBoardFull() {
    	if (c0.isEnabled() == false && c1.isEnabled() == false && c2.isEnabled() == false && 
    			c3.isEnabled() == false && c4.isEnabled() == false && c5.isEnabled() == false) {
    		return true;
    	} else return false;
    }
    
    // will run each variant of winning configuration
    public static boolean isWinningPlay() {
    	boolean isWinner = false;
    	Component[][] colorArray = new Component[6][6];
    	int rowCount = 0, columnCount = 0;
    	try {
    		// build 2D array of colors on board
        	for (Component comp: boardPanel.getComponents()) {
        		if (columnCount == 6) {
        			rowCount++;
        			columnCount = 0;
        		}
        		colorArray[rowCount][columnCount] = comp;
        		columnCount++;
        	}
    	} catch (IndexOutOfBoundsException e) {}
    	
    	if (checkHorizontal(colorArray) == true || 
    			checkVeritcal(colorArray) == true ||
    			checkDiagonalAscending(colorArray) == true ||
    			checkDiagonalDescending(colorArray) == true) {
    		isWinner = true;
    	}
		return isWinner;
    }
    
    public static boolean checkHorizontal(Component[][] c) {
		int inARow = 0, counter = 0;
		boolean hWinner = false;
		
    	for (Component e[]: c) {
    		while (counter < 6) {
    			try {
    				// see if the rows have matching colors next to each other that are not black
        			if (e[counter].getForeground() == e[counter+1].getForeground() && 
        					!e[counter].getForeground().equals(Color.BLACK)) {
        				inARow++;
        				if (counter == 4 && inARow != 3) inARow = 0;
        				if (inARow == 3) {
        					hWinner = true;
        		   			JOptionPane.showMessageDialog(null, "HORIZONTAL WIN");
        				}
        			} else inARow = 0;
        		} catch (IndexOutOfBoundsException out) { break; }
    			counter++;
    		}
			counter = 0;		// reset counter at end of each row
    	}
    	return hWinner;
    }
    
    public static boolean checkVeritcal(Component[][] c) {
		int inARow = 0, rCounter = 0, cCounter = 0;
		boolean vWinner = false;

		while (cCounter < 6) {
			while (rCounter < 6) {
	   			try {
	   				// see if the columns have matching colors next to each other that are not black (-13421773)
	       			if (c[rCounter][cCounter].getForeground() == 
	       					c[rCounter+1][cCounter].getForeground() && 
	       					!c[rCounter][cCounter].getForeground().equals(Color.BLACK) && 
	       					!c[rCounter+1][cCounter].getForeground().equals(Color.BLACK)) {
	       				inARow++;
	       				if (inARow == 3) {
	       		   			vWinner = true;
	       		   			JOptionPane.showMessageDialog(null, "VERTICAL WIN");
	       		   			System.out.println("\n\n\n" + c[rCounter][cCounter].getForeground());
	       		   			break;
	       		   		}
	       			} else inARow = 0;
	       		} catch (IndexOutOfBoundsException out) { break; }
	   			rCounter++;
	   		}
	   		cCounter++;
		}
    	return vWinner;
    }
    
    // checks for four-in-a-row from bottom left to top right
    public static boolean checkDiagonalAscending(Component[][] c) {
    	int rCounter = 0, cCounter = 0;
		boolean aWinner = false;

		while (cCounter < 6) {
			rCounter = 0;
			while (rCounter < 6) {
	   			try {
	   				// see if the columns have matching colors next to each other that are not black (-13421773)
	   				if (c[rCounter][cCounter].getForeground().getRGB() == 
	       					c[rCounter+1][cCounter-1].getForeground().getRGB() && 
	       					!c[rCounter][cCounter].getForeground().equals(Color.BLACK)) {
	       				if (c[rCounter+1][cCounter-1].getForeground().getRGB() == 
	       						c[rCounter+2][cCounter-2].getForeground().getRGB()) {
	       					if (c[rCounter+2][cCounter-2].getForeground().getRGB() == 
	       							c[rCounter+3][cCounter-3].getForeground().getRGB()) {
	       						aWinner = true;
		       		   			JOptionPane.showMessageDialog(null, "DiagonalAscending WIN");
		       		   			break;
	       					} 
	       				} 
	       			}
	       		} catch (IndexOutOfBoundsException out) { break; }
	   			rCounter++;
	   		}
	   		cCounter++;
	   		if (aWinner == true) break;
		}
    	return aWinner;
    }

    // checks for four-in-a-row from top left to bottom right
    public static boolean checkDiagonalDescending(Component[][] c) {
    	int rCounter = 0, cCounter = 0;
		boolean dWinner = false;

		while (cCounter < 6) {
			rCounter = 0;
			while (rCounter < 6) {
	   			try {
	   				// see if the columns have matching colors next to each other that are not black (-13421773)
	       			if (c[rCounter][cCounter].getForeground().getRGB() == 
	       					c[rCounter+1][cCounter+1].getForeground().getRGB() && 
	       					!c[rCounter][cCounter].getForeground().equals(Color.BLACK)) {
	       				if (c[rCounter+1][cCounter+1].getForeground().getRGB() == 
	       						c[rCounter+2][cCounter+2].getForeground().getRGB() && 
	       						!c[rCounter][cCounter].getForeground().equals(Color.BLACK)) {
	       					if (c[rCounter+2][cCounter+2].getForeground().getRGB() == 
	       							c[rCounter+3][cCounter+3].getForeground().getRGB() && 
	       							!c[rCounter][cCounter].getForeground().equals(Color.BLACK)) {
	       						dWinner = true;
		       		   			JOptionPane.showMessageDialog(null, "DiagDescending WIN");
		       		   			break;
	       					}
	       				}
	       			}
	       		} catch (IndexOutOfBoundsException out) { break; }
	   			rCounter++;
	   		}
	   		cCounter++;
		}
    	return dWinner;
    }
}










