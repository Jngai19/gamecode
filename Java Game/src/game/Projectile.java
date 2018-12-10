package game;

import java.awt.Image;
import java.awt.Toolkit;

public class Projectile {

	private double xCoord;
	private double yCoord;
	private int width;
	private int height;
	private Image img;
	
	public Projectile() {
		setxCoord(10);
		setyCoord(10);
		setWidth(30);
		setHeight(30);
		setImg("files/bullet-transparent-laser-2.png");
	}
	
	public Projectile(double x, double y, int w, int h, String imgpath) {
		setxCoord(x);
		setyCoord(y);
		setWidth(w);
		setHeight(h);
		setImg(imgpath);
	}
	
	public void setImg(String imgpath) {
		this.img = Toolkit.getDefaultToolkit().getImage(imgpath);
	}
	
	public Image getImg() {
		return img;
	}

	public double getxCoord() {
		return this.xCoord;
	}
	
	public double getyCoord() {
		return this.yCoord;
	}

	public void setxCoord(double d) {
		this.xCoord = d;
	}
	
	public void setyCoord(double y) {
		this.yCoord = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int w) {
		this.width = w;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int h) {
		this.height = h;
	}

}

