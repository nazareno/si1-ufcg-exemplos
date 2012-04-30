package si20121.solucao.adapter.filas;

import static org.junit.Assert.assertEquals;

import java.util.SortedSet;
import java.util.TreeSet;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class VisualizadorDeColecoesTest {

	private VisualizadorDeFilas visualizador;

	@Before
	public void setUp() throws Exception {
		visualizador = new VisualizadorDeFilas();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testaUsaDeque() throws Exception {

		UmaFilaDeNumeros minhaFila = new UmaFilaDeNumeros();
		minhaFila.add(1);
		minhaFila.add(2);
		minhaFila.add(3);

		String visualizacaoDoDeque = visualizador.getVisualizacao(minhaFila);

		assertEquals("1...3", visualizacaoDoDeque);
	}

	@Test
	public void testaUsaSortedSet() throws Exception {

		/*
		 * Motivacao:
		 */

		// SortedSet<Integer> setExemplo = new TreeSet<Integer>();
		//
		// ...
		//
		// String visualizacaoDoDeque =
		// visualizador.getVisualizacao(setExemplo);
		//
		// assertEquals("1...3", visualizacaoDoDeque);
	}
}
