package si20121.solucao.state;

public class EstadoComprando implements EstadoDoCarrinho {

	@Override
	public void validaAdicionaProduto(String nome, int qtde)
			throws CompraInvalidaException {
		return;
	}

	@Override
	public float paga(int numeroDoCartao) throws PagamentoInvalidoException {
		/*
		 * Aqui estaria a lógica lidando com o cartão.
		 * 
		 * Aqui poderia estar também a lógica para mudar o estado do carrinho
		 * para pago.
		 */
		return (float) Math.random() * 1000;
	}

	@Override
	public void cancela() throws CancelamentoInvalidaException {
		/*
		 * Aqui poderíamos limpar o carrinho. Essa lógica pode estar lá ou aqui?
		 */
		return;
	}

}
