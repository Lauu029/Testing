package ejemplo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ejemploTest {

	@Before
	public void setUp() throws Exception {
		//mul = new Multiplica();
	}
	
	@Test
	public void testThrowEsception() throws NullPointerException {
//		NullPointerException expected;
//		int[] array1= null;
//		int[] array2= {1,0,2};
//		expected = assertThrows("testA1B2C2", NullPointerException.class, () -> mul.multiplica(array1,array2));
	}
	@Test
	public void testEquals() {
		String msg = "Should be equal global value";
		
//		assertEquals(msg, (Double) (10000 * 0.15), SEK100.valorUniversal(), 0.0005);
// 		assertEquals(msgSEK,"200.0 SEK", SEK200.toString());
//		assertEquals(msg,0, EUR0.valorUniversal());
	}
	
	@Test
	public void testTrue() {
		String msgF = "Should not have equal money";
		String msgT = "Should have equal money";
		
//		assertFalse(msgF, SEK100.equals(SEK200));
//		
//		assertTrue(msgT, SEK100.equals(SEK100));
	}
	
	//assertNull
	//assertNotNull
	//assertNotEquals
	//assertArrayEquals -> misma array objetos mismo orden
	//assertSame -> mismo objeto
	//assertNotSame
}
