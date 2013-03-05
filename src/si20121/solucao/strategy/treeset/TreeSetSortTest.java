package si20121.solucao.strategy.treeset;

import static org.junit.Assert.assertEquals;

import java.util.Comparator;
import java.util.TreeSet;

import org.junit.Before;
import org.junit.Test;

import si20112.depois.strategy.treeset.AlgumDado;

public class TreeSetSortTest {

	AlgumDado dado1, dado2;

	@Before
	public void setUp() throws Exception {
		dado1 = new AlgumDado("Fulano", 3213);
		dado2 = new AlgumDado("Sicrano", 1276);
	}

	@Test
	public void testOrdenaPorNome() {
		Comparator<AlgumDado> strategy = new Comparator<AlgumDado>(){
			@Override
			public int compare(AlgumDado o1, AlgumDado o2) {
				return o1.getNome().compareTo(o2.getNome());
			}
		};
		TreeSet<AlgumDado> set = new TreeSet<AlgumDado>(strategy);
		
		set.add(dado2);
		set.add(dado1);

		assertEquals(dado1, set.first());
	}

	@Test
	public void testOrdenaPorValor() {
		TreeSet<AlgumDado> set = new TreeSet<AlgumDado>(new Comparator<AlgumDado>(){

			@Override
			public int compare(AlgumDado o1, AlgumDado o2) {
				return o1.getValor() - o2.getValor();
			}});
		
		set.add(dado1);
		set.add(dado2);

		assertEquals(dado2, set.first());
	}

}
