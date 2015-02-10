package org.jfree.data.test;

import org.jfree.data.*;
import org.jmock.*;
import org.junit.*;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.security.InvalidParameterException;

// Performs black box testing on the getCumulativePercentages() method of
// the DataUtilities class.
//
public class DataUtilitiesGetCumulativePercentages extends TestCase {
	private Mockery     m_mockery; // Mocking object.
	private KeyedValues m_values;  // Keys and values.
	
	// Creates a new mockery and KeyedValues object.
	//
	@Before
	public void setUp()
	{
		m_mockery = new Mockery();
		m_values  = m_mockery.mock(KeyedValues.class);
	}
	
	// Creates a null set of keyed values.
	//
	private void createNullSet()
	{
		m_values = null;
	}
	
	// Creates a set of values consisting of 1 key-value pair using the
	// specified value.  The key associated with the value is the number 0.
	//	 value: The value to use to create the key-value pair.
	//
	private void createSingleValueSet(double value)
	{
		m_mockery.checking(new Expectations()
		{
			{
				allowing(m_values).getItemCount();
				will(returnValue(1));
				allowing(m_values).getValue(0);
				will(returnValue(value));
				
				allowing(m_values).getKey(0);
				will(returnValue(0));
				allowing(m_values).getIndex(0);
				will(returnValue(0));
				allowing(m_values).getKeys();
				will(returnValue(new ArrayList<Integer>().add(0)));
			}
		});
	}
	
	// Creates a 2 key-value pair set containing the following data:
	//   0: 0
	//   1: 3
	//
	private void createTwoValueSet()
	{
		m_mockery.checking(new Expectations()
		{
			{
				allowing(m_values).getItemCount();
				will(returnValue(2));
				
				// Keys.
				allowing(m_values).getKey(0);
				will(returnValue(0));
				allowing(m_values).getKey(1);
				will(returnValue(1));
				
				allowing(m_values).getIndex(0);
				will(returnValue(0));
				allowing(m_values).getIndex(1);
				will(returnValue(1));
				
				allowing(m_values).getKeys();
				will(returnValue(new ArrayList<Integer>() {{ add(0); add(1); }}));
				
				// Values.
				allowing(m_values).getValue(0);
				will(returnValue(0));
				allowing(m_values).getValue(1);
				will(returnValue(3));
			}
		});
	}
	
	// Creates a set of 5 key-value pairs containing the following data:
	//   0: 1.1
	//   1: 2
	//   2: 3.14
	//   3: 4
	//   4: 5
	//
	private void createFiveValueSet()
	{
		m_mockery.checking(new Expectations()
		{
			{
				allowing(m_values).getItemCount();
				will(returnValue(5));
				
				// Keys.
				allowing(m_values).getKey(0);
				will(returnValue(0));
				allowing(m_values).getKey(1);
				will(returnValue(1));
				allowing(m_values).getKey(2);
				will(returnValue(2));
				allowing(m_values).getKey(3);
				will(returnValue(3));
				allowing(m_values).getKey(4);
				will(returnValue(4));
				
				allowing(m_values).getIndex(0);
				will(returnValue(0));
				allowing(m_values).getIndex(1);
				will(returnValue(1));
				allowing(m_values).getIndex(2);
				will(returnValue(2));
				allowing(m_values).getIndex(3);
				will(returnValue(3));
				allowing(m_values).getIndex(4);
				will(returnValue(4));
				
				allowing(m_values).getKeys();
				will(returnValue(new ArrayList<Integer>() {
					{
						add(0);
						add(1);
						add(2);
						add(3);
						add(4);
					}}));
				
				// Values.
				allowing(m_values).getValue(0);
				will(returnValue(1.1));
				allowing(m_values).getValue(1);
				will(returnValue(2));
				allowing(m_values).getValue(2);
				will(returnValue(3.14));
				allowing(m_values).getValue(3);
				will(returnValue(4));
				allowing(m_values).getValue(4);
				will(returnValue(5));
			}
		});
	}
	
	// Ensures getCumulativePercentages() throws an exception when the data it
	// operates on is null.
	//
	@Test (expected = InvalidParameterException.class)
	public void testThrowsInvalidParameterExceptionForNullData()
	{
		createNullSet();
		DataUtilities.getCumulativePercentages(m_values);
	}
	
	// Ensures getCumulativePercentages() works for a single-value set containing
	// only the value zero.
	//
	@Test
	public void testSingleSetOnlyZero()
	{
		createSingleValueSet(0);
		KeyedValues actual = DataUtilities.getCumulativePercentages(m_values);
		
		assertEquals("Cumulative percentage of only zero should be 0%.",
				0.0, actual.getValue(0).doubleValue(), 0.0000001);
	}
	
	// Ensures getCumulativePercentages() works for a single-value set containing
	// only one decimal value.
	//
	@Test
	public void testSingleSetOnlyDecimal()
	{
		createSingleValueSet(1.1);
		KeyedValues actual = DataUtilities.getCumulativePercentages(m_values);
		
		assertEquals("Cumulative percentage of a single decimal value should be 100%.",
				1.0, actual.getValue(0).doubleValue(), 0.0000001);
	}
	
	// Ensures getCumulativePercentages() works for a single-value set containing
	// only one positive integer.
	//
	@Test
	public void testSingleSetOnlyPositiveInteger()
	{
		createSingleValueSet(5);
		KeyedValues actual = DataUtilities.getCumulativePercentages(m_values);
		
		assertEquals("Cumulative percentage of a single positive integer should be 100%.",
				1.0, actual.getValue(0).doubleValue(), 0.0000001);
	}
	
	// Ensures getCumulativePercentages() works for a single-value set containing
	// only one negative integer.
	//
	@Test (expected = InvalidParameterException.class)
	public void testSingleSetOnlyNegativeInteger()
	{
		createSingleValueSet(-3);
		DataUtilities.getCumulativePercentages(m_values);
	}
	
	// Ensures getCumulativePercentages() works for a multi-value set containing
	// two values, one of which is zero.
	//
	@Test
	public void testMultiValueSetContainingZero()
	{
		createTwoValueSet();
		KeyedValues actual = DataUtilities.getCumulativePercentages(m_values);
		
		assertEquals("Cumulative percentages for multi-value sets should be calculated correctly.",
				0.0, actual.getValue(0).doubleValue(), 0.0000001);
		assertEquals("Cumulative percentages for multi-value sets should be calculated correctly.",
				1.0, actual.getValue(1).doubleValue(), 0.0000001);
	}
	
	// Ensures getCumulativePercentages() works for a multi-value set containing
	// five values (positive integers and decimal values). 
	//
	@Test
	public void testMultiValueSet()
	{
		createFiveValueSet();
		KeyedValues actual = DataUtilities.getCumulativePercentages(m_values);
		
		assertEquals("Cumulative percentages for multi-value sets should be calculated correctly.",
				0.072, actual.getValue(0).doubleValue(), 0.001);
		assertEquals("Cumulative percentages for multi-value sets should be calculated correctly.",
				20.3, actual.getValue(1).doubleValue(), 0.001);
		assertEquals("Cumulative percentages for multi-value sets should be calculated correctly.",
				40.9, actual.getValue(2).doubleValue(), 0.001);
		assertEquals("Cumulative percentages for multi-value sets should be calculated correctly.",
				67.1, actual.getValue(3).doubleValue(), 0.001);
		assertEquals("Cumulative percentages for multi-value sets should be calculated correctly.",
				1.0, actual.getValue(4).doubleValue(), 0.001);
	}
	
}
