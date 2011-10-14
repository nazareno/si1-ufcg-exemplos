package exemplos.observer.casainteligente;

public class Microondas implements TelefoneListener {

	private boolean ligado = false; 
	
	public boolean isLigado() {
		return ligado;
	}

	@Override
	public void notificaLigacaoDoDono() {
		this.ligado = true;
	}

}
