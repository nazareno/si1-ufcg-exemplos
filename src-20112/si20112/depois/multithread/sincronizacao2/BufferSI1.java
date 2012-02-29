package si20112.depois.multithread.sincronizacao2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BufferSI1 {

	private int valor = -1;
	private boolean disponivel = false;

	private Lock trava = new ReentrantLock();
	private Condition condicao = trava.newCondition();

	public void put(int numero) {
		trava.lock();
		try {
			if (disponivel) {
				try {
					condicao.await();
				} catch (InterruptedException e) {
				}
			}
			valor = numero;
			disponivel = true;
			condicao.signalAll();
		} finally {
			trava.unlock();
		}
	}

	public int get() {
		trava.lock();
		int retorno;
		try {
			if (!disponivel) {
				try {
					condicao.await();
				} catch (InterruptedException e) {
				}
			}
			disponivel = false;
			retorno = valor;
			condicao.signalAll();
		} finally {
			trava.unlock();
		}
		return retorno;
	}

}
