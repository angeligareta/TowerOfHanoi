/**
 * BenchmarkTowerOfHanoi.java
 *
 * @author Ángel Igareta (angel@igareta.com)
 * @version 1.0
 * @since 04-03-2018
 */
package es.esit.ull.daa.towerofhanoi;

/**
 * Benchmark for the Tower of Hanoi.
 */
public class BenchmarkTowerOfHanoi {

	/** towerOfHanoi */
	public static TowerOfHanoi towerOfHanoi;

	/**
	 * Tests tower of Hanoi with a custom number of disks and structure type.
	 * 
	 * @param numberOfDisks
	 * @param structureType
	 * @return
	 * @throws Exception
	 */
	public static long testHanoiWith(int numberOfDisks, boolean structureType) throws Exception {
		towerOfHanoi = new TowerOfHanoi(numberOfDisks, false, structureType);

		long startTime = System.nanoTime();
		towerOfHanoi.start();
		long endTime = System.nanoTime();

		return (endTime - startTime);
	}

	/**
	 * The first argument is the number of tests and the second is the maximum
	 * number of disks.
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		if (args.length != 2) {
			System.out.println("You must enter 2 arguments, the number of tests" + "and the maximum number of disks.");
		}
		else {
			System.out.println("\t\t\t\t** BENCHMARKS ** ");
			System.out.println("DISKS\t\t| Movements \t\t | Array Time \t\t | Stack Time \t\t | ");
			int numberOfTests = Integer.parseInt(args[0]);
			int maxNumberOfDisks = Integer.parseInt(args[1]);

			for (int i = 1; i <= maxNumberOfDisks; ++i) {
				long elapsedTimeWithArray = 0;
				long elapsedTimeWithStack = 0;

				for (int j = 1; j <= numberOfTests; j++) {
					elapsedTimeWithArray += testHanoiWith(i, false);
					elapsedTimeWithStack += testHanoiWith(i, true);
				}

				elapsedTimeWithArray /= numberOfTests;
				elapsedTimeWithStack /= numberOfTests;

				System.out.println(i + "\t\t| " + towerOfHanoi.getNumberOfMovements() + "\t\t| "
						+ elapsedTimeWithArray / 1000000000.0 + "\t\t| " + elapsedTimeWithStack / 1000000000.0 + "\t\t|");
			}
		}
	}
}
