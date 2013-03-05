package si2012.antes.composite.msgs;


public class Mensagem {

	private String origem;
	private String[] destinos;
	private String texto;
	private Mensagem msgRespondida;

	public Mensagem(String origem, String[] destinos, String texto) {
		this.origem = origem;
		this.destinos = destinos;
		this.texto = texto;
		this.msgRespondida = null;
	}

	/**
	 * Constroi resposta de uma msg original.
	 */
	public Mensagem(Mensagem msgOriginal, String origem, String texto) {
		this(origem, new String[] { msgOriginal.getOrigem() }, texto);
		this.msgRespondida = msgOriginal;
	}

	/**
	 * @return the origem
	 */
	public String getOrigem() {
		return origem;
	}

	/**
	 * @param origem
	 *            the origem to set
	 */
	public void setOrigem(String origem) {
		this.origem = origem;
	}

	/**
	 * @return the destinos
	 */
	public String[] getDestinos() {
		return destinos;
	}

	/**
	 * @param destinos
	 *            the destinos to set
	 */
	public void setDestinos(String[] destinos) {
		this.destinos = destinos;
	}

	/**
	 * @return the texto
	 */
	public String getTexto() {
		return texto;
	}

	/**
	 * @param texto
	 *            the texto to set
	 */
	public void setTexto(String texto) {
		this.texto = texto;
	}

	/**
	 * Mostra na tela a mensagem. 
	 */
	public void exibe() {
		System.out.println(".Inicio da Msg");
		System.out.println("De: " + this.getOrigem());
		System.out.println("Para: " + this.getDestinos());

		System.out.println("Anexos:");
		this.msgRespondida.exibe();
	}
}
