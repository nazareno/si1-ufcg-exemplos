package si20121.antes.strategy.ingresso;


public class PrecoDefaultStrategy implements CalculadorDePreco {

	@Override
	public float calculaPreco(Ingresso ingresso) {
		return ingresso.getPreco();
	}

}
