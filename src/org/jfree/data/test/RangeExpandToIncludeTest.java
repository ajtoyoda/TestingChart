package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RangeExpandToIncludeTest {
	@Before
	public void setUp() {
		//No set up is necessary because each test case needs a new range
	}

	@After
	public void tearDown() {
		//Ensure it is reset for safety
	}
	
	@Test
	public void testExpandToIncludeNullArgument(){
		range = Range.expandToInclude(null, 0);
		assertEquals(new Range(0,0), range);
	}
	@Test
	public void testExpandToIncludeRangeAlreadyContainsNumber(){
		range = Range.expandToInclude(new Range(0,5),2);
		assertEquals(new Range(0,5), range);
	}
	@Test
	public void testExpandToIncludeNumberGreaterThanRange(){
		range = Range.expandToInclude(new Range(0,5), 7);
		assertEquals(new Range(0,7), range);
	}
	@Test
	public void testExpandToIncludeNumberLessThanRange(){
		range = Range.expandToInclude(new Range(0,5), -3);
		assertEquals(new Range(-3,5), range);
	}
	private Range range;
}
