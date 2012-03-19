package si20121.solucao.grasp3;

public class EmissorTabajara implements EmissorDeNotaFiscal {

	public NotaFiscal getNotaFiscal(Venda vendaAtual) {
		/*
		 * Aqui falaríamos com outro sistema, usando uma tecnologia que o resto
		 * de nosso software não precisa conhecer, como por exemplo, SOAP ou
		 * REST. Além disso, pegaríamos de vendaAtual a informação necessária e
		 * a colocaríamos no formato necessário. Por fim, converteríamos o
		 * resultado do retorno do sistema externo em um objeto NotaFiscal.
		 */
		return new NotaFiscal();
	}

}
