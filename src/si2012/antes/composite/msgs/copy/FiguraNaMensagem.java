package si2012.antes.composite.msgs.copy;

public class FiguraNaMensagem implements Exibivel {

	private final String arquivo;

	public FiguraNaMensagem(String arquivo) {
		this.arquivo = arquivo;
	}

	public String getArquivo() {
		return arquivo;
	}

	public void exibe() {
		System.out.println("FIGURA: " + getArquivo());
	}

}
