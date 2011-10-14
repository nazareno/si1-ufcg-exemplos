package exemplos.observer.casainteligente;

public class ArCondicionado implements TelefoneListener {

	public enum Potencia {
		BAIXA, MEDIA, ALTA;
	}

	private Potencia potencia;

	public ArCondicionado() {
		this.potencia = Potencia.BAIXA;
	}

	public Potencia getPotencia() {
		return this.potencia;
	}

	/**
	 * @param potencia
	 *            the potencia to set
	 */
	public void setPotencia(Potencia potencia) {
		this.potencia = potencia;
	}

	@Override
	public void notificaLigacaoDoDono() {
		setPotencia(ArCondicionado.Potencia.ALTA);
	}

}
