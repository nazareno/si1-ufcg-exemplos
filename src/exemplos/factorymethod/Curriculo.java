package exemplos.factorymethod;

import java.util.LinkedList;
import java.util.List;

import com.sun.tools.corba.se.idl.InvalidArgument;

public class Curriculo {

	private List<Pagina> paginas;

	public Curriculo(String nome, String profissao, String endereco,
			String historico, String outrasInfos) throws InvalidArgument {

		this.paginas = montaCurriculo(nome, profissao, endereco, historico,
				outrasInfos);
	}

	protected List<Pagina> montaCurriculo(String nome, String profissao,
			String endereco, String historico, String outrasInfos) throws InvalidArgument {
		List<Pagina> paginas = new LinkedList<Pagina>();

		/*
		 * Imagine que aqui tem bastante código tratando entradas e gerando mais
		 * informação a partir do que foi dado pelo usuário.
		 * 
		 * Por exemplo, tem o link do currículo lattes dele e não geramos mais
		 * dados.
		 */

		if(! validaNome(nome)){
			throw new InvalidArgument("é necessário sobrenome");
		}
		
		paginas.add(new PaginaDeRosto(nome));
		paginas
				.add(criaPaginaDeConteudo(nome, profissao, endereco, historico));
		paginas.add(new PaginaDeEncerramento(nome, outrasInfos));

		return paginas;
	}

	/**
	 * @param nome
	 * @param profissao
	 * @param endereco
	 * @param historico
	 * @return
	 */
	protected Pagina criaPaginaDeConteudo(String nome,
			String profissao, String endereco, String historico) {
		return new PaginaDeConteudo(nome, profissao, endereco, historico);
	}

	protected boolean validaNome(String nome) {
		return nome.split(" ").length > 1;
	}

	public String toString() {
		String resultado = "\n----------------\n";
		for (Pagina pagina : paginas) {
			resultado += pagina.versaoParaImpressao();
			resultado += "\n----------------\n";
		}
		return resultado;
	}
}
