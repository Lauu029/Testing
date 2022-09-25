package Money;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Money.Divisa;
import Money.Money;

public class MoneyTestTemplate {
	Divisa SEK, DKK, NOK, EUR;
	Money SEK100, EUR10, SEK200, EUR20, SEK0, EUR0, SEKn100;
	
	@Before
	public void setUp() throws Exception {
		
		SEK = new Divisa("SEK", 0.15);
		DKK = new Divisa("DKK", 0.20);
		EUR = new Divisa("EUR", 1.5);
		
		SEK100 = new Money(10000, SEK);
		EUR10 = new Money(1000, EUR);
		SEK200 = new Money(20000, SEK);
		EUR20 = new Money(2000, EUR);
		SEK0 = new Money(0, SEK);
		EUR0 = new Money(0, EUR);
		SEKn100 = new Money(-10000, SEK);
	}

	@Test
	public void testGetCantidad() {
		fail("No implementado");
	}

	@Test
	public void testGetDivisa() {
		fail("No implementado");
	}

	@Test
	public void testToString() {
		fail("No implementado");
	}

	@Test
	public void testGlobalValue() {
		fail("No implementado");
	}

	@Test
	public void testEqualsMoney() {
		fail("No implementado");
	}

	@Test
	public void testAdd() {
		fail("No implementado");
	}

	@Test
	public void testSub() {
		fail("No implementado");
	}

	@Test
	public void testIsZero() {
		String msg="Should be a different result";
		assertEquals(msg, false, SEK100.isZero());
		assertEquals(msg,false, EUR10.isZero());
		assertEquals(msg,false, SEK200.isZero());
		assertEquals(msg, false, EUR20.isZero());
		assertEquals(msg,true, SEK0.isZero());
		assertEquals(msg,true, EUR0.isZero());
		assertEquals(msg,false, SEKn100.isZero());
	}

	@Test
	public void testNegate() {
		String msg="Should be a different result";
		
		assertEquals(msg, -10000, SEK100.negate());
		assertEquals(msg,-1000, EUR10.negate());
		assertEquals(msg,-20000, SEK200.negate());
		assertEquals(msg, -2000, EUR20.negate());
		assertEquals(msg,0, SEK0.negate());
		assertEquals(msg,0, EUR0.negate());
		assertEquals(msg,10000, SEKn100.negate());
	}

	@Test
	public void testCompareTo() {
		
		fail("No implementado");		
	}
}
