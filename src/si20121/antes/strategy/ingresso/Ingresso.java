package si20121.antes.strategy.ingresso;

public class Ingresso {

	private final CalculadorDePreco calculadorDePreco;
	private final float precoBase;

	public Ingresso(float precoBase){
		this(precoBase, new PrecoDefaultStrategy());
	}
	
	public Ingresso(float precoBase, CalculadorDePreco precoDefaultStrategy) {
		this.precoBase = precoBase;
		this.calculadorDePreco = precoDefaultStrategy;
	}

	public float getPreco() {
		return calculadorDePreco.calculaPreco(this);
	}

}
