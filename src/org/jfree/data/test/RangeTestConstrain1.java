package org.jfree.data.test;

import junit.framework.TestCase;

import org.jfree.data.Range;
import org.junit.*;

public class RangeTestConstrain1 extends TestCase {
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		exampleRange = new Range(-1, 1);
	}

	@After
	public void tearDown() throws Exception {
	
	}

	@Test public void testCoinstrain1(){
		assertEquals("The constrained value of -2 on -1 and 1 should be -1",
				-1, exampleRange.constrain(-2), 0.000001d);
	}	
	@Test public void testCoinstrain2(){
		assertEquals("The constrained value of -1 on -1 and 1 should be -1",
				-1, exampleRange.constrain(-1), 0.000001d);
	}
	@Test public void testCoinstrain3(){
		assertEquals("The constrained value of 0 on -1 and 1 should be 0",
				0, exampleRange.constrain(0), 0.000001d);
	}
	@Test public void testCoinstrain4(){
		assertEquals("The constrained value of 1 on -1 and 1 should be 1",
				1, exampleRange.constrain(1), 0.000001d);
	}
	@Test public void testCoinstrain5(){
		assertEquals("The constrained value of 2 on -1 and 1 should be 1",
				1, exampleRange.constrain(2), 0.000001d);
	}
	private Range exampleRange;
}
