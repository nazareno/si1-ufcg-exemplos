package si20112.depois.multithread.pool;

public class FachadaDoSistema {

	private static FachadaDoSistema instance;

	protected FachadaDoSistema(){
		// nada demais
	}
	
	public void alteraDadosDoUsuario(){
		/*
		 * Suponha que demora para fazer a operação.
		 */
		try {
			Thread.sleep(400);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static FachadaDoSistema getInstance() {
		if(instance == null){
			instance = new FachadaDoSistema();
		}
		return instance;
	}
	
}
