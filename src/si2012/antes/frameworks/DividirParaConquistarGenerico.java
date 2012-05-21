package si2012.antes.frameworks;

public class DividirParaConquistarGenerico {

	public Solucao soluciona(Problema p) {
		if(isTrivial(p)){
			return solucionaTrivial(p);
		}
		
		Problema[] partes = decompoe(p);
		Solucao[] solucoes = new Solucao[partes.length];
		
		for (int i = 0; i < partes.length; i++) {
			solucoes[i] = soluciona(partes[i]);
		}
		
		return combina(solucoes);
	}

	private Solucao combina(Solucao[] solucoes) {
		// TODO Auto-generated method stub
		return null;
	}

	private Problema[] decompoe(Problema p) {
		// TODO Auto-generated method stub
		return null;
	}

	private Solucao solucionaTrivial(Problema p) {
		// TODO Auto-generated method stub
		return null;
	}

	private boolean isTrivial(Problema p) {
		// TODO Auto-generated method stub
		return false;
	}

}
