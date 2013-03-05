package si2012.antes.singleton;

public class Configuracao {

	private int timeout;

	public Configuracao() {
		this.timeout = 0;
	}

	/**
	 * @return the timeout
	 */
	public int getTimeout() {
		return timeout;
	}

	/**
	 * @param timeout
	 *            the timeout to set
	 */
	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}

}
