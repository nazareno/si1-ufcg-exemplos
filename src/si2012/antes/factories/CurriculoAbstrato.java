package si2012.antes.factories;

import java.util.LinkedList;
import java.util.List;

public abstract class  CurriculoAbstrato{

	private List<Secao> secoes;
	private CurriculoPDFFactory pdfFactory;

	public CurriculoAbstrato(String nome, String experiencia, String endereco) {
		secoes = new LinkedList<Secao>();
		defineCurriculo(nome, experiencia, endereco);
		pdfFactory = new CurriculoPDFFactory();
	}
	
	protected void addSecao(Secao secao){
		this.secoes.add(secao);
	}
	
	protected abstract void defineCurriculo(String nome, String experiencia, String endereco);

	public String getConteudo() {
		String conteudo = "";
		for (Secao secao : secoes) {
			conteudo += secao.getConteudo();
		}
		return conteudo;
	}
	
	public ThumbnailPDF getThumbnailPDF(){
		/*
		 * Código grande e complicado para gerar o 
		 * thumbnail. 
		 */
		return pdfFactory.criaThumbnailPDF(this);
	}

	public CurriculoPDF getConteudoPDF() {
		/*
		 * Uso complicado de uma biblioteca de PDF.
		 */
		return pdfFactory.criaCurriculo(this);
		//return CurriculoPDFFactory.criaCurriculo(this);
	}

}
