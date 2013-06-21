package durante.grasp;

import java.util.List;

public class SistemaTPV {

	private Venda vendaAtual;
	private final CatalogoDeProdutos catalogo;
	private GerenteDeDados gerenteDeDados;

	public SistemaTPV() {
		this.catalogo = new CatalogoDeProdutos();
		this.gerenteDeDados = new GerenteDeDados();
	}

	public void novaVenda() {
		vendaAtual = new Venda();
	}

	public double getTotal() {
		return vendaAtual.getTotal();
	}

	public void addItemVenda(int quantidade, long codigo) {
		// 2
		Produto produto = catalogo.getProduto(codigo);

		vendaAtual.addItemVenda(quantidade, produto);
	}

	public void registraProduto(long codigo, String nome, double preco) {
		catalogo.registraProduto(codigo, nome, preco);
		gerenteDeDados.salvar(catalogo);
	}

	public List<ItemVenda> getItensVenda() {
		return vendaAtual.getItensVenda();
	}


}
