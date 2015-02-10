package org.jfree.data.test;

import junit.framework.TestCase;

import org.jfree.data.Range;
import org.junit.*;
/***
 * Contains blackbox testing of Range.constrain(double) function
 * @author jamie
 *
 */
public class RangeTestConstrain extends TestCase {
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		exampleRange = new Range(-1, 1);
		exampleRange1 = new Range(0, 0);
	}

	@After
	public void tearDown() throws Exception {

	}

	/***
	 * Tests a constrain value of a number less than a range of length 0
	 */
	@Test
	public void testCoinstrainValueLessThanRangeWithRangeOfLength0() {
		assertEquals("The constrained value of -1 on 0 and 0 should be 0", 0,
				exampleRange1.constrain(-1), 0.000001d);
	}

	/***
	 * Tests a constrain value of a number greater than a range of length 0
	 */
	@Test
	public void testCoinstrainValueGreaterThanRangeWithRangeOfLength0() {
		assertEquals("The constrained value of 1 on 0 and 0 should be 0", 0,
				exampleRange1.constrain(1), 0.000001d);
	}

	/***
	 * Tests a constrain value of a number equal to a the range of length 0
	 */
	@Test
	public void testCoinstrainValueEqualToRangeWithRangeOfLength0() {
		assertEquals("The constrained value of 0 on 0 and 0 should be 0", 0,
				exampleRange1.constrain(0), 0.000001d);
	}

	/***
	 * Test constrain value less than range
	 */
	@Test
	public void testCoinstrainValueLessThanRange() {
		assertEquals("The constrained value of -2 on -1 and 1 should be -1",
				-1, exampleRange.constrain(-2), 0.000001d);
	}

	/***
	 * Test constrain value equal to lower bound of range
	 */
	@Test
	public void testCoinstrainValueEqualToLowerBoundOfRange() {
		assertEquals("The constrained value of -1 on -1 and 1 should be -1",
				-1, exampleRange.constrain(-1), 0.000001d);
	}

	/***
	 * Test constrain value inside of the range 
	 */
	@Test
	public void testCoinstrainValueInsideOfRange() {
		assertEquals("The constrained value of 0 on -1 and 1 should be 0", 0,
				exampleRange.constrain(0), 0.000001d);
	}

	/***
	 * Test constrain value equal to upper bound of range
	 */
	@Test
	public void testCoinstrainValueEqualToUpperBoundOfRange() {
		assertEquals("The constrained value of 1 on -1 and 1 should be 1", 1,
				exampleRange.constrain(1), 0.000001d);
	}

	/***
	 * Test constrain value greater than the range
	 */
	@Test
	public void testCoinstrainValueGreaterThanRange() {
		assertEquals("The constrained value of 2 on -1 and 1 should be 1", 1,
				exampleRange.constrain(2), 0.000001d);
	}
	
	/***
	 * Test a decimal constrain value
	 */
	@Test
	public void testConstrainValueDecimal(){
		assertEquals("The constrained value of 1.5 on -1 and 1 should be 1", 1, exampleRange.constrain(1.5), 0.000001d);
	}

	private Range exampleRange, exampleRange1;
}
