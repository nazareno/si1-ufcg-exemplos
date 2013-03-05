package si2012.antes.composite.msgs.copy;

public class SistemaDeMensagens {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ThreadDeMensagens thread = new ThreadDeMensagens();

		/*
		 * Mensagem original
		 */
		Mensagem msgOriginal = new Mensagem("Fulano", new String[] {
				"Beltrano", "Sicrano" }, "Mensagem original.");

		thread.add(msgOriginal);

		/*
		 * Resposta simples, contém a original como anexo
		 */
		Mensagem resposta1 = new Mensagem(msgOriginal, "Beltrano",
				"Nada a declarar.");
		thread.add(resposta1);

		/*
		 * Agora queremos implementar outras formas de anexo: fotos, links...
		 */
		Mensagem resposta2 = new Mensagem(msgOriginal, "Sicrano",
				"A resposta são essas fotos.");
		resposta2.add(new FiguraNaMensagem("Foto 1"));
		resposta2.add(new FiguraNaMensagem("Foto 2"));
		thread.add(resposta2);

		Mensagem treplica = new Mensagem(resposta1, "Fulano",
				"A tréplica é um link.");
		treplica.add(new Hiperlink("Texto para exibir",
				"http://www.lsd.ufcg.edu.br"));

		thread.add(treplica);

		/*
		 * Se quiséssemos uma referência para outra thread:
		 */
		// treplica.add(new ThreadDeMensagens());

		thread.exibe();
	}

}
