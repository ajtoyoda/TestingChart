package org.jfree.data.test;

import junit.framework.TestCase;

import org.jfree.data.Range;
import org.junit.*;

public class RangeTestIntersects extends TestCase {
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		exampleRange00 = new Range(0,0);
		exampleRange = new Range(0, 10);
	}

	@After
	public void tearDown() throws Exception {
	
	}

	@Test public void testIntersects1(){
		assertEquals("0,10 should intersect 0,10",
				true,exampleRange.intersects(0,10));
	}	
	@Test public void testIntersects2(){
		assertEquals("-10,-1 should not intersect 0,10",
				false, exampleRange.intersects(-10,-1));
	}
	@Test public void testIntersects3(){
		assertEquals("-10,0 should not intersect 0,10",
				false, exampleRange.intersects(-10,0));
	}
	@Test public void testIntersects4(){
		assertEquals("10,20 should not intersect 0,10",
				false, exampleRange.intersects(10,20));
	}
	@Test public void testIntersects5(){
		assertEquals("11,20 should not intersect 0,10",
				false, exampleRange.intersects(11,20));
	}
	
	@Test public void testIntersects11(){
		assertEquals("0,0 should intersect 0,0",
				true, exampleRange00.intersects(0,10));
	}	
	@Test public void testIntersects12(){
		assertEquals("-5,-2 should not intersect 0,0",
				false, exampleRange00.intersects(-5,2));
	}
	@Test public void testIntersects13(){
		assertEquals("-1,0 should not intersect 0,0",
				false, exampleRange00.intersects(-1, 0));
	}
	@Test public void testIntersects14(){
		assertEquals("0,1 should not intersect 0,0",
				false, exampleRange00.intersects(0,1));
	}
	@Test public void testIntersects15(){
		assertEquals("2,5 should not intersect 0,0",
				false, exampleRange00.intersects(2,5));
	}
	private Range exampleRange, exampleRange00;
}
