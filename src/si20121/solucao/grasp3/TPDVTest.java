package si20121.solucao.grasp3;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TPDVTest {

	private TPDV tpdv;
	private CatalogoDeProdutos catalogo;

	@Before
	public void setUp() throws Exception {
		Loja aLoja = new Loja();
		catalogo = new CatalogoDeProdutos();
		catalogo.cadastra(312312, "Sabão em pó", 5f);
		catalogo.cadastra(873612, "Danoninho", 30f);

		aLoja.sobrescreveCatalogo(catalogo);

		tpdv = aLoja.criaTPDV();
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

		assertEquals(0f, tpdv.getTotalAtual(), 0f);

		// Novamente creator:
		tpdv.addItemVenda(312312, 3); // custa 5
		tpdv.addItemVenda(873612, 10); // custa 30

		assertEquals(15f + 300f, tpdv.getTotalAtual(), 0f);
	}

	@Test
	public void testaDebito() throws Exception {
		tpdv.novaVenda();

		assertEquals(0f, tpdv.getDebito(), 0f);

		tpdv.addItemVenda(312312, 4); // custa 5
		assertEquals(20f, tpdv.getDebito(), 0f);

		tpdv.pagar(5f, Pagamento.Forma.CARTAO);
		assertEquals(15f, tpdv.getDebito(), 0f);

		tpdv.pagar(10f, Pagamento.Forma.DINHEIRO);
		assertEquals(5f, tpdv.getDebito(), 0f);

		assertEquals(20f, tpdv.getTotalAtual(), 0f);
	}

	@Test
	public void testaFinalizaVenda() throws Exception {
		tpdv.novaVenda();
		assertTrue(tpdv.isVendaAberta());

		tpdv.finalizaVenda();
		try {
			tpdv.addItemVenda(312312, 10);
			fail();
		} catch (VendaInvalidaException e) {
			// ok
		}
		assertFalse(tpdv.isVendaAberta());

		assertEquals(1, tpdv.getVendasRealizadas().size());
	}

	@Test
	public void testaEmissaoDeNotaFiscal() throws Exception {
		tpdv.novaVenda();
		tpdv.addItemVenda(312312, 2);
		tpdv.finalizaVenda();
		
		tpdv.configuraEmissorDeNF(new EmissorTabajara());
		
		NotaFiscal nota = tpdv.getNotaFiscal();

		NotaFiscal aCorreta = new NotaFiscal(); /* Deveríamos construir uma nota correta */
		assertNotNull(nota);
		// assertEquals(aCorreta, nota);
		
		tpdv.configuraEmissorDeNF(new EmissorDeNFXingLing());
		
		nota = tpdv.getNotaFiscal();
		aCorreta = new NotaFiscal(); /* Deveríamos construir uma nota correta */
		assertNotNull(nota);
		// assertEquals(aCorreta, nota);
	}
}
