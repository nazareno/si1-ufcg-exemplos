package si20122.depois.multithread.sincronizacao3;


public class FilaDePedidosTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final FilaDePedidos fila = new FilaDePedidos();
		
		Thread queColoca = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 1000; i++) {
					fila.addPedido(i);
				}
			}
		});
		
		Thread queTira = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 1000; i++) {
					fila.removePedido();
				}
			}
		});
		
		queColoca.start();
		queTira.start();
		
		for (int i = 0; i < 20; i++) {
			System.out.println("Estado da fila: " + fila.toString());
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
