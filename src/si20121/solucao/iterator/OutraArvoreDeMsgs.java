package si20121.solucao.iterator;

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
		return new ArvoreDeMsgEmProfundidadeIterator<MsgDeForum>(this);
	}

	public List<MsgDeForum> getMsgsRaiz() {
		return msgsRaiz;
	}

}

class ArvoreDeMsgEmProfundidadeIterator<T> implements Iterator<MsgDeForum> {

	private List<MsgDeForum> arvoreOrdenada;
	private int cursor = 0;

	public ArvoreDeMsgEmProfundidadeIterator(OutraArvoreDeMsgs arvore) {
		this.arvoreOrdenada = ordenaArvore(arvore);
	}

	private List<MsgDeForum> ordenaArvore(OutraArvoreDeMsgs arvore) {
		List<MsgDeForum> resposta = new LinkedList<MsgDeForum>();
		
		for (MsgDeForum msgRaiz : arvore.getMsgsRaiz()) {
			visita(msgRaiz, resposta);
		}
		
		return resposta;
	}

	private void visita(MsgDeForum msgRaiz, List<MsgDeForum> resposta) {
		resposta.add(msgRaiz);
		for (MsgDeForum msgDeForum : msgRaiz.getRespostas()) {
			visita(msgDeForum, resposta);
		}
	}

	@Override
	public boolean hasNext() {
		return cursor < arvoreOrdenada.size();
	}

	@Override
	public MsgDeForum next() {
		return arvoreOrdenada.get(cursor++);
	}

	@Override
	public void remove() {
		arvoreOrdenada.remove(cursor);
	}

}