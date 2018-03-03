/**
 * StartTowerOfHanoi.java
 *
 * @author Ángel Igareta (angel@igareta.com)
 * @version 1.0
 * @since 03-03-2018
 */
package es.esit.ull.daa.towerofhanoi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Semaphore;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * Class that starts the tower of Hanoi depending on the number of disks
 * recieved. Besides it handle the graphic UI.
 */
public class StartTowerOfHanoi extends Thread {

	/** playBoard */
	private static JFrame playBoard;
	/** towerBoard */
	private static JFrame towerBoard;
	/** playButton */
	private static JButton playButton;
	/** towerOfHanoi */
	private static TowerOfHanoi towerOfHanoi;
	/** semaphore for preventing 2 threads to run at the same time. */
	private final static Semaphore semaphore = new Semaphore(1);

	/** Shows the Play Board. */
	private static void showPlayBoard() {
		playBoard = new JFrame("Play Towers of Hanoi - Ángel Igareta");
		playBoard.setSize(200, 200);
		playBoard.setVisible(true);
		playBoard.setLocationRelativeTo(null);
		playBoard.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		playButton = new JButton("Play!");
		playBoard.add(playButton);
	}

	/** Shows the Tower Board. */
	private static void showTowerBoard() {
		towerBoard = new JFrame("Towers of Hanoi - Ángel Igareta");
		towerBoard.add(towerOfHanoi);

		towerBoard.setSize(TowerOfHanoi.panelWidth, TowerOfHanoi.panelHeight);
		towerBoard.setVisible(true);
		towerBoard.setLocationRelativeTo(null);
		towerBoard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Thread#run()
	 */
	public void run() {
		try {
			semaphore.acquire();
		}
		catch (InterruptedException e1) {
			e1.printStackTrace();
		}

		playButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				playBoard.dispose();
				semaphore.release();

				try {
					Thread.currentThread().join();
				}
				catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
	}

	/** Shows the Help. */
	private static void showHelp() {
		System.out.println("Tower of Hanoi must recieve 1 or 2 parameters:");
		System.out.println("\tThe first one is the number of disks.");
		System.out.println("\tThe second one is the debug mode. (optional)");
	}

	/**
	 * Starts the Tower of Hanoi depending on the argument recieved.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		if ((args.length > 2) || (args.length < 1)) {
			showHelp();
		}
		else {
			boolean debug = false;
			int numberOfDisks;

			if ((args.length == 2) && (args[1].equals("1"))) {
				debug = true;
			}

			try {
				numberOfDisks = Integer.parseInt(args[0]);
				towerOfHanoi = new TowerOfHanoi(numberOfDisks, debug);

				if (debug) {
					showPlayBoard();
					Thread buttonWaiterThread = new StartTowerOfHanoi();
					buttonWaiterThread.start();

					Thread.sleep(2000);
					semaphore.acquire();
					showTowerBoard();
				}

				long startTime = System.currentTimeMillis();
				towerOfHanoi.start();
				long endTime = System.currentTimeMillis();

				System.out.println("Total Number of Movements: " + towerOfHanoi.getNumberOfMovements());
				System.out.println("Total execution time: " + (endTime - startTime) + "ms");
			}
			catch (NumberFormatException e) {
				System.out.println("The first argument is invalid " + e.getMessage());
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
