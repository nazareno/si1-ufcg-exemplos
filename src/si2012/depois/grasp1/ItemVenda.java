package si2012.depois.grasp1;

public class ItemVenda {

	private final Produto produto;
	private final int quantidade;

	public ItemVenda(Produto produto, int quantidade) {
		this.produto = produto;
		this.quantidade = quantidade;
	}

	public float getSubTotal() {
		return quantidade * produto.getPreco();
	}

}
