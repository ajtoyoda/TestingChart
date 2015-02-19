package org.jfree.data.test;

import junit.framework.TestCase;

import org.jfree.data.Range;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RangeCombineTest extends TestCase {
	@Before
	public void setUp() {
		//no universal setup is needed as each test case needs its own new Range
	}

	@After
	public void tearDown() {
		exampleRange = null;
		exampleRange2 = null;
	}

	public void testBothNull(){
		assertTrue(Range.combine(null, null)==null);
	}
	public void testFirstNull(){
		exampleRange = new Range(1,1);
		assertEquals(Range.combine(null, exampleRange), exampleRange);
	}
	
	public void testSecondNull(){
		exampleRange = new Range(1,1);
		assertEquals(Range.combine(exampleRange, null), exampleRange);
	}
	
	public void testFirstRangeHigherThanSecond(){
		exampleRange= new Range(1,2);
		exampleRange2 = new Range(2,3);
		assertEquals(Range.combine(exampleRange, exampleRange2),new Range(1,3));
	}
	public void testSecondRangeHigherThanFirst(){
		exampleRange= new Range(1,2);
		exampleRange2 = new Range(2,3);
		assertEquals(Range.combine(exampleRange2, exampleRange),new Range(1,3));
	}
	public void testCombineSameRange(){
		exampleRange = new Range(1,2);
		assertEquals(Range.combine(exampleRange, exampleRange), exampleRange);
	}
	public void testGapInRange(){
		exampleRange = new Range(1,2);
		exampleRange2 = new Range(3,4);
		assertEquals(Range.combine(exampleRange, exampleRange2), new Range(1,4));
	}
	private Range exampleRange, exampleRange2;

}

