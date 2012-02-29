package si20112.depois.factorymethod;

public class PaginaDeConteudo implements Pagina {

	private String nome;
	private String profissao;
	private String endereco;
	private String historico;

	public PaginaDeConteudo(String nome, String profissao, String endereco,
			String historico) {
		this.nome = nome;
		this.profissao = profissao;
		this.endereco = endereco;
		this.historico = historico;
	}

	public String versaoParaImpressao() {
		String result = "Nome: " + nome;
		result += "\n\n" + profissao;
		result += "\n\n" + endereco;
		result += "\n\n" + historico;
		return result;
	}

}
