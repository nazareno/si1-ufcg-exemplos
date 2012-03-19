package si20121.solucao.grasp3;

public class EmissorDeNFXingLing implements EmissorDeNotaFiscal {

	@Override
	public NotaFiscal getNotaFiscal(Venda vendaAtual) {
		return new NotaFiscal();
	}

}
