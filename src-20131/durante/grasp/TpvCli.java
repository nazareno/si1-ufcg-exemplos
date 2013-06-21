package durante.grasp;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class TpvCli {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SistemaTPV sistema = new SistemaTPV();
		sistema.registraProduto(1L, "Danoninho", 3.20);

		TpvCli interfaceComUsuario = new TpvCli(sistema);

		interfaceComUsuario.trataEntradas();

	}

	private final SistemaTPV sistema;

	public TpvCli(SistemaTPV sistema) {
		this.sistema = sistema;
	}

	private void trataEntradas() {
		Scanner leitor = new Scanner(System.in);

		sistema.novaVenda();

		while (true) {
			int quantidade = lerQuantidade(leitor);

			if (deveSair(quantidade)) {
				break;
			}

			long codigo = lerCodigo(leitor);

			sistema.addItemVenda(quantidade, codigo);

			imprimeItensVenda(sistema);
			imprimeTotal(sistema);
		}
	}

	/**
	 * @param sistema
	 * @return
	 */
	private void imprimeItensVenda(SistemaTPV sistema) {
		List<ItemVenda> itens = sistema.getItensVenda();
		for (ItemVenda item : itens) {
			System.out.println(item.getQuantidade() + "x "
					+ item.getDescricao() + "= " + item.getTotal());
		}
	}

	/**
	 * @param quantidade
	 * @return
	 */
	private boolean deveSair(int quantidade) {
		return quantidade == 0;
	}

	/**
	 * @param sistema
	 */
	private void imprimeTotal(SistemaTPV sistema) {
		System.out.println("Total: " + sistema.getTotal());
	}

	/**
	 * @param sistema
	 * @param leitor
	 * @param quantidade
	 * @return
	 */
	private long lerCodigo(Scanner leitor) {
		System.out.print("\nCódigo: ");
		long codigo = leitor.nextLong();

		return codigo;
	}

	/**
	 * @param leitor
	 * @return
	 */
	private int lerQuantidade(Scanner leitor) {
		int quantidade = 0;
		System.out.print("\n\nQuantidade: ");
		try {
			quantidade = leitor.nextInt();
		} catch (InputMismatchException e) {
			System.err.println("Inválido.");
		}
		return quantidade;
	}
}
