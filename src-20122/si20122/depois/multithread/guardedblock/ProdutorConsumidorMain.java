package si20122.depois.multithread.guardedblock;

public class ProdutorConsumidorMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		final FilaDeRequisicoes fila = new FilaDeRequisicoes();

		Thread produtor = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					for (int j = 0; j < 100; j++) {
						gerarRequisicao(j);
					}
					try {
						Thread.sleep((long) Math.random() * 1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}

			private void gerarRequisicao(int num) {
				fila.colocaRequisicao(num);
			}
		});

		Thread consumidor = new Thread(new Consumidor(fila));
		Thread consumidor2 = new Thread(new Consumidor(fila));
		
		
	}

}

class Consumidor implements Runnable {

	private final FilaDeRequisicoes fila;

	public Consumidor(FilaDeRequisicoes fila) {
		this.fila = fila;
	}

	@Override
	public void run() {
		while (true) {
			processaRequisicao();
			try {
				Thread.sleep((long) Math.random() * 100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private void processaRequisicao() {
		System.out.println(fila.tiraRequisicao());
	}

}
