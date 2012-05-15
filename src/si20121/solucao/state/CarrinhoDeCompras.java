package si20121.solucao.state;

import java.util.HashMap;
import java.util.Map;

public class CarrinhoDeCompras {

	private Map<String, Integer> produtos;
	private EstadoDoCarrinho estado;

	public CarrinhoDeCompras() {
		produtos = new HashMap<String, Integer>();
		estado = new EstadoComprando();
	}

	public void addProduto(String nome, int qtde)
			throws CompraInvalidaException {
		this.estado.validaAdicionaProduto(nome, qtde);
		this.produtos.put(nome, qtde);
	}

	public int getNumProdutos() {
		int total = 0;
		for (int qtde : produtos.values()) {
			total += qtde;
		}
		return total;
	}

	public void realizaPagamento(int numeroDoCartao)
			throws PagamentoInvalidoException {
		estado.paga(numeroDoCartao);
		this.estado = new EstadoPago();
	}

	public void cancelaCompra() throws CancelamentoInvalidaException {
		this.estado.cancela();
		// que tal ir para um estado cancelado? 
	}

}
