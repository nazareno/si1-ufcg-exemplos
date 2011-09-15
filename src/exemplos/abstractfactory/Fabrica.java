package exemplos.abstractfactory;

public interface Fabrica {

	Mensagem criaMensagem(Fornecedor fornecedor);
	ServicoDeMsg criaServico();

}
