package si20121.depois;

/**
 * Depois de fazer os testes, dá pra escrever um javadoc bacana sobre essa
 * classe explicando as decisões que importam para alguém que vá usaá-la, como a
 * existência do enum Jogador, a semântica de null em getGanhador e a
 * alternância implícita dos jogadores em joga().
 * 
 * @author nazareno
 * 
 */
public class VelhaGame {

	public enum Jogador {
		J1, J2
	};

	private int ocupados;
	private Jogador ganhador = null;
	private Jogador[][] tabuleiro;

	public VelhaGame() {
		tabuleiro = new Jogador[3][3];
	}

	/**
	 * @return true se o tabuleiro foi todo ocupado (não há ganhador) ou se
	 *         alguém ganhou o jogo.
	 */
	public boolean isAcabado() {
		return ocupados == 9 || ganhador != null;
	}

	public void joga(int linha, int coluna) throws JogadaInvalidaException {
		if (tabuleiro[linha - 1][coluna - 1] != null) {
			throw new JogadaInvalidaException("Campo já ocupado.");
		}

		Jogador naVez = getJogadorNaVez();
		marcaJogada(linha, coluna, naVez);
		atualizaGanhador(linha, naVez);
	}

	/**
	 * @return
	 */
	private Jogador getJogadorNaVez() {
		Jogador naVez = ocupados % 2 == 0 ? Jogador.J1 : Jogador.J2;
		return naVez;
	}

	/**
	 * @param linha
	 * @param coluna
	 * @param naVez
	 */
	private void marcaJogada(int linha, int coluna, Jogador naVez) {
		tabuleiro[linha - 1][coluna - 1] = naVez;
		ocupados++;
	}

	/**
	 * @param linhaJogada
	 * @param jogadorQueJogou
	 */
	private void atualizaGanhador(int linhaJogada, Jogador jogadorQueJogou) {
		if (tabuleiro[linhaJogada - 1][0] == tabuleiro[linhaJogada - 1][1]
				&& tabuleiro[linhaJogada - 1][1] == tabuleiro[linhaJogada - 1][2]) {
			ganhador = jogadorQueJogou;
		}
	}

	public Jogador getDono(int linha, int coluna) {
		return tabuleiro[linha - 1][coluna - 1];
	}

	/**
	 * J1, J2 ou null, se ninguém ganhou.
	 * 
	 * @return o ganhador da partida, se existir.
	 */
	public Jogador getGanhador() {
		return ganhador;
	}

	public String toString() {
		String tabuleiroString = "";
		for (int l = 0; l < 3; l++) {
			for (int c = 0; c < 3; c++) {
				tabuleiroString += tabuleiro[l][c] + ", ";
			}
		}
		return tabuleiroString;
	}

}
