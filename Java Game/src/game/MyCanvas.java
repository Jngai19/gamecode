package game;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.Random;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;


public class MyCanvas extends Canvas implements KeyListener, MouseListener {

	public static int killed = 0;
	public static double x;
	public static double y;
	Background back = new Background(0,0,967,758,"files/BACKGROUND.jpg");
	Goodguy link = new Goodguy(10,10,50,50,"files/GoodImage.png");
	LinkedList badguys = new LinkedList();
	Score score = new Score(827,36,50,50, "files/Zerooo.jpg");
	
	LinkedList knives = new LinkedList();
	
	public MyCanvas() {
		this.setSize(967,758); // set same size as MyScreen
		this.addKeyListener(this); // add the listener to your canvas
		this.addMouseListener(this); // add the listener to your canvas

		
		Random rand = new Random();
		for(int i = 0; i<10; i++) {
			Badguy bg = new Badguy(rand.nextInt(this.getWidth()),rand.nextInt(this.getHeight()) ,50,50,"files/NewBadguy.png");
			badguys.add(bg);
		}
		
		this.setBackground(Color.WHITE);
	}
	
	@Override
	public void paint(Graphics g) {
		g.drawImage(back.getImg(), 0, 0, 967, 758, this); // draw good guy
		g.drawImage(link.getImg(), link.getxCoord(), link.getyCoord(), link.getWidth(), link.getHeight(), this); // draw good guy
		g.drawImage(score.getImg(), score.getxCoord(), score.getyCoord(), score.getWidth(), score.getHeight(), this);

		for(int i = 0; i < badguys.size(); i++) {// draw bad guys
			Badguy bg = (Badguy) badguys.get(i);
			g.drawImage(bg.getImg(), bg.getxCoord(), bg.getyCoord(), bg.getWidth(), bg.getHeight(), this); 
			Rectangle r = new Rectangle(bg.getxCoord(),bg.getyCoord(),bg.getWidth(),bg.getHeight());
			
			for(int j = 0; j < knives.size(); j++) {
				Projectile k = (Projectile) knives.get(j);
				if (k.getxCoord() > this.getWidth()) { knives.remove(k); }
				//k.setxCoord(k.getxCoord() + 1);
				double run = x - link.getxCoord();
				double rise = y - link.getyCoord();
				link.changeDirection(x, link.getxCoord());
				if (x > link.getxCoord()) {
					k.setxCoord(k.getxCoord() + 1);
					k.setyCoord(k.getyCoord() + (rise/run));
				} else {
					k.setxCoord(k.getxCoord() - 1);
					k.setyCoord(k.getyCoord() - (rise/run));
				}
				g.drawImage(k.getImg(), (int) k.getxCoord(), (int) k.getyCoord(), k.getWidth(), k.getHeight(), this); 
				
				
				
				Rectangle kr = new Rectangle( (int) k.getxCoord(), (int) k.getyCoord(),k.getWidth(),k.getHeight());
				if (kr.intersects(r)) {
					badguys.remove(i);
					knives.remove(j);
					killed = killed + 1;
					System.out.println(killed);
					score.updateScore(killed);
				}
				repaint();
			}
		}
	}

	private void setImg(String string) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		System.out.println(e);
		if (e.getKeyCode() == 32) {
			Projectile knife = new Projectile(link.getxCoord(),link.getyCoord(),30,30,"files/bullet-transparent-laser-2.png");
			knives.add(knife);
		}
		link.moveIt(e.getKeyCode(),this.getWidth(),this.getHeight());
		for(int i = 0; i < badguys.size(); i++) { 
			Badguy bg = (Badguy) badguys.get(i); 
			Rectangle ggr = new Rectangle(link.getxCoord(),link.getyCoord(),link.getWidth(),link.getHeight());
			Rectangle r = new Rectangle(bg.getxCoord(),bg.getyCoord(),bg.getWidth(),bg.getHeight());
			if (ggr.intersects(r)) { 
				badguys.remove(i);
			}
		}
		repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		//System.out.println(e);
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		//System.out.println(e);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println(e);
		x = e.getX();
		y = e.getY();
		Projectile knife = new Projectile(link.getxCoord(),link.getyCoord(),30,30,"files/bullet-transparent-laser-2.png");
		knives.add(knife);
		repaint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
	
	
