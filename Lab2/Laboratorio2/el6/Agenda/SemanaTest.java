package Agenda;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SemanaTest {
	Semana s;

	@Before
	public void setUp() throws Exception {

	}
	
	@Test
	public void testSemana() throws DatoException{
		//p1
		assertThrows(DatoException.class, () -> s = new Semana(0)); //T F
		assertThrows(DatoException.class, () -> s = new Semana(54)); //F T
		
		s = new Semana(2);
		assertEquals("s1 -> a = F, b = F", 2, s.getNumeroSemana());
		
		//p2
		assertEquals("s1 -> c = T", 2, s.getNumeroSemana());
		s = new Semana(1);
		assertEquals("s1 -> c = F", 1, s.getNumeroSemana());
		
		//p3
		s = new Semana(24);
		assertEquals("s1 -> d = T, e = T", 24, s.getNumeroSemana());
		s = new Semana(25);
		assertEquals("s1 -> d = T, e = F", 25, s.getNumeroSemana());
		s = new Semana(53);
		assertEquals("s1 -> d = F, e = T", 53, s.getNumeroSemana());
		s = new Semana(1);
		s.getDia(5);
		assertEquals("s1 -> d = F, e = F", 1, s.getNumeroSemana());

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