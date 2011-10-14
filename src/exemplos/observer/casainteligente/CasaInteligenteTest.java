package exemplos.observer.casainteligente;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class CasaInteligenteTest {

	private static final String TELEFONE_DO_DONO = "83 8888-9999";
	private TelefoneInteligente telefone;
	private Microondas microondas;
	private ArCondicionado arCondicionado;

	@Before
	public void setUp() throws Exception {
		this.telefone = new TelefoneInteligente(TELEFONE_DO_DONO);
		this.microondas = new Microondas();
		this.arCondicionado = new ArCondicionado();
		
		telefone.addListener(microondas);
		telefone.addListener(arCondicionado);
	}

	@Test
	public void testaAtivacaoPorLigacao() throws Exception {
		assertFalse(microondas.isLigado());
		assertEquals(ArCondicionado.Potencia.BAIXA, arCondicionado.getPotencia());
		
		telefone.novaChamada("83 9999-1234"); // outro telefone
		
		// nada acontece:
		assertFalse(microondas.isLigado());
		assertEquals(ArCondicionado.Potencia.BAIXA, arCondicionado.getPotencia());
		
		telefone.novaChamada(TELEFONE_DO_DONO); // meu telefone
		
		// mágica!
		assertTrue(microondas.isLigado());
		assertEquals(ArCondicionado.Potencia.ALTA, arCondicionado.getPotencia());
	}
	
}
