package Money;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

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
		String msg = "Should be same cantidad";
		assertEquals(msg,10000, SEK100.getCantidad());
		assertEquals(msg,1000, EUR10.getCantidad());
		assertEquals(msg,20000, SEK200.getCantidad());
		assertEquals(msg,2000, EUR20.getCantidad());
		assertEquals(msg,0, SEK0.getCantidad());
		assertEquals(msg,0, EUR0.getCantidad());
		assertEquals(msg,-10000, SEKn100.getCantidad());
	}

	@Test
	public void testGetDivisa() {
		String msgSEK = "Should be SEK divisa";
		String msgEUR = "Should be EUR divisa";

		assertEquals(msgSEK,SEK, SEK100.getDivisa());
		assertEquals(msgEUR,EUR, EUR10.getDivisa());
		assertEquals(msgSEK,SEK, SEK200.getDivisa());
		assertEquals(msgEUR,EUR, EUR20.getDivisa());
		assertEquals(msgSEK,SEK, SEK0.getDivisa());
		assertEquals(msgEUR,EUR, EUR0.getDivisa());
		assertEquals(msgSEK,SEK, SEKn100.getDivisa());
	}

	@Test
	public void testToString() {
		String msgSEK = "Should be N SEK in string";
		String msgEUR = "Should be N EUR in string";
		
		assertEquals(msgSEK,"100.0 SEK", SEK100.toString());
		assertEquals(msgEUR,"10.0 EUR", EUR10.toString());
		assertEquals(msgSEK,"200.0 SEK", SEK200.toString());
		assertEquals(msgEUR,"20.0 EUR", EUR20.toString());
		assertEquals(msgSEK,"0.0 SEK", SEK0.toString());
		assertEquals(msgEUR,"0.0 EUR", EUR0.toString());
		assertEquals(msgSEK,"-100.0 SEK", SEKn100.toString());
	}

	@Test
	public void testGlobalValue() {
		String msg = "Should be equal global value";
		
		assertEquals(msg, (Double) (10000 * 0.15), SEK100.valorUniversal(), 0.0005);
		assertEquals(msg,(Double) (1000 * 1.5), EUR10.valorUniversal(), 0.0005);
		assertEquals(msg,(Double) (20000* 0.15), SEK200.valorUniversal(), 0.0005);
		assertEquals(msg,(Double) (2000 * 1.5), EUR20.valorUniversal(), 0.0005);
		assertEquals(msg,0, SEK0.valorUniversal());
		assertEquals(msg,0, EUR0.valorUniversal());
		assertEquals(msg,(Double) (-10000* 0.15), SEKn100.valorUniversal(), 0.0005);
	}

	@Test
	public void testEqualsMoney() {
		String msgF = "Should not have equal money";
		String msgT = "Should have equal money";
		
		assertFalse(msgF, SEK100.equals(SEK200));
		assertFalse(msgF, SEK200.equals(SEK100));
		assertFalse(msgF, EUR10.equals(EUR20));
		assertFalse(msgF, SEKn100.equals(SEK100));
		
		assertTrue(msgT, SEK100.equals(SEK100));
		assertTrue(msgT, EUR0.equals(SEK0));
	}

	@Test
	public void testAdd() {
		String msg="The Addiction is wrong";
		assertEquals(msg, 3000, SEK100.getDivisa().valorUniversal((SEK100.add(EUR10)).getCantidad()));
		assertEquals(msg, 4500, SEK200.getDivisa().valorUniversal((SEK200.add(SEK100)).getCantidad()));
		assertEquals(msg, 4500, EUR10.getDivisa().valorUniversal((EUR10.add(SEK200)).getCantidad()));
		assertEquals(msg, 3000, EUR20.getDivisa().valorUniversal((EUR20.add(SEK0)).getCantidad()));
		assertEquals(msg, 0, EUR0.getDivisa().valorUniversal((EUR0.add(SEK0)).getCantidad()));
		assertEquals(msg, -1500, EUR0.getDivisa().valorUniversal((EUR0.add(SEKn100)).getCantidad()));
	}

	@Test
	public void testSub() {
		String msg="The Substaction is wrong";
		assertEquals(msg, 0, SEK100.getDivisa().valorUniversal((SEK100.sub(EUR10)).getCantidad()));
		assertEquals(msg, 1500, SEK200.getDivisa().valorUniversal((SEK200.sub(SEK100)).getCantidad()));
		assertEquals(msg, -1500, EUR10.getDivisa().valorUniversal((EUR10.sub(SEK200)).getCantidad()));
		assertEquals(msg, 3000, EUR20.getDivisa().valorUniversal((EUR20.sub(SEK0)).getCantidad()));
		assertEquals(msg, 0, EUR0.getDivisa().valorUniversal((EUR0.sub(SEK0)).getCantidad()));
		assertEquals(msg, 1500, EUR0.getDivisa().valorUniversal((EUR0.sub(SEKn100)).getCantidad()));
	}

	@Test
	public void testIsZero() {
		String msg="Should be equal to zero";
		assertFalse(msg,  SEK100.isZero());
		assertFalse(msg, EUR10.isZero());
		assertFalse(msg, SEK200.isZero());
		assertFalse(msg,  EUR20.isZero());
		assertTrue(msg, SEK0.isZero());
		assertTrue(msg, EUR0.isZero());
		assertFalse(msg, SEKn100.isZero());
	}

	@Test
	public void testNegate() {
		String msgN="Should be Negative";
		String msgP="Should be Positive";
		String msgC="Should be Zero";
		
		assertEquals(msgN, -10000, SEK100.negate().getCantidad());
		assertEquals(msgN,-1000, EUR10.negate().getCantidad());
		assertEquals(msgN,-20000, SEK200.negate().getCantidad());
		assertEquals(msgN, -2000, EUR20.negate().getCantidad());
		assertEquals(msgC, 0, SEK0.negate().getCantidad());
		assertEquals(msgC, 0, EUR0.negate().getCantidad());
		assertEquals(msgP,10000, SEKn100.negate().getCantidad());
	}

	@Test
	public void testCompareTo() {
		String msgEq="Monedas should be equal";
		String msgLess="Monedas should be less";
		String msgGreat="Monedas should be greater";
		
		assertTrue(msgEq, SEK100.compareTo(EUR10)==0);
		assertTrue(msgEq, EUR20.compareTo(SEK200)==0);
		assertTrue(msgEq, EUR0.compareTo(SEK0)==0);
		assertTrue(msgLess, EUR10.compareTo(SEK200)<0);	
		assertTrue(msgLess, SEKn100.compareTo(SEK100)<0);
		assertTrue(msgGreat, EUR10.compareTo(SEK100)==0);
	}
}
