package Money;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


import static org.junit.Assert.*;

public class CuentaTestTemplate {
	
	Divisa SEK, DKK;
	Banco Nordea;
	Banco DanskeBanco;
	Banco SweBanco;
	Cuenta testAccount;
	Money importe;
	
	@Before
	public void setUp() throws Exception {
		
		SEK = new Divisa("SEK", 0.15);
		SweBanco = new Banco("SweBanco", SEK);
		
	}
	

	@Test
	public void testGetSaldo() {
		fail("No implementado");
	}
	
		
	@Test
	public void testAnadirPagoPeriodico() throws PagoExistenteException{
		fail("No implementado");
	}
	
	@Test
	public void testAnadirPagoPeriodicoException() throws PagoExistenteException{
		fail("No implementado");
	}
	
	@Test
	public void testBorrarPagoPeriodico()  throws PagoNoExistenteException, PagoExistenteException {
		fail("No implementado");
	}
	
	@Test
	public void testBorrarPagoPeriodicoException()  throws PagoNoExistenteException {
		fail("No implementado");
	}
	
	@Test
	public void testPagoPeriodicoExiste() throws PagoNoExistenteException,PagoExistenteException{
		fail("No implementado");
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