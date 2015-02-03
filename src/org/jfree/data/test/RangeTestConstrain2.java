package org.jfree.data.test;

import junit.framework.TestCase;

import org.jfree.data.Range;
import org.junit.*;

public class RangeTestConstrain2 extends TestCase {
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		exampleRange = new Range(0, 0);
	}

	@After
	public void tearDown() throws Exception {
	
	}

	@Test public void testCoinstrain1(){
		assertEquals("The constrained value of -1 on 0 and 0 should be 0",
				exampleRange.constrain(-1), 0, 0.000001d);
	}	
	@Test public void testCoinstrain2(){
		assertEquals("The constrained value of 1 on 0 and 0 should be 0",
				exampleRange.constrain(1), 0, 0.000001d);
	}
	@Test public void testCoinstrain3(){
		assertEquals("The constrained value of 0 on 0 and 0 should be 0",
				exampleRange.constrain(0), 0, 0.000001d);
	}
	private Range exampleRange;
}
