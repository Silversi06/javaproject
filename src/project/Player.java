package project;

import java.awt.*;

import javax.swing.ImageIcon;

public class Player {
	public int hp,x,y,width,height;
	public Image img;
	public Player() {
		hp = 100;
		x = 200;
		y = 0;
		width = 100;
		height = 250;
		img = new ImageIcon(Main.class.getResource("../project/»ç¶÷.png")).getImage();
	}
}
