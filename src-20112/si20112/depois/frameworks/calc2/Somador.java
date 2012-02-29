package si20112.depois.frameworks.calc2;

public class Somador implements Operacao {

	@Override
	public int opera(int currentTotal, int display) {
		return currentTotal + display;
	}

}
