package si20121.durante.threads.intro;

public class ThreadSimples extends Thread {

	@Override
	public void run() {
		TesteComThreads.x();
		for (int i = 0; i < 5; i++) {
			System.out.println("Na thread criada depois");
		}
	}
}
