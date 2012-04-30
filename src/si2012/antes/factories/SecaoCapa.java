package si2012.antes.factories;

public class SecaoCapa implements Secao {

	private String nome;

	public SecaoCapa(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String getConteudo() {
		return this.nome;
	}

	
}
