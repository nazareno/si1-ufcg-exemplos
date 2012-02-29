package si20112.depois.adapter;

public class CamadaLogicaDoExemploComSwing {

	private static CamadaLogicaDoExemploComSwing instance;

	protected CamadaLogicaDoExemploComSwing(){
		//...
	}
	
	public static CamadaLogicaDoExemploComSwing getInstance(){
		if(instance == null){
			instance = new CamadaLogicaDoExemploComSwing();
		}
		return instance;
	}
	
	public void metodoDaCamadaLogica(){
		System.out.println("M�todo da interface da camada l�gica.");
	}

}
