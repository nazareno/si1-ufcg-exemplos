package si2012.antes.factories;

public class MostraCurriculo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CurriculoExtendido cv = new CurriculoExtendido("Nazareno Andrade", "Professor no DSC",
				"Rua alguma coisa, 1234...");

		CurriculoResumido cvResumido = new CurriculoResumido(
				"Nazareno Andrade", "Professor no DSC",
				"Rua alguma coisa, 1234...");

		System.out.println(cv.getConteudo());
		System.out.println(cvResumido.getConteudo());
		
		CurriculoPDF pdf = cv.getConteudoPDF();
		ThumbnailPDF tPdf = cv.getThumbnailPDF();
		//CurriculoPNG png = cv.getConteudoPNG();
		//ThumbnailPNG tPng = cv.getThumbnailPNG();
		//this.mostraThumbnail(pdf);
		//this.mostraThumbnail(png);
	}

}
