package si20112.depois.multithread.sincronizacao2;

public class CopyOfBufferSI1 {

	private int valor = -1;
	private boolean disponivel = false;

	public synchronized void put(int numero) {
		while (disponivel) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		valor = numero;
		disponivel = true;
		notifyAll();
	}

	public synchronized int get() {
		while (!disponivel) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		disponivel = false;
		notifyAll();
		return valor;
	}

}
