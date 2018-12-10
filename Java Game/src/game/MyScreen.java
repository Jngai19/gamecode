package game;

import java.awt.Rectangle;

import javax.swing.JFrame;
public class MyScreen extends JFrame {
/**
 * MyScreen basic window for game, inherits properties and methods from JFrame
 * @author Jojo.Ngai
 * @since Sept. 27, 2018
 */
	
	/**
	 *  MyScreen default constructor
	 *  @param none, default constructor
	 */
	public MyScreen() {
		// this is current instance, setters are mutator methods which change properties
		this.setSize(967,758);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	// main method is required to run the program
	public static void main(String[] args) {
		// instantiate an individual instance of MyScreen by calling on constructor
		MyScreen screen = new MyScreen();
		MyCanvas canvas = new MyCanvas();
		screen.getContentPane().add(canvas);
		
	}

}
