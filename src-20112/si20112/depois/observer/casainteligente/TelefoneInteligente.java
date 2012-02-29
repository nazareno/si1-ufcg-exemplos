package si20112.depois.observer.casainteligente;

import java.util.ArrayList;
import java.util.List;

public class TelefoneInteligente {

	private List<TelefoneListener> listeners = new ArrayList<TelefoneListener>();
	private String telefoneDoDono;


	public TelefoneInteligente(String telefoneDoDono) {
		this.telefoneDoDono = telefoneDoDono;
	}
	
	public void novaChamada(String origem) {
		if(origem.equals(this.telefoneDoDono)){
			disparaNotificacao();
		}
	}

	private void disparaNotificacao() {
		for (TelefoneListener listener : listeners) {
			listener.notificaLigacaoDoDono();
		}
	}

	public void addListener(TelefoneListener listener) {
		this.listeners.add(listener);
	}

}
