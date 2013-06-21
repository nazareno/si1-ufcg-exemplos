package durante.grasp;

public class DescontoPorQuantidade implements Desconto {

	private final int quantidadeMinima;
	private final double descontoFracao;

	public DescontoPorQuantidade(int quantidade, double desconto) {
		this.quantidadeMinima = quantidade;
		this.descontoFracao = desconto;
	}

	/**
	 * @return the quantidade
	 */
	public int getQuantidade() {
		return quantidadeMinima;
	}

	/**
	 * @return the desconto
	 */
	public double getDesconto() {
		return descontoFracao;
	}

	@Override
	public double getValorDoDesconto(ItemVenda itemVenda) {
		if (itemVenda.getQuantidade() >= quantidadeMinima) {
			return itemVenda.getPrecoBase() * descontoFracao;
		} else {
			return 0;
		}
	}

}
