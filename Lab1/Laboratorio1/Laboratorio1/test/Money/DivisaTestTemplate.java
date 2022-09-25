package Money;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Money.Divisa;

public class DivisaTestTemplate {
	Divisa SEK, DKK, NOK, EUR;
	
	@Before
	public void setUp() throws Exception {
		SEK = new Divisa("SEK", 0.15);
		DKK = new Divisa("DKK", 0.20);
		EUR = new Divisa("EUR", 1.5);
	}

	@Test
	public void testGetName() {
		String msg = "Should be same name";
		assertEquals(msg,"SEK", SEK.getName());
		assertEquals(msg,"DKK", DKK.getName());
		assertEquals(msg,"EUR", EUR.getName());

	}
	
	@Test
	public void testGetRate() {
		String msg = "Should be same rate";
		assertEquals(msg, (Double)0.15, SEK.getRate());
		assertEquals(msg, (Double)0.20, DKK.getRate());
		assertEquals(msg, (Double)1.5, EUR.getRate());
	}
	
	@Test
	public void testSetRate() {
		Double newrate = 0.5;
		Double[] oldrates = {SEK.getRate(), DKK.getRate(), EUR.getRate()};
		
		String msg = "Should be the new rate";
		SEK.setRate(newrate);
		DKK.setRate(newrate);
		EUR.setRate(newrate);
		
		assertEquals();
	}
	
	@Test
	public void testGlobalValue() {

	}
	
	@Test
	public void testValueEnEstaDivisa() {
		fail("No implementado");
	}

}
