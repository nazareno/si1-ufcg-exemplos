package si20112.depois.multithread.intro;

public class SimpleThreadC implements Runnable {
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName());
			try {
				Thread.sleep((long) (Math.random() * 1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Fim da thread " + Thread.currentThread().getName());
	}

}
