package si20121.depois.grasp2;

import java.util.List;

public class TPDV {

	private Venda vendaAtual;
	private CatalogoDeProdutos catalogo;
	private Loja loja;

	public TPDV(Loja loja, CatalogoDeProdutos catalogo) {
		this.loja = loja;
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

	public void addPagamento(float pago, String forma) {
		vendaAtual.addPagamento(pago, forma);
	}

	public float getSaldo() {
		return vendaAtual.getSaldo();
	}

	public List<Pagamento> getPagamentosRealizados() {
		return vendaAtual.getPagamentos();
	}

	public boolean isVendaAberta() {
		return ! vendaAtual.isFechada();
	}

	public void fechaVenda() {
		this.vendaAtual.fecha();
		this.loja.addVenda(vendaAtual);
	}

	public int getVendasRealizadas() {
		return this.loja.getVendasRealizadas();
	}

}
