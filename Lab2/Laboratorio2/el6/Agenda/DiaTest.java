package Agenda;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DiaTest {
	@Before
	public void setUp() throws Exception {

	}
	
	@Test
	public void testBuscaSlot() throws DatoException {
		Dia d = new Dia(1);

		//Camino 3
		assertEquals("Should be 9", 9, d.buscaSlot(1));
		
		//Camino de test 2
		Cita c1 = new Cita("a",2);
		d.asignarCita(9, c1);
				
		assertEquals("Should be 11", 11, d.buscaSlot(2));
		
		//Camino de test 1
		Cita c2 = new Cita("b",1);
		d.asignarCita(12, c2);
		
		Cita c3 = new Cita("c",4);
		d.asignarCita(13, c3);
		
		assertEquals("Should be 14", -1, d.buscaSlot(2));
		
	}
}
