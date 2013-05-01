package si2012.antes.singleton;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class SingletonTest {

	private Modulo1 cliente1;
	private Modulo2 cliente2;

	@Before
	public void setUp() throws Exception {
		cliente1 = new Modulo1();
		cliente2 = new Modulo2();
	}

	@Test
	public void testaDoisClientes() throws Exception {
		assertEquals(cliente1.getConfiguracao(), cliente2.getConfiguracao());
	}

	@Test
	public void testaModificacaoDeConfig() throws Exception {
		assertEquals(0, cliente2.getTimeout());
		cliente1.modificaTimeout(50);
		assertEquals(50, cliente2.getTimeout());
	}

	@Test
	public void testaConfiguracaoInvalida() throws Exception {
		// testar se timeout negativo dah erro
	}

	@Test
	public void testaComConfiguracaoDefault() throws Exception {
		// testar se os defaults funcionam
	}
}
