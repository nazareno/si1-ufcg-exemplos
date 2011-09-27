package exemplos.abstractfactory;

public class ClasseCliente {

	/**
	 * Faz um pedido e envia para a empresa que tratar‡ dele.
	 */
	public static void main(String[] args) {
		Fornecedor fornecedor = new Fornecedor("Zezinho livros",
				"zezinho@zezinholivros.com.br");

		Pedido pedido = new Pedido();
		
		pedido.addItem("Livro sobre padr›es de projeto", 50);
		pedido.addItem("Livro sobre arquitetura de software", 30);

		Fabrica fabricaParaUsar = criaFabrica(fornecedor);
		processaPedido(fornecedor, pedido, fabricaParaUsar);

		Fornecedor fornecedorGrande = new Fornecedor("Amazon",
				"sales@amazon.com", "http://amazon.com/sales");
		fabricaParaUsar = criaFabrica(fornecedorGrande);
		processaPedido(fornecedorGrande, pedido, fabricaParaUsar);
	}

	private static Fabrica criaFabrica(Fornecedor fornecedor) {
		if(fornecedor.hasRestUrl()){
			return new FabricaDeREST();
		} else {
			return new FabricaDeEmail();
		}
	}

	/**
	 * @param fornecedor
	 * @param pedido
	 */
	private static void processaPedido(Fornecedor fornecedor, Pedido pedido,
			Fabrica fabrica) {
		Mensagem msg = fabrica.criaMensagem(fornecedor);
		ServicoDeMsg servico = fabrica.criaServico();
		msg.add(pedido);
		servico.envia(msg);
	}

}
