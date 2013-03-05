package si20121.solucao.strategy.treeset;


public class Sessao {

	private final String login;
	private final int id;

	public Sessao(String nome, int valor) {
		this.login = nome;
		this.id = valor;
	}

	/**
	 * @return the nome
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @return the valor
	 */
	public int getId() {
		return id;
	}

	@Override
	public boolean equals(Object obj) {
		Sessao outro = (Sessao) obj;
		return this.login.equals(outro.login) && (this.id == outro.id);
	}
	
	
}
