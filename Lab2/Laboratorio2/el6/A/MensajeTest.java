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
		when(cliente.getEmail()).thenReturn("Danlles");
		when(templateE.preparaMensaje(template, cliente)).thenReturn("Danlles friki");
		
		mensaje.sendMensaje(cliente, template);
		
		verify(mailServer).send("Danlles", "Danlles friki");;
	}
}