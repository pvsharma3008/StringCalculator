package com.StringCalculator;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

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
	
	@Test
	public void testAddWithNewLineDelimiter() {
		String num = "1\n2";
		assertEquals(3, calculator.add(num));
	}
	
	@Test
	public void testAddWithMultipleNumbers() {
		String num = "1\n2,3";
		assertEquals(6, calculator.add(num));
	}
	
	@Test
	public void testAddForCustomDelimiter() {
		String num  = "//;\n1;2;7";
		assertEquals(10, calculator.add(num));
	}
	
	@Rule
	public ExpectedException expectedException = ExpectedException.none();
	
	@Test
	public void testAddForNegetiveNumbersShouldTHrowException() {
		expectedException.expect(IllegalArgumentException.class);
		expectedException.expectMessage("negatives not allowed: -3-2");

		calculator.add("-3,-2,1");
	}
	
	@Test
	public void testAddForNegetiveNumberShouldTHrowException() {
		expectedException.expect(IllegalArgumentException.class);
		expectedException.expectMessage("negatives not allowed: -3");

		calculator.add("-3");
	}
	
	@Test
	public void testAddForMoreThanThousandNumbers() {
		String num  = "//;\n1;2;7000";
		assertEquals(3, calculator.add(num));
	}
	
	@Test
	public void testAddForCustomDelimiterOfAnyLength() {
		String num  = "//[;;;]\n1;;;2;;;7";
		assertEquals(10, calculator.add(num));
	}
	@Test
	public void testAddForMultipleCustomDelimiterOfAnyLength() {
		String num  = "//[;;;][,,]\n1;;;2,,7";
		assertEquals(10, calculator.add(num));
	}

	
}
