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
 * [DESCRIPTION]
 */
public class StackTypePeg extends Peg {
	
	public StackTypePeg() { 
		super(new Stack<Disk>()); 
	}
	
	public StackTypePeg(char pegID) {
		super(new Stack<Disk>(), pegID);
	}

	@Override
	public Disk pop() {
		return ((Stack<Disk>) peg).pop();
	}

	@Override
	public void push(Disk disk) {
		((Stack<Disk>) peg).push(disk);		
	}

	@Override
	public boolean isEmpty() {
		return ((Stack<Disk>) peg).empty();
	}

	@Override
	public void draw(Graphics g, int x, int y) {
		;		
	}

	@Override
	public void initializePeg(int numberOfDisks) {
		while (numberOfDisks > 0 ) {
			this.push(new Disk(numberOfDisks--));
		}		
	}

}
