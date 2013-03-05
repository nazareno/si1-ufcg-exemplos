package si2012.antes.factories;

public class SecaoExperiencia implements Secao {

	private final String experiencia;

	public SecaoExperiencia(String experiencia) {
		this.experiencia = experiencia;
	}

	@Override
	public String getConteudo() {
		return experiencia;
	}

}
