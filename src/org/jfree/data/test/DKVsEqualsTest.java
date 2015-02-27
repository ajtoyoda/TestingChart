package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.DefaultKeyedValues;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DKVsEqualsTest {

	@Before
	public void setUp() throws Exception {
		DKVs1 = new DefaultKeyedValues();
		DKVs2 = new DefaultKeyedValues();
	}

	@After
	public void tearDown() throws Exception {
		DKVs1 = null;
		DKVs2 = null;
	}

	@Test
	public void equalWithItselfTest() {
		Integer key = 0;
		Double value = 1.23;
		//addValue is a facade for setValue, remember to test it there
		DKVs1.addValue(key, value);
		assertTrue(DKVs1.equals(DKVs1));
	}
	
	@Test
	public void notEqualWithArbitraryClass(){
		Integer key = 0;
		Double value = 1.23;
		//addValue is a facade for setValue, remember to test it there
		DKVs1.addValue(key, value);
		assertFalse(DKVs1.equals(key));
	}
	
	@Test
	public void notEqualWithDifferentCounts(){
		Integer key = 0;
		Double value = 1.23;
		//addValue is a facade for setValue, remember to test it there
		DKVs1.addValue(key, value);
		assertFalse(DKVs1.equals(DKVs2));
	}
	
	@Test 
	public void notEqualWithDifferentKeys(){
		Integer key1 = 0;
		Integer key2 = 1;
		Double value = 1.11;
		DKVs1.addValue(key1, value);
		DKVs2.addValue(key2, value);
		assertFalse(DKVs1.equals(DKVs2));
	}
	
	@Test 
	public void notEqualWithDifferentValues(){
		Integer key = 0;
		Double value1 = 1.11;
		Double value2 = 2.22;
		DKVs1.addValue(key, value1);
		DKVs2.addValue(key, value2);
		assertFalse(DKVs1.equals(DKVs2));
	}

	@Test
	public void notEqualWithOneNullValue(){
		Integer key1 = 0;
		Integer key2 = 1;
		Double value1 = null;
		Double value2 = 1.11;
		DKVs1.addValue(key1, value1);
		DKVs2.addValue(key2, value2);
		assertFalse(DKVs1.equals(DKVs2));
	}
	
	@Test
	public void equalWhenEqual(){
		Integer key = 0;
		Double value = 1.11;
		DKVs1.addValue(key, value);
		DKVs2.addValue(key, value);
		assertTrue(DKVs1.equals(DKVs2));
	}
	
	private DefaultKeyedValues DKVs1;
	private DefaultKeyedValues DKVs2;
}
