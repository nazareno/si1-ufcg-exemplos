package si20121.antes.strategy.ingresso;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class IngressoTest {

	@Test
	public void testGetValorDefault() {
		Ingresso ingresso = new Ingresso(50f);
		assertEquals(50f, ingresso.getPreco(), 0f);
	}

	@Test
	public void testGetValorParaEstudante() {
		/*
		 * Precisamos informar de alguma forma que é ingresso de estudante.
		 */
		//Ingresso ingresso = new Ingresso(50f, new PrecoEstudanteStrategy());
		//assertEquals(25f, ingresso.getPreco());
	}

	@Test
	public void testGetValorPromocaoPercentagem() throws Exception {
		/*
		 * Desconto de 10%
		 */
		//Ingresso ingresso = new Ingresso(50f, new PrecoComDescontoStrategy()); // novo strategy
		//assertEquals(45f, ingresso.getPreco());
	}
	
	/*
	 * E se a loja quisesse dar o melhor dos dois descontos? E se quisesse acumular descontos? 
	 */
}
