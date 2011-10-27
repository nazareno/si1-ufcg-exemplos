package exemplos.multithread.escalonamento;

public class CorridaDeThreads {

	public static void main(String[] args) {
		ThreadCorredora thread1 = new ThreadCorredora();
		ThreadCorredora thread2 = new ThreadCorredora();
		ThreadCorredora thread3 = new ThreadCorredora();

		thread1.setPriority(10);

		thread1.start();
		thread2.start();
		thread3.start();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		thread1.parar();
		thread2.parar();
		thread3.parar();

		try {
			thread1.join();
			thread2.join();
			thread3.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("\n\nRelatório:");
		float totalContadores = thread1.getContador() + thread2.getContador()
				+ thread3.getContador();
		System.out.println("Thread1:"
				+ (thread1.getContador() / totalContadores));
		System.out.println("Thread2:"
				+ (thread2.getContador() / totalContadores));
		System.out.println("Thread3:"
				+ (thread3.getContador() / totalContadores));
		// System.out.println("Fim.");
	}

}

class ThreadCorredora extends Thread {

	private int contador;
	//private volatile boolean stop = false;

	public ThreadCorredora() {
		contador = 0;
	}

	public void parar() {
		//stop = true;
		this.interrupt();
	}

	@Override
	public void run() {
		//while (!stop) {
		while (!isInterrupted()) {
			Math.log(Math.PI / Math.E);
			contador++;
		}
		System.out.println(getName() + ": Pararei.");
	}

	/**
	 * @return the contador
	 */
	public int getContador() {
		return contador;
	}
}