/**
 * PegArray.java
 *
 * @author Ángel Igareta (angel@igareta.com)
 * @version 1.0
 * @since 03-03-2018
 */
package es.esit.ull.daa.towerofhanoi.peg;

import java.util.ArrayList;

import es.esit.ull.daa.towerofhanoi.peg.disk.Disk;

/**
 * [DESCRIPTION]
 */
public class ArrayTypePeg extends Peg {
		
	public ArrayTypePeg() { 
		super(new ArrayList<Disk>());
	}

	public ArrayTypePeg(int numberOfDisks) {
		super(new ArrayList<Disk>(), numberOfDisks);
	}
	
	@Override
	public Disk pop() {
		Disk disk = peg.get(0);
		peg.remove(0);
		
		return disk;
	}

	@Override
	public void push(Disk disk) {
		peg.add(0, disk);		
	}

	@Override
	public boolean isEmpty() {
		return peg.isEmpty();
	}
	
}
