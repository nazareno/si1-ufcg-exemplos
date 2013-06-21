package durante.grasp;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Categories.ExcludeCategory;

public class ItemVendaTest {

	@Test
	public void testInputInvalido() throws Exception {
		try {
			ItemVenda item = new ItemVenda(0, new Produto("Passagem de onibus",
					2.10));
			fail();
		} catch (IllegalArgumentException erro) {
			// ok
		}

		try {
			ItemVenda item = new ItemVenda(-1, new Produto(
					"Passagem de onibus", 2.10));
			fail();
		} catch (IllegalArgumentException erro) {
			// ok
		}
	}

	@Test
	public void testDescontoQuantidade() {
		for (int quantidade = 1; quantidade <= 9; quantidade++) {
			Produto produto = new Produto("Passagem de onibus", 2.10,
					new DescontoPorQuantidade(10, 0.10));
			ItemVenda item = new ItemVenda(quantidade, produto);
			assertEquals(2.10 * quantidade, item.getTotal(), 0.0);
		}

		ItemVenda item = new ItemVenda(10, new Produto("Passagem de onibus",
				2.10, new DescontoPorQuantidade(10, 0.10)));
		assertEquals(18.90, item.getTotal(), 0.0);
	}

	@Test
	public void testDescontoData() {
		int umDiaEmMillis = 24 * 60 * 60 * 1000;
		Produto produtoComDescontoData = new Produto("Passagem", 1.0,
				new DescontoPorData(System.currentTimeMillis() + umDiaEmMillis,
						0.30));
		ItemVenda item = new ItemVenda(1, produtoComDescontoData);
		assertEquals(.70, item.getTotal(), 0.0);
	}

}
