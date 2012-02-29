package si20112.depois.abstractfactory;

public class ServicoREST implements ServicoDeMsg {

	@Override
	public void envia(Mensagem msg) {
		System.out.println("Enviando mensagem via REST.");
	}

}
