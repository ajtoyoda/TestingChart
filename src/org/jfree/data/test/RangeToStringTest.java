package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RangeToStringTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	
	}
	@Test
	public void testToStringRangeOfSizeZero(){
		assertEquals("Range[0.0,0.0]", new Range(0,0).toString());
	}
	@Test
	public void testToStringRangeSizePositive(){
		assertEquals("Range[0.0,5.0]", new Range(0,5).toString());
	}
}
