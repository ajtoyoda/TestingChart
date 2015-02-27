package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RangeShiftTest {

	@Before
	public void setUp() throws Exception {
		exampleRange = new Range(5, 10);
	}

	@After
	public void tearDown() throws Exception {
	
	}
	@Test
	public void testShiftPositive(){
		assertEquals(new Range(6,11), Range.shift(exampleRange,1));
	}
	@Test
	public void testShiftNegative(){
		assertEquals(new Range(4,9), Range.shift(exampleRange,-1));
	}
	@Test
	public void testShiftCrossZeroNegative(){
		assertEquals(new Range(0,4), Range.shift(exampleRange, -6));
	}
	@Test
	public void testShiftCrossZeroPositive(){
		assertEquals(new Range(-4,0), Range.shift(new Range(-10,-5), 6));
	}
	@Test
	public void testShiftZero(){
		assertEquals(new Range(5,10), Range.shift(exampleRange, 0));
	}
	@Test
	public void testShiftCrossZeroNegativeWithArgumentTrue(){
		assertEquals(new Range(-1,4), Range.shift(exampleRange, -6, true));
	}
	@Test
	public void testShiftCrossZeroPositiveWithArgumentTure(){
		assertEquals(new Range(-4,1), Range.shift(new Range(-10,-5), 6, true));
	}
	private Range exampleRange;

}
