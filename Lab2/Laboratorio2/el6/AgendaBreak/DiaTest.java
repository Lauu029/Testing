package AgendaBreak;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DiaTest {
	Dia d;
	@Before
	public void setUp() throws Exception {

	}
	
	@Test
	//Test Prime path Coverage
	public void testBuscaSlot() throws DatoException {
		d = new Dia(1);
	
		//Camino 3
		assertEquals("Should be 9", 9, d.buscaSlot(1));
		
		//Camino de test 2
		Cita c1 = new Cita("a",2);
		d.asignarCita(9, c1);
				
		assertEquals("Should be 11", 11, d.buscaSlot(2));
		
		//Camino de test 1
		Cita c2 = new Cita("b",1);
		d.asignarCita(12, c2);
		
		Cita c3 = new Cita("c",3);
		d.asignarCita(14, c3);
		
		assertEquals("Should be 14", -1, d.buscaSlot(2));
		
	}
}