package si2012.antes.singleton;

import java.util.LinkedList;
import java.util.List;

public class Configuracao {

	private static Configuracao config;
	private static Object lock = new Object();

	private int timeout;

	public synchronized static Configuracao getInstance() {
		if (config == null) {
			try {
				config = new Configuracao();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return config;
	}

	protected Configuracao() throws Exception {
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
