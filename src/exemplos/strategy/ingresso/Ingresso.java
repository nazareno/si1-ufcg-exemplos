package exemplos.strategy.ingresso;

public class Ingresso {

	private final CalculadorDePreco calculadorDePreco;
	private final float precoBase;

	public Ingresso(float precoBase, CalculadorDePreco precoDefaultStrategy) {
		this.precoBase = precoBase;
		this.calculadorDePreco = precoDefaultStrategy;
	}

	public float getPreco() {
		return calculadorDePreco.calculaPreco(this);
	}

}
