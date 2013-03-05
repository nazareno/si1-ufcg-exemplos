package si2012.antes.singleton;

public class Modulo2 {

	private Configuracao minhaConfiguracao;
	
<<<<<<< HEAD
=======
	public Modulo2() {
		// Criacao da configuracao: 
		minhaConfiguracao = Configuracao.getInstance();
	}
	
>>>>>>> cec5077feec5ca86269402cd4444bb40ac8da12b
	public Configuracao getConfiguracao() {
		return minhaConfiguracao;
	}

	public int getTimeout() {
		return minhaConfiguracao.getTimeout();
	}

}
