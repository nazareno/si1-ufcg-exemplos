package exemplos.strategy.ingresso;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class IngressoTest {

	@Test
	public void testGetValorDefault() {
		Ingresso ingresso = new Ingresso(50f, new PrecoDefaultStrategy());
		assertEquals(50f, ingresso.getPreco());
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
	 * E para uma promoção com valor absoluto? 
	 */
}
