package Temp;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ThermostatTest{
	Thermostat thermo;
	ProgrammedSetting pSet;
	@Before
	public void setUp() throws Exception {
		thermo = new Thermostat();
		pSet = new ProgrammedSetting();
		
	}
	
	@Test
	public void testCalc1() {
		pSet.setSetting(Period.EVENING, DayType.WEEKDAY, 2);
		thermo.setThresholdDiff(0);
		thermo.setCurrentTemp(1);
		
		assertEquals("test 1", 1,  thermo.turnHeaterOn(1,2,1,3,2002));
	}
	@Test
	public void testCalc2() {
		assertEquals("test 2", 62, thermo.turnHeaterOn(3,3,5,4,1987));	
	}
	@Test
	public void testCalc3() {
		assertEquals("test 3", 93, thermo.turnHeaterOn(3,3,6,4,2000));		
	}
	@Test
	public void testCalc4() {
		assertEquals("test 4", 32, thermo.turnHeaterOn(3,3,4,4,2000));		
	}
	@Test
	public void testCalc5() {
		assertEquals("test 5", 32, thermo.turnHeaterOn(3,3,4,4,1987));		
	}
	
	@Test
	public void testCalc6() {
		//mt3
		assertEquals("test 6", 32, thermo.cal(1,3,2,4,1987));
	}
	
	@Test
	public void testCalc7() {
		//mt4
		assertEquals("test 7", 61, thermo.cal(1,3,3,4,2000));		
	}
	
	@Test
	public void testCalc8() {
		//mt5
		assertEquals("test 8", 60, thermo.cal(1,3,3,4,1000));		
	}
	
}