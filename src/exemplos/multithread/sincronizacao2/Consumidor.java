package exemplos.multithread.sincronizacao2;

public class Consumidor extends Thread {

	private final BufferSI1 buffer;

	public Consumidor(BufferSI1 b) {
		this.buffer = b;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
            int value = buffer.get();
            System.out.println("Consumidor: " + value);
            try {
				sleep((int) (Math.random() * 10));
			} catch (InterruptedException e) {
			}
        }
	}
}
