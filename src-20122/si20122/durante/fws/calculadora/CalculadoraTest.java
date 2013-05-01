package si20122.durante.fws.calculadora;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CalculadoraTest {

	int operando1 = 2;
	int operando2 = 7;

	Calculadora calculadora;

	@Before
	public void setUp() throws Exception {
		Operacao[] operacoes = {new OperacaoSoma(), new OperacaoSubtracao()};
		calculadora = new Calculadora(operacoes);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void soma() throws OperacaoInvalidaException {
		int resultadoEsperado = 9;

		assertEquals(0, calculadora.getResultado());

		calculadora.setOperando(operando1);

		// só podemos setar o segundo depois da operação
		try {
			calculadora.setOperando(operando2);
			fail();
		} catch (OperacaoInvalidaException e) {
			// ok
		}

		// resultado inalterado
		assertEquals(0, calculadora.getResultado());

		// setamos a operação:
		calculadora.setOperacao("+");
		calculadora.setOperando(operando2);

		assertEquals(resultadoEsperado, calculadora.getResultado());
	}

	@Test
	public void subtracao() throws Exception {
		int resultadoEsperado = -5;

		calculadora.setOperando(operando1);

		// só podemos setar o segundo depois da operação
		try {
			calculadora.setOperando(operando2);
			fail();
		} catch (OperacaoInvalidaException e) {
			// ok
		}

		// resultado inalterado
		assertEquals(0, calculadora.getResultado());

		// setamos a operação:
		calculadora.setOperacao("-");
		calculadora.setOperando(operando2);

		assertEquals(resultadoEsperado, calculadora.getResultado());

	}
}
