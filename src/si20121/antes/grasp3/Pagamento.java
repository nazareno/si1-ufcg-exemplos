package si20121.antes.grasp3;

public class Pagamento {

	private final float valor;
	private final Forma forma;
	
	public enum Forma {CARTAO, DINHEIRO};

	public Pagamento(float valor, Forma cartao) {
		this.valor = valor;
		this.forma = cartao;
	}

	/**
	 * @return the valor
	 */
	public float getValor() {
		return valor;
	}

	/**
	 * @return the forma
	 */
	public Forma getForma() {
		return forma;
	}

}
