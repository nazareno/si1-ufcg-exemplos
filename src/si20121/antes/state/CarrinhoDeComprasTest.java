package si20121.antes.state;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CarrinhoDeComprasTest {

	private CarrinhoDeCompras carrinho;

	@Before
	public void setup() {
		carrinho = new CarrinhoDeCompras();
	}

	@Test
	public void testAddProduto() throws CompraInvalidaException,
			PagamentoInvalidoException {
		carrinho.addProduto("Design patterns: o livro", 2);
		carrinho.addProduto("OODesign for dummies", 1);
		assertEquals(3, carrinho.getNumProdutos());

		/*
		 * depois do pagamento não é possível mais adicionar produtos
		 */
		carrinho.realizaPagamento(32324);
		try {
			carrinho.addProduto("Outro livro", 1);
			fail();
		} catch (CompraInvalidaException e) {
			// ok
		}
	}

	@Test
	public void testRealizaPagamento() throws CompraInvalidaException,
			PagamentoInvalidoException {
		carrinho.addProduto("OODesign for dummies", 1);

		/*
		 * depois do pagamento não é possível mais adicionar pagamentos
		 */
		carrinho.realizaPagamento(32324);

		try {
			carrinho.realizaPagamento(32324);
			fail();
		} catch (PagamentoInvalidoException e) {
			// ok
		}
	}
}
