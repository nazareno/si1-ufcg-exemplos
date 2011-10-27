package exemplos.multithread.intro;

public class DuasThreads {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Thread(new SimpleThreadC(), "Thread com composição").start();
		new SimpleThreadH("Thread segunda").start();
		System.out.println("Acabamos a thread principal.");
	}

}
