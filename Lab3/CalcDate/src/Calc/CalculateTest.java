package Calc;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CalculateTest {
	Calculate cl;
	@Before
	public void setUp() throws Exception {
		cl = new Calculate();
	}
	
	@Test
	public void testCalc1() {
		//1,2,3
		assertEquals("test 1", 1,  cl.cal(1,2,1,3,2002));
	}
	@Test
	public void testCalc2() {
		assertEquals("test 2", 62, cl.cal(3,3,5,4,1987));	
	}
	@Test
	public void testCalc3() {
		assertEquals("test 3", 93, cl.cal(3,3,6,4,2000));		
	}
	@Test
	public void testCalc4() {
		assertEquals("test 4", 32, cl.cal(3,3,4,4,2000));		
	}
	@Test
	public void testCalc5() {
		assertEquals("test 5", 32, cl.cal(3,3,4,4,1987));		
	}
	
	@Test
	public void testCalc6() {
		//mt3
		assertEquals("test 6", 32, cl.cal(1,3,2,4,1987));
	}
	
	@Test
	public void testCalc7() {
		//mt4
		assertEquals("test 7", 61, cl.cal(1,3,3,4,2000));		
	}
	
	@Test
	public void testCalc8() {
		//mt5
		assertEquals("test 8", 60, cl.cal(1,3,3,4,1000));		
	}
	
}<>
