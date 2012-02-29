package si20112.depois.multithread.sincronizacao2;

public class Produtor extends Thread {

	private final BufferSI1 buffer;

	public Produtor(BufferSI1 b) {
		this.buffer = b;
	}

	public void run() {
		for (int i = 0; i < 10; i++) {
			buffer.put(i);
			try {
				sleep((int) (Math.random() * 10));
			} catch (InterruptedException e) {
			}
		}
	}
}
