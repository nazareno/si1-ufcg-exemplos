package exemplos.strategy.treeset;

public class AlgumDado {

	private final String nome;
	private final int valor;

	public AlgumDado(String nome, int valor) {
		this.nome = nome;
		this.valor = valor;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @return the valor
	 */
	public int getValor() {
		return valor;
	}

	@Override
	public boolean equals(Object obj) {
		AlgumDado outro = (AlgumDado) obj;
		return this.nome.equals(outro.nome) && (this.valor == outro.valor);
	}
	
	
}
