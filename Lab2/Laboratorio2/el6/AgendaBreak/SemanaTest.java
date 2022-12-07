package AgendaBreak;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SemanaTest {
	@Before
	public void setUp() throws Exception {

	}
	
	@Test
	public void testDiaSemana() throws DatoException {	
		Semana s = new Semana(0);
		
		assertEquals("Should be No citable", "No citable", s.diaSemana(0));
		assertEquals("Should be Lunes", "Lunes", s.diaSemana(1));
		assertEquals("Should be Martes", "Martes", s.diaSemana(2));
		assertEquals("Should be Miercoles", "Miercoles", s.diaSemana(3));
		assertEquals("Should be Jueves", "Jueves", s.diaSemana(4));
		assertEquals("Should be Viernes", "Viernes", s.diaSemana(5));
	}
}