package org.jfree.data.test;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;

import org.jfree.data.Range;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RangeExpandTest {
	@Before
	public void setUp() {
		//No set up is necessary because each test case needs a new range
	}

	@After
	public void tearDown() {
		//Ensure it is reset for safety
	}

	@Test (expected = InvalidParameterException.class)
	public void testExpandNullArgument(){
		Range.expand(null, 0, 0);
	}
	@Test
	public void testExpandByZeroOnUpperAndLower(){
		range =Range.expand(new Range(0,6), 0,0);
		assertEquals(new Range(0,6), range);
	}
	@Test
	public void testExpandByDoubleOnBothTopAndBottom(){
		range =Range.expand(new Range(0,6), 1,1);
		assertEquals(new Range(-6,12), range);
	}
	@Test
	public void testExpandByDifferentNumbersOnTopAndBottom(){
		range =Range.expand(new Range(0,8), 0.5,0.25);
		assertEquals(new Range(-4,10), range);
	}
	private Range range;
}
