package si20121.durante.threads.intro;
public class TesteComThreads {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int x = 4;
		
		Thread minhaThreadExtra = new ThreadSimples();
		Thread minhaThreadExtraPorComposicao = new Thread(new RunnableImpl());

		minhaThreadExtra.start();
		minhaThreadExtraPorComposicao.start();

		for (int i = 0; i < 5; i++) {
			System.out.println("Na Thread principal");
			for (int j = 0; j < 100; j++) {
				double tmp = (Math.PI / Math.E);
			}
		}
	}
	
	public static void x(){
		
	}
}

