package si2012.antes.factories;

public class CurriculoResumido extends CurriculoAbstrato {

	public CurriculoResumido(String nome, String experiencia, String endereco) {
		super(nome, experiencia, endereco);
	}

	@Override
	protected void defineCurriculo(String nome, String experiencia,
			String endereco) {
		this.addSecao(new SecaoCapa(nome));
		this.addSecao(new SecaoExperienciaResumida(experiencia, endereco));
	}

}
