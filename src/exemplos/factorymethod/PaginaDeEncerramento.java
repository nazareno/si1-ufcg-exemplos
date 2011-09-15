package exemplos.factorymethod;

public class PaginaDeEncerramento implements Pagina {

	private final String outrasInfos;
	private final String nome;

	public PaginaDeEncerramento(String nome, String outrasInfos) {
		this.nome = nome;
		this.outrasInfos = outrasInfos;
	}

	@Override
	public String versaoParaImpressao() {
		return nome.toLowerCase() + "\n" + outrasInfos;
	}
}
