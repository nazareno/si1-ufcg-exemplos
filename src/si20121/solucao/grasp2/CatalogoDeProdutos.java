package si20121.solucao.grasp2;

import java.util.HashMap;
import java.util.Map;

public class CatalogoDeProdutos {

	private Map<Integer, Produto> cadastrados = new HashMap<Integer, Produto>();

	public void cadastra(int codigo, String descricao, float preco) {
		// produto é criado aqui pelo Creator
		cadastrados.put(codigo, new Produto(codigo, descricao, preco));
	}

	public Produto getProduto(int codigo) {
		return cadastrados.get(codigo);
	}

}
