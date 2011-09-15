package exemplos.abstractfactory;

public class MensagemDeEmail implements Mensagem {

	private Pedido pedido;
	private final Fornecedor fornecedor;

	public MensagemDeEmail(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	/* (non-Javadoc)
	 * @see pedidos.Mensagem#add(pedidos.Pedido)
	 */
	public void add(Pedido pedido) {
		this.pedido = pedido;
	}

	/* (non-Javadoc)
	 * @see pedidos.Mensagem#getDestinatario()
	 */
	public String getDestinatario() {
		return this.fornecedor.getEmail();
	}

	/* (non-Javadoc)
	 * @see pedidos.Mensagem#getConteudo()
	 */
	public String getConteudo() {
		StringBuilder b = new StringBuilder();
		b.append("Prezado sr., ");
		b.append(pedido);
		return b.toString();
	}
}
