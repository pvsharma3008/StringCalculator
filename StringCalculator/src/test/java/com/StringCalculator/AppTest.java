package com.StringCalculator;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest
{
	private App calculator;
	
	@Before
	public void init() {
		calculator = new App();
	}
	@Test
	public void testAddWithEmptyString() {
		assertEquals(0, calculator.add(""));
	}
	
	@Test
	public void testAddWithSingleNumber() {
		String num = "20";
		assertEquals(Integer.parseInt(num), calculator.add(num));
	}
	
	@Test
	public void testAddWithtwoNumber() {
		String num = "20,30";
		assertEquals(50, calculator.add(num));
	}
	
}
