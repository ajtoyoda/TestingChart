package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/***
 * Perform blackbox testing on Range.getUpperBound()
 * @author Taylor
 *
 */
public class RangeGetUpperBound {
	@Before
	public void setUp() {
		//No setup is necessary as new range is needed for each test
	}

	@After
	public void tearDown() {
		//Reset to known state for safety
		range = null;
	}

	//Tests postive upper bound
	@Test
	public void testGetUpperBoundRegularUpperBound() {
		range = new Range(-1,1);
		assertEquals(1, range.getUpperBound(), 0.00001d);
	}
	
	//Test upper bound of 0 and identical upper and lower upper bound
	@Test
	public void testGetUpperBoundZeroUpperBound() {
		range = new Range(0,0);
		assertEquals(0, range.getUpperBound(), 0.00001d);
	}
	
	//Test arbitrarily large upper bound
	@Test
	public void testGetUpperBoundLargeUpperBound() {
		range = new Range(9999999, 999999999);
		assertEquals(999999999, range.getUpperBound(), 0.000001d);
	}
	
	//Test negative upper bound
	@Test
	public void testGetUpperBoundNegativeUpperBound(){
		range = new Range(-5,-1);
		assertEquals(-1, range.getUpperBound(), 0.000001d);
	}
	private Range range;
}
