package si20112.depois.multithread.ciclodevida;

import java.util.logging.Logger;

public class CicloDeVidaDemo {

	private static Logger log = Logger.getLogger("CicloDeVidaDemo");

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ThreadQueDorme queDorme = new ThreadQueDorme();
		ThreadQueMorre queMorre = new ThreadQueMorre();

		log.info("Status,prioridade de queDorme: " + queDorme.getState() + ", "
				+ queDorme.getPriority());
		
		log.info("Start");
		queDorme.start();
		queMorre.start();
		
		try {
			queMorre.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		log.info("Status,prioridade de queDorme: " + queDorme.getState() + ", "
				+ queDorme.getPriority());
		log.info("Status,prioridade de queMorre: " + queMorre.getState() + ", "
				+ queMorre.getPriority());


		queDorme.interrupt();
		//queDorme.interrupt();
		
		log.info("Status,prioridade de queDorme: " + queDorme.getState() + ", "
				+ queDorme.getPriority());
	}

}
