/**
 * PegArray.java
 *
 * @author Ángel Igareta (angel@igareta.com)
 * @version 1.0
 * @since 03-03-2018
 */
package es.esit.ull.daa.towerofhanoi.peg;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import es.esit.ull.daa.towerofhanoi.peg.disk.Disk;

/**
 * Structure Array Type that stores disk objects for the Hanoi Tower.
 */
public class ArrayTypePeg extends Peg {

	/** Default constructor. It gives a type to the Array structure. */
	public ArrayTypePeg() {
		super(new ArrayList<Disk>());
	}

	/**
	 * Constructor that gives a type to the Array structure and assign the char
	 * received by argument to the pagID.
	 * 
	 * @param pegID
	 *          ID of the peg.
	 */
	public ArrayTypePeg(char pegID) {
		super(new ArrayList<Disk>(), pegID);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.esit.ull.daa.towerofhanoi.peg.Peg#initializePeg(int)
	 */
	@Override
	public void initializePeg(int numberOfDisks) {
		int totalNumberOfDisks = numberOfDisks;

		for (int i = numberOfDisks; i > 0; --i) {
			this.push(new Disk(numberOfDisks, Peg.width / (totalNumberOfDisks - numberOfDisks + 1),
					Peg.height / totalNumberOfDisks));
			numberOfDisks--;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.esit.ull.daa.towerofhanoi.peg.Peg#pop()
	 */
	@Override
	public Disk pop() {
		Disk disk = peg.get(peg.size() - 1);
		peg.remove(peg.size() - 1);

		return disk;
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
		peg.add(disk);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.esit.ull.daa.towerofhanoi.peg.Peg#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
		return peg.isEmpty();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.esit.ull.daa.towerofhanoi.peg.Peg#draw(java.awt.Graphics, int, int)
	 */
	@Override
	public void draw(Graphics g, int x, int y) {
		int minHeight = y;
		int maxHeight = y - Peg.height;

		int minWidth = x;
		int maxWidth = x + Peg.width;
		int midWidth = x + (Peg.width / 2);

		g.setColor(new Color(139, 69, 19));

		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(5));
		g2.drawLine(minWidth, minHeight, maxWidth, minHeight); // Base
		g2.drawLine(midWidth, minHeight, midWidth, maxHeight); // Peg
		g.setColor(Color.BLACK);

		for (int i = peg.size(); i > 0; --i) {
			peg.get(i - 1).draw(g, minWidth + ((Peg.width - peg.get(i - 1).getWidth()) / 2),
					minHeight - ((peg.size() - i + 1) * peg.get(i - 1).getHeight()));
		}
	}

}
