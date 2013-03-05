package si2012.durante.observer.caronas;

public class Usuario implements InteressadoEmCarona {

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

	public void solicitaCarona(Carona carona) throws SolicitacaoIlegalException {
		this.solicitacoesFeitas++;
		carona.solicitaCarona(this);
	}

	public int getSolicitacoesPendentes() {
		return solicitacoesFeitas - solicitacoesAceitas - solicitacoesNegadas;
	}

	@Override
	public void caronaEncerrada(Carona carona) {
		boolean aceito = carona.isUsuarioAceito(this);
		
	}

}
