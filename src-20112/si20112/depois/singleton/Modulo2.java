package si20112.depois.singleton;

public class Modulo2 {

	private Configuracao config;

	public Modulo2() {
		this.config = Configuracao.getInstance();
	}

	/**
	 * @return the config
	 */
	public Configuracao getConfig() {
		return config;
	}

	public long getTimeout() {
		return this.config.getTimeout();
	}

}
