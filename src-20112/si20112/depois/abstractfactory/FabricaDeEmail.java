package si20112.depois.abstractfactory;

public class FabricaDeEmail implements Fabrica {

	@Override
	public Mensagem criaMensagem(Fornecedor fornecedor) {
		return new MensagemDeEmail(fornecedor);
	}

	@Override
	public ServicoDeMsg criaServico() {
		return new ServicoDeEmail();
	}

}
