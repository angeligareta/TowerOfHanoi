/**
 * Peg.java
 *
 * @author Ángel Igareta (angel@igareta.com)
 * @version 1.0
 * @since 03-03-2018
 */
package es.esit.ull.daa.towerofhanoi.peg;

import java.awt.Graphics;
import java.util.AbstractList;

import es.esit.ull.daa.towerofhanoi.peg.disk.Disk;

/**
 * [DESCRIPTION]
 */
public abstract class Peg {
	
	public final static int width = 250;
	public final static int height = 400;
	
	protected AbstractList<Disk> peg; 
	private char pegID;
	
	public Peg(AbstractList<Disk> peg) { 
		this.peg = peg;
		this.pegID = 'X';
	}
	
	public Peg(AbstractList<Disk> peg, char pegID) { 
		this.peg = peg;
		this.pegID = pegID;
	}
	
	public abstract void initializePeg(int numberOfDisks);
	
	public abstract void draw(Graphics g, int x, int y);
	
	public abstract Disk pop();
	
	public abstract void push(Disk disk);
	
	public abstract boolean isEmpty();

	public char getID() {
		return pegID;
	}
}
