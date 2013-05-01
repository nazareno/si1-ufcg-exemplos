package si2012.antes.singleton;

public class Modulo2 {

	private Configuracao minhaConfiguracao;
	
	public Configuracao getConfiguracao() {
		return minhaConfiguracao;
	}

	public int getTimeout() {
		return minhaConfiguracao.getTimeout();
	}

}
