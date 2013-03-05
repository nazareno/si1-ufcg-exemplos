package si20121.durante.tdd;

import si20121.durante.tdd.OldGame.Jogador;

public class OldGame {

	public enum Jogador {
		J1, J2
	};

	private boolean ehJogador1;
	private Jogador[][] casas;

	public OldGame() {
		ehJogador1 = true;
		casas = new Jogador[3][3];
	}

	public Jogador quemJoga() {
		if (ehJogador1) {
			return Jogador.J1;
		} else {
			return Jogador.J2;
		}
	}

	public void joga(int linha, int coluna) {
		if (casas[linha][coluna] == null) {
			casas[linha][coluna] = quemJoga();
			ehJogador1 = !ehJogador1;
		} else {
			// TODO jogar exceção
		}
	}

	public Jogador deQuemEh(int linha, int coluna) {
		return casas[linha][coluna];
	}

}
