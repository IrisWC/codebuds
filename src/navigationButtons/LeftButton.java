package navigationButtons;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import Core.Game;

public class LeftButton extends JButton{
	
	public LeftButton(JPanel p) {
		this.setBounds(0, 0, 100, Game.HEIGHT);
		ImageIcon arrowIcon = new ImageIcon("img/leftarrow.png");
		Image arrowModified = arrowIcon.getImage().getScaledInstance(48, 80, Image.SCALE_SMOOTH);
		this.setIcon(new ImageIcon(arrowModified));
		this.setBackground(new Color(50,47,48));
		this.setOpaque(true);
		this.setBorderPainted(false);
		this.addActionListener((ActionListener) p);
		p.add(this);
	}

}
