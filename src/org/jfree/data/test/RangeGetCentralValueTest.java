package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RangeGetCentralValueTest {
	@Before
	public void setUp() {
		//No set up is necessary because each test case needs a new range
	}

	@After
	public void tearDown() {
		//Ensure it is reset for safety
		range = null;
	}

	@Test
	public void testCentralValueEvenLengthRange(){
		range = new Range(0,4);
		assertEquals(range.getCentralValue(), 2, 0.00001d);
	}
	@Test
	public void testCentralValueOddLengthRange(){
		range = new Range(0,5);
		assertEquals(range.getCentralValue(), 2.5, 0.00001d);
	}
	@Test
	public void testCentralValueLengthZeroRange(){
		range = new Range(1,1);
		assertEquals(range.getCentralValue(), 1, 0.00001d);
	}
	@Test
	public void testCentralValueSpansZeroRange(){
		range = new Range(-1,1);
		assertEquals(range.getCentralValue(), 0, 0.00001d);
	}
	@Test
	public void testCentralValueNegativeRange(){
		range = new Range(-5,-4);
		assertEquals(range.getCentralValue(), -4.5, 0.00001d);
	}
	private Range range;
}
