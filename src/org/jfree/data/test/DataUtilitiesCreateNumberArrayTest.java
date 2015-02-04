package org.jfree.data.test;

import org.jfree.data.DataUtilities;
import org.junit.*;
import junit.framework.TestCase;
import java.security.InvalidParameterException;

// Tests the createNumberArray() method of the DataUtilities class.
//
public class DataUtilitiesCreateNumberArrayTest extends TestCase {
	private double[] m_array; // Array of doubles to convert.
	
	// Helper method to initialize m_array to null.
	//
	private void createNullArray()
	{
		m_array = null;	
	}
	
	// Helper method to initialize m_array with a single value.
	//
	private void createSingleValueArray()
	{
		m_array = new double[] { 1.0 };
	}
	
	// Helper method to initialize m_array with many different
	// values.
	//
	private void createArray()
	{
		m_array = new double[] { 1.0, 1.11, -1.52, 0.0 };
	}
	
	// Verifies createNumberArray throws an exception for an invalid array.
	//
	@Test (expected = InvalidParameterException.class)
	public void testThrowsInvalidParameterExceptionForNullArray()
	{
		createNullArray();
		DataUtilities.createNumberArray(m_array);
	}
	
	// Verifies createNumberArray() copies the values of a single number array
	// to a new array of the same length.
	//
	@Test
	public void testCopiesSingleValueArrayLength()
	{
		createSingleValueArray();
		Number[] actual = DataUtilities.createNumberArray(m_array);
		
		assertEquals("Length of arrays should be equal.",
				m_array.length, actual.length);
	}
	
	// Verifies createNumberArray() duplicates the contents of a single-
	// value array.
	//
	@Test
	public void testCopiesSingleValueArrayData()
	{
		createSingleValueArray();
		Number[] actual = DataUtilities.createNumberArray(m_array);
		
		assertEquals("Data of arrays should be equal.",
				m_array[0], actual[0].doubleValue(), 0.0000001);
	}
	
	// Verifies createNumberArray() duplicates the length of a multi-value
	// array.
	//
	@Test
	public void testCopiesArrayLength()
	{
		createArray();
		Number[] actual = DataUtilities.createNumberArray(m_array);
		
		assertEquals("Length of arrays should be equal.",
				m_array.length, actual.length);
	}
	
	// Verifies createNumberArray() duplicates the data of a multi-value
	// array.
	//
	@Test
	public void testCopiesArrayData()
	{
		createArray();
		Number[] actual = DataUtilities.createNumberArray(m_array);
		
		if (m_array.length != actual.length)
			fail("Array contents should be identical.");
		
		boolean isEqual = true;
		for (int i = 0; i < m_array.length; ++i)
		{
			if (actual[i] == null || actual[i].doubleValue() != m_array[i])
			{
				isEqual = false;
				break;
			}
		}
		
		assertTrue("Array contents should be identical.", isEqual);
	}
}
