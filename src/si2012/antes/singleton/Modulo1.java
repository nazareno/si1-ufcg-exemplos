package si2012.antes.singleton;

public class Modulo1 {
	
	private Configuracao configuracao;
	
	public Modulo1() {
		// Codigo de criacao do objeto propriamente dito
		
		// Criacao da configuracao: 
		configuracao = Configuracao.getInstance();
	}

	public Configuracao getConfiguracao() {
		return configuracao;
	}

	public void modificaTimeout(int novoValor) {
		configuracao.setTimeout(novoValor);
	}

}
