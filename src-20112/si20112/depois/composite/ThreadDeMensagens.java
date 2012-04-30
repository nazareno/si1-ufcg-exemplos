package si20112.depois.composite;

import java.util.LinkedList;
import java.util.List;

public class ThreadDeMensagens implements ExibivelComposto {

	private List<Exibivel> mensagens = new LinkedList<Exibivel>();

	public void add(Exibivel msg) {
		/*
		 * Aqui talvez fosse importante permitir somente a adição de mensagens.
		 * O que você acha?
		 */
		this.mensagens.add(msg);
	}

	public void exibe() {
		System.out.println("Inicio da Thread");
		for (Exibivel msg : mensagens) {
			System.out.println("\n-----");
			msg.exibe();
		}
		System.out.println("Fim da Thread");
	}

}
