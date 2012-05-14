package si20121.antes.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class OutraArvoreDeMsgs {

	private List<MsgDeForum> msgsRaiz = new ArrayList<MsgDeForum>();

	public void addMensagem(MsgDeForum mensagem) {
		this.msgsRaiz.add(mensagem);
	}

	public Iterator<MsgDeForum> iteradorEmProfundidade() {
		return null;
	}

}
