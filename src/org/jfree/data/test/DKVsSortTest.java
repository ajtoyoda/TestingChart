package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.DefaultKeyedValues;
import org.jfree.util.SortOrder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DKVsSortTest {

	@Before
	public void setUp() throws Exception {
		DKVs = new DefaultKeyedValues();
		order = null;
	}
	

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSortByKeysWithEmptyStructure() {
		DKVs.sortByKeys(order.ASCENDING);
		assertTrue(DKVs.getKeys().isEmpty());
	}
	
	@Test
	public void testSortByValuesWithEmptyStructure(){
		DKVs.sortByKeys(order.ASCENDING);
		assertTrue(DKVs.getKeys().isEmpty());
	}
	
	@Test
	public void testSortByKeys() {
		
		
		Integer key1 = 0;
		Integer key2 = 1;
		Integer key3 = 2;
		
		Double value1 = 1.11;
		Double value2 = 2.22;
		Double value3 = 3.33;
		
		DKVs.addValue(key3, value3);
		DKVs.addValue(key2, value2);
		DKVs.addValue(key1, value1);
				
		DKVs.sortByKeys(order.ASCENDING);
		
		assertEquals(key1, DKVs.getKey(0));
		assertEquals(key2, DKVs.getKey(1));
		assertEquals(key3, DKVs.getKey(2));
			
	}
	
	@Test
	public void testSortByValues(){
		Integer key1 = 0;
		Integer key2 = 1;
		Integer key3 = 2;
		
		Double value1 = 1.11;
		Double value2 = 2.22;
		Double value3 = 3.33;
		
		DKVs.addValue(key3, value3);
		DKVs.addValue(key2, value2);
		DKVs.addValue(key1, value1);
				
		DKVs.sortByValues(order.ASCENDING);
		
		assertEquals(value1, DKVs.getValue(0));
		assertEquals(value2, DKVs.getValue(1));
		assertEquals(value3, DKVs.getValue(2));
	}


	
	private DefaultKeyedValues DKVs;
	private SortOrder order;
	
}