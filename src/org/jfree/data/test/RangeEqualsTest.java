package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.Before;
import org.junit.Test;

public class RangeEqualsTest {

	@Before
	public void setUp(){
		range = new Range(0,10);
	}
	@Test
	public void testNotNotARange(){
		boolean testCondition = range.equals(new Object());
		assertFalse(testCondition);
	}
	@Test 
	public void testRangeIsCompletelyDifferent(){
		boolean testCondition = range.equals(new Range(11,12));
		assertFalse(testCondition);
	}
	@Test
	public void testRangeInsideRange(){
		boolean testCondition = range.equals(new Range (5,6));
		assertFalse(testCondition);
	}
	@Test
	public void testRangeLowerBoundSame(){
		boolean testCondition = range.equals(new Range(0,9));
		assertFalse(testCondition);
	}
	@Test
	public void testRangeUpperBoundSame(){
		boolean testCondition = range.equals(new Range(1,10));
		assertFalse(testCondition);
	}
	@Test
	public void testRangeIsEqualButDifferentInstance(){
		boolean testCondition = range.equals(new Range(0,10));
		assertTrue(testCondition);
	}
	@Test
	public void testRangeIsEqualSameInstance(){
		boolean testCondition = range.equals(range);
		assertTrue(testCondition);
	}
	private Range range;
}