package si20121.solucao.state;

public class EstadoPago implements EstadoDoCarrinho {

	@Override
	public void validaAdicionaProduto(String nome, int qtde)
			throws CompraInvalidaException {
		throw new CompraInvalidaException("Compra já foi paga.");
	}

	@Override
	public float paga(int numeroDoCartao) throws PagamentoInvalidoException {
		throw new PagamentoInvalidoException("Compra já foi paga");
	}

	@Override
	public void cancela() throws CancelamentoInvalidaException {
		/*
		 * devolver o dinheiro do cliente e limpar o carrinho.
		 * 
		 * precisamos de uma referência para o carrinho. onde recebemos?
		 */
	}

}
