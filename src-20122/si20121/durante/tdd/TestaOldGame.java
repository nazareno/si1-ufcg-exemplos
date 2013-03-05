package si20121.durante.tdd;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestaOldGame {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testaJogadaAlternada() throws Exception {
		OldGame jogo = new OldGame();

		OldGame.Jogador jogador = jogo.quemJoga();

		jogo.joga(0, 2);

		OldGame.Jogador novoJogador = jogo.quemJoga();

		assertNotSame(jogador, novoJogador);

		jogo.joga(1, 2);

		OldGame.Jogador terceiroJogador = jogo.quemJoga();

		assertEquals(jogador, terceiroJogador);
	}

	@Test
	public void testaJogadasNaMesmaCasa() throws Exception {
		OldGame jogo  = new OldGame();
		
		// jogador 1
		jogo.joga(1, 1);
		OldGame.Jogador dono = jogo.deQuemEh(1, 1);
		assertEquals(OldGame.Jogador.J1, dono);
		
		// vez do jogador 2
		OldGame.Jogador jogador = jogo.quemJoga();
		
		// testar jogar exceção
		jogo.joga(1, 1);
		
		assertEquals(OldGame.Jogador.J1, dono);
		
		// deve ser a vez do jogador 2 ainda
		OldGame.Jogador naVez = jogo.quemJoga();
		
		assertEquals("A vez deve ficar em quem jogou errado", jogador, naVez);

	}
}
