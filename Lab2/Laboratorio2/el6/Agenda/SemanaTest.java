package Agenda;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SemanaTest {
	@Before
	public void setUp() throws Exception {

	}
	
	@Test
	public void testDiaSemana() throws DatoException {	
		Semana s = new Semana(3);
		
		assertEquals("Should be No citable", s.diaSemana(0), "No citable");
		assertEquals("Should be Lunes", s.diaSemana(1), "Lunes");
		assertEquals("Should be Martes", s.diaSemana(2), "Martes");
		assertEquals("Should be Miercoles", s.diaSemana(3), "Miercoles");
		assertEquals("Should be Jueves", s.diaSemana(4), "Jueves");
		assertEquals("Should be Viernes", s.diaSemana(5), "Viernes");
	}
}