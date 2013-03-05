package si2012.solucao.observer.carona;

public class Usuario implements CaronaListener {

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
		carona.solicitaCarona(this);
		this.solicitacoesFeitas++;
	}

	public int getSolicitacoesPendentes() {
		return solicitacoesFeitas - solicitacoesAceitas - solicitacoesNegadas;
	}

	@Override
	public void notificaEncerramento(Carona carona) {
		if (carona.isConfirmado(this)) {
			// adiciona na lista de caronas futuras aceitas, etc.
			;
		}
	}

	@Override
	public boolean equals(Object obj) {
		return ((Usuario) obj).nome.equals(this.nome);
	}

	public void caronaConfirmada(Carona carona) {
		this.solicitacoesAceitas++;
	}

	public void caronaNegada(Carona carona) {
		this.solicitacoesNegadas++;
	}

}
