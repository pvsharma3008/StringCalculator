package com.StringCalculator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest
{
	@Test
	public void testAddWithEmptyString() {
		assertEquals(0, App.add(""));
	}
	
	@Test
	public void testAddWithSingleNumber() {
		String num = "1";
		assertEquals(Integer.parseInt(num), App.add(num));
	}
	
}
