package si20121.solucao.grasp2;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TPDVTest {

	private TPDV tpdv;

	@Before
	public void setUp() throws Exception {
		CatalogoDeProdutos catalogo = new CatalogoDeProdutos();
		catalogo.cadastra(312312, "Sabão em pó", 5f);
		catalogo.cadastra(873612, "Danoninho", 30f);
		
		Loja aLoja = new Loja();
		
		// sobrescrever o catalogo default para testes
		aLoja.setCatalogo(catalogo);
		
		tpdv = aLoja.getTPDV();
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

	@Test
	public void testaAdicionaPagamento() throws Exception {
		tpdv.novaVenda();

		tpdv.addItemVenda(312312, 5); // total = 25

		tpdv.addPagamento(15f, "Cartão");
		tpdv.addPagamento(5f, "Dinheiro");

		assertEquals(25f, tpdv.getTotalAtual(), 0f);
		assertEquals(5f, tpdv.getSaldo(), 0f);

		assertEquals(2, tpdv.getPagamentosRealizados().size());
		// podemos testar se a informaçao foi guardada correta
	}

	@Test
	public void testaSalvaVenda() throws Exception {
		tpdv.novaVenda();
		assertTrue(tpdv.isVendaAberta());
		assertEquals(0, tpdv.getVendasRealizadas());

		tpdv.fechaVenda();
		assertFalse(tpdv.isVendaAberta());

		tpdv.novaVenda();
		assertTrue(tpdv.isVendaAberta());
		assertEquals(1, tpdv.getVendasRealizadas());

		/*
		 * se não fosse na aula, deveriamos implementar o equals de venda e
		 * testar se a venda que foi salva é a que finalizamos!
		 */

	}
}
