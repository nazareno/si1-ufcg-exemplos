package si2012.antes.singleton;

public class Modulo2 {

	private Configuracao minhaConfiguracao;
	
	public Modulo2() {
		// Criacao da configuracao: 
		minhaConfiguracao = Configuracao.getInstance();
	}
	
	public Configuracao getConfiguracao() {
		return minhaConfiguracao;
	}

	public int getTimeout() {
		return minhaConfiguracao.getTimeout();
	}

}
