package si2012.solucao.composite.msgs;

import java.util.LinkedList;
import java.util.List;

public class Mensagem implements Exibivel {

	private String origem;
	private String[] destinos;
	private String texto;
	private List<Exibivel> exibiveis;

	public Mensagem(String origem, String[] destinos, String texto) {
		this.origem = origem;
		this.destinos = destinos;
		this.texto = texto;
		this.exibiveis = new LinkedList<Exibivel>();
	}

	/**
	 * Constroi resposta de uma msg original.
	 */
	public Mensagem(Mensagem msgOriginal, String origem, String texto) {
		this(origem, new String[] { msgOriginal.getOrigem() }, texto);
		this.add(msgOriginal);
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
		for (Exibivel exibivel : exibiveis) {
			exibivel.exibe();
		}
	}

	public void add(Exibivel exibivel) {
		exibiveis.add(exibivel);
	}

}
