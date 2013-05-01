package si20122.depois.multithread.sincronizacao3;

public class ContadorTest {
	public static void main(String[] args) {
		int valorFinal = 0;
		int tentativas = 0;
		while (valorFinal == 0 && tentativas < 10000) {
			final Contador contador = new Contador();
			tentativas++;

			Thread add = new Thread(new Runnable() {
				@Override
				public void run() {
					for (int i = 0; i < 100000; i++) {
						contador.add();
					}
				}
			});

			Thread add2 = new Thread(new Runnable() {
				@Override
				public void run() {
					for (int i = 0; i < 100000; i++) {
						contador.add();
					}
				}
			});

			
			Thread subtrai = new Thread(new Runnable() {
				@Override
				public void run() {
					for (int i = 0; i < 100000; i++) {
						contador.subtrai();
					}
				}
			});

			Thread subtrai2 = new Thread(new Runnable() {
				@Override
				public void run() {
					for (int i = 0; i < 100000; i++) {
						contador.subtrai();
					}
				}
			});
			
			add.start();
			subtrai.start();
			add2.start();
			subtrai2.start();

			try {
				add.join();
				subtrai.join();
				add2.join();
				subtrai2.join();
			} catch (InterruptedException e) {
			}

			valorFinal = contador.getValor();
			
			if(tentativas % 10 == 0){
				System.out.println(tentativas);
			}
		}
		System.out.println(valorFinal);
		System.out.println("tentativas:" + tentativas);
	}
}
