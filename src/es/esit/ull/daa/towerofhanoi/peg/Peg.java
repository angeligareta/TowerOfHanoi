/**
 * Peg.java
 *
 * @author Ángel Igareta (angel@igareta.com)
 * @version 1.0
 * @since 03-03-2018
 */
package es.esit.ull.daa.towerofhanoi.peg;

import java.util.AbstractList;

import es.esit.ull.daa.towerofhanoi.peg.disk.Disk;

/**
 * [DESCRIPTION]
 */
public abstract class Peg {
	
	protected AbstractList<Disk> peg; 
	
	public Peg(AbstractList<Disk> peg) { 
		this.peg = peg; 
	}
	
	public Peg(AbstractList<Disk> peg, int numberOfDisks) {
		this.peg = peg;
		
		while (numberOfDisks > 0 ) {
			this.push(new Disk(numberOfDisks--));
		}
	}
	
	public abstract Disk pop();
	
	public abstract void push(Disk disk);
	
	public abstract boolean isEmpty();
}
