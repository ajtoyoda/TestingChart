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
	}
	

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSortByKeysWithEmptyStructure() {
		fail();
		
	}

	
	private DefaultKeyedValues DKVs;
}