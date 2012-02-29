package si20112.depois.factorymethod;

import com.sun.tools.corba.se.idl.InvalidArgument;

public class CurriculoResumido extends Curriculo {

	public CurriculoResumido(String nome, String profissao, String endereco,
			String historico, String outrasInfos) throws InvalidArgument {
		super(nome, profissao, endereco, historico, outrasInfos);
	}

	@Override
	protected boolean validaNome(String nome) {
		return true;
	}
	
	@Override
	protected Pagina criaPaginaDeConteudo(String nome,
			String profissao, String endereco, String historico) {
		return new PaginaDeConteudoResumida();
	}
}
