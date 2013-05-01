package si20122.depois.multithread.guardedblock;

import java.util.ArrayDeque;
import java.util.Deque;

public class FilaDeRequisicoes {

	private Deque<Integer> fila = new ArrayDeque<Integer>();

	public void colocaRequisicao(int num) {
		synchronized (fila) {
			// esperar notificação
			while (this.cheia()) {
				try {
					fila.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			// coloca de fato
			this.fila.add(num);
			fila.notify();
		}
	}

	private boolean cheia() {
		return fila.size() == 20;
	}

	public int tiraRequisicao() {
		synchronized (fila) {
			while (fila.isEmpty()) {
				try {
					fila.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			int retorno = fila.getLast();
			fila.notify();
			return retorno;
		}

	}

}
