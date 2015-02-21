package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RangeConstructorTest {

	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {

	}
	@Test
	public void testConstructorValidValues(){
		exampleRange = new Range(0, 0);
		assertEquals(0, exampleRange.getUpperBound(), 0.00001d);
		assertEquals(0, exampleRange.getLowerBound(), 0.00001d);
	}
	//Unspecified which exception will be thrown in javadocs
	@Test(expected = Exception.class)
	public void testConstructorInValidValues(){
		exampleRange = new Range(0, -1);
	}
	private Range exampleRange;

}
