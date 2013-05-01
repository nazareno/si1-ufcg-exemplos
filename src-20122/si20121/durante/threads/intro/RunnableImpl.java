package si20121.durante.threads.intro;

public class RunnableImpl implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			TesteComThreads.x();

			System.out.println("Na Thread 3");
			Math.acos(Math.E);
		}
	}

}
