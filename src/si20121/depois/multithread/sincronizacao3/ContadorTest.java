package si20121.depois.multithread.sincronizacao3;

public class ContadorTest {
	public static void main(String[] args) {
		final Contador contador = new Contador();
		
		Thread add = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 10000; i++) {
					contador.add();
				}
			}
		});
		
		Thread subtrai = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 10000; i++) {
					contador.subtrai();
				}
			}
		});

		add.start();
		subtrai.start();
		
		try {
			add.join();
			subtrai.join();
		} catch (InterruptedException e) {
		}
		
		System.out.println(contador.getValor());
	}
}
