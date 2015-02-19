package org.jfree.data.test;

import junit.framework.TestCase;

import org.jfree.data.Range;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RangeCombineTest extends TestCase {
	@Before
	public void setUp() {
		//no universal setup is needed as each test case needs its own new Range
	}

	@After
	public void tearDown() {
		exampleRange = null;
	}

	
	private Range exampleRange;

}

