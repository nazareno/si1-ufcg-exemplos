package si20112.depois.abstractfactory;

public class ServicoDeEmail implements ServicoDeMsg {

	/* (non-Javadoc)
	 * @see pedidos.ServicoDeMsg#envia(pedidos.Mensagem)
	 */
	public void envia(Mensagem msg) {
		String endereco = msg.getDestinatario();
		String conteudo = msg.getConteudo();

		this.processa(endereco, conteudo);
	}

	private void processa(String endereco, String conteudo) {
		System.out.println("Enviou email para " + endereco + " com conte�do "
				+ conteudo);
	}

}
