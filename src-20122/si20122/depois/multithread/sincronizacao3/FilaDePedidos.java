package si20122.depois.multithread.sincronizacao3;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class FilaDePedidos {

	private Deque<Integer> filaInterna;

	public FilaDePedidos() {
		filaInterna = new ArrayDeque<Integer>();
	}

	public synchronized void addPedido(int i) {
		filaInterna.add(i);
	}

	public synchronized int removePedido() {
		return filaInterna.isEmpty() ? 0 : filaInterna.removeFirst();
	}

	@Override
	public synchronized String toString() {
		String retorno = "[ ";
		for (Iterator<Integer> iterator = filaInterna.iterator(); iterator
				.hasNext();) {
			retorno += iterator.next() + " ";
		}
		retorno += "]";
		return retorno;
	}
}
