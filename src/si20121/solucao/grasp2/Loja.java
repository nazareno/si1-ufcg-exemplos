package si20121.solucao.grasp2;

import java.util.Collection;
import java.util.LinkedList;

public class Loja {

	private CatalogoDeProdutos catalogo;
	private Collection<Venda> vendasRealizadas;

	public Loja() {
		this.vendasRealizadas = new LinkedList<Venda>();
	}
	
	public void setCatalogo(CatalogoDeProdutos catalogo) {
		this.catalogo = catalogo;
	}

	public TPDV getTPDV() {
		return new TPDV(this, catalogo);
	}

	public void addVenda(Venda vendaAtual) {
		this.vendasRealizadas.add(vendaAtual);
	}

	public int getVendasRealizadas() {
		return vendasRealizadas.size();
	}

}
