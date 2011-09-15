package exemplos.abstractfactory;

public class Fornecedor {

	private final String nome;
	private final String email;
	private final String restUrl;

	public Fornecedor(String nome, String email) {
		this(nome, email, null);
	}

	public Fornecedor(String nome, String email, String restUrl) {
		this.nome = nome;
		this.email = email;
		this.restUrl = restUrl;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @return the restUrl
	 */
	public String getRestUrl() {
		return restUrl;
	}

	public boolean hasRestUrl() {
		return getRestUrl() != null;
	}


}
