package si2012.durante.tdd;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestaJogoDaVelha {

	private JogoDaVelha jogo;

	@Before
	public void setUp() throws Exception {
		jogo = new JogoDaVelha();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testFimPorCompletude() throws Exception {

		for (int linha = 1; linha <= 3; linha++) {
			for (int coluna = 1; coluna <= 3; coluna++) {
				assertFalse(jogo.isAcabado());
				jogo.joga(linha, coluna);
			}
		}

		assertTrue(jogo.isAcabado());
	}

	@Test
	public void testaAlternancia() throws Exception {
		jogo.joga(1, 1);
		assertEquals(JogoDaVelha.Jogador.J1, jogo.getDono(1, 1));
		jogo.joga(2, 1);
		assertEquals(JogoDaVelha.Jogador.J2, jogo.getDono(2, 1));
		jogo.joga(3, 1);
		assertEquals(JogoDaVelha.Jogador.J1, jogo.getDono(3, 1));
	}

	@Test
	public void testaJogadaEmCasaOcupada() throws Exception {
		try {
			jogo.joga(1, 1);
			jogo.joga(1, 1);
			fail("Jogou duas vezes na mesma casa.");
		} catch (JogadaInvalidaException e) {
			// ok
		}
	}

}
