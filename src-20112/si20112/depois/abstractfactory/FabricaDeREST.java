package si20112.depois.abstractfactory;

public class FabricaDeREST implements Fabrica {

	@Override
	public Mensagem criaMensagem(Fornecedor fornecedor) {
		return new MensagemREST(fornecedor);
	}

	@Override
	public ServicoDeMsg criaServico() {
		return new ServicoREST();
	}

}
