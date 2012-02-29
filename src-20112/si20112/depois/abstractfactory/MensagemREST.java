package si20112.depois.abstractfactory;

public class MensagemREST implements Mensagem {

	private Pedido pedido;
	private final Fornecedor fornecedor;

	public MensagemREST(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	@Override
	public void add(Pedido pedido) {
		this.pedido = pedido;
	}

	@Override
	public String getConteudo() {
		return "Msg REST para " + this.pedido.toString();
	}

	@Override
	public String getDestinatario() {
		return fornecedor.getRestUrl();
	}

}
