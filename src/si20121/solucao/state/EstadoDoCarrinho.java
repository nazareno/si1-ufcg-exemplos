package si20121.solucao.state;

public interface EstadoDoCarrinho {

	void validaAdicionaProduto(String nome, int qtde) throws CompraInvalidaException;
	
	float paga(int numeroDoCartao) throws PagamentoInvalidoException;

	void cancela() throws CancelamentoInvalidaException;
	
}
