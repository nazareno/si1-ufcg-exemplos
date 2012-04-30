package si20121.antes.adapter.swing;

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
		System.out.println("Metodo da interface da camada logica.");
	}

}
