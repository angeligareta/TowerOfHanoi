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
 * [DESCRIPTION]
 */
public class Disk {
	private int width;
	private int height;
	private int number;
	private Color color;

	public Disk(int number) {
		this.number = number;
	}

	public Disk(int number, int width, int height) {
		this.number = number;
		this.width = width;
		this.height = height;

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

	/**
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}

	public int getNumber() {
		return this.number;
	}

	public void draw(Graphics g, int x, int y) {
		g.setColor(this.color);
		g.fillRoundRect(x, y, this.width, this.height, this.height / 3, this.height / 3);

		g.setColor(Color.BLACK);
	}
}
