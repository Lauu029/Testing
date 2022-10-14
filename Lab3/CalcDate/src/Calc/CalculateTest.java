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
		assertEquals("test 1", cl.cal(1,2,1,3,2002), 1);
	}
	@Test
	public void testCalc2() {
		assertEquals("test 2", cl.cal(3,3,5,4,1987), 62);
		
	}
	@Test
	public void testCalc3() {
		assertEquals("test 3", cl.cal(3,3,6,4,2000), 93);
		
	}
	@Test
	public void testCalc4() {
		assertEquals("test 4", cl.cal(3,3,4,4,2000), 32);
		
	}
	@Test
	public void testCalc5() {
		assertEquals("test 5", cl.cal(3,3,4,4,1987), 32);
		
	}
	
	
}
