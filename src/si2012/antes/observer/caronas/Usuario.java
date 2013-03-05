package si2012.antes.observer.caronas;

public class Usuario {

	private final String nome;
	private int solicitacoesAceitas;
	private int solicitacoesFeitas;
	private int solicitacoesNegadas;

	public Usuario(String nome) {
		this.nome = nome;
		solicitacoesAceitas = 0;
	}

	public String getNome() {
		return nome;
	}

	public int getCaronasAceitas() {
		return solicitacoesAceitas;
	}

	public void solicitaCarona(Carona carona) {
		this.solicitacoesFeitas++;
	}

	public int getSolicitacoesPendentes() {
		return solicitacoesFeitas - solicitacoesAceitas - solicitacoesNegadas;
	}

}
