package si2012.solucao.composite.msgs;

public class FiguraNaMensagem implements Exibivel {

	private final String nomeDoArquivo;

	public FiguraNaMensagem(String nomeDoArquivo) {
		this.nomeDoArquivo = nomeDoArquivo;
	}

	public String getNomeDoArquivo() {
		return nomeDoArquivo;
	}

	/* (non-Javadoc)
	 * @see si2012.solucao.composite.msgs.Exibivel#exibe()
	 */
	@Override
	public void exibe() {
		System.out.println("-Figura: " + nomeDoArquivo);
	}

}
