package project;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Car{
	public int moveSpeed,x,y,width,height;
	public Image img;
	public Car() {
		moveSpeed = 20;
		width = 350;
		height = 140;
		x = 0;
		y= 500 ;
		img = new ImageIcon(Main.class.getResource("../project/ÀÚµ¿Â÷.png")).getImage();
	}
	
	public void move() {
		this.x += this.moveSpeed;
		if(this.x > 1800)
			this.x = 0;
	}
}
