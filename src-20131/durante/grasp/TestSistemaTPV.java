package durante.grasp;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestSistemaTPV {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testaIniciarVenda() {
		SistemaTPV sistema = new SistemaTPV();
		sistema.registraProduto(87234827364L, "Danoninho", 5.0);
		
		// /// pior
		// Venda venda = new Venda();
		// sistema.novaVenda(venda);

		// / melhor:
		sistema.novaVenda();

		assertEquals(0.0, sistema.getTotal(), 0.0);

		// o produto tem preço 5.0
		sistema.addItemVenda(3, 87234827364L);

		assertEquals(15.0, sistema.getTotal(), 0.0);

		sistema.novaVenda();
		assertEquals(0.0, sistema.getTotal(), 0.0);
	}

}
