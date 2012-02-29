package si20112.depois.iterator.threadsdemsgs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class OutraArvoreDeMsgs {

	private List<MsgDeForum> msgsRaiz = new ArrayList<MsgDeForum>();

	public void addMensagem(MsgDeForum mensagem) {
		this.msgsRaiz.add(mensagem);
	}

	public Iterator<MsgDeForum> iteradorEmProfundidade() {
		return new Iterator<MsgDeForum>() {
			private List<MsgDeForum> todos = ordenaArvore();
			private int cursor = 0;

			@Override
			public boolean hasNext() {
				return cursor >= todos.size() - 1;
			}

			private List<MsgDeForum> ordenaArvore() {
				List<MsgDeForum> lista = new ArrayList<MsgDeForum>();
				for (MsgDeForum msgDeForum : msgsRaiz) {
					visitaNo(msgDeForum, lista);
				}
				return lista;
			}

			private void visitaNo(MsgDeForum msg, List<MsgDeForum> lista) {
				lista.add(msg);
				for (MsgDeForum msgDeForum : msg.getRespostas()) {
					visitaNo(msgDeForum, lista);
				}
			}

			@Override
			public MsgDeForum next() {
				return todos.get(cursor++);
			}

			@Override
			public void remove() {
				todos.remove(cursor);
			}
		};
	}

}
