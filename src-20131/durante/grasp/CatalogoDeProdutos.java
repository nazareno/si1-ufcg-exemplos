package durante.grasp;

import java.util.HashMap;
import java.util.Map;

public class CatalogoDeProdutos {

	private Map<Long, Produto> mapa = new HashMap<Long, Produto>();

	public Produto getProduto(long codigo) {
		return this.mapa.get(codigo);
	}

	public void registraProduto(long codigo, String nome, double preco) {
		this.mapa.put(codigo, new Produto(nome, preco));
	}

}
