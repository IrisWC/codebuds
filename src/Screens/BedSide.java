package Screens;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

import java.awt.geom.AffineTransform;
import java.awt.event.*;

import Assets.*;
import Core.*;
import navigationButtons.*;

public class BedSide extends JPanel implements ActionListener, KeyListener{

	private Game mainCore;
	private int width, height;
	private JButton leftButton, rightButton, backpackButton, painting, dialogueBox;
//	private JPanel p;
	private ArrayList<ClickableItem> furnitures;
	
	public BedSide(Game mainCore, int width, int height) {
		super();
		this.mainCore = mainCore;
		this.width = width;
		this.height = height;
		
		setLayout(null);
		
		leftButton = new LeftButton(this);
		rightButton = new RightButton(this);
		backpackButton = new BackpackButton(this);
		
//		ImageIcon bedIcon = new ImageIcon("img/furniture/bed.png");
//		Image bedModified = bedIcon.getImage().getScaledInstance(450, 450, Image.SCALE_SMOOTH);
//		JButton bed = new JButton(new ImageIcon(bedModified));
//		bed.setBounds(300, 270, 450, 450);
//		bed.setOpaque(false);
//		bed.setContentAreaFilled(false);
//		bed.setBorderPainted(false);
//		bed.addActionListener(this);
//        add(bed);
		ClickableItem bed = new ClickableItem(this, "img/furniture/bed.png", 300, 270, 450, 450);
		ClickableItem starryNight = new ClickableItem(this, "img/paintings/starry night.png", 425, 50, 200, 200);
        
        dialogueBox = null;
        
        ImageIcon bedroom = new ImageIcon("img/Bedroom.png");
		Image bedroomModified = bedroom.getImage().getScaledInstance(Game.BACKGROUND_WIDTH, Game.BACKGROUND_HEIGHT, Image.SCALE_SMOOTH);
		JLabel background = new JLabel(new ImageIcon(bedroomModified));
		background.setBounds(0, 0, Game.BACKGROUND_WIDTH, Game.BACKGROUND_HEIGHT);
        add(background);
        
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D)g;

		int width = getWidth();
		int height = getHeight();

		double ratioX = (double)width/this.width;
		double ratioY = (double)height/this.height;

		AffineTransform at = g2.getTransform();
		g2.scale(ratioX, ratioY);
		
//		g.drawImage(new ImageIcon("img/bed.png").getImage(), 300, 300, 300, 300, this);
		
//		JButton bed = new JButton(new ImageIcon("img//bed.png"));
//		p.add(bed);
//	    bed.setBounds(getWidth()/2, getHeight()/2, 300, 300);
//	    bed.setOpaque(false);
//	    bed.setContentAreaFilled(false);
//	    bed.setBorderPainted(false);
//		
//		add(p);
		
		g2.setTransform(at);
	}
	
	public void run() {
		while(true) {
			repaint();
			
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == leftButton)
			mainCore.switchScreen("exitSide");
		if(e.getSource() == rightButton)
			mainCore.switchScreen("bathroomSide");
		if(e.getSource() == backpackButton)
			mainCore.openInventory();
		if(e.getSource() == painting) {
			System.out.println("painting clicked");
			
			dialogueBox = new JButton("painting clue");
			dialogueBox.setBounds(300, 300, 300, 300);
			dialogueBox.setBackground(new Color(55,50,45));
			dialogueBox.setOpaque(true);
			dialogueBox.setBorderPainted(false);
			dialogueBox.addActionListener(this);
			this.add(dialogueBox);
		}
		if(e.getSource() == dialogueBox) 
			dialogueBox = null;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
