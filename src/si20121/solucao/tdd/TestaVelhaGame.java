package si20121.solucao.tdd;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class TestaVelhaGame {

	private VelhaGame jogo;

	@Before
	public void setup() {
		jogo = new VelhaGame();
	}
	
	@Test
	public void testFimPorOcupacao() throws Exception {
		// preenche todos os campos
		for (int linha = 1; linha < 4; linha++) {
			assertFalse("Acabou na jogada errada: linha " + linha + jogo.toString(), jogo.isAcabado());
			for (int coluna = 1; coluna < 4; coluna++) {
				jogo.joga(linha, coluna);
			}
		}
		
		// cheio = fim
		assertTrue(jogo.isAcabado());
	}

	@Test
	public void testImpossivelReusarCampo() throws Exception {
		jogo.joga(1, 1);
		jogo.joga(2, 2);
		jogo.joga(3, 3);
		
		try {
			jogo.joga(2, 2);
			fail("Duas jogadas no mesmo campo");
		} catch (JogadaInvalidaException e) {
			// ok
		}
		
		jogo.joga(1, 2);
		jogo.joga(2, 1);
	}
	
	@Test
	public void testaAlternaJogador() throws Exception {
		jogo.joga(1, 1);
		jogo.joga(2, 2);
		jogo.joga(3, 3);
		
		assertEquals(VelhaGame.Jogador.J1, jogo.getDono(1,1));
		assertEquals(VelhaGame.Jogador.J1, jogo.getDono(3,3));
		assertEquals(VelhaGame.Jogador.J2, jogo.getDono(2,2));
	}

	@Test
	public void testaGanhadorInicial() throws Exception {
		assertNull(jogo.getGanhador());
	}
	
	@Test
	public void testaVitoriaPorLinha() throws Exception {
		jogo.joga(1,1); //1
		jogo.joga(2,1); //2
		jogo.joga(1, 2); //1 
		jogo.joga(2, 2); //2
		assertFalse(jogo.isAcabado());
		assertNull(jogo.getGanhador());
		jogo.joga(1, 3); //1
		assertTrue(jogo.isAcabado());
		assertEquals(VelhaGame.Jogador.J1, jogo.getGanhador());
	}

}
