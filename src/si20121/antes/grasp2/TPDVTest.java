package si20121.antes.grasp2;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TPDVTest {

	private TPDV tpdv;
	private CatalogoDeProdutos catalogo;

	@Before
	public void setUp() throws Exception {
		catalogo = new CatalogoDeProdutos();
		catalogo.cadastra(312312, "Sabão em pó", 5f);
		catalogo.cadastra(873612, "Danoninho", 30f);
		tpdv = new TPDV(catalogo);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testaGetTotal() throws Exception {

		// SOLUCAO 1:
		// Venda novaVenda = new Venda();
		// tpdv.adicionaVenda(novaVenda);

		// SOLUCAO 2, melhor devido ao Creator
		tpdv.novaVenda();

		// Novamente creator:
		tpdv.addItemVenda(312312, 3); // custa 5
		tpdv.addItemVenda(873612, 10); // custa 30
		
		assertEquals(15f + 300f, tpdv.getTotalAtual(), 0f);
	}

}
