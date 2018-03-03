/**
 * PegStack.java
 *
 * @author Ángel Igareta (angel@igareta.com)
 * @version 1.0
 * @since 03-03-2018
 */
package es.esit.ull.daa.towerofhanoi.peg;

import java.awt.Graphics;
import java.util.Stack;

import es.esit.ull.daa.towerofhanoi.peg.disk.Disk;

/**
 * Structure Stack Type that stores disk objects for the Hanoi Tower.
 */
public class StackTypePeg extends Peg {

	/** Default constructor. It gives a type to the Stack structure. */
	public StackTypePeg() {
		super(new Stack<Disk>());
	}

	/**
	 * Constructor that gives a type to the Stack structure and assign the char
	 * received by argument to the pagID.
	 * 
	 * @param pegID
	 *          ID of the peg.
	 */
	public StackTypePeg(char pegID) {
		super(new Stack<Disk>(), pegID);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.esit.ull.daa.towerofhanoi.peg.Peg#pop()
	 */
	@Override
	public Disk pop() {
		return ((Stack<Disk>) peg).pop();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.esit.ull.daa.towerofhanoi.peg.Peg#push(es.esit.ull.daa.towerofhanoi.peg.
	 * disk.Disk)
	 */
	@Override
	public void push(Disk disk) {
		((Stack<Disk>) peg).push(disk);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.esit.ull.daa.towerofhanoi.peg.Peg#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
		return ((Stack<Disk>) peg).empty();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.esit.ull.daa.towerofhanoi.peg.Peg#draw(java.awt.Graphics, int, int)
	 */
	@Override
	public void draw(Graphics g, int x, int y) {
		;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.esit.ull.daa.towerofhanoi.peg.Peg#initializePeg(int)
	 */
	@Override
	public void initializePeg(int numberOfDisks) {
		while (numberOfDisks > 0) {
			this.push(new Disk(numberOfDisks--));
		}
	}
}
