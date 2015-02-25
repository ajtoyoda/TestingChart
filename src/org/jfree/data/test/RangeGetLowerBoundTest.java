package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/***
 * Perform blackbox testing on Range.getLowerBound()
 * @author Taylor
 *
 */
public class RangeGetLowerBoundTest {

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
	public void testGetLowerBoundNegativeLowerBound() {
		range = new Range(-1,1);
		assertEquals(-1, range.getLowerBound(), 0.00001d);
	}
	@Test
	public void testGetLowerBoundLowerBoundIsUpperBound() {
		range = new Range(0,0);
		assertEquals(0, range.getLowerBound(), 0.00001d);
	}
	@Test
	public void testGetLowerBoundLargeLowerBound() {
		range = new Range(9999999, 999999999);
		assertEquals(9999999, range.getLowerBound(), 0.00001d);
	}

	@Test 
	public void testGetLowerBoundPositiveLowerBound(){
		range = new Range(2,5);
		assertEquals(2,range.getLowerBound(), 0.00001d);
	}
	private Range range;
}
