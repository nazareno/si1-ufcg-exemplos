package si20112.depois.composite;

import java.util.ArrayList;
import java.util.List;

public class Mensagem implements ExibivelComposto {

	private String origem;
	private String[] destinos;
	private String texto;
	private List<Exibivel> internos;

	public Mensagem(String origem, String[] destinos, String texto) {
		this.origem = origem;
		this.destinos = destinos;
		this.texto = texto;
		
		internos = new ArrayList<Exibivel>();
	}

	/**
	 * Constroi resposta de uma msg original. 
	 */
	public Mensagem(Mensagem msgOriginal, String origemUnica, String texto) {
		this(msgOriginal.getOrigem(), new String[]{origemUnica}, texto);
		this.internos.add(msgOriginal);
	}

	/**
	 * @return the origem
	 */
	public String getOrigem() {
		return origem;
	}

	/**
	 * @param origem the origem to set
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
	 * @param destinos the destinos to set
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
	 * @param texto the texto to set
	 */
	public void setTexto(String texto) {
		this.texto = texto;
	}

	public void add(Exibivel e) {
		this.internos.add(e);
	}

	public void exibe() {
		System.out.println("---\nInicio da Msg");
		System.out.println("De: " + this.getOrigem());
		System.out.println("Para: " + this.getDestinos());
		
		System.out.println("Msgs anteriores:");
		for (Exibivel exibivel : internos) {
			exibivel.exibe();
		}
		
	}
}
