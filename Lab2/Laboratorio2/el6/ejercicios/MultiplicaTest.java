package ejercicios;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

//Laura Gómez Bodego
//Sergio José Alfonso Rojas
//Daniel Illanes Morillas

public class MultiplicaTest {
	Multiplica mul;
	
	@Before
	public void setUp() throws Exception {
		mul = new Multiplica();
	}

	//a) parámetros de entrada: array1, array2
	//b) características:
	//		array1 null-> true/ false --> a1,a2
	//		array2 null-> true/false --> b1,b2
	//		relacion longitudes-> array1 > array2/ array 1 < array2/ array1== array2 --> c1,c2,c3
	//c) BCC-> todos los casos base variando para crear las combinaciones
	//	 PWC-> a2,b2,c1/ a2,b2,c2/ a2,b2,c3
	
	@Test
	public void testA2B2C1() {
		int[] array1= {1,0,2};
		int[] array2= {2,3};
		int[] result= {2,0,2};
		int[] outarray= mul.multiplica(array1,array2);

		assertEquals("testA2B2C1 - 1", result[0], outarray[0]);
		assertEquals("testA2B2C1 - 2", result[1], outarray[1]);
		assertEquals("testA2B2C1 - 3", result[2], outarray[2]);
	}
	@Test
	public void testA2B2C2() {
		int[] array1= {2,3};
		int[] array2= {1,0,2};
		int[] result= {2,0,2};
		int[] outarray= mul.multiplica(array1,array2);

		assertEquals("testA2B2C2 - 1", result[0], outarray[0]);
		assertEquals("testA2B2C2 - 2", result[1], outarray[1]);
		assertEquals("testA2B2C2 - 3", result[2], outarray[2]);
	}
	@Test
	public void testA2B2C3() {
		int[] array1= {1,0,2};
		int[] array2= {1,0,2};
		int[] result= {1,0,4};
		int[] outarray= mul.multiplica(array1,array2);
		
		assertEquals("testA2B2C3 - 1", result[0], outarray[0]);
		assertEquals("testA2B2C3 - 2", result[1], outarray[1]);
		assertEquals("testA2B2C3 - 3", result[2], outarray[2]);
	}
	@Test
	public void testA1B2C2() {
		int[] array1= null;
		int[] array2= {1,0,2};
		assertThrows("testA1B2C2", NullPointerException.class, () -> mul.multiplica(array1,array2));
	}
	@Test
	public void testA2B1C2() throws NullPointerException {
		int[] array1= {1,0,2};
		int[] array2= null;
		NullPointerException expected;
		expected = assertThrows("testA2B1C2", NullPointerException.class, () -> mul.multiplica(array1,array2));
	}
}