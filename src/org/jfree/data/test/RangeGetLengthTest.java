package org.jfree.data.test;

import org.junit.*;

import junit.framework.TestCase;

import org.jfree.data.Range;

public class RangeGetLengthTest extends TestCase {
	@Before
	public void setUp() {
		//
	}

	@After
	public void tearDown() {
		exampleRange = null;
	}

	@Test
	public void getLengthTest1() {
		exampleRange = new Range(0, 0);
		assertEquals("The length of 0,0 should be 0", exampleRange.getLength(),
				0);
	}

	@Test
	public void testGetLength2() {
		exampleRange = new Range(0, 999999);
		assertEquals("The length of 0,999999 should be 999999",
				exampleRange.getLength(), 999999, 0.000001d);
	}
	@Test
	public void testGetLength3(){
		exampleRange = new Range(-1,1);
		assertEquals("The length of -1,1 should be 2",  exampleRange.getLength(), 2, 0.000001d);
	}
	@Test
	public void testGetLength4(){
		exampleRange = new Range(0,10);
		assertEquals("The length of 0,10 should be 10", exampleRange.getLength(), 10, 0.000001d);
	}

	private Range exampleRange;

}
