package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RangeGetUpperBound {
	@Before
	public void setUp() {
		//
	}

	@After
	public void tearDown() {
		range = null;
	}

	@Test
	public void testGetUpperBound1() {
		range = new Range(-1,1);
		assertEquals(1, range.getUpperBound(), 0.00001d);
	}
	@Test
	public void testGetUpperBound2() {
		range = new Range(0,0);
		assertEquals(0, range.getUpperBound(), 0.00001d);
	}
	@Test
	public void testGetUpperBound3() {
		range = new Range(9999999, 999999999);
		assertEquals(999999999, range.getUpperBound(), 0.00001d);
	}
	
	private Range range;
}
