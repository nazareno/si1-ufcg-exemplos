package si20112.depois.composite;

public class Hiperlink implements Exibivel {

	private final String textoParaExibir;
	private final String url;

	public Hiperlink(String textoParaExibir, String url) {
		this.textoParaExibir = textoParaExibir;
		this.url = url;
	}

	@Override
	public void exibe() {
		// TODO Auto-generated method stub
	}

}
