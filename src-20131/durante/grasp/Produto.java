package durante.grasp;

public class Produto {

	private final String descricao;
	private final double preco;
	private final Desconto desconto;

	public Produto(String descricao, double preco, Desconto desconto) {
		this.descricao = descricao;
		this.preco = preco;
		this.desconto = desconto;
	}

	public Produto(String descricao, double preco) {
		this(descricao, preco, null);
	}

	public double getPreco() {
		return preco;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public double getDesconto(ItemVenda itemVenda) {
		return desconto.getValorDoDesconto(itemVenda);
	}

}
