package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RangeHashCodeTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	
	}
	@Test
	public void testHashCodeIsSomeWhatUnique(){
		assertNotSame(new Range(0,5).hashCode(), new Range(5,10).hashCode());
	}

}
