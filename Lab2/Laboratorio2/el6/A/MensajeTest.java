package A;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MensajeTest {
	private Mensaje mensaje;
	private Cliente cliente = mock(Cliente.class);
	private Template template = mock(Template.class);
	private TemplateEngine templateE = mock(TemplateEngine.class);
	private MailServer mailServer = mock(MailServer.class);
	
	@Before
	public void setUp() throws Exception {
		mensaje = new Mensaje(mailServer, templateE);
	}
	
	@Test
	public void testMensaje() {
		mensaje.sendMensaje(cliente, template);
		
		when(cliente.getEmail()).thenReturn("DAnlles friki");
		
		verify(mailServer).send(cliente.getEmail(), "DAnlles friki");;
	}
		
}
