package Agenda;

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
		assertThrows(DatoException.class, () -> d = new Dia(0)); //T F
		assertThrows(DatoException.class, () -> d = new Dia(366)); //F T
		
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
		
		//p3
		
		//p4
		
		//p5
		
	}
	
	@Test
	//Test CACC
	public void testAsignarCitaCACC() throws DatoException {
		//p1
		
		d = new Dia(1);
		Cita c1 = new Cita("a",2);
		
		assertTrue("p1 -> a = T, b = T", d.asignarCita(9, c1)); //T T
		
		
		assertEquals("Should be -1", -1, d.buscaSlot(10)); //F T

		//p2
		//p3
		//p4
		//p5
		
	}
	
	@Test
	//Test PPC
	public void testBuscaSlotPPC() throws DatoException {
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
