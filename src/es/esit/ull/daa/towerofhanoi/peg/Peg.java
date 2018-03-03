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
 * Abstract Structure Type that stores disk objects for the Hanoi Tower.
 */
public abstract class Peg {

	/** Width of the Peg. */
	public final static int width = 250;
	/** Height of the Peg. */
	public final static int height = 400;
	/** AbstractStructure that store disk objects. */
	protected AbstractList<Disk> peg;
	/** ID of a Peg. */
	private char pegID;

	/**
	 * Default constructor. It gives a type to the Abstract structure.
	 * 
	 * @param peg
	 *          Type of the Structure.
	 */
	public Peg(AbstractList<Disk> peg) {
		this.peg = peg;
		this.pegID = 'X';
	}

	/**
	 * Constructor that gives a type to the Abstract structure and assign the char
	 * received by argument to the pagID.
	 * 
	 * @param peg
	 *          Type of the Structure.
	 * @param pegID
	 *          ID of the disk.
	 */
	public Peg(AbstractList<Disk> peg, char pegID) {
		this.peg = peg;
		this.pegID = pegID;
	}

	/**
	 * @return pegID
	 */
	public char getID() {
		return pegID;
	}

	/**
	 * Introduces numberOfDisks disks in the peg.
	 * 
	 * @param numberOfDisks
	 *          Number of disks to introduce in the peg.
	 */
	public abstract void initializePeg(int numberOfDisks);

	/**
	 * It draws the peg in the (x,y) coordinates received by argument.
	 * 
	 * @param g
	 *          Graphics to draw the Peg in.
	 * @param x
	 *          X Position of the Peg.
	 * @param y
	 *          Y Position of the Peg.
	 */
	public abstract void draw(Graphics g, int x, int y);

	/**
	 * Removes the element on the top of the peg and returns it.
	 * 
	 * @return Element on the top of the peg.
	 */
	public abstract Disk pop();

	/**
	 * Introduces an element on the top of the peg.
	 * 
	 * @param disk
	 *          Element to introduce.
	 */
	public abstract void push(Disk disk);

	/**
	 * Returns true if the peg is empty.
	 * 
	 * @return True if the peg is empty.
	 */
	public abstract boolean isEmpty();
}
