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
 * [DESCRIPTION]
 */
public class TowerOfHanoi extends JPanel {
	
	private Peg originPeg;
	private Peg auxiliarPeg;
	private Peg destinationPeg;
	
	private int numberOfDisks;
	private int numberOfMovements;
	private boolean debug;
	
	public final static int marginBetweenPeg = 100;
	public final static int panelWidth = (4 * marginBetweenPeg) + (3 * Peg.width);
	public final static int panelHeight = 700;

	public TowerOfHanoi(int numberOfDisks, boolean debug){
		this.numberOfDisks = numberOfDisks;
		this.debug = debug;
		
		if (debug) {
			originPeg = new ArrayTypePeg('A');
			auxiliarPeg = new ArrayTypePeg('B');
			destinationPeg = new ArrayTypePeg('C');			
		}
		else {
			originPeg = new StackTypePeg('A');
			auxiliarPeg = new StackTypePeg('B');
			destinationPeg = new StackTypePeg('C');			
		}
		
		originPeg.initializePeg(numberOfDisks);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);		
		
		originPeg.draw(g, (TowerOfHanoi.panelHeight / 2) - Peg.width, panelHeight - 80);
		auxiliarPeg.draw(g, (TowerOfHanoi.panelHeight / 2) + TowerOfHanoi.marginBetweenPeg, 
				panelHeight - 80);
		destinationPeg.draw(g, (TowerOfHanoi.panelHeight / 2) + 2*TowerOfHanoi.marginBetweenPeg + Peg.width,
				panelHeight - 80);
		
		g.setFont(new Font("Montserrat", Font.PLAIN, 30)); 
		g.drawString("A", ((TowerOfHanoi.panelHeight / 2) - Peg.width) + Peg.width / 2 - 9, panelHeight - 40);
		g.drawString("B", ((TowerOfHanoi.panelHeight / 2) + TowerOfHanoi.marginBetweenPeg)  + Peg.width / 2 - 9, 
				panelHeight - 40);
		g.drawString("C", ((TowerOfHanoi.panelHeight / 2) + 2*TowerOfHanoi.marginBetweenPeg + Peg.width) 
				+ Peg.width / 2 - 9, panelHeight - 40);
		g.drawString(String.valueOf(this.numberOfMovements), panelWidth / 2 - 9, 100);
	}

	public void start() throws InterruptedException {
		if (debug) {
			Thread.sleep(1000);
			this.repaint();
			paintComponent(this.getGraphics());
			Thread.sleep(1500);			
		}
		
		moveDisks(this.numberOfDisks, this.originPeg, this.auxiliarPeg, this.destinationPeg);
		System.out.println("Total Number of Movements: " + numberOfMovements);
	}
	
	private void moveDisks(int numberOfDisks, Peg originPeg, Peg auxiliarPeg, Peg destinationPeg) throws InterruptedException {
		if (numberOfDisks == 1) {
			numberOfMovements ++;			
			destinationPeg.push(originPeg.pop());
			
			if (debug) {
				paintComponent(this.getGraphics());
				this.getGraphics().drawString(originPeg.getID() + " -> " + destinationPeg.getID(),
						(panelWidth / 2) - 20, 150);
				System.out.println(numberOfMovements + " movement is: " + originPeg.getID() 
				+ " -> " + destinationPeg.getID());
				
				this.repaint();
				Thread.sleep(1000);
			}
		}
		else {
			moveDisks(numberOfDisks - 1, originPeg, destinationPeg, auxiliarPeg);
			moveDisks(1, originPeg, auxiliarPeg, destinationPeg);
			moveDisks(numberOfDisks - 1, auxiliarPeg, originPeg, destinationPeg);			
		}
	}

}
