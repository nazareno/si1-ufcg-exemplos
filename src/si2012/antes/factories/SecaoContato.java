package si2012.antes.factories;

public class SecaoContato implements Secao {

	private final String endereco;

	public SecaoContato(String endereco) {
		this.endereco = endereco;
	}

	@Override
	public String getConteudo() {
		return endereco;
	}

}
