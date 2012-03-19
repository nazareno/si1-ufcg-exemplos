package si20121.solucao.grasp2;

public class Pagamento {

	private final float pago;
	private final String forma;

	public Pagamento(float pago, String forma) {
		this.pago = pago;
		this.forma = forma;
	}

	/**
	 * @return the pago
	 */
	public float getPago() {
		return pago;
	}

	/**
	 * @return the forma
	 */
	public String getForma() {
		return forma;
	}

}
