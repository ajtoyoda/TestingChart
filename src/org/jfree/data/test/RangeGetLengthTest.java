package org.jfree.data.test;

import org.junit.*;

import junit.framework.TestCase;

import org.jfree.data.Range;

/***
 * Perform BlackBox testing of Range.getLength() method.
 * The methods do not have comments because the names are descriptive enough
 * @author jamie
 *
 */
public class RangeGetLengthTest extends TestCase {
	@Before
	public void setUp() {
		//no universal setup is needed as each test case needs its own new Range
	}

	@After
	public void tearDown() {
		exampleRange = null;
	}

	
	@Test
	public void getLengthTestRangeOfLengthZero() {
		exampleRange = new Range(0, 0);
		assertEquals("The length of 0,0 should be 0", exampleRange.getLength(),
				0);
	}

	@Test
	public void testGetLengthRangeOfLargeLength() {
		exampleRange = new Range(0, 999999);
		assertEquals("The length of 0,999999 should be 999999",
				999999, exampleRange.getLength(), 0.000001d);
	}
	@Test
	public void testGetLengthRangeThatGoesOverZero(){
		exampleRange = new Range(-1,1);
		assertEquals("The length of -1,1 should be 2",  2, exampleRange.getLength(), 0.000001d);
	}
	@Test
	public void testGetLengthRangeThatHasZeroAsLowerBound(){
		exampleRange = new Range(0,10);
		assertEquals("The length of 0,10 should be 10", 10, exampleRange.getLength(), 0.000001d);
	}

	private Range exampleRange;

}
