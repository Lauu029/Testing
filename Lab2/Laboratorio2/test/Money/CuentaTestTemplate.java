package Money;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import org.junit.runner.RunWith;
//import junitparams.JUnitParamsRunner;
//import junitparams.Parameters;

import static org.junit.Assert.*;

public class CuentaTestTemplate {
	
	Divisa SEK, DKK;
	Banco Nordea, DanskeBanco, SweBanco;
	Cuenta testAccount1, testAccount2;
	Money importe;
	
	@Before
	public void setUp() throws Exception {
		
		SEK = new Divisa("SEK", 0.15);
		DKK = new Divisa("DKK", 1.5);
		testAccount1 = new Cuenta("testAccount1", SEK);
		testAccount2 = new Cuenta("testAccount2", DKK);	
		testAccount1.pagoPeriodico("dos cheeseburguers", new Money(10,DKK), testAccount2);
	}
//	private static final Object[] getCuenta() {
//		return new Object[] {
//				new Object[] {"testAccount1", "SEK", 0.15},
//				new Object[] {"testAccount2", "EUR", 1.5}		
//		};
//	}

	
	public void testGetSaldo() {
		assertEquals("Concha", testAccount1.getSaldo(), new Money(0,SEK));
		assertEquals("Concha", testAccount2.getSaldo(), new Money(0,DKK));
	}
	
		
	@Test
	public void testAnadirPagoPeriodico() throws PagoExistenteException{
		testAccount1.pagoPeriodico("pa misiles de siria", new Money(10,DKK), testAccount2);
		assertTrue(testAccount1.pagoPeriodicoExiste("pa misiles de siria"));
	}
	
	@Test(expected = PagoExistenteException.class)
	public void testAnadirPagoPeriodicoException() throws PagoExistenteException{
			testAccount1.pagoPeriodico("pa misiles de siria", new Money(10,DKK), testAccount2);
			testAccount1.pagoPeriodico("pa misiles de siria", new Money(10,DKK), testAccount2);
	}
	
	@Test
	public void testBorrarPagoPeriodico()  throws PagoNoExistenteException, PagoExistenteException {
		testAccount1.pagoPeriodico("aguanta", new Money(10,DKK), testAccount2);
		assertTrue(testAccount1.pagoPeriodicoExiste("aguanta"));
		testAccount1.cancelarPagoPeriodico("aguanta");
		assertFalse(testAccount1.pagoPeriodicoExiste("aguanta"));
	}
	
	@Test(expected = PagoNoExistenteException.class)
	public void testBorrarPagoPeriodicoException()  throws PagoNoExistenteException {
		testAccount1.cancelarPagoPeriodico("ahuevo");
	}
	
	@Test
	public void testPagoPeriodicoExiste() throws PagoNoExistenteException,PagoExistenteException{
		assertTrue(testAccount1.pagoPeriodicoExiste("dos cheeseburguers"));
	}
	
	@Test
	public void testdeposito() {
		fail("No implementado");
	}

	@Test
	public void testReintegro() {
		fail("No implementado");
	}
}

