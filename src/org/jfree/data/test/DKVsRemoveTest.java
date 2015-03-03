package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.DefaultKeyedValues;
import org.jfree.data.UnknownKeyException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DKVsRemoveTest {

	@Before
	public void setUp() throws Exception {
		DKVs = new DefaultKeyedValues();
	}

	@After
	public void tearDown() throws Exception {
		DKVs = null;
	}

	@Test 
	public void removeExistingByKey() {
		Integer key = 0;
		Double value = 1.11;
		DKVs.addValue(key, value);
		DKVs.removeValue(key);
		assertTrue(DKVs.getKeys().isEmpty());
	}
	
	@Test 
	public void removeNonExistantByKey(){
		Integer key = 0;
		Integer falseKey = 1;
		Double value = 1.11;
		DKVs.addValue(key, value);
		DKVs.removeValue(falseKey);
		assertTrue(DKVs.getValue(key)==value);
		
	}
	
	@Test (expected = UnknownKeyException.class)
	public void removeNullByKey(){
		Integer key = 0;
		Integer falseKey = null;
		Double value = 1.11;
		DKVs.addValue(key, value);
		DKVs.removeValue(falseKey);
	}
	
	//note that remove by key translates keys to index and thus also test remove by index
	
	

	DefaultKeyedValues DKVs;
}
