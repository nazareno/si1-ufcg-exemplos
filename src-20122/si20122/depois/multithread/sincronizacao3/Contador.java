package si20122.depois.multithread.sincronizacao3;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Contador {

	private int valor = 0;

	Lock trava = new ReentrantLock();

	public Contador() {
	}

	public void add() {
		try {
			trava.lock();
			valor += 1;
		} finally {
			trava.unlock();
		}
	}

	public void subtrai() {
		try {
			trava.lock();
			valor -= 1;
		} finally {
			trava.unlock();
		}
	}

	public int getValor() {
		return valor;
	}

}
