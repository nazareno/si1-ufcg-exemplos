package si20121.depois.multithread.sincronizacao3;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Contador {

	private int valor = 0;
	private Lock lock;

	public Contador() {
		this.lock = new ReentrantLock();
	}

	public void add() {
		lock.lock();
		try {
			valor += 1;
		} finally {
			lock.unlock();
		}
	}

	public void subtrai() {
		lock.lock();
		try {
			valor -= 1;
		} finally {
			lock.unlock();
		}
	}

	public int getValor() {
		return valor;
	}


}
