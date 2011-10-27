package exemplos.multithread.intro;

import java.util.Timer;
import java.util.TimerTask;

public class TimerDemo {

	private Timer timer;

	public TimerDemo(int s) {
		this.timer = new Timer();
		//timer.schedule(new RemindTask(), s * 1000);
		
		/*
		 * Qual o resultado com: 
		 */
		try {
			Thread.sleep(s * 1000);
			System.out.println("Executando a tarefa.");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	class RemindTask extends TimerTask {
		@Override
		public void run() {
			System.out.println("Executando a tarefa.");
			timer.cancel();
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new TimerDemo(5);
		System.out.println("Tarefa criada. Última linha do main()");
	}

}
