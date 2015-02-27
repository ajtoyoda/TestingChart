package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.DefaultKeyedValues;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DKVsSetValueTest {

	@Before
	public void setUp() throws Exception {
		DKVs = new DefaultKeyedValues();
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testSetValueWithKey0() {
		Integer key = 0;
		Double value = 1.23;
		DKVs.setValue(key, value);
		Double valueOut = (Double) DKVs.getValue(key);
		assertEquals(value, valueOut);
		Integer keyOut = (Integer) DKVs.getKey(0);
		assertEquals(key, keyOut);
	}
	
	@Test
	public void testSetValueWithPosKey(){
		Integer key = 5;
		Double value = 1.23;
		DKVs.setValue(key, value);
		Double valueOut = (Double) DKVs.getValue(key);
		assertEquals(value, valueOut);
		Integer keyOut = (Integer) DKVs.getKey(0);
		assertEquals(key, keyOut);
		
	}
	
	@Test
	public void testSetValueWithNegKey(){
		Integer key = -5;
		Double value = 1.23;
		DKVs.setValue(key, value);
		Double valueOut = (Double) DKVs.getValue(key);
		assertEquals(value, valueOut);
		Integer keyOut = (Integer) DKVs.getKey(0);
		assertEquals(key, keyOut);
		
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testSetValueWithNullKey(){
		Integer key = null;
		Double value = 1.23;
		DKVs.setValue(key,value);
	}
	
	@Test
	public void testSetValueWithManyKeys(){
		Integer key1 = 0;
		Integer key2 = 1;
		Double value1 = 1.23;
		Double value2 = 4.56;
		DKVs.setValue(key1,value1);
		DKVs.setValue(key2,value2);
		Integer keyOut1 = (Integer) DKVs.getKey(0);
		Integer keyOut2 = (Integer) DKVs.getKey(1);
		Double valueOut1 = (Double) DKVs.getValue(key1);
		Double valueOut2 = (Double) DKVs.getValue(key2);
		assertEquals(key1, keyOut1);
		assertEquals(key2, keyOut2);
		assertEquals(value1, valueOut1);
		assertEquals(value2, valueOut2);
	}

	@Test
	public void testSetValueWithDuplicateKeys(){
		Integer key1 = 0;
		Integer key2 = 0;
		Double value1 = 1.23;
		Double value2 = 4.56;
		DKVs.setValue(key1,value1);
		DKVs.setValue(key2,value2);
		Integer keyOut1 = (Integer) DKVs.getKey(0);
		Double valueOut1 = (Double) DKVs.getValue(key1);
		Double valueOut2 = (Double) DKVs.getValue(key2);
		assertEquals(key1, keyOut1);
		assertEquals(key2, keyOut1);
		assertEquals(valueOut1, valueOut2);
		assertEquals(value2, valueOut2);
		
	}
	//when passed a double value instead of a Double value, the function typecasts.
		//Only one test is needed to prove typecase functionality as extensive testing has
		//been performed with Double inputs
	@Test
	public void testSetValueWithPrimType(){
		Integer key = 0;
		double value = 1.23;
		DKVs.setValue(key,value);
		Integer keyOut = (Integer) DKVs.getKey(0);
		double valueOut = (double) DKVs.getValue(key);
		assertEquals(keyOut, key);
		assertEquals(valueOut, value, 0.00001d);
	}
	
	@Test
	public void testAddValueDouble(){
		Integer key = 0;
		Double value = 1.23;
		DKVs.addValue(key, value);
		Double valueOut = (Double) DKVs.getValue(key);
		assertEquals(value, valueOut);
		Integer keyOut = (Integer) DKVs.getKey(0);
		assertEquals(key, keyOut);
	}
	
	@Test
	public void testAddValuedouble(){
		Integer key = 0;
		double value = 1.23;
		DKVs.addValue(key, value);
		Double valueOut = (double) DKVs.getValue(key);
		assertEquals(value, valueOut, 0.000001d);
		Integer keyOut = (Integer) DKVs.getKey(0);
		assertEquals(key, keyOut);
	}
	
	
	private DefaultKeyedValues DKVs;
}
