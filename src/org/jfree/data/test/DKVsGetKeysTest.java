package org.jfree.data.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.jfree.data.DefaultKeyedValues;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DKVsGetKeysTest {

	@Before
	public void setUp() throws Exception {
		DKVs = new DefaultKeyedValues();
		output = new ArrayList<Integer>();
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void getNoKeys() {
		output = DKVs.getKeys();
		assertTrue(output.isEmpty());
	}
	
	@Test
	public void getOneKey(){
		Integer key = 0;
		Double value = 1.11;
		DKVs.addValue(key, value);
		output = DKVs.getKeys();
		assertEquals(key, output.get(0));
	}
	
	@Test
	public void getManyKeys(){
		
		Integer key1 = 0;
		Integer key2 = 1;
		Integer key3 = 2;
		
		Double value1 = 1.11;
		Double value2 = 2.22;
		Double value3 = 3.33;
		
		DKVs.addValue(key1, value1);
		DKVs.addValue(key2, value2);
		DKVs.addValue(key3, value3);
		
		output = DKVs.getKeys();
		
		assertEquals(key1, output.get(0));
		assertEquals(key2, output.get(1));
		assertEquals(key3, output.get(2));
		
		
	}

	private DefaultKeyedValues DKVs;
	private List output;
}
