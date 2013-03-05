package si2012.antes.singleton;

public class ConfiguracaoXML extends Configuracao {

	private static ConfiguracaoXML config;
	
	protected ConfiguracaoXML() throws Exception{
		super();
	}
	
	public static ConfiguracaoXML getInstace(){
		if (config == null)
			try {
				config = new ConfiguracaoXML();
			} catch (Exception e) {
				e.printStackTrace();
			}
		return config;
	}
	
}
