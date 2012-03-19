package si20121.solucao.grasp1;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Venda {

	private List<ItemVenda> itensVenda;

	public Venda() {
		itensVenda = new LinkedList<ItemVenda>();
	}

	public void novoItemVenda(Produto produto, int quantidade) {
		itensVenda.add(new ItemVenda(produto, quantidade));
	}

	public float getTotal() {
		float total = 0f;
		for (Iterator iterator = itensVenda.iterator(); iterator.hasNext();) {
			ItemVenda item = (ItemVenda) iterator.next();
			total += item.getSubTotal();
		}
		return total;
	}

}
