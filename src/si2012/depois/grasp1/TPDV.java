package si2012.depois.grasp1;

public class TPDV {

	private Venda vendaAtual;
	private CatalogoDeProdutos catalogo;

	public TPDV(CatalogoDeProdutos catalogo) {
		this.catalogo = catalogo;
	}
	
	public void novaVenda() {
		vendaAtual = new Venda();
	}

	public void addItemVenda(int codigo, int quantidade) {
		// Creator novamente:
		vendaAtual.novoItemVenda(catalogo.getProduto(codigo), quantidade);
	}

	public float getTotalAtual() {
		return vendaAtual.getTotal();
	}

}
