package si20112.depois.multithread.sincronizacao2;

public class ProdutorConsumidorTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BufferSI1 b = new BufferSI1();
		Produtor produtor = new Produtor(b);
		Consumidor consumidor = new Consumidor(b);
		//Consumidor consumidor2 = new Consumidor(b);
		
		produtor.start();
		consumidor.start();
		//consumidor2.start();
	}

}
