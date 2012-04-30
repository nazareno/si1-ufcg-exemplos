package si2012.solucao.composite.msgs;

import java.util.LinkedList;
import java.util.List;

public class ThreadDeMensagens {

	private List<Mensagem> mensagens = new LinkedList<Mensagem>();

	public void add(Mensagem msg) {
		this.mensagens.add(msg);
	}

	public void exibe() {
		System.out.println("Inicio da Thread");
		for (Mensagem msg : mensagens) {
			System.out.println("\n-----");
			msg.exibe();
		}
		System.out.println("Fim da Thread");
	}

}
