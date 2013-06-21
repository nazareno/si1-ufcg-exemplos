package durante.grasp;

import java.util.ArrayList;
import java.util.List;

public class Venda {

	private List<ItemVenda> itens;
	
	public Venda() {
		itens = new ArrayList<ItemVenda>();
	}

	public void addItemVenda(int quantidade, Produto produto) {
		itens.add(new ItemVenda(quantidade, produto));
	}

	public double getTotal() {
		double total = 0.0;
		for (ItemVenda item : this.getItensVenda()) {
			total += item.getTotal();
		}
		return total;
	}

	public List<ItemVenda> getItensVenda() {
		return new ArrayList<ItemVenda>(this.itens);
	}

}
