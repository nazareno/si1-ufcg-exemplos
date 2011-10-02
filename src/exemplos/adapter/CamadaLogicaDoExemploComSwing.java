package exemplos.adapter;

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
		System.out.println("MŽtodo da interface da camada l—gica.");
	}

}
