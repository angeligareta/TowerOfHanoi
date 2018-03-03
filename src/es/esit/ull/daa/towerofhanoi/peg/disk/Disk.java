/**
 * Disk.java
 *
 * @author Ángel Igareta (angel@igareta.com)
 * @version 1.0
 * @since 03-03-2018
 */
package es.esit.ull.daa.towerofhanoi.peg.disk;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

/**
 * Disk Class that represent a disk of the Tower of Hanoi. Every disk has it's 
 * own color.
 */
public class Disk {
	
	/** Width of the Disk. */
	private int width;
	/** Height of the Disk. */
	private int height;
	/** Number of the Disk. */
	private int number;
	/** Unique color of the Disk. */
	private Color color;

	/**
	 * Default constructor. Only receives the number of the disk.
	 * @param number Number of the disk.
	 */
	public Disk(int number) {
		this.number = number;
	}

	/**
	 * Constructor that receives the number of the disk, it's width and height and
	 * sets an unique color for the disk.
	 * @param number Number of the disk.
	 * @param width Width of the disk.
	 * @param height Height of the disk.
	 */
	public Disk(int number, int width, int height) {
		this.number = number;
		this.width = width;
		this.height = height;
		initializeColor();		
	}
	
	/**
	 * @return the width.
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @return the height.
	 */
	public int getHeight() {
		return height;
	}
	
	/**
	 * @return the disk number.
	 */
	public int getNumber() {
		return this.number;
	}

	/**
	 * Draws the disk in the graphics that receives by argument. 
	 * @param g Graphics where the disk will be draw.
	 * @param x Position x to draw.
	 * @param y Position y to draw.
	 */
	public void draw(Graphics g, int x, int y) {
		g.setColor(this.color);
		g.fillRoundRect(x, y, this.width, this.height, this.height / 3, this.height / 3);
		g.setColor(Color.BLACK);
		
		g.drawString(String.valueOf(this.getNumber()), x + (this.width / 2) - 3, y + (this.height / 2));
	}

	/**
	 * Initializes the method color to a default one or random.
	 */
	private void initializeColor() {
		switch (number) {
		case 1:
			this.color = Color.cyan;
			break;
		case 2:
			this.color = Color.gray;
			break;
		case 3:
			this.color = Color.orange;
			break;
		case 4:
			this.color = Color.darkGray;
			break;
		case 5:
			this.color = Color.pink;
			break;
		default:
			Random rand = new Random();
			this.color = new Color(rand.nextFloat(), rand.nextFloat(), rand.nextFloat());
		}		
	}	
}
