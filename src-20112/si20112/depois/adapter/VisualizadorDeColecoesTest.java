package si20112.depois.adapter;


import static org.junit.Assert.assertEquals;

import java.util.SortedSet;
import java.util.TreeSet;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class VisualizadorDeColecoesTest {

	private VisualizadorDeColecoes visualizador;

	@Before
	public void setUp() throws Exception {
		visualizador = new VisualizadorDeColecoes();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testaUsaDeque() throws Exception {

		Enfileiravel minhaFila  = new MinhaFilaDeNumeros();
		minhaFila.add(1);
		minhaFila.add(2);
		minhaFila.add(3);
		
		String visualizacaoDoDeque = visualizador.getVisualizacao(minhaFila);
		
		assertEquals("1...3", visualizacaoDoDeque);
	}
	
	@Test
	public void testaUsaSortedSet() throws Exception {
		SortedSet<Integer> setExemplo = new TreeSet<Integer>();
		Enfileiravel adaptado = new SortedSetAdapter(setExemplo);
		adaptado.add(1);
		adaptado.add(2);
		adaptado.add(3);
		
		String visualizacaoDoDeque = visualizador.getVisualizacao(adaptado);
		
		assertEquals("1...3", visualizacaoDoDeque);
	}
}
