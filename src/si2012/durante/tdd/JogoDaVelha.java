package si2012.durante.tdd;

public class JogoDaVelha {

	public enum Jogador {
		J1, J2
	};

	private int ocupadas;
	private Jogador[][] tabuleiro;

	public JogoDaVelha() {
		tabuleiro = new Jogador[3][3];
	}

	public boolean isAcabado() {
		return ocupadas == 9;
	}

	public void joga(int linha, int coluna) throws JogadaInvalidaException {

		Jogador jogadorDaVez = ocupadas % 2 == 0 ? Jogador.J1 : Jogador.J2;

		tabuleiro[linha - 1][coluna - 1] = jogadorDaVez;

		ocupadas++;
	}

	/**
	 * Retorna o jogador que tem uma peça na casa, ou null, se ninguém tiver.
	 * 
	 * @return Jogador ou null;
	 */
	public Jogador getDono(int linha, int coluna) {
		return tabuleiro[linha - 1][coluna - 1];
	}

}
