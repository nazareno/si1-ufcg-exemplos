package si2012.antes.frameworks;

public class Cliente {

	public static void main(String[] args) {
		DividirParaConquistarGenerico dpq = new DividirParaConquistarGenerico();
		
		int[] dados = new int[]{2, 3, 7, 1, 4, 9};
		
		Problema p = new Problema(dados);
		
		Solucao resposta = dpq.soluciona(p);
	}
}
