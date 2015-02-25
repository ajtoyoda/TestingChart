package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RangeContainsTest {
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
	public void testContainsLengthZeroRange(){
		range = new Range(0,0);
		assertTrue(range.contains(0));
	}
	@Test
	public void testContainsPositiveUpperBoundRange(){
		range = new Range(1,5);
		assertTrue(range.contains(5));
	}
	@Test
	public void testContainsPositiveLowerBoundRange(){
		range = new Range(1,5);
		assertTrue(range.contains(1));
	}
	@Test
	public void testContainsPositiveInsideRange(){
		range = new Range(1,5);
		assertTrue(range.contains(3));
	}
	@Test
	public void testContainsNegativeUpperBoundRange(){
		range = new Range(-5,-1);
		assertTrue(range.contains(-1));
	}
	@Test
	public void testContainsNegativeLowerBoundRange(){
		range = new Range(-5,-1);
		assertTrue(range.contains(-5));
	}
	@Test
	public void testContainsNegativeInsideRange(){
		range = new Range(-5,-1);
		assertTrue(range.contains(-3));
	}
	private Range range;
}
