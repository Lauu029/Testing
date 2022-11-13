package C;
import static org.mockito.Mockito.*;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class WebVerificatorTest {
	private WebVerificator webVerificator;
	private Logger logger = mock(Logger.class);
	private Result result = mock(Result.class);
	private Server server = mock(Server.class);
	private Web web = mock(Web.class);
	
	@Before
	public void setUp() throws Exception {
		webVerificator = new WebVerificator(logger);
	}
	
	@Test
	public void testWebOK() {
		when(server.connect(web)).thenReturn(result);
		when(result.isOk()).thenReturn(true);
		
		webVerificator.checkWeb(server, web);
		
		verify(logger).registerWebisOk(web);
		verify(logger, never()).registerWebReturnedError(web, result);
	}
	
	@Test
	public void testWebError() {	
		when(server.connect(web)).thenReturn(result);
		when(result.isOk()).thenReturn(false);
		
		webVerificator.checkWeb(server, web);
		
		verify(logger).registerWebReturnedError(web, result);
		verify(logger, never()).registerWebisOk(web);
	}
}