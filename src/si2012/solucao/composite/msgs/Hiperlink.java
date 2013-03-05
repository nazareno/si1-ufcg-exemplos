package si2012.solucao.composite.msgs;

public class Hiperlink implements Exibivel {

	private final String texto;
	private final String url;

	public Hiperlink(String texto, String url) {
		this.texto = texto;
		this.url = url;
	}

	public String getTexto() {
		return texto;
	}

	public String getUrl() {
		return url;
	}

	@Override
	public void exibe() {
		System.out.println("Link: texto [" + getTexto() + "] e url ["
				+ getUrl() + "]");
	}

}
