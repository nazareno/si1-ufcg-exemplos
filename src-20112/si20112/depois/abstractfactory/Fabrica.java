package si20112.depois.abstractfactory;

public interface Fabrica {

	Mensagem criaMensagem(Fornecedor fornecedor);
	ServicoDeMsg criaServico();

}
