package si20121.durante.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class OutraArvoreDeMsgs {

	private List<MsgDeForum> msgsRaiz = new ArrayList<MsgDeForum>();

	public void addMensagem(MsgDeForum mensagem) {
		this.msgsRaiz.add(mensagem);
	}

	public Iterator<MsgDeForum> iteradorEmProfundidade() {
		return new IteradorEmProfundidade<MsgDeForum>(this);
	}

	public List<MsgDeForum> getMsgsRaiz() {
		return msgsRaiz;
	}
}

class IteradorEmProfundidade<T> implements Iterator<MsgDeForum>{

	private List<MsgDeForum> arvoreOrdenada;
	private int contador;

	public IteradorEmProfundidade(OutraArvoreDeMsgs aArvore) {
		this.contador = 0;
		this.arvoreOrdenada = new LinkedList<MsgDeForum>();
		for (MsgDeForum raiz : aArvore.getMsgsRaiz()) {
			percorreEmProfundidade(raiz, arvoreOrdenada);
		}
	}

	private void percorreEmProfundidade(MsgDeForum raiz, List<MsgDeForum> arvoreOrdenada2) {
		arvoreOrdenada2.add(raiz);
		for (MsgDeForum filho : raiz.getRespostas()) {
			percorreEmProfundidade(filho, arvoreOrdenada2);
		}
	}

	@Override
	public boolean hasNext() {
		return contador < arvoreOrdenada.size();
	}

	@Override
	public MsgDeForum next() {
		return arvoreOrdenada.get(contador++);
	}

	@Override
	public void remove() {
		arvoreOrdenada.remove(contador);
		/*
		 * Teria que remover na árvore também!
		 */
	}
	
}
