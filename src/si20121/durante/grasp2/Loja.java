package si20121.durante.grasp2;

import java.util.Collection;
import java.util.LinkedList;

public class Loja {

	private LinkedList<Venda> vendasRealizadas;
	private CatalogoDeProdutos catalogo;

	public Loja() {
		this.vendasRealizadas = new LinkedList<Venda>();
		// o catalogo é criado a partir de um DB
	}

	public void armazena(Venda vendaAtual) {
		vendasRealizadas.add(vendaAtual);
	}

	public Collection<Venda> getVendasRealizadas() {
		return new LinkedList<Venda>(vendasRealizadas);
	}

	public TPDV criaTPDV() {
		return new TPDV(this, this.catalogo);
	}

	protected void sobrescreveCatalogo(CatalogoDeProdutos catalogo2) {
		this.catalogo = catalogo2;
	}

}
