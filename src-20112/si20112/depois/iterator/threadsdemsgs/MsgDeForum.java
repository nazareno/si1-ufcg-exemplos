package si20112.depois.iterator.threadsdemsgs;

import java.util.ArrayList;
import java.util.List;

public class MsgDeForum {

	private final String autor;
	private final String texto;
	private List<MsgDeForum> respostas = new ArrayList<MsgDeForum>();

	public MsgDeForum(String autor, String texto) {
		this.autor = autor;
		this.texto = texto;
	}

	public void addResposta(MsgDeForum resposta) {
		this.respostas.add(resposta);
	}

	/**
	 * @return the autor
	 */
	public String getAutor() {
		return autor;
	}

	/**
	 * @return the texto
	 */
	public String getTexto() {
		return texto;
	}

	/**
	 * @return the respostas
	 */
	public List<MsgDeForum> getRespostas() {
		return respostas;
	}

}
