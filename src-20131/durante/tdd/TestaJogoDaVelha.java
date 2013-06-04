package durante.tdd;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestaJogoDaVelha {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testaColocaJogada() throws Exception {
		JogoDaVelha jogo = new JogoDaVelha();
		assertEquals(0, jogo.getEspacosOcupados());
		
		jogo.novaJogada(0, 0);
		assertEquals(1, jogo.getEspacosOcupados());
		
		try{
			jogo.novaJogada(0, 0);
			fail("Deveria jogar excecao por espaco ocupado");
		}catch(JogadaInvalidaException e){
			// ok
		}
		assertEquals(1, jogo.getEspacosOcupados());
	}
	
	
}
