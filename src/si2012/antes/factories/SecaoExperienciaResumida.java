package si2012.antes.factories;

public class SecaoExperienciaResumida implements Secao {

	private final String experiencia;
	private final String endereco;

	public SecaoExperienciaResumida(String experiencia, String endereco) {
		this.experiencia = experiencia;
		this.endereco = endereco;
	}

	@Override
	public String getConteudo() {
		// TODO fazer.
		return null;
	}

}
