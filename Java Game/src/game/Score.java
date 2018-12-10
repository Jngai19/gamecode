package game;

import java.awt.Image;
import java.awt.Toolkit;

public class Score {

	private int xCoord;
	private int yCoord;
	private int width;
	private int height;
	private Image img;
	
	public Score() {
		setxCoord(837);
		setyCoord(22);
		setWidth(30);
		setHeight(30);
		setImg("files/images.jpeg");
	}
	
	public Score(int x, int y, int w, int h, String imgpath) {
		System.out.println("***");
		setxCoord(x);
		setyCoord(y);
		setWidth(w);
		setHeight(h);
		setImg(imgpath);
	}
	
	public void updateScore(int killed) {
		if (killed == 0) {
			setImg("files/Zerooo.jpg");
		} else if (killed == 1){
			setImg("files/One.jpg"); 
		} else if (killed == 2) {
			setImg("files/TWO.png");
		} else if (killed == 3) {
			setImg("files/rijGx57ET.jpg");
		} else if (killed == 4) {
			setImg("files/AcbK4onKi.jpg");
		} else if (killed == 5) {
			setImg("files/Five.png");
		} else if (killed == 6) {
			setImg("files/SIX.png");
		} else if (killed == 7) {
			setImg("files/SEVEN.png");
		} else if (killed == 8) {
			setImg("files/EIGHT.png");
		} else if (killed == 9) {
			setImg("files/NINE.png");
		} else if (killed == 10) {
			setImg("files/TEN.jpg"); 
			}
		}
		
	public void setImg(String imgpath) {
		this.img = Toolkit.getDefaultToolkit().getImage(imgpath);
	}
	
	public Image getImg() {
		return img;
	}

	public int getxCoord() {
		return this.xCoord;
	}
	
	public int getyCoord() {
		return this.yCoord;
	}

	public void setxCoord(int x) {
		this.xCoord = x;
	}
	
	public void setyCoord(int y) {
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
