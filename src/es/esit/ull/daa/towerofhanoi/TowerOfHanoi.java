/**
 * TowerOfHanoi.java
 *
 * @author Ángel Igareta (angel@igareta.com)
 * @version 1.0
 * @since 03-03-2018
 */
package es.esit.ull.daa.towerofhanoi;

import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;

import es.esit.ull.daa.towerofhanoi.peg.*;

/**
 * Class that represents the TowerOfHanoi or Tower of Brahma mathematical
 * puzzle. It consists of three pegs and a number of disks of different sizes,
 * which can move into any pegs. The puzzle starts with the disks in a stack in
 * ascending order of size on one peg, the smallest at the top.
 * 
 * The rules of the puzzle are:
 * <ol>
 * <li>Only one disk can be moved at a time.</li>
 * <li>Each move consists of taking the upper disk from one of the stacks and
 * placing it on top of another stack.</li>
 * <li>No disk may be placed on top of a smaller disk.</li>
 * </ol>
 */
public class TowerOfHanoi extends JPanel {

	/** Version ID of the JPanel. */
	private static final long serialVersionUID = -6549304631560885935L;
	/** source Peg. */
	private Peg sourcePeg;
	/** Auxiliary Peg. */
	private Peg auxiliaryPeg;
	/** Destination Peg. */
	private Peg destinationPeg;

	/** Integer that represents the number of disks. */
	private int numberOfDisks;
	/** Integer that represents the number of movements made in the tower. */
	private int numberOfMovements;
	/** Boolean that represents if the graphic mode is active. */
	private boolean debug;

	/** Integer that represents the margin between disks. */
	private final static int marginBetweenPeg = 100;
	/** Integer that represents the width of the Tower Board. */
	public final static int panelWidth = (4 * marginBetweenPeg) + (3 * Peg.width);
	/** Integer that represents the number of disks. */
	public final static int panelHeight = 700;

	/**
	 * Constructor of the Tower Of Hanoi. If the graphic mode is enabled it uses an
	 * Array Disk Set, if not it uses a Stack Disk Set in order to improve
	 * efficiency.
	 * 
	 * @param numberOfDisks
	 *          Integer that represents the number of disks.
	 * @param debug
	 *          Boolean that represents if the graphic mode is active.
	 * @param structureType
	 *          Boolean that represent what structure to use (Array if false or
	 *          Stack if true).
	 * @throws Exception
	 */
	public TowerOfHanoi(int numberOfDisks, boolean debug, boolean structureType) throws Exception {
		this.numberOfDisks = numberOfDisks;
		this.debug = debug;

		if (numberOfDisks < 1) {
			throw new Exception("Error: Number of disks must be greater than 0.");
		}

		if (debug || !structureType) {
			sourcePeg = new ArrayTypePeg('A');
			auxiliaryPeg = new ArrayTypePeg('B');
			destinationPeg = new ArrayTypePeg('C');
		}
		else {
			sourcePeg = new StackTypePeg('A');
			auxiliaryPeg = new StackTypePeg('B');
			destinationPeg = new StackTypePeg('C');
		}

		sourcePeg.initializePeg(numberOfDisks);
	}

	/**
	 * Starts to solve the Tower of Hanoi puzzle.
	 * 
	 * @throws InterruptedException
	 */
	public void start() throws InterruptedException {
		if (debug) {
			Thread.sleep(1000);
			this.repaint();
			paintComponent(this.getGraphics());
			Thread.sleep(1500);

			System.out.println(System.lineSeparator() + "\t**MOVEMENTS**");
		}

		moveDisks(this.numberOfDisks, this.sourcePeg, this.auxiliaryPeg, this.destinationPeg);
	}

	/**
	 * @return the numberOfMovements
	 */
	public int getNumberOfMovements() {
		return numberOfMovements;
	}

	/*
	 * (non-Javadoc) If the graphic mode is enabled it shows the 3 pegs and it's
	 * components.
	 * 
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		sourcePeg.draw(g, (TowerOfHanoi.panelHeight / 2) - Peg.width, panelHeight - 80);
		auxiliaryPeg.draw(g, (TowerOfHanoi.panelHeight / 2) + TowerOfHanoi.marginBetweenPeg, panelHeight - 80);
		destinationPeg.draw(g, (TowerOfHanoi.panelHeight / 2) + 2 * TowerOfHanoi.marginBetweenPeg + Peg.width,
				panelHeight - 80);

		g.setFont(new Font("Montserrat", Font.PLAIN, 30));
		g.drawString("A", ((TowerOfHanoi.panelHeight / 2) - Peg.width) + Peg.width / 2 - 9, panelHeight - 40);
		g.drawString("B", ((TowerOfHanoi.panelHeight / 2) + TowerOfHanoi.marginBetweenPeg) + Peg.width / 2 - 9,
				panelHeight - 40);
		g.drawString("C",
				((TowerOfHanoi.panelHeight / 2) + 2 * TowerOfHanoi.marginBetweenPeg + Peg.width) + Peg.width / 2 - 9,
				panelHeight - 40);
		g.drawString(String.valueOf(this.numberOfMovements), panelWidth / 2 - 9, 100);
	}

	/**
	 * Tower of Hanoi recursive algorithm. The steps to follow are:
	 * <ol>
	 * <li>Move n-1 disks from source to auxiliary Peg.</li>
	 * <li>Move nth disk from source to destination Peg.</li>
	 * <li>Move n-1 disks from auxiliary Peg to destination Peg.</li>
	 * </ol>
	 * 
	 * @param numberOfDisks
	 * @param sourcePeg
	 * @param auxiliaryPeg
	 * @param destinationPeg
	 * @throws InterruptedException
	 */
	private void moveDisks(int numberOfDisks, Peg sourcePeg, Peg auxiliaryPeg, Peg destinationPeg)
			throws InterruptedException {
		if (numberOfDisks == 1) {
			numberOfMovements++;
			destinationPeg.push(sourcePeg.pop());

			if (debug) {
				paintComponent(this.getGraphics());
				this.getGraphics().drawString(sourcePeg.getID() + " -> " + destinationPeg.getID(), (panelWidth / 2) - 20, 150);
				System.out.println(numberOfMovements + " movement is: " + sourcePeg.getID() + " -> " + destinationPeg.getID());

				this.repaint();
				Thread.sleep(1000);
			}
		}
		else {
			moveDisks(numberOfDisks - 1, sourcePeg, destinationPeg, auxiliaryPeg);

			// moveDisks(1, sourcePeg, auxiliaryPeg, destinationPeg);
			destinationPeg.push(sourcePeg.pop());
			numberOfMovements++;

			moveDisks(numberOfDisks - 1, auxiliaryPeg, sourcePeg, destinationPeg);
		}
	}

}
