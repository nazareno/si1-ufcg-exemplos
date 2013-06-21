package durante.tdd;

public class JogoDaVelha {

	private int numEspacosOcupados;
	private boolean[][] espacosOcupados;

	public JogoDaVelha() {
		espacosOcupados = new boolean[3][3];
	}

	/**
	 * Jogadas são automaticamente alternadas. Índices vão de 0 a 2.
	 * 
	 * @param i
	 * @param j
	 * @throws JogadaInvalidaException
	 */
	public void novaJogada(int i, int j) throws JogadaInvalidaException {
		if (espacosOcupados[i][j] == true) {
			throw new JogadaInvalidaException();
		}

		espacosOcupados[i][j] = true;
		numEspacosOcupados++;
	}

	public int getEspacosOcupados() {
		return numEspacosOcupados;
	}

}
