package exemplos.multithread.ciclodevida;

import java.util.logging.Logger;

public class ThreadQueDorme extends Thread {

	private static Logger logger = Logger.getLogger("ThreadQueDorme");
	
	public ThreadQueDorme() {
		super("Thread que só dorme.");
	}
	
	@Override
	public void run() {
		logger.info(getName() + " - Início.");
		
		try {
			sleep(1000000); // para sempre
		} catch (InterruptedException e) {
			logger.info(getName() + "- Fui acordada. Vou acabar.");
		} 
	}
}
