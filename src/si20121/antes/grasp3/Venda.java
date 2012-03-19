package si20121.antes.grasp3;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import si20121.antes.grasp3.Pagamento.Forma;


public class Venda {

	private List<ItemVenda> itensVenda;
	private List<Pagamento> pagamentos;
	private boolean aberta;

	public Venda() {
		itensVenda = new LinkedList<ItemVenda>();
		pagamentos = new LinkedList<Pagamento>();
		aberta = true;
	}

	public void novoItemVenda(Produto produto, int quantidade)
			throws VendaInvalidaException {
		if (!aberta) {
			throw new VendaInvalidaException("Venda finalizada");
		}
		itensVenda.add(new ItemVenda(produto, quantidade));
	}

	public float getTotal() {
		float total = 0f;
		for (Iterator<ItemVenda> iterator = itensVenda.iterator(); iterator
				.hasNext();) {
			ItemVenda item = (ItemVenda) iterator.next();
			total += item.getSubTotal();
		}
		return total;
	}

	public void pagar(float valor, Forma cartao) {
		Pagamento pago = new Pagamento(valor, cartao);
		pagamentos.add(pago);
	}

	public float getDebito() {
		return getTotal() - calculaPago();
	}

	/**
	 * @return
	 */
	private float calculaPago() {
		float pago = 0f;
		for (Pagamento pagamento : pagamentos) {
			pago += pagamento.getValor();
		}
		return pago;
	}

	public boolean isAberta() {
		return aberta;
	}

	public void finaliza() {
		aberta = false;
	}

}
