package Agenda;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DiaTest {
	@Before
	public void setUp() throws Exception {

	}
	
	@Test
	public void testEquals() throws DatoException {
		Dia d = new Dia(1);
		
		assertEquals("Should be No citable", "No citable", d.buscaSlot(20));
	}
}
