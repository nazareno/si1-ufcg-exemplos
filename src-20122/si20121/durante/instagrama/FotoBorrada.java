package si20121.durante.instagrama;

public class FotoBorrada implements Imagem {

	private final Imagem imagem;

	public FotoBorrada(Imagem imagem) {
		this.imagem = imagem;
	}
	
	@Override
	public String getImagem() {
		return "Versão borrada de " + imagem.getImagem();
	}

}
