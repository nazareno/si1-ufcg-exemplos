package si20121.antes.grasp3;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class Loja {

	private List<Venda> vendasRealizadas;
	private CatalogoDeProdutos catalogo;
	private GerenciadorDeArquivos gerenciadorDeArquivos;
	private EmissorDeNotaFiscal emissor;

	public Loja() {
		this.vendasRealizadas = new LinkedList<Venda>();
		this.gerenciadorDeArquivos = new GerenciadorDeArquivos();
		// o catalogo é criado a partir de um DB
		/*
		 * Emissor de notas é lido a partir 
		 * de um arquivo de configuração. 
		 */
		this.emissor = new EmissorDeNotaFiscalDoGoverno();
	}

	public void armazena(Venda vendaAtual) {
		vendasRealizadas.add(vendaAtual);
		salvaVendasRealizadas();
		salvaCatalogoDeProdutos();
	}

	private void salvaCatalogoDeProdutos() {
		// abre arquivo, salva catálogo
		// usa formato definido nesta classe
		gerenciadorDeArquivos.salvaEmArquivo(this.catalogo);
	}

	private void salvaVendasRealizadas() {
		gerenciadorDeArquivos.salvaEmArquivo(this.vendasRealizadas);
		// abre arquivo, salva catálogo
		// usa formato definido nesta classe
	}

	public Collection<Venda> getVendasRealizadas() {
		return new LinkedList<Venda>(vendasRealizadas);
	}

	public TPDV criaTPDV() {
		return new TPDV(this, this.catalogo, emissor);
	}

	protected void sobrescreveCatalogo(CatalogoDeProdutos catalogo2) {
		this.catalogo = catalogo2;
	}

	public void sobrescreveEmissorDeNota(
			EmissorDeNotaFiscal novoEmissor) {
		this.emissor = novoEmissor;
		
	}

}
