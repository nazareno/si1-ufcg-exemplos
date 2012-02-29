package si20112.depois.singleton;

public class Modulo1 {

	private Configuracao config;

	public Modulo1(){
		this.config = Configuracao.getInstance();
	}

	/**
	 * @return the config
	 */
	public Configuracao getConfig() {
		return config;
	}

	public long getTimeout() {
		return config.getTimeout();
	}

	public void modificaTimeout(int novoTimeout) {
		this.config.setTimeout(novoTimeout);
	}
}
