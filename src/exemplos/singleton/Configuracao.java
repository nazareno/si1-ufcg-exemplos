package exemplos.singleton;


public class Configuracao {
	
	private static final long DEFAULT_TIMEOUT = 761325;
	private static final String DEFAULT_TMPPATH = "/tmp";
	private long timeout;
	private String tmpPath;
	
	private static Configuracao config;
	
	public static synchronized Configuracao getInstance(){
		if(config == null){
			config = new Configuracao();
		}
		return config;
	}
	
	protected Configuracao(long timeout, String tmpPath){
		this.timeout = timeout;
		this.tmpPath = tmpPath;
	}
	
	protected Configuracao(){
		this(DEFAULT_TIMEOUT, DEFAULT_TMPPATH);
	}

	/**
	 * @return the timeout
	 */
	public long getTimeout() {
		return timeout;
	}

	/**
	 * @param timeout the timeout to set
	 */
	public void setTimeout(long timeout) {
		this.timeout = timeout;
	}

	/**
	 * @return the tmpPath
	 */
	public String getTmpPath() {
		return tmpPath;
	}

	/**
	 * @param tmpPath the tmpPath to set
	 */
	public void setTmpPath(String tmpPath) {
		this.tmpPath = tmpPath;
	}
	
	
}
