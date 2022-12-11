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
	//Test CACC
	public void testDiaCACC() throws DatoException {
		assertThrows("p1 -> a = T, b = F", DatoException.class, () -> d = new Dia(0)); //T F
		assertThrows("p1 -> a = F, b = T", DatoException.class, () -> d = new Dia(366)); //F T
		
		d = new Dia(2);
		
		assertEquals("p1 -> a = F, b = F", 2, d.getDiaNumero()); //F F
		
	}
	
	@Test
	//Test CACC
	public void testBuscaSlotCACC() throws DatoException {
		//p1
		
		d = new Dia(1);
		assertEquals("p1 -> a = T", 9, d.buscaSlot(9)); //T
		assertEquals("p1 -> a = F", -1, d.buscaSlot(10)); //F

		//p2
		Cita c1 = new Cita("a", 9);
		d.asignarCita(9, c1);
		assertEquals("p2 -> b = F", -1, d.buscaSlot(2));
		
		d = new Dia(1);
		assertEquals("p2 -> b = T", 9, d.buscaSlot(1));
		
		//p3
		assertEquals("p3 -> c = T", 9, d.buscaSlot(1));
		assertEquals("p3 -> c = F", 9, d.buscaSlot(2));

		//p4
		assertEquals("p4 -> d = T, e = T, f = T", 9, d.buscaSlot(2)); // T
		
		
		d = new Dia(1);
		c1 = new Cita("a", 8);
		d.asignarCita(9, c1);
		assertEquals("p4 -> d = T, e = T, f = F", -1, d.buscaSlot(2)); //T
		assertEquals("p4 -> d = T, e = F, f = T", 17, d.buscaSlot(1)); //T
		assertEquals("p4 -> d = T, e = F, f = F", -1, d.buscaSlot(10));

		d = new Dia(1);
		assertEquals("p4 -> d = F, e = T, f = T", -1, d.buscaSlot(0));
		c1 = new Cita("a", 8);
		d.asignarCita(9, c1);
		assertEquals("p4 -> d = F, e = T, f = F", -1, d.buscaSlot(0));
		//assertEquals("p4 -> d = F, e = F, f = T", 9, d.buscaSlot(2)); //Imposible
		//assertEquals("p4 -> d = F, e = F, f = F", 9, d.buscaSlot(2)); //Imposible

		
		//p5
		d = new Dia(1);
		assertEquals("p5 -> g = T", 9, d.buscaSlot(2));
		c1 = new Cita("b", 1);
		d.asignarCita(9, c1);
		assertEquals("p5 -> g = F", 10, d.buscaSlot(2));

	}
	
	@Test
	//Test CACC
	public void testAsignarCitaCACC() throws DatoException {
		//p1
		
		d = new Dia(1);
		Cita c1 = new Cita("a", 2);
		
		assertTrue("p1 -> a = T, b = T", d.asignarCita(9, c1)); 
		
		//Cita c2 = new Cita("b", 10);
		
		//assertFalse("p1 -> a = T, b = F", d.asignarCita(11, c2));
		
		Cita c3 = new Cita("c", 2);
		
		assertFalse("p1 -> a = F, b = T", d.asignarCita(6, c3)); 
		
		//p2
		
		Cita c4 = new Cita("c", 1);
		d.asignarCita(11, c4);
		assertEquals("p2 -> c = T", c4, d.getCita(11)); 
		
		Cita c5 = new Cita("c", 0);
		d.asignarCita(12, c5);
		
		assertNotEquals("p2 -> c = F", c5, d.getCita(12)); 
		
	}
	
	@Test
	//Test CACC
	public void testMuestraCitaCACC() throws DatoException {
		//p1
		d = new Dia(1);
		Cita c1 = new Cita("a", 2);
		d.asignarCita(9, c1);
		
		assertEquals("p1 -> a = T && p2 -> b = T", "9:00 a", d.muestraCita(9)); 
		
		assertEquals("p1 -> a = F", "Hora no valida", d.muestraCita(6)); 
		
		//p2
		
		assertEquals("p1 -> b = F", "No existe", d.muestraCita(11)); 
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