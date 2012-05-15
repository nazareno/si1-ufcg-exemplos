package si20121.antes.state;

import java.util.HashMap;
import java.util.Map;

import si20121.antes.state.CarrinhoDeCompras.Estado;

public class CarrinhoDeCompras {

	private Map<String, Integer> produtos;
	private Estado estado;

	public enum Estado {
		COMPRANDO, PAGO, ENVIADO
	};

	public CarrinhoDeCompras() {
		produtos = new HashMap<String, Integer>();
		estado = Estado.COMPRANDO;
	}

	public void addProduto(String nome, int qtde)
			throws CompraInvalidaException {
		if (estado != Estado.COMPRANDO)
			throw new CompraInvalidaException();

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
		if (estado != Estado.COMPRANDO)
			throw new PagamentoInvalidoException();
		this.estado = Estado.PAGO;
	}

}
