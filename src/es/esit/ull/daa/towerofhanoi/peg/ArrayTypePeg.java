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
 * [DESCRIPTION]
 */
public class ArrayTypePeg extends Peg {
		
	public ArrayTypePeg() { 
		super(new ArrayList<Disk>());
	}
	
	public ArrayTypePeg(char pegID) {
		super(new ArrayList<Disk>(), pegID);
	}
	
	public void initializePeg(int numberOfDisks) {
		int totalNumberOfDisks = numberOfDisks;
		
		for (int i = numberOfDisks; i > 0; --i ) {
			this.push(new Disk(numberOfDisks, 
					Peg.width / (totalNumberOfDisks - numberOfDisks + 1),	Peg.height / totalNumberOfDisks));
			numberOfDisks --;
		}
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

	@Override
	public void draw(Graphics g, int x, int y) {
		int minHeight = y;
		int maxHeight = y - Peg.height;
		
		int minWidth = x;
		int maxWidth = x + Peg.width;
		int midWidth = x + (Peg.width / 2);
		
		g.setColor(new Color(139,69,19));
		
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(5));
		g2.drawLine(minWidth, minHeight, maxWidth, minHeight); // Base
		g2.drawLine(midWidth, minHeight, midWidth, maxHeight); // Peg
		g.setColor(Color.BLACK);
		
		for (int i = peg.size(); i > 0; --i ) {
			peg.get(i - 1).draw(g, minWidth + ((Peg.width - peg.get(i - 1).getWidth()) / 2), 
					minHeight - ((peg.size() - i + 1) * peg.get(i - 1).getHeight()));
		}
	}
	
}
