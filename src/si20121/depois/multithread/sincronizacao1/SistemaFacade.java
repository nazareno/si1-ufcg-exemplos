package si20121.depois.multithread.sincronizacao1;

public class SistemaFacade {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final Usuario fulano = new Usuario("Fulano");
		final Usuario sicrano = new Usuario("Sicrano");

		fulano.cadastraItem("CD Calypso");

		Runnable thread1 = new Runnable() {
			@Override
			public void run() {
				try {
					for (int i = 0; i < 30; i++) {
						fulano.setItemDisponivel();
						Thread.sleep((long) (Math.random() * 100));
						fulano.setItemIndisponivel();
						Thread.sleep((long) (Math.random() * 100));
					}
				} catch (InterruptedException e) {
					/*
					 * Não esperamos nenhuma interrupção
					 */
					e.printStackTrace();
				}
			}
		};

		Runnable thread2 = new Runnable() {
			@Override
			public void run() {
				try {
					for (int i = 0; i < 20; i++) {
						boolean funcionou = fulano.empresta(sicrano);
						
						if (funcionou) {
							if (fulano.isItemDisponivel()) {
								System.out.println(Thread.currentThread()
										.getName()
										+ "- Pegou emprestado e tudo bem.");
							} else {
								System.out
										.println(Thread.currentThread()
												.getName()
												+ "**** Pegou emprestado um item indisponivel!.");
							}
						} else {
							System.out.println(Thread.currentThread().getName()
									+ " Item estava indisponível.");
						}
						Thread.sleep((long) (Math.random() * 80));
						if (funcionou) {
							fulano.itemDevolvido();
							System.out.println(Thread.currentThread().getName()
									+ "- Devolveu.");
						}
						Thread.sleep((long) (Math.random() * 80));
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};

		new Thread(thread1, "<que empresta>").start();
		new Thread(thread2, "<que pede>").start();
	}
}
