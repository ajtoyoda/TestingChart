package org.jfree.data.test;

import junit.framework.TestCase;

import org.jfree.data.Range;
import org.junit.*;

/***
 * This contains blackbox testing for the methond Range.intersects
 * Methods do not have commenting because name is descriptive enough
 * @author jamie
 *
 */
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

	@Test public void testIntersectsRangeEqualToRange(){
		assertEquals("0,10 should intersect 0,10",
				true,exampleRange.intersects(0,10));
	}	
	@Test public void testIntersectsEntirelyLessThanRange(){
		assertEquals("-10,-1 should not intersect 0,10",
				false, exampleRange.intersects(-10,-1));
	}
	@Test public void testIntersectsUpperBoundOfIntersectingRangeEqualToLowerBoundOfRange(){
		assertEquals("-10,0 should not intersect 0,10",
				false, exampleRange.intersects(-10,0));
	}
	@Test public void testIntersectsLowerBoundOfIntersectingRangeEqualToUpperBoundOfRange(){
		assertEquals("10,20 should not intersect 0,10",
				false, exampleRange.intersects(10,20));
	}
	@Test public void testIntersectsEntirelyGreaterThanRange(){
		assertEquals("11,20 should not intersect 0,10",
				false, exampleRange.intersects(11,20));
	}
	
	@Test public void testIntersectsRangeOfSizeZeroIntersectsIdenticalRange(){
		assertEquals("0,0 should intersect 0,0",
				true, exampleRange00.intersects(0,10));
	}	
	@Test public void testIntersectsEntirelyLessThanRangeOfLength0(){
		assertEquals("-5,-2 should not intersect 0,0",
				false, exampleRange00.intersects(-5,2));
	}
	@Test public void testIntersectsUpperBoundOfIntersectingRangeEqualToLowerBoundOfRangeOfLength0(){
		assertEquals("-1,0 should not intersect 0,0",
				false, exampleRange00.intersects(-1, 0));
	}
	@Test public void testIntersectsLowerBoundOfIntersectingRangeEqualToUpperBoundOfRangeOfLength0(){
		assertEquals("0,1 should not intersect 0,0",
				false, exampleRange00.intersects(0,1));
	}
	@Test public void testIntersectsEntirelyGreaterThanRangeOfLength0(){
		assertEquals("2,5 should not intersect 0,0",
				false, exampleRange00.intersects(2,5));
	}
	@Test public void testIntersectsInvalidRange(){
		assertEquals("Invalid input should return false", false, exampleRange00.intersects(1,0));
	}
	private Range exampleRange, exampleRange00;
}
