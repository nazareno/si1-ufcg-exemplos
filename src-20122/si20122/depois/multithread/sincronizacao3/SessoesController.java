package si20122.depois.multithread.sincronizacao3;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;


public class SessoesController {

	private List<Integer> pedidos = new LinkedList<Integer>();

	/**
	 * Um usuário só pode ter até 3 pedidos pendentes.
	 * 
	 * @param id
	 *            o ID do usuário.
	 * @throws Exception
	 *             Se ele já tiver 3 pedidos pendentes.
	 */
	public void novaSessao(int id) throws Exception {
		if(!pedidos.contains(id))
			pedidos.add(id);
	}

	public void removeSessao(int id) {
		pedidos.remove(id);
	}

	public List<Integer> getPedidos() {
		return pedidos;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final SessoesController controller = new SessoesController();

		Runnable criador = new Runnable() {
			@Override
			public void run() {
				Random random = new Random();
				for (int i = 0; i < 3000; i++) {
					try {
						Thread.sleep(random.nextInt(1));
						controller.novaSessao(random.nextInt(5));
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					} catch (Exception e) {
					}
				}
			}
		};

		Runnable removedor = new Runnable() {

			@Override
			public void run() {
				Random random = new Random();
				for (int i = 0; i < 2500; i++) {
					try {
						Thread.sleep(random.nextInt(1));
						controller.removeSessao(random.nextInt(1));
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					} catch (Exception e) {
					}
				}
			}

		};

		Thread queAdiciona1 = new Thread(criador);
		Thread queAdiciona2 = new Thread(criador);

		Thread queRemove = new Thread(removedor);

		queAdiciona1.start();
		queAdiciona2.start();
		queRemove.start();

		try {
			queAdiciona1.join();
			queAdiciona2.join();
			queRemove.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Resultado: " + controller.getPedidos());

	}

}
