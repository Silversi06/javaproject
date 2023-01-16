package project;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Car3{
	public int moveSpeed,x,y,width,height;
	public Image img;
	public Car3() {
		moveSpeed = 5;
		width = 330;
		height = 220;
		x = 550;
		y= 0 ;
		img = new ImageIcon(Main.class.getResource("../project/ÀÚµ¿Â÷3.png")).getImage();
	}
	
	public void move() {
		this.y += this.moveSpeed;
		if(this.y > 1800)
			this.y = 0;
	}
}
