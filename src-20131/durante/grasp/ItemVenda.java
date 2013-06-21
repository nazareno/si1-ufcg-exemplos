package durante.grasp;

public class ItemVenda {

	private static final double DESCONTO_POR_QUANTIDADE = 0.10;

	private int quantidade;
	private Produto produto;

	public ItemVenda(int quantidade, Produto produto) {
		if (quantidade <= 0) {
			throw new IllegalArgumentException();
		}
		this.quantidade = quantidade;
		this.produto = produto;
	}

	public double getTotal() {
		return getPrecoBase() - getDesconto();
	}

	public double getPrecoBase() {
		return quantidade * produto.getPreco();
	}

	private double getDesconto() {
		return produto.getDesconto(this);
	}

	public int getQuantidade() {
		return this.quantidade;
	}

	public String getDescricao() {
		return this.produto.getDescricao();
	}

}
