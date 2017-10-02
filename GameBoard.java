import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class GameBoard extends JPanel {

	private static final long serialVersionUID = 1L;
	
	// this panel will hold the board
	private static JPanel boardPanel = new JPanel();
	// this panel will hold the arrows to drop pieces into columns
	private static JPanel placementPanel = new JPanel();
	// this panel will be the container for the arrow panel and board panel
	private static JPanel combinedPanel = new JPanel();
	// number is bottom left to top right (place 00 = bottom left corner)
	private static Component p00 = new DrawCircle();
	private static Component p01 = new DrawCircle();
	private static Component p02 = new DrawCircle();
	private static Component p03 = new DrawCircle();
	private static Component p04 = new DrawCircle();
	private static Component p05 = new DrawCircle();
	// buttons will be displayed as arrows to indicate which column to drop a game piece
	private static JButton c0 = new JButton();
	private static JButton c1 = new JButton();
	private static JButton c2 = new JButton();
	private static JButton c3 = new JButton();
	private static JButton c4 = new JButton();
	private static JButton c5 = new JButton();
	
	static Border b = BorderFactory.createLineBorder(Color.BLACK, 5);	
	
	//create board with size dependent on user input
	public GameBoard(int sizeOfBoard) {
		combinedPanel.setLayout(new BorderLayout());
		boardPanel.setBorder(b);
		boardPanel.setLayout(new GridLayout(6, 6));
		placementPanel.setLayout(new GridLayout(1, 6));
		placementPanel.setPreferredSize(new Dimension(WIDTH, 100));
		// always add the basic 6x6, then decide if more need to be added
		// create header with arrow selection for piece drop
		c0.add(new DrawArrow());
		c1.add(new DrawArrow());
		c2.add(new DrawArrow());
		c3.add(new DrawArrow());
		c4.add(new DrawArrow());
		c5.add(new DrawArrow());
		c0.setBackground(Color.black);
		c1.setBackground(Color.BLACK);
		c2.setBackground(Color.black);
		c3.setBackground(Color.black);
		c4.setBackground(Color.BLACK);
		c5.setBackground(Color.black);
		placementPanel.add(c0);
		placementPanel.add(c1);
		placementPanel.add(c2);
		placementPanel.add(c3);
		placementPanel.add(c4);
		placementPanel.add(c5);
		boardPanel.add(p00);
		boardPanel.add(p01);
		boardPanel.add(p02);
		boardPanel.add(p03);
		boardPanel.add(p04);
		boardPanel.add(p05);
		/*
		boardPanel.add(new DrawCircle());
		boardPanel.add(new DrawCircle());
		boardPanel.add(new DrawCircle());
		boardPanel.add(new DrawCircle());
		boardPanel.add(new DrawCircle());
		boardPanel.add(new DrawCircle());
		
		boardPanel.add(new DrawCircle());
		boardPanel.add(new DrawCircle());
		boardPanel.add(new DrawCircle());
		boardPanel.add(new DrawCircle());
		boardPanel.add(new DrawCircle());
		boardPanel.add(new DrawCircle());
		
		boardPanel.add(new DrawCircle());
		boardPanel.add(new DrawCircle());
		boardPanel.add(new DrawCircle());
		/*boardPanel.add(new DrawCircle());
		boardPanel.add(new DrawCircle());
		boardPanel.add(new DrawCircle());
		
		boardPanel.add(new DrawCircle());
		boardPanel.add(new DrawCircle());
		boardPanel.add(new DrawCircle());
		boardPanel.add(new DrawCircle());
		boardPanel.add(new DrawCircle());
		boardPanel.add(new DrawCircle());
		
		boardPanel.add(new DrawCircle());
		boardPanel.add(new DrawCircle());
		boardPanel.add(new DrawCircle());
		boardPanel.add(new DrawCircle());
		boardPanel.add(new DrawCircle());
		boardPanel.add(new DrawCircle());
		*/
		c0.addActionListener(new ButtonListener());
		
		// determine if board needs to be expanded
		switch (sizeOfBoard) {
			case 6: 
				// add panels to master panel
				combinedPanel.add(placementPanel, BorderLayout.NORTH);
				combinedPanel.add(boardPanel, BorderLayout.CENTER);
				break;
			case 9: 
				// create header with arrow selection for piece drop
				/*c0.add(new DrawArrow());
				c1.add(new DrawArrow());
				c2.add(new DrawArrow());
				c3.add(new DrawArrow());
				c4.add(new DrawArrow());
				c5.add(new DrawArrow());
				placementPanel.add(c0);
				placementPanel.add(c1);
				placementPanel.add(c2);
				placementPanel.add(c3);
				placementPanel.add(c4);
				placementPanel.add(c5);
				boardPanel.add(p00);
				boardPanel.add(p01);
				boardPanel.add(p02);
				boardPanel.add(p03);
				boardPanel.add(p04);
				boardPanel.add(p05);*/
				combinedPanel.add(placementPanel, BorderLayout.NORTH);
				combinedPanel.add(boardPanel);
				break;
			case 12:
				// create header with arrow selection for piece drop
				/*c0.add(new DrawArrow());
				c1.add(new DrawArrow());
				c2.add(new DrawArrow());
				c3.add(new DrawArrow());
				c4.add(new DrawArrow());
				c5.add(new DrawArrow());
				placementPanel.add(c0);
				placementPanel.add(c1);
				placementPanel.add(c2);
				placementPanel.add(c3);
				placementPanel.add(c4);
				placementPanel.add(c5);
				boardPanel.add(p00);
				boardPanel.add(p01);
				boardPanel.add(p02);
				boardPanel.add(p03);
				boardPanel.add(p04);
				boardPanel.add(p05);*/
				combinedPanel.add(placementPanel, BorderLayout.NORTH);
				combinedPanel.add(boardPanel, BorderLayout.CENTER);
				break;
			default:
					break;
		}
	}
	
	public JPanel getPanel() {
		return combinedPanel;
	}
	
    static class ButtonListener implements ActionListener {
   	 
      	public void actionPerformed(ActionEvent e) {
     		if (e.getSource().equals(c0)) {
     			boardPanel.remove(p00);
     			boardPanel.add(new FillCircle());
     			//boardPanel.repaint();
     			boardPanel.revalidate();
     		}
	      }
     }

	// create 
}
