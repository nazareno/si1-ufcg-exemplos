package si20112.depois.multithread.intro;

public class SimpleThreadH extends Thread {

	public SimpleThreadH(String nome) {
		super(nome);
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("Thread " + getName());
			try {
				sleep((long) (Math.random() * 1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Fim da thread " + getName());
	}

}
