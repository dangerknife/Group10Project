import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

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
	public static JPanel gameBoardPanel = new GameBoard(6);
	
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
		
	public static Component c1 = new DrawCircle();
	public static Component c2 = new DrawCircle();
	public static Component c3 = new DrawCircle();
	public static Component c4 = new DrawCircle();	
	public static Component c5 = new DrawCircle();
	public static Component c6 = new DrawCircle();	
	public static Component c7 = new DrawCircle();
	public static Component c8 = new DrawCircle();
	public static Component c9 = new DrawCircle();
	public static Component c10 = new DrawCircle();
	public static Component c11 = new DrawCircle();
	public static Component c12 = new DrawCircle();	
	public static Component c13 = new DrawCircle();
	public static Component c14 = new DrawCircle();	
	public static Component c15 = new DrawCircle();
	public static Component c16 = new DrawCircle();	
	public static Component c17 = new DrawCircle();
	public static Component c18 = new DrawCircle();
	public static Component c19 = new DrawCircle();
	public static Component c20 = new DrawCircle();	
	public static Component c21 = new DrawCircle();
	public static Component c22 = new DrawCircle();	
	public static Component c23 = new DrawCircle();
	public static Component c24 = new DrawCircle();
	public static Component c25 = new DrawCircle();	
	public static Component c26 = new DrawCircle();
	public static Component c27 = new DrawCircle();	
	public static Component c28 = new DrawCircle();
	public static Component c29 = new DrawCircle();	
	public static Component c30 = new DrawCircle();
	public static Component c31 = new DrawCircle();
	public static Component c32 = new DrawCircle();
	public static Component c33 = new DrawCircle();	
	public static Component c34 = new DrawCircle();
	public static Component c35 = new DrawCircle();	
	public static Component c36 = new DrawCircle();
	
	public static Component player1Color = new DrawCircle();
	public static Component player2Color = new DrawCircle();
	public static Component drawCircle = new DrawCircle();
	
	public static JButton draw1 = new JButton();
	public static JButton draw2 = new JButton();
	public static JButton draw3 = new JButton();
	public static JButton draw4 = new JButton();	
	public static JButton draw5 = new JButton();
	public static JButton draw6 = new JButton();	
	public static JButton draw7 = new JButton();
	public static JButton draw8 = new JButton();
	public static JButton draw9 = new JButton();
	public static JButton draw10 = new JButton();
	public static JButton draw11 = new JButton();
	public static JButton draw12 = new JButton();	
	public static JButton draw13 = new JButton();
	public static JButton draw14 = new JButton();	
	public static JButton draw15 = new JButton();
	public static JButton draw16 = new JButton();	
	public static JButton draw17 = new JButton();
	public static JButton draw18 = new JButton();
	public static JButton draw19 = new JButton();
	public static JButton draw20 = new JButton();	
	public static JButton draw21 = new JButton();
	public static JButton draw22 = new JButton();	
	public static JButton draw23 = new JButton();
	public static JButton draw24 = new JButton();
	public static JButton draw25 = new JButton();	
	public static JButton draw26 = new JButton();
	public static JButton draw27 = new JButton();	
	public static JButton draw28 = new JButton();
	public static JButton draw29 = new JButton();	
	public static JButton draw30 = new JButton();
	public static JButton draw31 = new JButton();
	public static JButton draw32 = new JButton();
	public static JButton draw33 = new JButton();	
	public static JButton draw34 = new JButton();
	public static JButton draw35 = new JButton();	
	public static JButton draw36 = new JButton();
	
	public static JRadioButton smallRadio = new JRadioButton("6x6");
	public static JRadioButton mediumRadio = new JRadioButton("9x9");
	public static JRadioButton largeRadio = new JRadioButton("12x12");
	public static ButtonGroup radioGroup = new ButtonGroup();
	
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
	
	static Border b = BorderFactory.createLineBorder(Color.BLACK, 3);	
	 
	public static int p1Color = 0;
	public static int p2Color = 0;
	public static int boardSize = 1;
	
    public static ActionListener buttonListener = new ButtonListener();
    public static ActionListener playerRadioListener = new PlayerRadioListener();
    public static ActionListener boardSizeRadioListener = new BoardSizeRadioListener();
	
	 public static void main(String args[]) throws InterruptedException {

		gameTitle.setFont(buttonFont);
		
		colorSelectLabel.setFont(buttonFont);
		colorSelectLabel.setHorizontalAlignment(JLabel.CENTER);
		
		boardSizeLabel.setFont(buttonFont);
		boardSizeLabel.setBorder(b);
		boardSizeLabel.setHorizontalAlignment(JLabel.CENTER);
		
		player1Label.setBorder(b);
		player1Label.setHorizontalAlignment(JLabel.CENTER);
		player1Label.setFont(buttonFont);
		player1Label.setOpaque(true);
		player1Label.setBackground(Color.black);
		player1Label.setForeground(Color.white);
		
		player2Label.setBorder(b);
		player2Label.setHorizontalAlignment(JLabel.CENTER);
		player2Label.setFont(buttonFont);
		player2Label.setOpaque(true);
		player2Label.setBackground(Color.black);
		player2Label.setForeground(Color.white);
				
		resetButton.setFont(buttonFont);
		resetButton.setBackground(Color.BLACK);
		resetButton.setForeground(Color.WHITE);
		
		greenButton.setFont(buttonFont);
		greenButton.setBackground(Color.green);
		
		redButton.setFont(buttonFont);
		redButton.setBackground(Color.red);
		
		blueButton.setFont(buttonFont);
		blueButton.setBackground(Color.blue);
		
		orangeButton.setFont(buttonFont);
		orangeButton.setBackground(Color.orange);		
		 
		smallRadio.setFont(radioFont);
		smallRadio.setSelected(true);
		mediumRadio.setFont(radioFont);
		largeRadio.setFont(radioFont);
		radioGroup.add(smallRadio);
		radioGroup.add(mediumRadio);
		radioGroup.add(largeRadio);
		
		p1RedRadio.setFont(buttonFont);	
		p1GreenRadio.setFont(buttonFont);		
		p1BlueRadio.setFont(buttonFont);
		p1OrangeRadio.setFont(buttonFont);
		p1RadioGroup.add(p1RedRadio);
		p1RadioGroup.add(p1GreenRadio);
		p1RadioGroup.add(p1BlueRadio);
		p1RadioGroup.add(p1OrangeRadio);
		
		p2RedRadio.setFont(buttonFont);	
		p2GreenRadio.setFont(buttonFont);		
		p2BlueRadio.setFont(buttonFont);
		p2OrangeRadio.setFont(buttonFont);
		p2RadioGroup.add(p2RedRadio);
		p2RadioGroup.add(p2GreenRadio);
		p2RadioGroup.add(p2BlueRadio);
		p2RadioGroup.add(p2OrangeRadio);
		
		/*
		// add circles to all buttons
		draw1.add(c1);
		draw2.add(c2);
		draw3.add(c3);
		draw4.add(c4);
		draw5.add(c5);
		draw6.add(c6);
		draw7.add(c7);
		draw8.add(c8);
		draw9.add(c9);
		draw10.add(c10);
		draw11.add(c11);
		draw12.add(c12);
		draw13.add(c13);
		draw14.add(c14);
		draw15.add(c15);
		draw16.add(c16);
		draw17.add(c17);
		draw18.add(c18);
		draw19.add(c19);
		draw20.add(c20);
		draw21.add(c21);
		draw22.add(c22);
		draw23.add(c23);
		draw24.add(c24);
		draw25.add(c25);
		draw26.add(c26);
		draw27.add(c27);
		draw28.add(c28);
		draw29.add(c29);
		draw30.add(c30);
		draw31.add(c31);
		draw32.add(c32);
		draw33.add(c33);
		draw34.add(c34);
		draw35.add(c35);
		draw36.add(c36);
		*/
		
		draw1.add(new DrawArrow());
		draw1.setBackground(new Color(Color.OPAQUE));
		// panel for all buttons
		connectPanel.setLayout(new GridLayout(6, 6));
		connectPanel.add(draw1);
		connectPanel.add(draw2);
		connectPanel.add(draw3);
		connectPanel.add(draw4);
		connectPanel.add(draw5);
		connectPanel.add(draw6);
		connectPanel.add(draw7);
		connectPanel.add(draw8);
		connectPanel.add(draw9);
		connectPanel.add(draw10);
		connectPanel.add(draw11);
		connectPanel.add(draw12);
		connectPanel.add(draw13);
		connectPanel.add(draw14);
		connectPanel.add(draw15);
		connectPanel.add(draw16);
		connectPanel.add(draw17);
		connectPanel.add(draw18);
		connectPanel.add(draw19);
		connectPanel.add(draw20);
		connectPanel.add(draw21);
		connectPanel.add(draw22);
		connectPanel.add(draw23);
		connectPanel.add(draw24);
		connectPanel.add(draw25);
		connectPanel.add(draw26);
		connectPanel.add(draw27);
		connectPanel.add(draw28);
		connectPanel.add(draw29);
		connectPanel.add(draw30);
		connectPanel.add(draw31);
		connectPanel.add(draw32);
		connectPanel.add(draw33);
		connectPanel.add(draw34);
		connectPanel.add(draw35);
		connectPanel.add(draw36);		
		
		player1Panel.setLayout(new GridLayout(5, 1));
		player1Panel.add(player1Label);
		player1Panel.add(p1RedRadio);
		player1Panel.add(p1GreenRadio);
		player1Panel.add(p1BlueRadio);
		player1Panel.add(p1OrangeRadio);
		
		player2Panel.setLayout(new GridLayout(5, 1));
		player2Panel.add(player2Label);
		player2Panel.add(p2RedRadio);
		player2Panel.add(p2GreenRadio);
		player2Panel.add(p2BlueRadio);
		player2Panel.add(p2OrangeRadio);
		
		colorsPanelCenter.setBorder(b);
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
		//basePanel.add(connectPanel, BorderLayout.CENTER);
		basePanel.add(new GameBoard(6).getPanel(), BorderLayout.CENTER);
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
        
        //addAllButtonListeners();
	 }
	 
	 static class BoardSizeRadioListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			if (smallRadio.isSelected()) {
				// Change CONNECTPANEL to 6x6
				if (boardSize == 6) {
					JOptionPane.showMessageDialog(null, "The Board is already 6x6");
				} else {
					boardSize = 6;
					// CALL method to add 6x6 panel
				}
			} else if (mediumRadio.isSelected()) {
				// Change CONNECTPANEL to 9x9
				if (boardSize == 9) {
					JOptionPane.showMessageDialog(null, "The Board is already 9x9");
				} else {
					boardSize = 9;
					// CALL method to add 9x9 panel
				}
			} else if (largeRadio.isSelected()) {
				// Change CONNECTPANEL to 12x12
				if (boardSize == 12) {
					JOptionPane.showMessageDialog(null, "The Board is already 12x12");
				} else {
					boardSize = 12;
					// CALL method to add 12x12 panel
				}
			}
		}
	 }
	 
	 static class PlayerRadioListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			if (p1RedRadio.isSelected()) {
				p1Color = 1;
			} else if (p1GreenRadio.isSelected()) {
				p1Color = 2;
			} else if (p1BlueRadio.isSelected()) {
				p1Color = 3;
			} else if (p1OrangeRadio.isSelected()) {
				p1Color = 4;
			}
			
			if (p2RedRadio.isSelected()) {
				p2Color = 1;
			} else if (p2GreenRadio.isSelected()) {
				p2Color = 2;
			} else if (p2BlueRadio.isSelected()) {
				p2Color = 3;
			} else if (p2OrangeRadio.isSelected()) {
				p2Color = 4;
			}
						
			if (p1Color == p2Color) {
				JOptionPane.showMessageDialog(null, "YOU MUST PICK DIFFERENT COLORS", "Same Color Selected", 1);
			}
		}
	 }
	 
     static class ButtonListener implements ActionListener {
    	 
      	public void actionPerformed(ActionEvent e) {
      		if (e.getSource().equals(resetButton)) {
      			draw1.setBackground(null);
      			draw2.setBackground(null);
      			draw3.setBackground(null);
      			draw4.setBackground(null);
      			draw5.setBackground(null);
      			draw6.setBackground(null);
      			draw7.setBackground(null);
      			draw8.setBackground(null);
      			draw9.setBackground(null);
      			draw10.setBackground(null);
      			draw11.setBackground(null);
      			draw12.setBackground(null);
      			draw13.setBackground(null);
      			draw14.setBackground(null);
      			draw15.setBackground(null);
      			draw16.setBackground(null);
      			draw17.setBackground(null);
      			draw18.setBackground(null);
      			draw19.setBackground(null);
      			draw20.setBackground(null);
       			draw21.setBackground(null);
      			draw22.setBackground(null);
      			draw23.setBackground(null);
      			draw24.setBackground(null);
      			draw25.setBackground(null);
      			draw26.setBackground(null);
      			draw27.setBackground(null);
      			draw28.setBackground(null);
      			draw29.setBackground(null);
      			draw30.setBackground(null);
      			draw31.setBackground(null);
      			draw32.setBackground(null);
      			draw33.setBackground(null);
      			draw34.setBackground(null);
      			draw35.setBackground(null);
      			draw36.setBackground(null);
        	}
      		
      		if (p1Color != p2Color) {
	      		if (e.getSource().equals(draw1)) {
	      			if (draw1.getBackground().equals(Color.GREEN)) {
	      				draw1.setBackground(Color.RED);
	          		} else draw1.setBackground(Color.GREEN);
	      		}
	      		
	      		if (e.getSource().equals(draw2)) {
	      			if (draw2.getBackground().equals(Color.GREEN)) {
	      				draw2.setBackground(Color.RED);
	          		} else draw2.setBackground(Color.GREEN);
	      		}
	      		
	      		if (e.getSource().equals(draw3)) {
	      			if (draw3.getBackground().equals(Color.GREEN)) {
	      				draw3.setBackground(Color.RED);
	          		} else draw3.setBackground(Color.GREEN);
	      		}
	      		
	      		if (e.getSource().equals(draw4)) {
	      			if (draw4.getBackground().equals(Color.GREEN)) {
	      				draw4.setBackground(Color.RED);
	          		} else draw4.setBackground(Color.GREEN);
	      		}
	      		
	      		if (e.getSource().equals(draw5)) {
	      			if (draw5.getBackground().equals(Color.GREEN)) {
	      				draw5.setBackground(Color.RED);
	          		} else draw5.setBackground(Color.GREEN);
	      		}
	      		
	      		if (e.getSource().equals(draw6)) {
	      			if (draw6.getBackground().equals(Color.GREEN)) {
	      				draw6.setBackground(Color.RED);
	          		} else draw6.setBackground(Color.GREEN);
	      		}
	      		
	      		if (e.getSource().equals(draw7)) {
	      			if (draw7.getBackground().equals(Color.GREEN)) {
	      				draw7.setBackground(Color.RED);
	          		} else draw7.setBackground(Color.GREEN);
	      		}
	      		
	      		if (e.getSource().equals(draw8)) {
	      			if (draw8.getBackground().equals(Color.GREEN)) {
	      				draw8.setBackground(Color.RED);
	          		} else draw8.setBackground(Color.GREEN);
	      		}
	      		
	      		if (e.getSource().equals(draw9)) {
	      			if (draw9.getBackground().equals(Color.GREEN)) {
	      				draw9.setBackground(Color.RED);
	          		} else draw9.setBackground(Color.GREEN);
	      		}
	      		
	      		if (e.getSource().equals(draw10)) {
	      			if (draw10.getBackground().equals(Color.GREEN)) {
	      				draw10.setBackground(Color.RED);
	          		} else draw10.setBackground(Color.GREEN);
	      		}
	      		
	      		if (e.getSource().equals(draw11)) {
	      			if (draw11.getBackground().equals(Color.GREEN)) {
	      				draw11.setBackground(Color.RED);
	          		} else draw11.setBackground(Color.GREEN);
	      		}
	      		
	      		if (e.getSource().equals(draw12)) {
	      			if (draw12.getBackground().equals(Color.GREEN)) {
	      				draw12.setBackground(Color.RED);
	          		} else draw12.setBackground(Color.GREEN);
	      		}
	      		
	      		if (e.getSource().equals(draw13)) {
	      			if (draw13.getBackground().equals(Color.GREEN)) {
	      				draw13.setBackground(Color.RED);
	          		} else draw13.setBackground(Color.GREEN);
	      		}
	      		
	      		if (e.getSource().equals(draw14)) {
	      			if (draw14.getBackground().equals(Color.GREEN)) {
	      				draw14.setBackground(Color.RED);
	          		} else draw14.setBackground(Color.GREEN);
	      		}
	      		
	      		if (e.getSource().equals(draw15)) {
	      			if (draw15.getBackground().equals(Color.GREEN)) {
	      				draw15.setBackground(Color.RED);
	          		} else draw15.setBackground(Color.GREEN);
	      		}
	      		
	      		if (e.getSource().equals(draw16)) {
	      			if (draw16.getBackground().equals(Color.GREEN)) {
	      				draw16.setBackground(Color.RED);
	          		} else draw16.setBackground(Color.GREEN);
	      		}
	      		
	      		if (e.getSource().equals(draw17)) {
	      			if (draw17.getBackground().equals(Color.GREEN)) {
	      				draw17.setBackground(Color.RED);
	          		} else draw17.setBackground(Color.GREEN);
	      		}
	      		
	      		if (e.getSource().equals(draw18)) {
	      			if (draw18.getBackground().equals(Color.GREEN)) {
	      				draw18.setBackground(Color.RED);
	          		} else draw18.setBackground(Color.GREEN);
	      		}
	      		
	      		if (e.getSource().equals(draw19)) {
	      			if (draw19.getBackground().equals(Color.GREEN)) {
	      				draw19.setBackground(Color.RED);
	          		} else draw19.setBackground(Color.GREEN);
	      		}
	      		
	      		if (e.getSource().equals(draw20)) {
	      			if (draw20.getBackground().equals(Color.GREEN)) {
	      				draw20.setBackground(Color.RED);
	          		} else draw20.setBackground(Color.GREEN);
	      		}
	      		
	      		if (e.getSource().equals(draw21)) {
	      			if (draw21.getBackground().equals(Color.GREEN)) {
	      				draw21.setBackground(Color.RED);
	          		} else draw21.setBackground(Color.GREEN);
	      		}
	      		
	      		if (e.getSource().equals(draw22)) {
	      			if (draw22.getBackground().equals(Color.GREEN)) {
	      				draw22.setBackground(Color.RED);
	          		} else draw22.setBackground(Color.GREEN);
	      		}
	      		
	      		if (e.getSource().equals(draw23)) {
	      			if (draw23.getBackground().equals(Color.GREEN)) {
	      				draw23.setBackground(Color.RED);
	          		} else draw23.setBackground(Color.GREEN);
	      		}
	      		
	      		if (e.getSource().equals(draw24)) {
	      			if (draw24.getBackground().equals(Color.GREEN)) {
	      				draw24.setBackground(Color.RED);
	          		} else draw24.setBackground(Color.GREEN);
	      		}
	      		
	      		if (e.getSource().equals(draw25)) {
	      			if (draw25.getBackground().equals(Color.GREEN)) {
	      				draw25.setBackground(Color.RED);
	          		} else draw25.setBackground(Color.GREEN);
	      		}
	      		
	      		if (e.getSource().equals(draw26)) {
	      			if (draw26.getBackground().equals(Color.GREEN)) {
	      				draw26.setBackground(Color.RED);
	          		} else draw26.setBackground(Color.GREEN);
	      		}
	      		
	      		if (e.getSource().equals(draw27)) {
	      			if (draw27.getBackground().equals(Color.GREEN)) {
	      				draw27.setBackground(Color.RED);
	          		} else draw27.setBackground(Color.GREEN);
	      		}
	      		
	      		if (e.getSource().equals(draw28)) {
	      			if (draw28.getBackground().equals(Color.GREEN)) {
	      				draw28.setBackground(Color.RED);
	          		} else draw28.setBackground(Color.GREEN);
	      		}
	      		
	      		if (e.getSource().equals(draw29)) {
	      			if (draw29.getBackground().equals(Color.GREEN)) {
	      				draw29.setBackground(Color.RED);
	          		} else draw29.setBackground(Color.GREEN);
	      		}
	      		
	      		if (e.getSource().equals(draw30)) {
	      			if (draw30.getBackground().equals(Color.GREEN)) {
	      				draw30.setBackground(Color.RED);
	          		} else draw30.setBackground(Color.GREEN);
	      		}
	      		
	      		if (e.getSource().equals(draw31)) {
	      			if (draw31.getBackground().equals(Color.GREEN)) {
	      				draw31.setBackground(Color.RED);
	          		} else draw31.setBackground(Color.GREEN);
	      		}
	      		
	      		if (e.getSource().equals(draw32)) {
	      			if (draw32.getBackground().equals(Color.GREEN)) {
	      				draw32.setBackground(Color.RED);
	          		} else draw32.setBackground(Color.GREEN);
	      		}
	      		
	      		if (e.getSource().equals(draw33)) {
	      			if (draw33.getBackground().equals(Color.GREEN)) {
	      				draw33.setBackground(Color.RED);
	          		} else draw33.setBackground(Color.GREEN);
	      		}
	      		
	      		if (e.getSource().equals(draw34)) {
	      			if (draw34.getBackground().equals(Color.GREEN)) {
	      				draw34.setBackground(Color.RED);
	          		} else draw34.setBackground(Color.GREEN);
	      		}
	      		
	      		if (e.getSource().equals(draw35)) {
	      			if (draw35.getBackground().equals(Color.GREEN)) {
	      				draw35.setBackground(Color.RED);
	          		} else draw35.setBackground(Color.GREEN);
	      		}
	      		
	      		if (e.getSource().equals(draw36)) {
	      			if (draw36.getBackground().equals(Color.GREEN)) {
	      				draw36.setBackground(Color.RED);
	          		} else draw36.setBackground(Color.GREEN);
	      		}
      		}
	      }
     }

     public static void addAllButtonListeners() {
    	 
    	 if (smallRadio.isSelected()) {
	    	 draw1.addActionListener(buttonListener);
	         draw2.addActionListener(buttonListener);
	         draw3.addActionListener(buttonListener);
	         draw4.addActionListener(buttonListener);
	         draw5.addActionListener(buttonListener);
	         draw6.addActionListener(buttonListener);
	         draw7.addActionListener(buttonListener);
	         draw8.addActionListener(buttonListener);
	         draw9.addActionListener(buttonListener);
	         draw10.addActionListener(buttonListener);
	         draw11.addActionListener(buttonListener);
	         draw12.addActionListener(buttonListener);
	         draw13.addActionListener(buttonListener);
	         draw14.addActionListener(buttonListener);
	         draw15.addActionListener(buttonListener);
	         draw16.addActionListener(buttonListener);
	         draw17.addActionListener(buttonListener);
	         draw18.addActionListener(buttonListener);
	         draw19.addActionListener(buttonListener);
	         draw20.addActionListener(buttonListener);
	         draw21.addActionListener(buttonListener);
	         draw22.addActionListener(buttonListener);
	         draw23.addActionListener(buttonListener);
	         draw24.addActionListener(buttonListener);
	         draw25.addActionListener(buttonListener);
	         draw26.addActionListener(buttonListener);
	         draw27.addActionListener(buttonListener);
	         draw28.addActionListener(buttonListener);
	         draw29.addActionListener(buttonListener);
	         draw30.addActionListener(buttonListener);
	         draw31.addActionListener(buttonListener);
	         draw32.addActionListener(buttonListener);
	         draw33.addActionListener(buttonListener);
	         draw34.addActionListener(buttonListener);
	         draw35.addActionListener(buttonListener);
	         draw36.addActionListener(buttonListener);
    	 } else if (mediumRadio.isSelected()) {
    		 
    	 } else if (largeRadio.isSelected()) {
    		 
    	 }
     }
}
