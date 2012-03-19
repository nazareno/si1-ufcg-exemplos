package si20121.solucao.grasp2;

import java.util.LinkedList;
import java.util.List;

public class Venda {

	private List<ItemVenda> itensVenda;
	private List<Pagamento> pagamentos;
	private boolean fechada;

	public Venda() {
		itensVenda = new LinkedList<ItemVenda>();
		pagamentos = new LinkedList<Pagamento>();
		fechada = false;
	}

	public void novoItemVenda(Produto produto, int quantidade) {
		itensVenda.add(new ItemVenda(produto, quantidade));
	}

	public float getTotal() {
		float total = 0f;
		for (ItemVenda item : itensVenda) {
			total += item.getSubTotal();
		}
		return total;
	}

	public void addPagamento(float pago, String forma) {
		this.pagamentos.add(new Pagamento(pago, forma));
	}

	public float getSaldo() {
		return getTotal() - getTotalPago();
	}

	/**
	 * @return O total dos pagamentos realizados.
	 */
	private float getTotalPago() {
		float totalPago = 0f;
		for (Pagamento pago : pagamentos) {
			totalPago += pago.getPago();
		}
		return totalPago;
	}

	public List<Pagamento> getPagamentos() {
		return new LinkedList<Pagamento>(this.pagamentos);
	}

	public void fecha() {
		this.fechada = true;
	}

	/**
	 * @return the fechada
	 */
	public boolean isFechada() {
		return fechada;
	}

}
