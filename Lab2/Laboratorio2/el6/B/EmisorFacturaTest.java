package B;
import static org.mockito.Mockito.*;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class EmisorFacturaTest {
	private EmisorFactura emisorFactura;
	private Cliente cliente;
	private Factura factura = mock(Factura.class);
	private EmailService emailService = mock(EmailService.class);
	private PrinterService printerService = mock(PrinterService.class);
	
	@Before
	public void setUp() throws Exception {
		emisorFactura=new EmisorFactura(printerService,emailService);
		
	}
	
	@Test
	public void testEmail() {
		cliente = new Cliente("facturaEmail", true);
		
		emisorFactura.emitirFactura(factura, cliente);
		
		verify(emailService).sendFactura(factura,"facturaEmail");
		verify(printerService, never()).printFactura(factura);
	}
	
	@Test
	public void testPapel() {	
		cliente = new Cliente("facturaEmail", false);
		
		emisorFactura.emitirFactura(factura, cliente);
		
		verify(printerService).printFactura(factura);
		verify(emailService, never()).sendFactura(any(), anyString());
	}
}