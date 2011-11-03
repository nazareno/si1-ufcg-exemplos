package exemplos.multithread.sincronizacao2;

public class CopyOfBufferSI1 {

	private int valor = -1;
	private boolean disponivel = false;

	public synchronized void put(int numero) {
		if (disponivel) {
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
		if (!disponivel) {
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
