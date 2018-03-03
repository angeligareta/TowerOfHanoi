package es.esit.ull.daa.towerofhanoi.peg;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import es.esit.ull.daa.towerofhanoi.peg.disk.Disk;

public class JTestPegTypes {
	
	private ArrayTypePeg pegArray;
	private StackTypePeg pegStack;

	@Before
	public void setUp() throws Exception {
		pegArray = new ArrayTypePeg();
		pegStack = new StackTypePeg();
		pegArray.initializePeg(3);
		pegStack.initializePeg(3);
	}

	@Test
	public void testPushPopArray() {
		assertEquals(1, pegArray.pop().getNumber());
		assertEquals(2, pegArray.pop().getNumber());
		assertEquals(3, pegArray.pop().getNumber());
		
		pegArray.push(new Disk(4));
		pegArray.push(new Disk(3));
		pegArray.push(new Disk(2));
		
		assertEquals(2, pegArray.pop().getNumber());
		assertEquals(3, pegArray.pop().getNumber());
		assertEquals(4, pegArray.pop().getNumber());
		
		assert(pegArray.isEmpty());
	}
	
	@Test
	public void testPushPopStack() {
		assertEquals(1, pegStack.pop().getNumber());
		assertEquals(2, pegStack.pop().getNumber());
		assertEquals(3, pegStack.pop().getNumber());
		
		pegStack.push(new Disk(4));
		pegStack.push(new Disk(3));
		pegStack.push(new Disk(2));
		
		assertEquals(2, pegStack.pop().getNumber());
		assertEquals(3, pegStack.pop().getNumber());
		assertEquals(4, pegStack.pop().getNumber());
		
		assert(pegStack.isEmpty());
	}

	@Test
	public void testIsEmpty() {
		ArrayTypePeg pegArray2 = new ArrayTypePeg();
		assert(pegArray2.isEmpty());
		
		StackTypePeg pegStack2 = new StackTypePeg();
		assert(pegStack2.isEmpty());
	}

}
