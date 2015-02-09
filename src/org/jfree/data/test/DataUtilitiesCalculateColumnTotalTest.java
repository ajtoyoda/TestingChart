package org.jfree.data.test;

import org.jmock.*;
import org.jfree.data.*;
import org.junit.*;
import junit.framework.TestCase;

import java.security.InvalidParameterException;
import java.lang.IndexOutOfBoundsException;

// Performs black box testing on the CalculateColumnTotal() method of the
// DataUtilities class.
//
public class DataUtilitiesCalculateColumnTotalTest extends TestCase {
	private Mockery  m_mockery = null; // Mocking object.
	private Values2D m_table   = null; // Table of values used in all tests.
	
	// Prepares for each test by creating a mock Values2D object with a
	// specific table of values.
	//
	@Before
	public void setUp()
	{
		m_mockery = new Mockery();
		m_table   = m_mockery.mock(Values2D.class);
	}
	
	// Mocks a Values2D table of values containing positive and negative
	// integers, and decimal values.
	//
	private void createTable()
	{
		m_mockery.checking(new Expectations()
		{
			{
				// Table dimensions.
				allowing(m_table).getColumnCount();
				will(returnValue(4));
				allowing(m_table).getRowCount();
				will(returnValue(4));
				
				// Table contents.
				// Column 1: Positive integers.
				allowing(m_table).getValue(0, 0);
				will(returnValue(8));
				allowing(m_table).getValue(1, 0);
				will(returnValue(5));
				allowing(m_table).getValue(2, 0);
				will(returnValue(1));
				allowing(m_table).getValue(3, 0);
				will(returnValue(5));
				
				// Column 2: Negatives and fractional values.
				allowing(m_table).getValue(0, 1);
				will(returnValue(4));
				allowing(m_table).getValue(1, 1);
				will(returnValue(-19));
				allowing(m_table).getValue(2, 1);
				will(returnValue(1.11));
				allowing(m_table).getValue(3, 1);
				will(returnValue(-2));
				
				// Column 3: Negatives and fractional values.
				allowing(m_table).getValue(0, 2);
				will(returnValue(1));
				allowing(m_table).getValue(1, 2);
				will(returnValue(4.2));
				allowing(m_table).getValue(2, 2);
				will(returnValue(-1.52));
				allowing(m_table).getValue(3, 2);
				will(returnValue(9));
				
				// Column 4: Negative and positive integers adding to zero.
				allowing(m_table).getValue(0, 3);
				will(returnValue(0));
				allowing(m_table).getValue(1, 3);
				will(returnValue(7));
				allowing(m_table).getValue(2, 3);
				will(returnValue(5));
				allowing(m_table).getValue(3, 3);
				will(returnValue(-12));
				
				// Exceptional circumstances.
				allowing(m_table).getValue(-1, 0);
				will(throwException(new IndexOutOfBoundsException()));
				allowing(m_table).getValue(4, 0);
				will(throwException(new IndexOutOfBoundsException()));
			}
		});
	}
	
	// Mocks a m_table so that it consists of a single cell.  The cell contains a
	// positive integer.
	//
	private void createSingleCellTable()
	{
		m_mockery.checking(new Expectations() {
			{
				// Table dimensions.
				allowing(m_table).getColumnCount();
				will(returnValue(1));
				allowing(m_table).getRowCount();
				will(returnValue(1));
				
				// Table value.
				allowing(m_table).getValue(0, 0);
				will(returnValue(42));
			}
		});
	}
	
	// Converts m_table to null.
	//
	private void createNullTable()
	{
		m_table = null;
	}
	
	// Ensures calculateColumnTotal() throws an exception for a null
	// table.
	//
	@Test (expected = InvalidParameterException.class)
	public void testThrowsInvalidParameterExceptionForNullParameter()
	{
		createNullTable();
		DataUtilities.calculateColumnTotal(m_table, 0);
	}
	
	// Ensures calculateColumnTotal() throws an exception for column indexes
	// that are below a table's lower bound.
	//
	@Test (expected = InvalidParameterException.class)
	public void testThrowsInvalidParameterExceptionForColumnBelowLowerBound()
	{
		final int MISSING_TABLE_COLUMN = -1;
		createTable();
		DataUtilities.calculateColumnTotal(m_table, MISSING_TABLE_COLUMN);
	}
	
	// Ensures calculateColumnTotal() throws an exception for Column indices
	// that are beyond a table's upper bound.
	//
	@Test (expected = InvalidParameterException.class)
	public void testThrowsInvalidParameterExceptionForColumnAboveUpperBound()
	{
		final int MISSING_TABLE_COLUMN = 4;
		createTable();
		DataUtilities.calculateColumnTotal(m_table, MISSING_TABLE_COLUMN);
	}
	
	// Ensures calculateColumnTotal() works for a table consisting of a single
	// cell.
	//
	@Test
	public void testAddsSingleValueTable()
	{
		createSingleCellTable();
		double actual = DataUtilities.calculateColumnTotal(m_table, 0);
		
		assertEquals("Calculation for a single value table failed.",
				42.0, actual, 0.0000001);
	}
	
	// Ensures calculateColumnTotal() works for positive integers, including
	// zero.
	//
	@Test
	public void testAddsPositiveIntegers()
	{
		createTable();
		double actual = DataUtilities.calculateColumnTotal(m_table, 0);
		
		assertEquals("Summing positive integers failed.",
				19.0, actual, 0.0000001);
	}
	
	// Ensures calculateColumnTotal() works for positive and negative integers
	// combined.
	//
	@Test
	public void testAddsNegativeIntegers()
	{
		createTable();
		double actual = DataUtilities.calculateColumnTotal(m_table, 3);
		
		assertEquals("Summing positive and negative integers combined failed.",
				0.0, actual, 0.0000001);
	}
	
	// Ensures calculateColumnTotal() works for decimal values.
	//
	@Test
	public void testAddsFractionalNumbers()
	{
		createTable();
		double actual = DataUtilities.calculateColumnTotal(m_table, 2);
		
		assertEquals("Summing fractional values failed.",
				12.68, actual, 0.0000001);
	}
}
